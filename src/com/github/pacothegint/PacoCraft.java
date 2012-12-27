package com.github.pacothegint;


import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;



public class PacoCraft extends JavaPlugin {
	private Listener PacoChatListener = new PacoCraftPlayerListener(this);
	public static PacoCraft plugin; 
	public final Logger logger = Logger.getLogger("Minecraft");


	@Override
	public void onEnable(){
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " Version " + pdffile.getVersion() + " Has been Enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.PacoChatListener, this);

	}
	@Override
	public void onDisable(){
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " Has been Disabled!");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("test")){
			player.sendMessage("This is a test");
		}
		return true;
	}
	
}