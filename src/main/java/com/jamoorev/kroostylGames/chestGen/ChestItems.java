package com.jamoorev.kroostylGames.chestGen;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ChestItems {

	
	public static ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
	
	public static void addItemsToList() {
		stacks.add(new ItemStack(Material.WOOD_SWORD,1));
		stacks.add(new ItemStack(Material.STONE_SWORD));
		stacks.add(new ItemStack(Material.IRON_SWORD));
		stacks.add(new ItemStack(Material.GOLD_SWORD));
		
		stacks.add(new ItemStack(Material.WOOD_AXE));
		stacks.add(new ItemStack(Material.STONE_AXE));
		stacks.add(new ItemStack(Material.GOLD_AXE));
		stacks.add(new ItemStack(Material.IRON_AXE));
		stacks.add(new ItemStack(Material.DIAMOND_AXE));
		
		for (int i = 0; i < 5;i++) {
			stacks.add(new ItemStack(Material.APPLE,i+1));
			stacks.add(new ItemStack(Material.COOKED_BEEF,i+1));
			stacks.add(new ItemStack(Material.COOKED_CHICKEN,i+1));
			for (int ii = 0; ii < 4;ii++) {
				stacks.add(new ItemStack(Material.RAW_FISH,i+1,(short)ii));
			}
			stacks.add(new ItemStack(Material.RAW_BEEF,i+1));
			stacks.add(new ItemStack(Material.RAW_CHICKEN,i+1));

			stacks.add(new ItemStack(Material.PUMPKIN_PIE,i+1));
		
			stacks.add(new ItemStack(Material.CARROT,i+1));
		}
		
		stacks.add(new ItemStack(Material.FISHING_ROD));
		
		stacks.add(new ItemStack(Material.LEATHER_HELMET));
		stacks.add(new ItemStack(Material.LEATHER_CHESTPLATE));
		stacks.add(new ItemStack(Material.LEATHER_HELMET));
		stacks.add(new ItemStack(Material.LEATHER_BOOTS));
		
		stacks.add(new ItemStack(Material.GOLD_HELMET));
		stacks.add(new ItemStack(Material.GOLD_CHESTPLATE));
		stacks.add(new ItemStack(Material.GOLD_LEGGINGS));
		stacks.add(new ItemStack(Material.GOLD_BOOTS));
		
		stacks.add(new ItemStack(Material.CHAINMAIL_HELMET));
		stacks.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		stacks.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		stacks.add(new ItemStack(Material.CHAINMAIL_BOOTS));
		
		stacks.add(new ItemStack(Material.IRON_HELMET));
		stacks.add(new ItemStack(Material.IRON_CHESTPLATE));
		stacks.add(new ItemStack(Material.IRON_LEGGINGS));
		stacks.add(new ItemStack(Material.IRON_BOOTS));
				
		stacks.add(new ItemStack(Material.DIAMOND_SWORD));
		
		for (int i = 0; i < 5; i++) {
			stacks.add(new ItemStack(Material.STICK,i));
		}
		
		for (int i = 0; i < 4;i++) { 
			stacks.add(new ItemStack(Material.IRON_INGOT,i));
			stacks.add(new ItemStack(Material.GOLD_INGOT,i));
		}
		
		for (int i = 0; i < 3;i++) {
			stacks.add(new ItemStack(Material.DIAMOND,i));
		}
		
	}
	
}
