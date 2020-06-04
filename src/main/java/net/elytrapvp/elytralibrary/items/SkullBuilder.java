package net.elytrapvp.elytralibrary.items;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;

public class SkullBuilder extends ItemBuilder
{

    /**
     * Create a SkullBuilder
     * @param id Skull Texture
     */
    public SkullBuilder(String id)
    {
        // Temporarily set the item to a player head.
        super(Material.PLAYER_HEAD);

        String url = "http://textures.minecraft.net/texture/" + id;

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);

        ItemMeta skullMeta = skull.getItemMeta();
        GameProfile profile = new GameProfile(java.util.UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;

        try
        {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        }
        catch (NoSuchFieldException | SecurityException e)
        {
            e.printStackTrace();
        }

        profileField.setAccessible(true);

        try
        {
            profileField.set(skullMeta, profile);
        }
        catch (IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

        skull.setItemMeta(skullMeta);
        super.setItem(skull);
    }

}
