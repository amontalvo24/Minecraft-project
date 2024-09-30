package albondra.mymod.init;

import java.util.ArrayList;
import java.util.List;

import albondra.mymod.MyModMod;
import albondra.mymod.item.ItemBase;
import albondra.mymod.item.armor.ArmorBase;
import albondra.mymod.item.foods.FoodBase;
import albondra.mymod.item.laser.ChargerBase;
import albondra.mymod.item.laser.LaserBase;
import albondra.mymod.item.laser.Laserbeam;
import albondra.mymod.item.tools.ToolAxe;
import albondra.mymod.item.tools.ToolHoe;
import albondra.mymod.item.tools.ToolPickaxe;
import albondra.mymod.item.tools.ToolSpade;
import albondra.mymod.item.tools.ToolSword;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

public static final List<Item> ITEMS = new ArrayList<Item>();

public static final Item AQUAMARINE = new ItemBase("aquamarine");

//Materials
public static final ArmorMaterial ARMOR_MATERIAL_AQUAMARINE= EnumHelper.addArmorMaterial("armor_material_aquamarine", MyModMod.MODID+ ":aquamarine", 14, new int[] {2, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
public static final ToolMaterial MATERIAL_AQUAMARINE = EnumHelper.addToolMaterial("material_aquamarine", 3, 250, 8.0F, 3.0F, 10);

//Weapon
public static final ItemSword AQUAMARINE_SWORD = new ToolSword("aquamarine_sword", MATERIAL_AQUAMARINE);
public static final ItemBow LASER_GUN= new LaserBase("laser_gun");
public static final Laserbeam LASER_BEAM= new Laserbeam("laser_beam");
public static final ItemArrow CHARGER_PACK = new ChargerBase("charger_pack");


//Tools
public static final ItemSpade AQUAMARINE_SHOVEL = new ToolSpade("aquamarine_shovel", MATERIAL_AQUAMARINE);
public static final ItemPickaxe AQUAMARINE_PICKAXE = new ToolPickaxe("aquamarine_pickaxe", MATERIAL_AQUAMARINE);
public static final ItemAxe AQUAMARINE_AXE = new ToolAxe("aquamarine_axe", MATERIAL_AQUAMARINE);
public static final ItemHoe AQUAMARINE_HOE = new ToolHoe("aquamarine_hoe", MATERIAL_AQUAMARINE);


//Armor
public static final Item AQUAMARINE_HELMET = new ArmorBase("aquamarine_helmet", ARMOR_MATERIAL_AQUAMARINE, 1, EntityEquipmentSlot.HEAD);
public static final Item AQUAMARINE_CHESTPLATE = new ArmorBase("aquamarine_chestplate", ARMOR_MATERIAL_AQUAMARINE, 1, EntityEquipmentSlot.CHEST);
public static final Item AQUAMARINE_LEGGINGS = new ArmorBase("aquamarine_leggings", ARMOR_MATERIAL_AQUAMARINE, 2, EntityEquipmentSlot.LEGS);
public static final Item AQUAMARINE_BOOTS = new ArmorBase("aquamarine_boots", ARMOR_MATERIAL_AQUAMARINE, 1, EntityEquipmentSlot.FEET);

//Food
public static final Item AQUAMARINE_APPLE = new FoodBase("aquamarine_apple", 4, 9.6f, false);
}