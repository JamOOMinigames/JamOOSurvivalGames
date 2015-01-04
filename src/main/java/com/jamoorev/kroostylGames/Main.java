package com.jamoorev.kroostylGames;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	public static int gameState;
	
	public Main() {
		instance = this;
	}
	
	public void onEnable() {
		gameState = 0;
	}
	
	public void onDisable() {
		
	}
	
	public void onLoad() {
		
	}
	
}
