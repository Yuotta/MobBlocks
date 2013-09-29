package Com.Erellion.Yuotta.Blocks;
/*CREATED BY YUOTTA
 * FOR ERELLION.COM
 * VISIT THE SERVER mc.erellion.com
 */

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import Com.Erellion.Yuotta.Main.MobBlocks;

public class InteractBlock implements Listener {
	private MobBlocks plugin;

	 public InteractBlock(MobBlocks plugin) {
		  this.plugin = plugin;
		 }
	 public InteractBlock() {
		 
	 }
	@EventHandler
	public void MaterialInteract(PlayerMoveEvent event) {
		
		Player player = event.getPlayer();
		World world = player.getLocation().getWorld();
		Location loc = player.getLocation().subtract(0, 1, 0);
		Block b = loc.getBlock();

		Material material = loc.getBlock().getType();
		
		if(!player.hasPermission(permission())) {
			return;
		}
		
			//SKELETON

			if (material == Material.MOSSY_COBBLESTONE) {
				loc.getBlock().setType(Material.AIR);
			
				if (player.getLocation().distance(player.getLocation()) <= 4.0D) {
					world.playEffect(loc, Effect.GHAST_SHOOT, 10);
					world.spawnEntity(player.getLocation(), EntityType.SKELETON);

				}
			}
		
		
		if (material == Material.EMERALD_BLOCK) {
			loc.getBlock().setType(Material.AIR);
		
			if (player.getLocation().distance(player.getLocation()) <= 4.0D) {
				world.playEffect(loc, Effect.GHAST_SHOOT, 10);
				world.spawnEntity(player.getLocation(), EntityType.ZOMBIE);

			}
		}
	
		//RED STONE HEAL
		if (material == Material.REDSTONE_BLOCK) {
			loc.getBlock().setType(Material.GRASS);
				player.setHealth(20);
				player.setFoodLevel(20);
				world.playEffect(loc, Effect.POTION_BREAK, 10);
			}
		}
	
	
	
	public String permission() {
		return "en.blocks";
	}

}
