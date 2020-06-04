package net.elytrapvp.elytralibrary.gui;

import net.elytrapvp.elytralibrary.items.ItemBuilder;
import net.elytrapvp.elytralibrary.items.SkullBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum CommonIcon
{
    FILLER(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName(" ").build()),
    GREEN_BACKWARD(new SkullBuilder("754aaab39764641ff8627932d2fe1a4ccced96537508d4abc6cd5fbbb87913").setDisplayName("&aBack").build()),
    GREEN_FORWARD(new SkullBuilder("61d0f82a2a4cdd85f79f4d9d9798f9c3a5bccbe9c7f2e27c5fc836651a8f3f45").setDisplayName("&aNext").build()),
    RED_BACKWARD(new SkullBuilder("edf5c2f893bd3f89ca40703ded3e42dd0fbdba6f6768c8789afdff1fa78bf6").setDisplayName("&cBack").build()),
    RED_FORWARD(new SkullBuilder("abae89e92ac362635ba3e9fb7c12b7ddd9b38adb11df8aa1aff3e51ac428a4").setDisplayName("&cNext").build()),
    RESET(new ItemBuilder(Material.BARRIER).setDisplayName("&cReset").build());

    private ItemStack icon;

    CommonIcon(ItemStack icon)
    {
        this.icon = icon;
    }

    public ItemStack getIcon()
    {
        return icon;
    }
}