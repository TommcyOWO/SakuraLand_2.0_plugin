package org.system.sakuraLand_plugin.Creater;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.system.sakuraLand_plugin.global;

import java.util.List;

public class NewComerGiftCreater {
    private final Plugin plugin;
    private final NamespacedKey key;

    public NewComerGiftCreater(Plugin plugin) {
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, "newcomer_gift");
        global.key = this.key;  // 儲存 NamespacedKey 供全局使用
    }

    public ItemStack getNewPlayerGift() {
        ItemStack giftBox = new ItemStack(Material.SHULKER_BOX, 1);
        BlockStateMeta meta = (BlockStateMeta) giftBox.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("新手禮包");
            meta.setLore(List.of("裡面有哪些東西呢(。ヘ°)?"));
            meta.setUnbreakable(true);
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "newcomer_gift");

            org.bukkit.block.ShulkerBox shulkerBox = (org.bukkit.block.ShulkerBox) meta.getBlockState();
            Inventory inventory = shulkerBox.getInventory();

            // 添加物品到界浮盒
            inventory.addItem(new ItemStack(Material.STONE_AXE, 1));
            inventory.addItem(new ItemStack(Material.STONE_SHOVEL, 1));
            inventory.addItem(new ItemStack(Material.COPPER_INGOT, 12));
            inventory.addItem(new ItemStack(Material.COOKED_BEEF, 32));
            inventory.addItem(new ItemStack(Material.BAKED_POTATO, 16));
            inventory.addItem(new ItemStack(Material.COOKED_PORKCHOP, 32));

            meta.setBlockState(shulkerBox);
            giftBox.setItemMeta(meta);
        }

        return giftBox;
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
