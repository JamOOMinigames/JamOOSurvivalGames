package com.jamoorev.kroostylGames.map;

import org.bukkit.Location;
import org.bukkit.Material;

import com.jamoorev.kroostylGames.Locations;
import com.jamoorev.kroostylGames.Main;

public class SpawnPlatformThread implements Runnable{

	public void run() {
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
