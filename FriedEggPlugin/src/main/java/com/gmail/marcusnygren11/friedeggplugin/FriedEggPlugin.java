package com.gmail.marcusnygren11.friedeggplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class FriedEggPlugin extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft");
	public ItemStack friedEgg;

	//Method that clears the recipe list to the default when the mod gets disabled.
	@Override
	public void onDisable() {
		getServer().clearRecipes();
	}

	//Method that creates the recipe and the item and then adds them to the game after enabling the mod.
	@Override
	public void onEnable() {
		ItemStack fried_egg = new ItemStack(Material.COOKED_BEEF);
		ItemMeta meta = fried_egg.getItemMeta();
		meta.setDisplayName("Fried Egg");
		List<String> lore = new ArrayList<String>();
		lore.add("Sunny Side down.");
		meta.setLore(lore);
		fried_egg.setItemMeta(meta);
		FurnaceRecipe recipe = new FurnaceRecipe(new ItemStack(fried_egg),
				Material.EGG);
		getServer().addRecipe(recipe);
	}
}