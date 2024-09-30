package albondra.mymod.handler;

import albondra.mymod.item.laser.LaserEntity;
import albondra.mymod.item.laser.LaserRender;
import albondra.mymod.others.EntityTest;
import albondra.mymod.others.RenderTest;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RendererHandler {

	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new IRenderFactory<EntityTest>()
		{
			@Override
			public Render<? super EntityTest> createRenderFor(RenderManager manager) 
			{
				return new RenderTest(manager);		
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(LaserEntity.class, new IRenderFactory<LaserEntity>() 
		{
			@Override
			public Render<? super LaserEntity> createRenderFor(RenderManager manager) 
			{
				return new LaserRender(manager);
			}
		});
	}
}
