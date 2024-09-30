package albondra.mymod.init;

import albondra.mymod.MyModMod;
import albondra.mymod.item.laser.LaserEntity;
import albondra.mymod.others.EntityTest;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Entityin {
	public static int id = 1;
	public static void registerEntities()
	{
		registerEntity("test", EntityTest.class, 250, 50, 13310623, 65354);
		registerArrow("laser_beam", LaserEntity.class, 251);
		
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(MyModMod.MODID + ":" + name), entity, name, id, MyModMod.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(MyModMod.MODID + ":" + name), entity, name, id, MyModMod.instance, 64, 20, true);
	}
	
	
}