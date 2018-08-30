package genesy.plugin.kdl;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ChatListener(getServer(), this), this);
		getServer().getPluginManager().registerEvents(new InteractListener(getServer(), this), this);
		this.saveDefaultConfig();
	}

	@Override
	public void onDisable() {

	}
}
