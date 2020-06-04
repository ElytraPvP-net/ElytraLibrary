package net.elytrapvp.elytralibrary.listeners;

import net.elytrapvp.elytralibrary.gui.CustomGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerQuit implements Listener
{
    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        UUID pU = p.getUniqueId();

        UUID iU = CustomGUI.getOpenInventories().get(pU);
        CustomGUI gui = CustomGUI.getInventories().get(iU);
        gui.delete();

        CustomGUI.getOpenInventories().remove(pU);
    }
}
