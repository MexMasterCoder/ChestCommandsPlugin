package me.MexMaster.ChestCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChestCommands_Command_Create implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			if(args.length == 1){
			Player p = (Player) sender;
				if(p.hasPermission("chestcommands.create")){
					chestblock = p.getTargetBlock(null, 200);
					chestlocation = chestblock.getLocation();
					
					chestblockxd = chestlocation.getX();
					chestblockyd = chestlocation.getY();
					chestblockzd = chestlocation.getZ();
					
					chestblockx = new Double(chestblockxd).intValue();
					chestblocky = new Double(chestblockyd).intValue();
					chestblockz = new Double(chestblockzd).intValue();

					if(chestblock.getTypeId() == 54){
						
						World w = p.getWorld();
						String worldname = w.getName();
						
						if(!me.MexMaster.ChestCommands.ChestCommands.chests.getBoolean(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz) || !me.MexMaster.ChestCommands.ChestCommands.chests.isSet(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz)){
							
							me.MexMaster.ChestCommands.ChestCommands.chests.set(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz + ".commandtable", args[0]);
							
							me.MexMaster.ChestCommands.ChestCommands.saveYamls();
							
							sender.sendMessage(ChatColor.GOLD + "Command Chest successfully created!");
							
						}else{
							p.sendMessage(ChatColor.RED + "This Chest is already set");
						}
					}else{
						p.sendMessage(ChatColor.RED + "No Chest");
					}
				}else{
					p.sendMessage(ChatColor.RED + "You don't have Permission!");
				}
			}else{
				sender.sendMessage(ChatColor.RED + "Wrong arguments");
			}
		}else{
			sender.sendMessage("This Command can only be executed by a player");
		}
		return true;
	}
	public static Location chestlocation;
	public static Block chestblock;
	
	public static int chestblockx;
	public static int chestblocky;
	public static int chestblockz;
	
	public static double chestblockxd;
	public static double chestblockyd;
	public static double chestblockzd;
}