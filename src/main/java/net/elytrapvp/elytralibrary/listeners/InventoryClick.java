package net.elytrapvp.elytralibrary.listeners;

import net.elytrapvp.elytralibrary.gui.CustomGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class InventoryClick implements Listener
{

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        if(!(e.getWhoClicked() instanceof Player))
            return;

        Player p = (Player) e.getWhoClicked();
        UUID pU = p.getUniqueId();

        UUID iU = CustomGUI.getOpenInventories().get(pU);

        if(iU == null)
            return;

        e.setCancelled(true);
        CustomGUI gui = CustomGUI.getInventories().get(iU);
        CustomGUI.ClickAction action = gui.getActions().get(e.getSlot());

        if(action != null)
            action.click(p);
    }

}
