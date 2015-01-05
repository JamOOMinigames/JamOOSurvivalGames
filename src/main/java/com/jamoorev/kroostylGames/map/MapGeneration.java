package com.jamoorev.kroostylGames.map;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldCreator;

import com.jamoorev.kroostylGames.Locations;
import com.jamoorev.kroostylGames.Main;
import com.jamoorev.kroostylGames.utils.FileHelper;


public class MapGeneration {

	public static void init() {
		Maps.addAllMaps();
	}
	
	public static void setNewWorld() {
		Bukkit.createWorld(new WorldCreator("world_kg"));
		
        if (Bukkit.getWorld("world_kg") != null) {
        	Bukkit.unloadWorld(Bukkit.getWorld("world_kg"), false);
        }
        
        FileHelper.deleteDir(new File(Main.instance.getServer().getWorldContainer(), "world_kg"));
        int map = new Random(Main.instance.getServer().getWorld("world").getFullTime()).nextInt(Maps.maps.size());
        
        if (Maps.maps.get(map) != null) {
            try {
				FileHelper.unzip(Maps.maps.get(map).getMapFile(), new File(Main.instance.getServer().getWorldContainer(), "world_kg"));
				Main.instance.getLogger().info("Loaded: " + Maps.map);
            } catch (IOException e) {
				e.printStackTrace();
				Main.instance.getServer().shutdown();
			}
            
        }
        
        // Init spawn platform location finder (Check for iron block and add one up on y-axis) (May need to multi-thread)
        
        for (int x = Maps.map.getCenter().getBlockX() - 40; x < Maps.map.getCenter().getBlockX() + 40;x++) {
        	for (int y = Maps.map.getCenter().getBlockY() - 10; y < Maps.map.getCenter().getBlockY() + 10; y++) {
        		for (int z = Maps.map.getCenter().getBlockZ() - 40; z < Maps.map.getCenter().getBlockZ() + 40;z++) {
        			
        			Location blockLoc = new Location(Main.instance.getServer().getWorld("world_kg"),x,y,z);
        			
        			if (Main.instance.getServer().getWorld("world_kg").getBlockAt(blockLoc) != null && Main.instance.getServer().getWorld("world_kg").getBlockAt(blockLoc).getType() == Material.IRON_BLOCK) {
        				if (!Locations.spawnPlatforms.contains(blockLoc.add(0, 1, 0))) {
        					Locations.spawnPlatforms.add(blockLoc.add(0,1,0));
        				}
        			}
        			
        		}
        	}
        }
        
	}
	
}
