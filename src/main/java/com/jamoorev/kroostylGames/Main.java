package com.jamoorev.kroostylGames;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
	private static Random random;
		
	public Main() {
		instance = this;
	}
	
	public void onLoad() {
		// This is where we load the lobby!
	}
	
	public void onEnable() {	
        Bukkit.getMessenger().registerOutgoingPluginChannel(instance, "BungeeCord");
		
		getServer().getPluginManager().registerEvents(new EventListener(), instance);
		
		GameState.initGameState();
	}
	
	public void onDisable() {
		
	}

	public static Player getPlayer(UUID uuid) {
		return instance.getServer().getPlayer(uuid);
	}
	
	public static Random getRandom() {
		if (random == null) {
			random = new Random(instance.getServer().getWorld("world").getFullTime());
		} else {
			random.setSeed(instance.getServer().getWorld("world").getFullTime());
		}
		return random;
	}
	
}
