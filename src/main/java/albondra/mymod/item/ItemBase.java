package albondra.mymod.item;

import albondra.mymod.IHasModel;
import albondra.mymod.MyModMod;
import albondra.mymod.init.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(MyModMod.aquamarinetab);

		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		MyModMod.proxy.registerItemRenderer(this, 0, "inventory");

	}
}

