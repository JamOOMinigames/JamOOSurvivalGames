package com.jamoorev.kroostylGames.chestGen;


import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jamoorev.kroostylGames.Main;

public class ChestGenThread implements Runnable{

	@Override
	public void run() {
		for (int x = -1000; x < 1000;x++) {
			for (int y = 0; y < 255; y++) {
				for (int z = -1000; z < 1000;z++) {
					Location blockLoc = new Location(Main.instance.getServer().getWorld("world_kg"),x,y,z);
					if (Main.instance.getServer().getWorld("world_kg").getBlockAt(blockLoc).getType() == Material.CHEST) {
							Chest chest = (Chest) Main.instance.getServer().getWorld("world_kg").getBlockAt(blockLoc).getState();
							Inventory inventory = chest.getInventory();
							inventory.clear();
                            ItemStack stack;

                            stack = ChestItems.stacks.get(new Random(Main.instance.getServer().getWorld("world").getFullTime()).nextInt(ChestItems.stacks.size()));
							
                            setInRandomSlot(inventory,stack);
					}
				}
			}
		}		
	}
	
    public static void setInRandomSlot(Inventory inventory, ItemStack stack) {
        inventory.setItem(new Random(Main.instance.getServer().getWorld("world").getFullTime()).nextInt(inventory.getSize() - 1),stack);
    }

}
