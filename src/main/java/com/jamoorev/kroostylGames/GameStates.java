package com.jamoorev.kroostylGames;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class GameStates {

	public static void startPreGame() {
		
	}
	
	public static void startGame() {
		
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
