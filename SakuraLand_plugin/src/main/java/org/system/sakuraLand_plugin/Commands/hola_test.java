package org.system.sakuraLand_plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.system.sakuraLand_plugin.Creater.NewComerGiftCreater;

public class hola_test implements CommandExecutor {
    private final NewComerGiftCreater creater;

    public hola_test(Plugin plugin) {
        this.creater = new NewComerGiftCreater(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().setItemInMainHand(creater.getNewPlayerGift());
            player.sendMessage("歡迎來到櫻花鄉伺服器!!");
            player.sendMessage("這是你的新手禮包~(ﾉ´▽｀)ﾉ♪");
            return true;
        } else {
            sender.sendMessage("此命令只能由玩家執行。");
            return false;
        }
    }
}
