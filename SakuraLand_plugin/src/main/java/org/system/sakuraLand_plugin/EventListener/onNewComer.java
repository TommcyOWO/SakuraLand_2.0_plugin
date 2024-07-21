package org.system.sakuraLand_plugin.EventListener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.persistence.PersistentDataType;
import org.system.sakuraLand_plugin.Creater.NewComerGiftCreater;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import org.system.sakuraLand_plugin.global;

public class NewComer implements Listener {
    private final NewComerGiftCreater creater;

    public NewComer(Plugin plugin) {
        this.creater = new NewComerGiftCreater(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            player.getInventory().setItemInMainHand(creater.getNewPlayerGift());
            player.sendMessage("歡迎來到櫻花鄉伺服器!!");
            player.sendMessage("這是你的新手禮包~(ﾉ´▽｀)ﾉ♪");
        } else {
            player.sendMessage("歡迎回來!(*´∀`)~♥");
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getType() == InventoryType.SHULKER_BOX) {
            Inventory inventory = event.getInventory();
            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
            if (item.getType() == Material.SHULKER_BOX && item.hasItemMeta()) {
                BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
                if (meta != null && meta.getPersistentDataContainer().has(global.key, PersistentDataType.STRING)) {
                    Player player = (Player) event.getPlayer();
                    for (ItemStack content : inventory.getContents()) {
                        if (content != null) {
                            player.getInventory().addItem(content);
                        }
                    }
                    player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    player.sendMessage("新手禮包已關閉，剩餘物品會放入你的背包。");
                }
            }
        }
    }
}
