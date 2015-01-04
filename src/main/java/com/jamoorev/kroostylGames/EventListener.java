package com.jamoorev.kroostylGames;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener{
	
	@EventHandler
	public void entityMoveInPreEvent(PlayerMoveEvent event) {
		if (GameState.getGameState() == 1) {
			if (Teams.inGame.contains(event.getPlayer().getUniqueId())) {
				event.setCancelled(true);
			}
		}
	}

}
