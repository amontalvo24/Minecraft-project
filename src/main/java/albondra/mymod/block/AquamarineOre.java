package albondra.mymod.block;

import java.util.Random;

import albondra.mymod.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class AquamarineOre extends BlockBase{
	
	public AquamarineOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(5.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.AQUAMARINE;
	}
	
	@Override 
	public int quantityDropped(Random rand) {
		int max = 5;
		int min = 1;
		return rand.nextInt(max) + min; 
	}
}
