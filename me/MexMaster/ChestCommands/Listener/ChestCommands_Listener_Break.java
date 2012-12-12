package me.MexMaster.ChestCommands.Listener;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
 
public class ChestCommands_Listener_Break implements Listener {
	

	
    Logger log = Logger.getLogger("Minecraft");
    Plugin plugin;
   
    public ChestCommands_Listener_Break(Plugin instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
    @EventHandler
    public void Listener(BlockBreakEvent e){
    	
		chestblockxd = e.getBlock().getX();
		chestblockyd = e.getBlock().getY();
		chestblockzd = e.getBlock().getZ();
		
		chestblockx = new Double(chestblockxd).intValue();
		chestblocky = new Double(chestblockyd).intValue();
		chestblockz = new Double(chestblockzd).intValue();
		
		World w = e.getPlayer().getWorld();
		String worldname = w.getName();
    	
    	if(e.getBlock().getTypeId() == 54 && me.MexMaster.ChestCommands.ChestCommands.chests.isSet(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz + ".commandtable")){
    		e.setCancelled(true);
    		
    		Player p = e.getPlayer();
    		
    		p.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.cancelled"));
    		
    	}
    }
    
	public static int chestblockx;
	public static int chestblocky;
	public static int chestblockz;
	
	public static double chestblockxd;
	public static double chestblockyd;
	public static double chestblockzd;
}