package albondra.mymod.item.tools;

import albondra.mymod.IHasModel;
import albondra.mymod.MyModMod;
import albondra.mymod.init.ModItems;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {

	public ToolPickaxe(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MyModMod.aquamarinetab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		MyModMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}