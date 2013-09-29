package Com.Erellion.Yuotta.Main;
/*CREATED BY YUOTTA
 * FOR ERELLION.COM
 * VISIT THE SERVER mc.erellion.com
 */
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Com.Erellion.Yuotta.Blocks.BlockRegister;



public class MobBlocks extends JavaPlugin {

	public static MobBlocks plugin;
	    ItemStack mossy = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
	    ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK, 1);	
	    
	    ItemStack[] mobblocks = new ItemStack[] { mossy, emerald };

	public MobBlocks() {
		System.out.println("Working on it...");
	}
	public void onEnable() {
		MobBlocks.plugin = this;
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BlockRegister(this), this);

	}
	
	public void onDisable() {
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("mbreload")) {
				sender.sendMessage(ChatColor.RED + "[MobBlocks]" + ChatColor.GREEN + "Reloading..");
				sender.sendMessage(ChatColor.RED + "[MobBlocks]" + ChatColor.GREEN + "Plugin by YUOTTA");
				reloadConfig();
				sender.sendMessage(ChatColor.RED + "[MobBlocks]" + ChatColor.GREEN + "MobBlocks Reloaded!");


			}
		if(cmd.getName().equalsIgnoreCase("mbgive")) {
			player.getInventory().addItem(mobblocks);
		}
		return true;
		}
}
		

