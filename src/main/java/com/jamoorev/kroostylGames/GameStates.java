package com.jamoorev.kroostylGames;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.jamoorev.kroostylGames.chestGen.ChestGeneration;
import com.jamoorev.kroostylGames.utils.Symbols;

public class GameStates {

	public static void startPreGame() {
		for (UUID uuid : Teams.players) {
			Teams.inGame.add(uuid);
		}
		
		for (UUID uuid : Teams.inGame) {
			for (Location loc : Locations.spawnPlatforms) {
				if (!Locations.takenPlatforms.contains(loc)) {
					Main.getPlayer(uuid).teleport(loc);
					Locations.takenPlatforms.add(loc);
					break;
				}
			}
		}
		
		// Chest Generation
		
		ChestGeneration.init();
	}
	
	public static void startGame() {
		ChestGeneration.generateNewChestContents();
		
		new BukkitRunnable() {
			@Override
			public void run() {
				if (GameState.getGameState() == 2) {
					for (UUID uuid : Teams.players) {
						Player player = Main.getPlayer(uuid);
						player.sendMessage(ChatColor.DARK_PURPLE + "KG " + ChatColor.GOLD + Symbols.box + " Sponsers have refilled all the chests!");
					}
				}
			}
		}.runTaskTimer(Main.instance, 24000L, 0L);
		
	}
	
	public static void endGame() {
		
	}
	
	public static void closeEverything() {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("lobby");
    		for (Player player : Main.instance.getServer().getWorld("world").getPlayers()) {
                player.sendPluginMessage(Main.instance, "BungeeCord", out.toByteArray());
    		}
    		
    		new BukkitRunnable() {
			@Override
			public void run() {
				Main.instance.getServer().shutdown();
			}
			
		}.runTaskLater(Main.instance, 20L);
	}
	
}
