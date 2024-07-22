package org.system.sakuraLand_plugin.EventListener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.persistence.PersistentDataType;
import org.system.sakuraLand_plugin.Creater.NewComerGiftCreater;
import org.system.sakuraLand_plugin.global;

public class onNewComer implements Listener {
    private final NewComerGiftCreater creater;

    public onNewComer(NewComerGiftCreater creater) {
        this.creater = creater;
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
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.SHULKER_BOX && item.hasItemMeta()) {
            BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
            if (meta != null && meta.getPersistentDataContainer().has(global.key, PersistentDataType.STRING)) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    org.bukkit.block.ShulkerBox shulkerBox = (org.bukkit.block.ShulkerBox) meta.getBlockState();
                    for (ItemStack content : shulkerBox.getInventory().getContents()) {
                        if (content != null) {
                            player.getInventory().addItem(content);
                        }
                    }
                    player.getInventory().remove(item);
                    player.sendMessage("新手禮包已開啟，物品已放入你的背包。");
                    event.setCancelled(true);
                }
            }
        }
    }
}
