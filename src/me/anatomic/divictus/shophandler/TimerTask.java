package me.anatomic.divictus.shophandler;

import me.anatomic.divictus.shophandler.network.FetchNewCommands;
import org.bukkit.Bukkit;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;

public class TimerTask implements Runnable {

    private final ShopHandler plugin;

    public TimerTask(ShopHandler plugin){
        this.plugin = plugin;
    }

    public void run(){
        //DO STUFF
        System.out.println("[DivictusShopHandler] Starting Check.");

        FetchNewCommands networkHandler = new FetchNewCommands(plugin);
        networkHandler.fetchAndExecute();
    }
}
