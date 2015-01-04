package com.jamoorev.kroostylGames.chestGen;

public class ChestGeneration {

	public static void init() {
		ChestItems.addItemsToList();
	}
	
	public static void generateNewChestContents() {
		new Thread(new ChestGenThread()).start();
	}
	
}
