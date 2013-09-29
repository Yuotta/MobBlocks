package Com.Erellion.Yuotta.Main;
/*CREATED BY YUOTTA
 * FOR ERELLION.COM
 * VISIT THE SERVER mc.erellion.com
 */
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;



public class Config extends MobBlocks {

	private MobBlocks plugin;
	  public FileConfiguration config;

	
	public Config (MobBlocks plugin) {
		this.plugin = plugin;
	}
	
	  public void loadConfiguration()
	  {
	    this.config = getConfig();
	    this.config.options().copyDefaults(true);
	    saveConfig();
	  }
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		addPlayerToConfig(event.getPlayer());
	}
	
	public void addPlayerToConfig(Player player) {
		FileConfiguration config = plugin.getConfig();
		if(!config.contains(player.getName())) {
			config.createSection(player.getName());
			System.out.println(player + " was added to the config");
			plugin.saveConfig();
		}
	}

}
