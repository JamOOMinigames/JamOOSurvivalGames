package com.jamoorev.kroostylGames.map;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;

import com.jamoorev.kroostylGames.Main;
import com.jamoorev.kroostylGames.utils.FileHelper;


public class MapGeneration {

	public static void init() {
		Maps.addAllMaps();
	}
	
	public static void setNewWorld() {
        
        FileHelper.deleteDir(new File(Main.instance.getServer().getWorldContainer(), "world_kg"));
        int map = Main.getRandom().nextInt(Maps.maps.size());
        
        if (Maps.maps.get(map) != null) {
            try {
				FileHelper.unzip(Maps.maps.get(map).getMapFile(), new File(Main.instance.getServer().getWorldContainer(), "world_kg"));
				Maps.map = Maps.maps.get(map);
				Main.instance.getLogger().info("Loaded: " + Maps.map);
            } catch (IOException e) {
				e.printStackTrace();
				Main.instance.getServer().shutdown();
			}
            
        }
        
        Bukkit.createWorld(new WorldCreator("world_kg"));
		
        // Init spawn platform location finder (Check for iron block and add one up on y-axis) (May need to multi-thread)
        
        new Thread(new SpawnPlatformThread()).run();
        
	}
	
}
