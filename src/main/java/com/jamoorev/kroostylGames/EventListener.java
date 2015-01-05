package com.jamoorev.kroostylGames;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.jamoorev.kroostylGames.title.TitleManager;
import com.jamoorev.kroostylGames.utils.Symbols;

public class EventListener implements Listener{
	
	@EventHandler
	public void entityMoveInPreEvent(PlayerMoveEvent event) {
		if (GameState.getGameState() == 1) {
			if (Teams.inGame.contains(event.getPlayer().getUniqueId())) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event) {
		// Handle login stuff here
		if (GameState.getGameState() > 0) {
			event.setJoinMessage("");
			Teams.joinSpectators(event.getPlayer());
		} else {
			event.setJoinMessage(ChatColor.DARK_PURPLE + "KG " + ChatColor.RESET + Symbols.box + " " + ChatColor.DARK_GRAY + event.getPlayer().getName() + " has joined the game (" + Main.instance.getServer().getWorld("world").getPlayers().size() + "/16)");
		}
	}
	
	@EventHandler
	public void playerLeaveEvent(PlayerQuitEvent event) {
		// Handle log out stuff here
		Teams.stripOfAllTeams(event.getPlayer());
		event.setQuitMessage(ChatColor.DARK_PURPLE + "KG " + ChatColor.RESET + Symbols.box + " " + ChatColor.DARK_GRAY + event.getPlayer().getName() + " has quit the game");
	}
	
	@EventHandler
	public void playerDeath(PlayerDeathEvent event) {
		event.setDroppedExp(0);
		if (GameState.getGameState() == 2) {
			if (event.getEntity().getLastDamageCause().getEntity() != null && event.getEntity().getLastDamageCause().getEntity() instanceof Player) {
				Player killer = (Player)event.getEntity().getLastDamageCause().getEntity();
				TitleManager.sendFloatingText(event.getEntity(), ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "YOU DIED", ChatColor.LIGHT_PURPLE + "You were killed by " + killer.getName(), 0, 40, 20);
			} else {
				TitleManager.sendFloatingText(event.getEntity(), ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "YOU DIED","", 0, 40, 20);
			}
			Teams.joinSpectators(event.getEntity());
		}
	}

}
