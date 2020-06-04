package net.elytrapvp.elytralibrary.listeners;

import net.elytrapvp.elytralibrary.gui.CustomGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

public class InventoryClose implements Listener
{
    @EventHandler
    public void onClose(InventoryCloseEvent e)
    {
        Player p = (Player) e.getPlayer();
        UUID pU = p.getUniqueId();

        UUID iU = CustomGUI.getOpenInventories().get(pU);
        CustomGUI gui = CustomGUI.getInventories().get(iU);
        gui.delete();

        CustomGUI.getOpenInventories().remove(pU);
    }

}
