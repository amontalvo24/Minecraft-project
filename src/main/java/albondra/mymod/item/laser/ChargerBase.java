package albondra.mymod.item.laser;

import java.util.List;

import albondra.mymod.IHasModel;
import albondra.mymod.MyModMod;
import albondra.mymod.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ChargerBase extends ItemArrow implements IHasModel {
	public int durability = 100; //ChargerPack's charge
	public ChargerBase(String name){
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MyModMod.aquamarinetab);
		setMaxStackSize(1);

		ModItems.ITEMS.add(this);

	}
	protected boolean isRedstoneBlock(ItemStack block) {
		return block.getItem().equals(getItemFromBlock(Blocks.REDSTONE_BLOCK));
	}

	@Override
	public void registerModels(){
		MyModMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player){
		return true;
	}

	@Override
	public boolean isDamageable(){ //item cannot break
		return false;
	}
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		super.onUsingTick(stack, player, count);
		
		if (durability<=2) {
			durability=0;
		}
	}

	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldin, EntityPlayer player, EnumHand handIN) {
		for (int i = 0; i < player.inventory.getSizeInventory(); i++){ //iterates through inventory 
			ItemStack itemstack = player.inventory.getStackInSlot(i);
			if (itemstack.getItem() == Items.REDSTONE && durability < 98){ //checks for redstone in inventory 
				player.inventory.decrStackSize(i, 1);
				durability+=5;
			}
			else if(isRedstoneBlock(itemstack)&& durability <80) {
				player.inventory.decrStackSize(i, 1);
				durability+=20;
			}
		}
		return super.onItemRightClick(worldin, player, handIN);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) { //adds tooltip information
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add("Durability: " + String.valueOf(durability));

	}
}
