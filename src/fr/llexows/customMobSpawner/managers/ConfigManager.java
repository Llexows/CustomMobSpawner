package fr.llexows.customMobSpawner.managers;

import fr.llexows.customMobSpawner.Core;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

/**
 * Created by Llexows.
 *
 * @version 0.1
 */
public final class ConfigManager {

    private Core instance;
    private static FileConfiguration config;
    private static HashMap<String, String> messages = new HashMap<>();

    public ConfigManager(Core instance){
        this.instance = instance;
        config = instance.getConfig();
    }

    public void setupConfig(){
        config.options().copyDefaults(true);
        instance.saveDefaultConfig();

        /*
        Register custom messages from the config
         */
        registerMesage("recieved-mob-spawner", "recieved-mob-spawner");
        registerMesage("give-spawner-player", "give-spawner-player");
        registerMesage("cannot-break-spawner", "cannot-break-spawner");
        registerMesage("received-magic-pickaxe", "received-magic-pickaxe");
        registerMesage("config-reloaded", "config-reloaded");
    }

    public static FileConfiguration getConfig(){
        return config;
    }

    public static String getMessage(String key){
        return messages.get(key);
    }

    private void registerMesage(String key, String section){
        messages.put(key, ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages."+section)));
    }

}
