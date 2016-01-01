package fr.llexows.customMobSpawner.commands;

import fr.llexows.customMobSpawner.Utils;
import fr.llexows.customMobSpawner.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Llexows.
 *
 * @version 0.1
 */
public final class GiveCommand extends PluginCommand {

    public GiveCommand() {
        super("give", "customspawner.give");
    }

    @Override
    public void execute(Player player, String[] args) {
        ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);

        switch(args.length){
            case 1:
                player.getInventory().addItem(spawner);
                Utils.sendMessage(player, ConfigManager.getMessage("recieved-mob-spawner"));
                break;
            case 2:
                for(Player pl : Bukkit.getOnlinePlayers()){
                    if(pl.getName().toLowerCase().equalsIgnoreCase(args[1].toLowerCase())){
                        pl.getInventory().addItem(spawner);
                        Utils.sendMessage(player, ConfigManager.getMessage("give-spawner-player").replace("%player%", pl.getName()));
                        return;
                    }
                }

                player.getInventory().addItem(spawner);
                Utils.sendMessage(player, "§aYou recieved a mob spawner.");

                break;
        }
    }
}
