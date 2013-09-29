package Com.Erellion.Yuotta.Blocks;
/*CREATED BY YUOTTA
 * FOR ERELLION.COM
 * VISIT THE SERVER mc.erellion.com
 */

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.Listener;


import Com.Erellion.Yuotta.Main.MobBlocks;


public class BlockRegister extends MobBlocks implements Listener {
	private MobBlocks plugin;
	public static HashMap<Integer, InteractBlock> cubes;
	
	public BlockRegister(MobBlocks plugin) {
		BlockRegister.cubes = new HashMap<Integer, InteractBlock>();

		this.plugin = plugin;


		BlockRegister.cubes = new HashMap<Integer, InteractBlock>();


		cubes.put(Material.MOSSY_COBBLESTONE.getId(), new InteractBlock());
		cubes.put(Material.EMERALD.getId(), new InteractBlock());

		
		for(InteractBlock s : cubes.values()) {
			if(s instanceof Listener) {
				plugin.getServer().getPluginManager().registerEvents((Listener)s, plugin);
			}
		}
	}

	}




