package net.elytrapvp.elytralibrary;

import net.elytrapvp.elytralibrary.listeners.InventoryClick;
import net.elytrapvp.elytralibrary.listeners.InventoryClose;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraLibrary extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        registerListeners();
    }

    public void registerListeners()
    {
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClose(), this);
    }

}
