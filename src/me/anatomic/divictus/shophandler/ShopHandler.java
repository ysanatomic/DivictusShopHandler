package me.anatomic.divictus.shophandler;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.com.google.gson.JsonArray;
import org.bukkit.craftbukkit.libs.com.google.gson.JsonElement;
import org.bukkit.craftbukkit.libs.com.google.gson.JsonObject;
import org.bukkit.craftbukkit.libs.com.google.gson.JsonParser;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;

public class ShopHandler extends JavaPlugin implements Listener {

    Timer time = new Timer();

    @Override
    public void onEnable() {
        System.out.println("[DivictusShopHandler] Plugin is enabled..");
        System.out.println("[DivictusShopHandler] Developed by Anatomic.");

        this.saveConfig();
        if(!this.getConfig().isSet("websiteURL")){
            this.getConfig().set("websiteURL", "http://localhost:8001/");
        }
        if(!this.getConfig().isSet("apikey")){
            this.getConfig().set("apikey", "myapikey");
        }
        this.saveConfig();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new TimerTask(this), 0L, 1200L);

        this.getCommand("divshopsetapikey").setExecutor(new SetAPIKeyCommand(this));
        this.getCommand("divshopshowapikey").setExecutor(new ShowAPIKeyCommand(this));
        this.getCommand("divshopforcecheck").setExecutor(new ForceCheckCommand(this));
        this.getCommand("divshopinfo").setExecutor(new InfoCommand());

    }

}

