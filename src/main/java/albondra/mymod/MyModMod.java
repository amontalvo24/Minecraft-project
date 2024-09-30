
package albondra.mymod;

import albondra.mymod.init.Entityin;
import albondra.mymod.init.ModCrafting;
import albondra.mymod.proxy.CommonProxy;
import albondra.mymod.tabs.AquaTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = MyModMod.MODID, name= MyModMod.MODIDNAME, version= MyModMod.MODVERSION)
public class MyModMod {
	
	public static final CreativeTabs aquamarinetab= new AquaTab("mymod");
	
	public static final String MODID= "mymod";
	public static final String MODIDNAME= "Minecfaft Java Project Mod";
	public static final String MODVERSION= "0.0.1";
	
	public static final int ENTITY_TEST= 250;
	public static final int ENTITY_LASER_BEAM = 251;

	@Instance
	public static MyModMod instance;

	@SidedProxy(clientSide = "albondra.mymod.proxy.ClientProxy", serverSide = "albondra.mymod.proxy.CommonProxy")
	public static CommonProxy proxy;


	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){


	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		
		ModCrafting.init();
		Entityin.registerEntities();
		

	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){


	}



}


