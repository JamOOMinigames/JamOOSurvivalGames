package com.jamoorev.kroostylGames.map;

import java.io.File;

import org.bukkit.Location;

public class Map {

	private String name, author;
	
	private Location center;
	
	private File mapFile;
	
	public Map(String name, String author, File mapFile, Location center) {
		this.name = name;
		this.author = author;
		this.center = center;
		this.mapFile = mapFile;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public Location getCenter() {
		return this.center;
	}
	
	public File getMapFile() {
		return this.mapFile;
	}
	
	@Override
	public String toString() {
		return this.name + " by " + this.author;
	}
	
}
