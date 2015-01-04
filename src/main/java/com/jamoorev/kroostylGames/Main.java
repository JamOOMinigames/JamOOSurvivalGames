package com.jamoorev.kroostylGames;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
		
	public Main() {
		instance = this;
	}
	
	public void onLoad() {
		// This is where we load the lobby!
	}
	
	public void onEnable() {	
        Bukkit.getMessenger().registerOutgoingPluginChannel(instance, "BungeeCord");
		
		getServer().getPluginManager().registerEvents(new EventListener(), instance);
	}
	
	public void onDisable() {
		
	}
	

	
}
