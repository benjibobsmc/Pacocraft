package com.github.pacothegint;


import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.Block;
import org.bukkit.command.Command; 
import org.bukkit.command.CommandSender;



@SuppressWarnings("unused")
public class PacoCraft extends JavaPlugin {
	private Listener Listener = new PacoCraftListener();
	public static PacoCraft plugin; 
	public final Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onEnable(){
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " Version " + pdffile.getVersion() + " Has been Enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.Listener, this);
	}
	@Override
	public void onDisable(){
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " Has been Disabled!");
	}
}