package com.jamoorev.kroostylGames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.jamoorev.kroostylGames.map.MapGeneration;
import com.jamoorev.kroostylGames.map.Maps;
import com.jamoorev.kroostylGames.title.TitleManager;
import com.jamoorev.kroostylGames.utils.Symbols;

public class EventListener implements Listener{
	
	@EventHandler
	public void entityMoveInPreEvent(PlayerMoveEvent event) {
		if (GameState.getGameState() == 1) {
			if (Teams.inGame.contains(event.getPlayer().getUniqueId())) {
				if (event.getTo().distance(event.getFrom()) > 1) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event) {
		// Handle login stuff here
		event.getPlayer().teleport(new Location(Bukkit.getWorld("world"),51,127,3));
		if (GameState.getGameState() > 0) {
			event.setJoinMessage("");
			Teams.joinSpectators(event.getPlayer());
			if (GameState.getGameState() == 1) {
				TitleManager.sendHeaderAndFooter(event.getPlayer(), ChatColor.LIGHT_PURPLE + "Kroostyl Games", ChatColor.BLUE + "Pre-Game");
			} else if (GameState.getGameState() == 2){
				TitleManager.sendHeaderAndFooter(event.getPlayer(), ChatColor.LIGHT_PURPLE + "Kroostyl Games", ChatColor.BLUE + "In-Game");
			} else {
				TitleManager.sendHeaderAndFooter(event.getPlayer(), ChatColor.LIGHT_PURPLE + "Kroostyl Games", ChatColor.BLUE + "Post-Game");
			}
		} else {
			event.setJoinMessage(Symbols.pluginIntro + ChatColor.DARK_GRAY + event.getPlayer().getName() + " has joined the game (" + (Main.instance.getServer().getWorld("world").getPlayers().size() + 1) + "/16)");
			TitleManager.sendHeaderAndFooter(event.getPlayer(), ChatColor.LIGHT_PURPLE + "Kroostyl Games", ChatColor.BLUE + "Lobby");
			if (event.getPlayer().getWorld().getPlayers().size() >= 8) {
				for (Player player : event.getPlayer().getWorld().getPlayers()) {
					player.sendMessage(Symbols.pluginIntro + ChatColor.GOLD + "Pre-game will begin in 1 minute!");
					player.setLevel(60);
				}
				
				new BukkitRunnable() {
					@Override
					public void run() {
						for (Player player : Bukkit.getWorld("world").getPlayers()) {
							int getLevel = player.getLevel();
							player.setLevel(getLevel - 1);
						}
					}
				}.runTaskTimer(Main.instance, 20L, 1200L);
				
				new BukkitRunnable() {
					public void run() {
						MapGeneration.setNewWorld();
						for (Player player : Bukkit.getWorld("world").getPlayers()) {
							TitleManager.sendFloatingText(player, ChatColor.RED + "The current map is:", ChatColor.AQUA + Maps.map.toString(), 20, 100, 20);
						}
					}
				}.runTaskLater(Main.instance, 600L);
				
				new BukkitRunnable() {
					public void run() {
						for (Player player : Bukkit.getWorld("world").getPlayers()) {
							Teams.joinPlayers(player);
						}
						GameState.triggerNextGameState();
					}
				}.runTaskLater(Main.instance, 1200L);
			}
		}
	}
	
	@EventHandler
	public void playerLeaveEvent(PlayerQuitEvent event) {
		// Handle log out stuff here
		Teams.stripOfAllTeams(event.getPlayer());
		event.setQuitMessage(Symbols.pluginIntro + ChatColor.DARK_GRAY + event.getPlayer().getName() + " has quit the game");
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
	
	public static boolean processCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("startKG")) {
				if (Bukkit.getWorld("world").getPlayers().size() >= 3) {
					for (Player player : Bukkit.getWorld("world").getPlayers()) {
						player.sendMessage(Symbols.pluginIntro + ChatColor.GOLD + "Pre-game will begin in 1 minute!");
						player.setLevel(60);
					}
				
					new BukkitRunnable() {
						public void run() {
							for (Player player : Bukkit.getWorld("world").getPlayers()) {
								int getLevel = player.getLevel();
								player.setLevel(getLevel - 1);
							}
						}
					}.runTaskTimer(Main.instance, 20L, 1200L);
				
					new BukkitRunnable() {
						public void run() {
							MapGeneration.setNewWorld();
							for (Player player : Bukkit.getWorld("world").getPlayers()) {
								TitleManager.sendFloatingText(player, ChatColor.RED + "The current map is:", ChatColor.AQUA + Maps.map.toString(), 20, 100, 20);
							}
						}
					}.runTaskLater(Main.instance, 600L);
				
					new BukkitRunnable() {
						public void run() {
							for (Player player : Bukkit.getWorld("world").getPlayers()) {
								Teams.joinPlayers(player);
							}
							GameState.triggerNextGameState();
						}
					}.runTaskLater(Main.instance, 1200L);
				} else {
					sender.sendMessage(ChatColor.RED + "You don't have enough players to start!");
				}
				return true;
		}
		return false;
	}

}
