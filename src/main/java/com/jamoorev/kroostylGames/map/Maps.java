package com.jamoorev.kroostylGames.map;

import java.util.ArrayList;

import com.jamoorev.kroostylGames.Main;

public class Maps {

	public static ArrayList<Map> maps = new ArrayList<Map>();
	
	public static Map map;
	
	public static void addAllMaps() {
		// Add all the maps here!
	}
	
	public static void addMapToMaps(Map map) {
		maps.add(map);
		Main.instance.getLogger().info("Added map to list: " + map);
	}
	
}
