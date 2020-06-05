package net.elytrapvp.elytralibrary.gui;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class CustomGUI
{
    private static Map<UUID, CustomGUI> inventories = new HashMap<>();
    private static Map<UUID, UUID> openInventories = new HashMap<>();

    private Inventory inventory;
    private UUID uuid;
    private Map<Integer, ClickAction> actions;

    public CustomGUI(int size, String name)
    {
        uuid = UUID.randomUUID();
        inventory = Bukkit.createInventory(null, size, ChatUtils.translate(name));
        actions = new HashMap<>();

        inventories.put(uuid, this);
    }

    public static Map<UUID, CustomGUI> getInventories()
    {
        return inventories;
    }

    public static Map<UUID, UUID> getOpenInventories()
    {
        return openInventories;
    }

    public void delete()
    {
        inventories.remove(getUuid());
    }

    public Map<Integer, ClickAction> getActions()
    {
        return actions;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public void setItem(int slot, ItemStack item, ClickAction action)
    {
        inventory.setItem(slot, item);

        if(actions != null)
            actions.put(slot, action);
    }

    public void setItem(int slot, ItemStack stack)
    {
        setItem(slot, stack, null);
    }

    public void open(Player p)
    {
        p.openInventory(inventory);
        openInventories.put(p.getUniqueId(), getUuid());
    }

    public interface ClickAction
    {
        void click(Player player);
    }
}
