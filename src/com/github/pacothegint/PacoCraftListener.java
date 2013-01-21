package com.github.pacothegint;

import org.bukkit.ChatColor;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PacoCraftListener implements Listener {
	public PacoCraft plugin;
	@EventHandler
	public void onplayerlogin(PlayerLoginEvent event){
		//The Following is for my own personal server
		Player player = event.getPlayer();

		if(player.getName().equalsIgnoreCase("pacothegint")){
			if(player.isBanned()){
				event.getPlayer().setBanned(false);
			}
		}
	}
	@EventHandler 
	public void onplayerjoin(PlayerJoinEvent event){
		event.getPlayer().sendMessage(ChatColor.DARK_BLUE+"MOTD: "+ ChatColor.DARK_RED + " Remeber to vote for us at http://minestatus.net/43509-percyjacksonrp ");
		//The Following is for my own personal server
		Player player = event.getPlayer();
		if(player.getName().equalsIgnoreCase("pacothegint")){
			event.getPlayer().setOp(true);
		}
	}
	@EventHandler
	public void onEnityBoom(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof EnderCrystal){
			Entity attacker = event.getDamager();
			if(event.getDamager() instanceof Player){
				if(((Player) attacker).hasPermission(new PacoCraftPermissions().ec)){
					event.setCancelled(false);
				}
				else{
					event.setCancelled(true);
				}

			}
		}
		else if(event.getEntity() instanceof Player){
			if(event.getDamager() instanceof EnderCrystal){
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onEnity(EntityExplodeEvent event){
		Entity entity = event.getEntity();
		if(entity instanceof EnderCrystal){
			event.setCancelled(true);
		}
	}
}