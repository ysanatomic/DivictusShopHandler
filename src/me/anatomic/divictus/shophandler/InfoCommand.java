package me.anatomic.divictus.shophandler;

import me.anatomic.divictus.shophandler.network.FetchNewCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("[*] This handler for the Divictus Shop was made by Anatomic.");
        sender.sendMessage("[*] Licensed under GPLv3.");
        return true;
    }
}