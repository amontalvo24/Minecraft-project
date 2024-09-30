package albondra.mymod.item.laser;

import albondra.mymod.MyModMod;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LaserRender extends RenderArrow<LaserEntity>
{
	public LaserRender(RenderManager manager){
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(LaserEntity entity){
		return new ResourceLocation(MyModMod.MODID + ":textures/entity/laser_beam.png");
	}
}
