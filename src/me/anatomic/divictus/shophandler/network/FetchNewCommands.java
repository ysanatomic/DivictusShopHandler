package me.anatomic.divictus.shophandler.network;

import me.anatomic.divictus.shophandler.ShopHandler;
import org.bukkit.Bukkit;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchNewCommands {

    ShopHandler plugin;

    public FetchNewCommands(ShopHandler plugin){
        this.plugin = plugin;
    }
    public void fetchAndExecute(){
        try {
            URL url = new URL(this.plugin.getConfig().get("websiteURL").toString() + "?apikey=" +
                    this.plugin.getConfig().get("apikey").toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.disconnect();
            con.connect();
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) con.getContent())); //Convert the input stream to a json element
            JsonObject rootobj;
            try {
                rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            } catch (Exception e) {
                return;
            }

            JsonArray commandsArray = rootobj.getAsJsonArray("commands");
            for(JsonElement cmdEl: commandsArray){
                JsonObject commandObj = cmdEl.getAsJsonObject();
                String actualCommand = commandObj.get("cmd").getAsString();
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), actualCommand);
            }

        } catch(JsonIOException | IOException e) {
            // intentionally blank
            ;
        }
    }
}
