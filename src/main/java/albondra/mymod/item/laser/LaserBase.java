package albondra.mymod.item.laser;

import javax.annotation.Nullable;

import albondra.mymod.IHasModel;
import albondra.mymod.MyModMod;
import albondra.mymod.init.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LaserBase extends ItemBow implements IHasModel {
	public LaserBase(String name)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxDamage(1000);
		setCreativeTab(MyModMod.aquamarinetab);
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				if (entityIn == null)
				{
					return 0.0F;
				}
				else
				{
					return entityIn.getActiveItemStack().getItem() != ModItems.LASER_GUN? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount());
				}
			}
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		MyModMod.proxy.registerItemRenderer(this, 0, "inventory");

	}

	protected boolean isChargerPack(ItemStack stack) {
		return stack.getItem() instanceof ChargerBase;
	}


	public static float getBeamVelocity(int charge) //the velocity of the beam entity from the laser's charge
	{
		float f = (float)charge;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F)
		{
			f = 1.0F;
		}

		return f;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) //when the player does not use the item
	{																											 //it looks around using the mouse
		if (entityLiving instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer)entityLiving;
			boolean flag = entityplayer.capabilities.isCreativeMode;
			ItemStack itemstack = this.findCharge(entityplayer);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
			if (i < 0) return;

			if (((ChargerBase)itemstack.getItem()).durability<=2) return;


			if (!itemstack.isEmpty() || flag)
			{
				if (itemstack.isEmpty())
				{
					itemstack = new ItemStack(ModItems.CHARGER_PACK);
				}

				float f = getBeamVelocity(i);

				if ((double)f >= 0.1D)
				{
					boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof Laserbeam && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));

					if (!worldIn.isRemote)
					{
						Laserbeam laserbeam =(itemstack.getItem() instanceof Laserbeam ? (Laserbeam) itemstack.getItem() :ModItems.LASER_BEAM);
						LaserEntity laserEntity = laserbeam.createArrow(worldIn, itemstack, entityplayer);
						laserEntity.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);

						if (f == 1.0F)
						{
							laserEntity.setIsCritical(true);
						}



						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						if (j > 0)
						{
							laserEntity.setDamage(laserEntity.getDamage() + (double)j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

						if (k > 0)
						{
							laserEntity.setKnockbackStrength(k);
						}

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
						{
							laserEntity.setFire(100);
						}



						stack.damageItem(1, entityplayer);


						if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == ModItems.LASER_BEAM))
						{
							laserEntity.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
						}

						worldIn.spawnEntity(laserEntity);
					}


					if (!flag1 && !entityplayer.capabilities.isCreativeMode)

					{
						((ChargerBase)itemstack.getItem()).durability-=1;


					}

					entityplayer.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	}

	private ItemStack findCharge(EntityPlayer player){	
		if (this.isChargerPack(player.getHeldItem(EnumHand.OFF_HAND)))
		{
			return player.getHeldItem(EnumHand.OFF_HAND);

		}
		else if (this.isChargerPack(player.getHeldItem(EnumHand.MAIN_HAND))){

			return player.getHeldItem(EnumHand.MAIN_HAND);
		}
		else{
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i){
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isChargerPack(itemstack)){
					return itemstack;
				}
			}
		}


		return ItemStack.EMPTY;

	}

	//called when the laser is right clicked.
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) //what the laser will do when you use it
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !this.findCharge(playerIn).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (!playerIn.capabilities.isCreativeMode && !flag)
		{
			return  flag ? new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack) : new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
		else
		{
			playerIn.setActiveHand(handIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
	}


}
