package me.MexMaster.ChestCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChestCommands_Command_Main implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(args.length == 0){
				sender.sendMessage(ChatColor.GOLD + "--ChestCommands--");
				sender.sendMessage(ChatColor.GRAY + "Commands:");
				sender.sendMessage(ChatColor.GOLD + "-/chestcommandscreate <commandtable> | To create a command chest at where you look");
				sender.sendMessage(ChatColor.GOLD + "-/chestcommandsremove | To remove a command chest at where you look");
				sender.sendMessage(ChatColor.GOLD + "-/chestcommandsreload | To reload the commandtables.yml, chests.yml and the messages.yml");
			}else{
				sender.sendMessage(ChatColor.RED + me.MexMaster.ChestCommands.ChestCommands.messages.getString("messages.wrong_arguments"));
			}
		return true;
	}
}