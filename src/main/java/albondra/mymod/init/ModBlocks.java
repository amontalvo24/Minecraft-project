package albondra.mymod.init;

import java.util.ArrayList;
import java.util.List;

import albondra.mymod.block.AquamarineOre;
import albondra.mymod.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block AQUAMARINE_BLOCK = new BlockBase("aquamarine_block", Material.IRON);
	public static final Block AQUAMARINE_ORE = new AquamarineOre("aquamarine_ore", Material.ROCK);
	
}

