package me.MexMaster.ChestCommands.Listener;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
 
public class ChestCommands_Listener_Interact implements Listener {
	

	
    Logger log = Logger.getLogger("Minecraft");
    Plugin plugin;
   
    public ChestCommands_Listener_Interact(Plugin instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
    @EventHandler
    public void Listener(PlayerInteractEvent e){
    	Player p = e.getPlayer();
    	thechest = p.getTargetBlock(null, 200).getLocation();
    	thechestblock = thechest.getBlock();
    	if(thechestblock.getTypeId() == 54){
    		
			chestblockxd = thechest.getX();
			chestblockyd = thechest.getY();
			chestblockzd = thechest.getZ();
			
			chestblockx = new Double(chestblockxd).intValue();
			chestblocky = new Double(chestblockyd).intValue();
			chestblockz = new Double(chestblockzd).intValue();
			
			World w = p.getWorld();
			String worldname = w.getName();
    		
    		if(me.MexMaster.ChestCommands.ChestCommands.chests.isSet(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz)){
    			
    			commandtablestr = me.MexMaster.ChestCommands.ChestCommands.chests.getString(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz + ".commandtable");
    			List<String> commandsconsole = me.MexMaster.ChestCommands.ChestCommands.commandtables.getStringList(commandtablestr + ".consolecommands");
    			
    			List<String> commandsplayer = me.MexMaster.ChestCommands.ChestCommands.commandtables.getStringList(commandtablestr + ".playercommands");
    			
    			for(String commandstr : commandsconsole) {
			        
    				plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), commandstr);
    				
    			}
    			
    			for(String commandstr : commandsplayer) {
			        
    				p.performCommand(commandstr);
    				
    			}
			}
    	}
    }
    public static Block thechestblock;
    public static Location thechest;
    
	public static int chestblockx;
	public static int chestblocky;
	public static int chestblockz;
	
	public static double chestblockxd;
	public static double chestblockyd;
	public static double chestblockzd;
	
	public static String commandtablestr;
}