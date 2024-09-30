package albondra.mymod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void init() {
		GameRegistry.addSmelting(ModBlocks.AQUAMARINE_ORE, new ItemStack(ModItems.AQUAMARINE, 1), .5F);
	}
}
