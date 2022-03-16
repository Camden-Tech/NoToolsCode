package me.BaddCamden.DamageWhenSneak;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.player.PlayerQuitEvent;

public class RegisterEvents implements Listener{
	Main mainPlugin;
	me.phoenix.manhuntplus.Main MP;
	public RegisterEvents(Main main) {
		mainPlugin = main;
		MP = main.getMP();
	} 
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		boolean speedRunnersLeft = false;
		for(String s : MP.speedRunners) {
			for(Player oP : Bukkit.getOnlinePlayers()) {
				if(Bukkit.getPlayer(s).equals(oP)) speedRunnersLeft = true;
			}
		}
		if(!speedRunnersLeft) {
			for(String h : MP.hunters) {
				Player hunter = Bukkit.getPlayer(h);
				hunter.removePotionEffect(PotionEffectType.POISON);
			}
		}
	}
	
	
	@EventHandler
	public void onShift(PlayerToggleSneakEvent e) {
		
		for(String s : MP.speedRunners) {
			Player p = Bukkit.getPlayer(s);
			if(p.equals(e.getPlayer())) {
				if(e.isSneaking()) {
				for(String h : MP.hunters) {
					Player hunter = Bukkit.getPlayer(h);
					hunter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100000, 0, true));
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 0, true));
				break;
				} else {
					for(String h : MP.hunters) {
						Player hunter = Bukkit.getPlayer(h);
						hunter.removePotionEffect(PotionEffectType.POISON);
					}
					p.removePotionEffect(PotionEffectType.GLOWING);
				}
			}
		}
		
	}
	
}
