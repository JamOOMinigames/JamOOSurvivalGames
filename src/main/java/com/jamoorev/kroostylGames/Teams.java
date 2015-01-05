package com.jamoorev.kroostylGames;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Teams {

	public static ArrayList<UUID> players = new ArrayList<UUID>();
	
	public static ArrayList<UUID> inGame = new ArrayList<UUID>();
	public static ArrayList<UUID> spectators = new ArrayList<UUID>();
	
	public static void joinSpectators(Player player) {
		joinPlayers(player);
		if (inGame.contains(player.getUniqueId())) {
			inGame.remove(player.getUniqueId());
		}
		player.setGameMode(GameMode.SPECTATOR);
		spectators.add(player.getUniqueId());
	}
	
	public static void joinPlayers(Player player) {
		if (!players.contains(player.getUniqueId())) {
			players.add(player.getUniqueId());
		}
	}
	
	public static void stripOfAllTeams(Player player) {
		if (inGame.contains(player.getUniqueId())) {
			inGame.remove(player.getUniqueId());
		}
		if (spectators.contains(player.getUniqueId())) {
			spectators.remove(player.getUniqueId());
		}
		players.remove(player.getUniqueId());
	}
	
}
