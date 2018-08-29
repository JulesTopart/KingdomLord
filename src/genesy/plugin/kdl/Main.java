package genesy.plugin.kdl;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		;
	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(
				ChatColor.GRAY + "* " + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " a rejoint la partie");
		for (Player p1 : getServer().getOnlinePlayers()) {
			p1.playSound(p1.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 0);
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		    public void run() {
		    	// TODO add recipe viewer
				final String[] tips = {
						"Vous n'�tes pas oblig� d'utiliser le ressource-pack du serveur. Vous pouvez le desactiver dans le menu dans le menu multijoueur",
						"Si vous �tes citoyen, vous pouvez faire /sethome home pour enregistrer la position de votre maison. Vous pouvez �galement faire /home pour vous y t�l�porter",
						"Au d�but de votre aventure, seul la pioche en bois est absolument n�cessaire pour avancer les autres outils en bois finiront vite a la poubelle...",
						"Ne creuser jamais directement sous vos pieds ! Vous pourriez faire une chute mortelle ou finir en cendres",
						"Ne creuser jamais directement au dessus de vous ! Vous pourriez finir enseveli !",
						"Vous avez trouv� du diamant? V�rifiez qu'il n'y a pas de lave aux alentours...",
						"Il faut seulement 10 blocs d'obsidienne pour faire un portail, les coins peuvent �tre constitu� de n'importe quel bloc",
						"Attention ! les creepers sont de vrai ninja ! Mind your back",
						"Les boucliers prot�ge des fl�ches et vous donne un bonus de protection",
						"Les airaign�s sont rapide elle vous rattraperons si vous �tes trop fatigu� pour sprinter... Frappez les en reculant mais attention aux platanes",
						"Ne tentez pas de cascade trop risqu�... Entrainez vous sur des parcours dans votre jardin ! Mieux vaut tomber dans les fleurs que dans un ravin",
						"Si vous �tes champion de saut en longueur vous pouvez tentez de sauter sur 4 blocs de long et 1 de haut",
						"Si vous �tes envahi par les monstres, et qu'il y a un creeper dans le lot, faite le exploser. Il vous debarassera des autres",
						"Les endermans detestent l'eau, et ne vous attaquerons pas si vous les regardais avec un citrouille sur la t�te",
						"Pour tuer un enderman, viser les jambes, cela r�duit la probabilit� qu'il se t�l�porte",
						"La chair pourri vous donnera faim, mais rapportera finalement 1 gigot si vous ne bougez pas trop. Pratique en camping !",
						"Stocker vos objets pr�cieux dans une enderchest ils seront � l'abri de tout d�sagr�ments", "", "", "",
						"Vous ne pouvez casser les enderchest qu'avec un pioche �quip�e del'enchantement silk touch ! Sans quoi l'enderchest sera transformer en 8 blocs d'obsidienne ", 
						"Prenez toujours un sceau d'eau lorsque vous partez miner, il peuvent amortir les chutes et refroidir la lave"};

				 int rnd = new Random().nextInt(tips.length);
				 p.sendMessage(ChatColor.GREEN + "Astuce : "+ ChatColor.ITALIC + ChatColor.WHITE + tips[rnd]);           
		    }
		}, 20L);
	}

	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(
				ChatColor.GRAY + "    * " + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " a quitt�(e) la partie");
		for (Player p1 : getServer().getOnlinePlayers()) {
			p1.playSound(p1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0);
		}
	}

}