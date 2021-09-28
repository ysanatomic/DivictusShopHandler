package me.anatomic.divictus.shophandler;

import me.anatomic.divictus.shophandler.network.FetchNewCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ForceCheckCommand implements CommandExecutor {

    ShopHandler plugin;
    public ForceCheckCommand(ShopHandler plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FetchNewCommands networkHandler = new FetchNewCommands(plugin);
        networkHandler.fetchAndExecute();
        return true;
    }
}
