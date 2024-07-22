package org.system.sakuraLand_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import org.system.sakuraLand_plugin.Commands.hola_test;
import org.system.sakuraLand_plugin.Creater.NewComerGiftCreater;
import org.system.sakuraLand_plugin.EventListener.onNewComer;

public final class SakuraLand_plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        NewComerGiftCreater creater = new NewComerGiftCreater(this);
        getCommand("hola").setExecutor(new hola_test(this));
        getServer().getPluginManager().registerEvents(new onNewComer(creater), this);
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "SakuraLand 2.0 Plugin is RUNNING");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "SakuraLand 2.0 Plugin is OUT");
    }
}
