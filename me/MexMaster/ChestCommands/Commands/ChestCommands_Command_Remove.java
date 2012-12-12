package me.MexMaster.ChestCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChestCommands_Command_Remove implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			if(args.length == 0){
			Player p = (Player) sender;
				if(p.hasPermission("chestcommands.remove")){
					chestblock = p.getTargetBlock(null, 200);
					if(chestblock.getTypeId() == 54){
						
						chestblockxd = chestblock.getLocation().getX();
						chestblockyd = chestblock.getLocation().getY();
						chestblockzd = chestblock.getLocation().getZ();
						
						chestblockx = new Double(chestblockxd).intValue();
						chestblocky = new Double(chestblockyd).intValue();
						chestblockz = new Double(chestblockzd).intValue();
						
						World w = p.getWorld();
						String worldname = w.getName();
						
						if(me.MexMaster.ChestCommands.ChestCommands.chests.isSet(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz)){
							me.MexMaster.ChestCommands.ChestCommands.chests.set(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz + ".commandtable", null);
							me.MexMaster.ChestCommands.ChestCommands.chests.set(worldname + "." + chestblockx + "+" + chestblocky + "+" + chestblockz, null);
							
							me.MexMaster.ChestCommands.ChestCommands.saveYamls();
							
							p.sendMessage(ChatColor.GOLD + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.removed"));
						}else{
							p.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.chest_not_set"));
						}
					}else{
						p.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.no_chest"));
					}
				}else{
					p.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.permission_deny"));
				}
			}else{
				sender.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.wrong_arguments"));
			}
		}else{
			sender.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.only_player_command"));
		}
		
		return true;
	}
	public static Block chestblock;
	
	public static int chestblockx;
	public static int chestblocky;
	public static int chestblockz;
	
	public static double chestblockxd;
	public static double chestblockyd;
	public static double chestblockzd;
}