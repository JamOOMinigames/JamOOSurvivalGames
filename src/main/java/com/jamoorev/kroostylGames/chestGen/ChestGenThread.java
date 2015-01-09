package com.jamoorev.kroostylGames.chestGen;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jamoorev.kroostylGames.Main;
import com.jamoorev.kroostylGames.map.Maps;

public class ChestGenThread implements Runnable{

	@Override
	public void run() {
		for (int x = Maps.map.getCenter().getBlockX()-500; x < Maps.map.getCenter().getBlockX() + 500;x++) {
			for (int y = 0; y < 255; y++) {
				for (int z = Maps.map.getCenter().getBlockX()-500; z < Maps.map.getCenter().getBlockX() + 500;z++) {
					Location blockLoc = new Location(Main.instance.getServer().getWorld("world_kg"),x,y,z);
					if (Main.instance.getServer().getWorld("world_kg").getBlockAt(blockLoc).getType() == Material.CHEST) {
							Chest chest = (Chest) Main.instance.getServer().getWorld("world_kg").getBlockAt(blockLoc).getState();
							Inventory inventory = chest.getInventory();
							inventory.clear();
                            ItemStack stack;

                            for (int i = 0; i < Main.getRandom().nextInt(10) + 1;i++) {
                            	stack = ChestItems.stacks.get(Main.getRandom().nextInt(ChestItems.stacks.size()));
							
                            	setInRandomSlot(inventory,stack);
                            }
					}
				}
			}
		}		
	}
	
    public static void setInRandomSlot(Inventory inventory, ItemStack stack) {
        inventory.setItem(Main.getRandom().nextInt(inventory.getSize() - 1),stack);
    }

}
