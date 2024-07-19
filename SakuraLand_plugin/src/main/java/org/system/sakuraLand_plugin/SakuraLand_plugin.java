package org.system.sakuraLand_plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SakuraLand_plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "SakuraLand 2.0 Plugin is RUNNING");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "SakuraLand 2.0 Plugin is RUNNING");
    }
}