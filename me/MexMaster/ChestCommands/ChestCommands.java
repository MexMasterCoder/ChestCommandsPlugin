package me.MexMaster.ChestCommands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import me.MexMaster.ChestCommands.Commands.ChestCommands_Command_Create;
import me.MexMaster.ChestCommands.Commands.ChestCommands_Command_Main;
import me.MexMaster.ChestCommands.Commands.ChestCommands_Command_Reload;
import me.MexMaster.ChestCommands.Commands.ChestCommands_Command_Remove;
import me.MexMaster.ChestCommands.Listener.ChestCommands_Listener_Break;
import me.MexMaster.ChestCommands.Listener.ChestCommands_Listener_Interact;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestCommands extends JavaPlugin{

    public static File chestFile;
    public static File commandtableFile;
    public static File messagesFile;

    public static FileConfiguration chests;
    public static FileConfiguration commandtables;
    public static FileConfiguration messages;

    @Override
    public void onDisable() {
    	
		System.out.println("-----------[ChestCommands]------------");
        
		saveYamls();
        
		System.out.println(" ChestCommands disabled!");
		System.out.println("--------------------------------------");
    }

    @Override
    public void onEnable() {
    	
		System.out.println("-----------[ChestCommands]------------");
		
		getCommand("chestcommandscreate").setExecutor(new ChestCommands_Command_Create());
		getCommand("chestcommandsremove").setExecutor(new ChestCommands_Command_Remove());
		getCommand("chestcommandsreload").setExecutor(new ChestCommands_Command_Reload());
		getCommand("chestcommands").setExecutor(new ChestCommands_Command_Main());
		
		new ChestCommands_Listener_Interact(this);
		new ChestCommands_Listener_Break(this);
    	
		chestFile = new File(getDataFolder(), "chests.yml");
		commandtableFile = new File(getDataFolder(), "commandtables.yml");
		messagesFile = new File(getDataFolder(), "messages.yml");

        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }

        chests = new YamlConfiguration();
        commandtables = new YamlConfiguration();
        messages = new YamlConfiguration();
        
        loadYamls();
		
		System.out.println(" Version: 1.0");
		System.out.println(" ChestCommands enabled!");
		System.out.println(" Author: MexMaster");
		System.out.println("--------------------------------------");	
    }
    
    private void firstRun() throws Exception {
    	System.out.println(" Configurationen werden generiert!");
    	
        if(!chestFile.exists()){                        
        	chestFile.getParentFile().mkdirs();         
            copy(getResource("chests.yml"), chestFile); 
        }
        if(!commandtableFile.exists()){                        
        	commandtableFile.getParentFile().mkdirs();         
            copy(getResource("commandtables.yml"), commandtableFile);
        }
        if(!messagesFile.exists()){                        
        	messagesFile.getParentFile().mkdirs();         
            copy(getResource("messages.yml"), messagesFile);
        }
        System.out.println(" Configurationen generiert!");
    }

    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadYamls() {
        try {
        	chests.load(chestFile);
        	commandtables.load(commandtableFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveYamls() {
        try {
        	chests.save(chestFile);
        	commandtables.save(commandtableFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}