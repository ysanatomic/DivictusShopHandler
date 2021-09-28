package me.anatomic.divictus.shophandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ShowAPIKeyCommand implements CommandExecutor {

    ShopHandler plugin;
    public ShowAPIKeyCommand(ShopHandler plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("[*] API KEY: " + plugin.getConfig().get("apikey").toString());
        return true;
    }

}
