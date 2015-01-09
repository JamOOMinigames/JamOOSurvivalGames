package com.jamoorev.kroostylGames.map;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Location;

import com.jamoorev.kroostylGames.Main;

public class Maps {

	public static ArrayList<Map> maps = new ArrayList<Map>();
	
	public static Map map;
	
	public static void addAllMaps() {
		// Add all the maps here!
		
		Map main = new Map("Main","Team Doorknob and MrBurd",new File(Main.instance.getDataFolder(),"world_main.zip"),new Location(Main.instance.getServer().getWorld("world_kg"),51, 64, 3));
	
		addMapToMaps(main);
	}
	
	public static void addMapToMaps(Map map) {
		maps.add(map);
		Main.instance.getLogger().info("Added map to list: " + map);
	}
	
}
