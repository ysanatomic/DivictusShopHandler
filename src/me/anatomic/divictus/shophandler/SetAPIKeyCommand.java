package me.anatomic.divictus.shophandler;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetAPIKeyCommand implements CommandExecutor {

    ShopHandler plugin;
    public SetAPIKeyCommand(ShopHandler plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1){
            sender.sendMessage("[*] You must input an API Key into the command.");
            return false;
        }
        plugin.getConfig().set("apikey", args[0]);
        plugin.saveConfig();
        sender.sendMessage("[*] API Key set.");
        return true;
    }

}
