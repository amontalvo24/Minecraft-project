package albondra.mymod.item.laser;

import albondra.mymod.IHasModel;
import albondra.mymod.MyModMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Laserbeam extends ItemArrow implements IHasModel{
	public Laserbeam(String name) 
	{
		setRegistryName(name);
	}
	
	@Override
	public LaserEntity createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) 
	{
		LaserEntity laserEntity = new LaserEntity(worldIn, shooter);
		return laserEntity;
	}
	
	@Override
	public void registerModels() {
		MyModMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
}
