package com.camellias.voidaicarcania.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.items.ItemAstralite;
import com.camellias.voidaicarcania.items.ItemChorusTea;
import com.camellias.voidaicarcania.items.ItemCinnabar;
import com.camellias.voidaicarcania.items.ItemDarkCamellia;
import com.camellias.voidaicarcania.items.ItemDwarfBrick;
import com.camellias.voidaicarcania.items.ItemEnargite;
import com.camellias.voidaicarcania.items.ItemFeatherweed;
import com.camellias.voidaicarcania.items.ItemFloatshroom;
import com.camellias.voidaicarcania.items.ItemGlowgrowth;
import com.camellias.voidaicarcania.items.ItemInfusedIngot;
import com.camellias.voidaicarcania.items.ItemMercury;
import com.camellias.voidaicarcania.items.ItemMoonMint;
import com.camellias.voidaicarcania.items.ItemMythril;
import com.camellias.voidaicarcania.items.ItemNeddlesprout;
import com.camellias.voidaicarcania.items.ItemSecretStick;
import com.camellias.voidaicarcania.items.ItemShulkerBullet;
import com.camellias.voidaicarcania.items.ItemSortigellium;
import com.camellias.voidaicarcania.items.ItemStarbloom;
import com.camellias.voidaicarcania.items.ItemTransformRoot;
import com.camellias.voidaicarcania.items.ItemTransmutationOrb;
import com.camellias.voidaicarcania.items.ItemTransmutationShard;
import com.camellias.voidaicarcania.items.ItemVoidBottle;
import com.camellias.voidaicarcania.items.ItemVoidBulb;
import com.camellias.voidaicarcania.items.ItemVoidCrystal;
import com.camellias.voidaicarcania.items.ItemVoidMelonSeed;
import com.camellias.voidaicarcania.items.ItemVoidStar;
import com.camellias.voidaicarcania.items.ItemVoidheart;
import com.camellias.voidaicarcania.items.ItemVoidicOrb;
import com.camellias.voidaicarcania.items.ItemVoidicShard;
import com.camellias.voidaicarcania.items.ItemWraithWisp;
import com.camellias.voidaicarcania.items.armour.ArmourEnargite;
import com.camellias.voidaicarcania.items.armour.ArmourMythril;
import com.camellias.voidaicarcania.items.baubles.amulets.ItemInverseAmulet;
import com.camellias.voidaicarcania.items.baubles.amulets.ItemInverseAmuletActive;
import com.camellias.voidaicarcania.items.baubles.amulets.ItemShieldAmulet;
import com.camellias.voidaicarcania.items.baubles.amulets.ItemShieldAmuletActive;
import com.camellias.voidaicarcania.items.baubles.belts.ItemResistanceBelt;
import com.camellias.voidaicarcania.items.baubles.belts.ItemResistanceBeltActive;
import com.camellias.voidaicarcania.items.baubles.belts.ItemStrengthBelt;
import com.camellias.voidaicarcania.items.baubles.belts.ItemStrengthBeltActive;
import com.camellias.voidaicarcania.items.baubles.body.ItemFlightCloak;
import com.camellias.voidaicarcania.items.baubles.body.ItemFlightCloakActive;
import com.camellias.voidaicarcania.items.baubles.body.ItemInvisibilityCloak;
import com.camellias.voidaicarcania.items.baubles.body.ItemInvisibilityCloakActive;
import com.camellias.voidaicarcania.items.baubles.charms.ItemLuckCharm;
import com.camellias.voidaicarcania.items.baubles.charms.ItemLuckCharmActive;
import com.camellias.voidaicarcania.items.baubles.charms.ItemVoidCharm;
import com.camellias.voidaicarcania.items.baubles.charms.ItemVoidCharmActive;
import com.camellias.voidaicarcania.items.baubles.head.ItemFeastCowl;
import com.camellias.voidaicarcania.items.baubles.head.ItemFeastCowlActive;
import com.camellias.voidaicarcania.items.baubles.head.ItemReaperCowl;
import com.camellias.voidaicarcania.items.baubles.head.ItemReaperCowlActive;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	//-----Item list-----//
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item TRANS_SHARD = new ItemTransmutationShard("transmutation_shard");
	public static final Item VOIDIC_SHARD = new ItemVoidicShard("voidic_shard");
	public static final Item VOID_BOTTLE = new ItemVoidBottle("void_bottle");
	
	//-----Baubles-----//
	public static final Item SHIELD_AMULET = new ItemShieldAmulet("shield_amulet");
	public static final Item A_SHIELD_AMULET = new ItemShieldAmuletActive("active_shield_amulet");
	public static final Item INVERSE_AMULET = new ItemInverseAmulet("inverse_amulet");
	public static final Item A_INVERSE_AMULET = new ItemInverseAmuletActive("active_inverse_amulet");
	
	public static final Item STRENGTH_BELT = new ItemStrengthBelt("strength_belt");
	public static final Item A_STRENGTH_BELT = new ItemStrengthBeltActive("active_strength_belt");
	public static final Item RESISTANCE_BELT = new ItemResistanceBelt("resistance_belt");
	public static final Item A_RESISTANCE_BELT = new ItemResistanceBeltActive("active_resistance_belt");
	
	public static final Item FEAST_COWL = new ItemFeastCowl("feast_cowl");
	public static final Item A_FEAST_COWL = new ItemFeastCowlActive("active_feast_cowl");
	public static final Item REAPER_COWL = new ItemReaperCowl("reaper_cowl");
	public static final Item A_REAPER_COWL = new ItemReaperCowlActive("active_reaper_cowl");
	
	public static final Item FLIGHT_CLOAK = new ItemFlightCloak("flight_cloak");
	public static final Item A_FLIGHT_CLOAK = new ItemFlightCloakActive("active_flight_cloak");
	public static final Item INVISIBILITY_CLOAK = new ItemInvisibilityCloak("invisibility_cloak");
	public static final Item A_INVISIBILITY_CLOAK = new ItemInvisibilityCloakActive("active_invisibility_cloak");
	
	public static final Item LUCK_CHARM = new ItemLuckCharm("protect_charm");
	public static final Item A_LUCK_CHARM = new ItemLuckCharmActive("active_protect_charm");
	public static final Item VOID_CHARM = new ItemVoidCharm("explode_charm");
	public static final Item A_VOID_CHARM = new ItemVoidCharmActive("active_explode_charm");
	
	//-----Orbs-----//
	public static final Item TRANS_ORB = new ItemTransmutationOrb("transmutation_orb");
	public static final Item VOID_ORB = new ItemVoidicOrb("voidic_orb");
	
	//-----Food Items and Seeds-----//
	public static final Item VOID_BULB = new ItemVoidBulb("void_bulb", 0, 0, false); //FoodItem - FoodHandler contianed in specific class
	public static final Item FLOATSHROOM = new ItemFloatshroom("floatshroom", 0, 0, false); //FoodItem
	public static final Item GLOWGROWTH = new ItemGlowgrowth("glowgrowth", 0, 0, false); //FoodItem
	public static final Item DARK_CAMELLIA = new ItemDarkCamellia("dark_camellia");
	public static final Item MELON_SEED = new ItemVoidMelonSeed("void_melon_seed");
	public static final Item NEDDLESPROUT = new ItemNeddlesprout("neddlesprout", 0, 0, false); //FoodItem
	public static final Item STARBLOOM = new ItemStarbloom("starbloom", 0, 0, false); //FoodItem
	public static final Item MOON_MINT = new ItemMoonMint("moon_mint", 0, 0, false); //FoodItem
	public static final Item FEATHERWEED = new ItemFeatherweed("featherweed", 0, 0, false); //FoodItem
	public static final Item TRANSROOT = new ItemTransformRoot("transformative_root");
	
	//-----Metallurgy-----//
	public static final Item CINNIBAR = new ItemCinnabar("cinnabar");
	public static final Item INFUSED_INGOT = new ItemInfusedIngot("infused_ingot");
	public static final Item MERCURY = new ItemMercury("mercury");
	public static final Item ENARGITE = new ItemEnargite("enargite_ingot");
	public static final Item SORTIGELLIUM = new ItemSortigellium("sortigellium_ingot");
	public static final Item ASTRALITE = new ItemAstralite("astralite_ingot");
	public static final Item MYTHRIL = new ItemMythril("mythril_ingot");
	
	//-----Stews-----//
	public static final Item MUSHROOM_BULB = new ItemVoidBulb("mushroom_stew_1", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item MUSHROOM_FLOAT = new ItemFloatshroom("mushroom_stew_2", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item MUSHROOM_GLOW = new ItemGlowgrowth("mushroom_stew_3", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item MUSHROOM_NEDDLE = new ItemNeddlesprout("mushroom_stew_4", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item MUSHROOM_BLOOM = new ItemStarbloom("mushroom_stew_5", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item MUSHROOM_MINT = new ItemMoonMint("mushroom_stew_6", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item MUSHROOM_FEATHER = new ItemFeatherweed("mushroom_stew_7", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	
	public static final Item RABBIT_BULB = new ItemVoidBulb("rabbit_stew_1", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item RABBIT_FLOAT = new ItemFloatshroom("rabbit_stew_2", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item RABBIT_GLOW = new ItemGlowgrowth("rabbit_stew_3", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item RABBIT_NEDDLE = new ItemNeddlesprout("rabbit_stew_4", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item RABBIT_BLOOM = new ItemStarbloom("rabbit_stew_5", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item RABBIT_MINT = new ItemMoonMint("rabbit_stew_6", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item RABBIT_FEATHER = new ItemFeatherweed("rabbit_stew_7", 10, 0, false).setCreativeTab(CreativeTabs.FOOD);
	
	public static final Item BEET_BULB = new ItemVoidBulb("beetroot_soup_1", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BEET_FLOAT = new ItemFloatshroom("beetroot_soup_2", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BEET_GLOW = new ItemGlowgrowth("beetroot_soup_3", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BEET_NEDDLE = new ItemNeddlesprout("beetroot_soup_4", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BEET_BLOOM = new ItemStarbloom("beetroot_soup_5", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BEET_MINT = new ItemMoonMint("beetroot_soup_6", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BEET_FEATHER = new ItemFeatherweed("beetroot_soup_7", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	
	//-----Breads-----//
	public static final Item BREAD_BULB = new ItemVoidBulb("bread_1", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BREAD_FLOAT = new ItemFloatshroom("bread_2", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BREAD_GLOW = new ItemGlowgrowth("bread_3", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BREAD_NEDDLE = new ItemNeddlesprout("bread_4", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BREAD_BLOOM = new ItemStarbloom("bread_5", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BREAD_MINT = new ItemMoonMint("bread_6", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item BREAD_FEATHER = new ItemFeatherweed("bread_7", 5, 0, false).setCreativeTab(CreativeTabs.FOOD);
	
	//-----Cookies-----//
	public static final Item COOKIE_BULB = new ItemVoidBulb("cookie_1", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item COOKIE_FLOAT = new ItemFloatshroom("cookie_2", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item COOKIE_GLOW = new ItemGlowgrowth("cookie_3", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item COOKIE_NEDDLE = new ItemNeddlesprout("cookie_4", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item COOKIE_BLOOM = new ItemStarbloom("cookie_5", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item COOKIE_MINT = new ItemMoonMint("cookie_6", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item COOKIE_FEATHER = new ItemFeatherweed("cookie_7", 2, 0, false).setCreativeTab(CreativeTabs.FOOD);
	
	//-----Pies-----//
	public static final Item PIE_BULB = new ItemVoidBulb("pumpkin_pie_1", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item PIE_FLOAT = new ItemFloatshroom("pumpkin_pie_2", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item PIE_GLOW = new ItemGlowgrowth("pumpkin_pie_3", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item PIE_NEDDLE = new ItemNeddlesprout("pumpkin_pie_4", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item PIE_BLOOM = new ItemStarbloom("pumpkin_pie_5", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item PIE_MINT = new ItemMoonMint("pumpkin_pie_6", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	public static final Item PIE_FEATHER = new ItemFeatherweed("pumpkin_pie_7", 6, 0, false).setCreativeTab(CreativeTabs.FOOD);
	
	public static final Item CHORUS_TEA = new ItemChorusTea("chorus_tea", 0, 5, false); //TeaItem
	
	//-----Misc. Items-----//
	public static final Item DWARF_BRICK = new ItemDwarfBrick("dwarf_brick");
	//public static final Item SPELL_BASE = new ItemSpellBase("spell_base");
	public static final Item VOID_STAR = new ItemVoidStar("void_star");
	public static final Item VOID_HEART = new ItemVoidheart("voidheart");
	
	public static final Item WRAITH_WISP = new ItemWraithWisp("wraith_wisp");
	public static final Item BULLET = new ItemShulkerBullet("bullet");
	public static final Item CRYSTAL = new ItemVoidCrystal("void_crystal");
	
	public static final Item CAMS_SUPER_SECRET_STICK = new ItemSecretStick("secret_stick");
	
	//-----Armours-----//
	public static final ArmorMaterial MYTHRIL_ARMOUR = EnumHelper.addArmorMaterial("mythril", Reference.MODID + ":mythril_armour", 40, new int[]{4,8,5,2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
	public static final ArmorMaterial ENARGITE_ARMOUR = EnumHelper.addArmorMaterial("enargite", Reference.MODID + ":enargite_armour", 20, new int[]{4,8,5,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3.0F);
	
	public static final Item MYTHRIL_HELM = new ArmourMythril(MYTHRIL_ARMOUR, 1, EntityEquipmentSlot.HEAD, "mythril_helm");
	public static final Item MYTHRIL_CHEST = new ArmourMythril(MYTHRIL_ARMOUR, 1, EntityEquipmentSlot.CHEST, "mythril_chestplate");
	public static final Item MYTHRIL_LEGS = new ArmourMythril(MYTHRIL_ARMOUR, 2, EntityEquipmentSlot.LEGS, "mythril_leggings");
	public static final Item MYTHRIL_BOOTS = new ArmourMythril(MYTHRIL_ARMOUR, 1, EntityEquipmentSlot.FEET, "mythril_boots");
	
	public static final Item ENARGITE_HELM = new ArmourEnargite(ENARGITE_ARMOUR, 1, EntityEquipmentSlot.HEAD, "enargite_helm");
	public static final Item ENARGITE_CHEST = new ArmourEnargite(ENARGITE_ARMOUR, 1, EntityEquipmentSlot.CHEST, "enargite_chestplate");
	public static final Item ENARGITE_LEGS = new ArmourEnargite(ENARGITE_ARMOUR, 2, EntityEquipmentSlot.LEGS, "enargite_leggings");
	public static final Item ENARGITE_BOOTS = new ArmourEnargite(ENARGITE_ARMOUR, 1, EntityEquipmentSlot.FEET, "enargite_boots");
}
