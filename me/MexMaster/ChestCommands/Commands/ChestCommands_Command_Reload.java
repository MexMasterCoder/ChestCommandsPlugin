package me.MexMaster.ChestCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChestCommands_Command_Reload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("chestcommands.reload")){
			if(args.length == 0){
				me.MexMaster.ChestCommands.ChestCommands.loadYamls();
				
				sender.sendMessage(ChatColor.GOLD + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.reloaded"));
			}
		}
		return true;
	}
}