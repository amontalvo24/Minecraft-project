package albondra.mymod.item.laser;


import albondra.mymod.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LaserEntity extends EntityArrow{
	public LaserEntity(World worldIn) {
		super(worldIn);

	}

	public LaserEntity(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public LaserEntity(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
		if (shooter instanceof EntityPlayer)
		{
			this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
		}
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ModItems.LASER_BEAM);
	}

	@Override
	protected void arrowHit(EntityLivingBase living) 
	{
		super.arrowHit(living);
		this.setDead();
	}
}