package me.anatomic.divictus.shophandler;

import me.anatomic.divictus.shophandler.network.FetchNewCommands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;

public class ForceCheckCommand implements CommandExecutor {

    ShopHandler plugin;
    public ForceCheckCommand(ShopHandler plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.runTaskAsynchronously(plugin, new TimerTask(plugin));
        return true;
    }
}
