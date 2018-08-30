package genesy.plugin.kdl;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class InteractListener implements Listener {

	private Plugin plugin;
	private Server server;
	public InteractListener() {
		
	}
	
	public InteractListener(Plugin pl, Server srv) {
		plugin = pl;
		server = srv;
	}

	
	public void onPlayerInteract(PlayerInteractAtEntityEvent e) {
		if(e.getPlayer().isSneaking() && e.getRightClicked() instanceof Player){
			Player player = e.getPlayer();
			Player victim = (Player) e.getRightClicked();
            e.setCancelled(true);
            Inventory inv = Bukkit.createInventory(null, 9, victim.getDisplayName() + " Inventory");
            player.openInventory(inv);
		}
	}
	
		
}
