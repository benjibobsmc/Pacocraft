package com.github.pacothegint;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PacoCraftPlayerListener implements Listener {
	public PacoCraft plugin;
	public PacoCraftPlayerListener(PacoCraft instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onplayerjoin(PlayerJoinEvent event){
		event.getPlayer().sendMessage(ChatColor.DARK_BLUE+"MOTD:"ChatColor.DARK_RED + "Remeber to vote for us at ")
	}
	
}


