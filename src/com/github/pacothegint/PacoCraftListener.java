package com.github.pacothegint;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class PacoCraftListener implements Listener {
	public PacoCraft plugin;
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
		else if (event.getEntity() instanceof EnderCrystal){
			if(event.getDamager() instanceof Arrow){
				Arrow a = (Arrow) event.getDamager();
				if(a.getShooter() instanceof Player) {
					Player player = (Player) a.getShooter();
					if(((Player) player).hasPermission(new PacoCraftPermissions().ec)){
						event.setCancelled(false);
					}
					else {
						event.setCancelled(true);
					}
				}
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