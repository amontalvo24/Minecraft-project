package albondra.mymod.tabs;

import albondra.mymod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AquaTab extends CreativeTabs{
	public AquaTab(String label) {
	super("aquamarinetab");	
	}

	
	public ItemStack getTabIconItem() {
		
		return new ItemStack(ModItems.AQUAMARINE);
	}

	
}
