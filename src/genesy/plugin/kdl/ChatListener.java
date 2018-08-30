package genesy.plugin.kdl;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class ChatListener implements Listener {

	private Server serverInstance;
	private Plugin pluginInstance;
	
	public ChatListener() {
	}
	
	public ChatListener(Server s, Plugin pl) {
		serverInstance = s;
		pluginInstance = pl;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(
				ChatColor.GRAY + "* " + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " a rejoint la partie");
		for (Player p1 : serverInstance.getOnlinePlayers()) {
			p1.playSound(p1.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 0);
		}

		Bukkit.getScheduler().scheduleSyncDelayedTask(pluginInstance, new Runnable() {
			public void run() {
				FileConfiguration config = pluginInstance.getConfig();
				List<String> tips = config.getStringList("tips");

				int rnd = new Random().nextInt(tips.size());
				p.sendMessage(ChatColor.GREEN + "Astuce : " + ChatColor.ITALIC + ChatColor.WHITE + tips.get(rnd));
			}
		}, 20L);
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(
				ChatColor.GRAY + "    * " + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " a quitté(e) la partie");
		for (Player p1 : serverInstance.getOnlinePlayers()) {
			p1.playSound(p1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0);
		}
	}
}
