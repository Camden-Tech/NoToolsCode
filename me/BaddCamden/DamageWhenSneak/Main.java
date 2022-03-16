package me.BaddCamden.DamageWhenSneak;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.phoenix.manhuntplus.api.HuntStartEvent;
import me.phoenix.manhuntplus.commands.Hunter;

public class Main  extends JavaPlugin{
	
	me.phoenix.manhuntplus.Main MP;
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		
		MP = (me.phoenix.manhuntplus.Main) pm.getPlugin("ManhuntPlus");
		
		RegisterEvents listener = new RegisterEvents(this);
		pm.registerEvents(listener, this );
		
	}

	public me.phoenix.manhuntplus.Main getMP(){
		return MP;
	}
}
