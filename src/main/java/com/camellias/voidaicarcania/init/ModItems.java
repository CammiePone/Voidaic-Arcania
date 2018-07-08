package com.camellias.voidaicarcania.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.items.ItemChorusTea;
import com.camellias.voidaicarcania.items.ItemDarkCamellia;
import com.camellias.voidaicarcania.items.ItemDwarfBrick;
import com.camellias.voidaicarcania.items.ItemFeatherweed;
import com.camellias.voidaicarcania.items.ItemFloatshroom;
import com.camellias.voidaicarcania.items.ItemGlowgrowth;
import com.camellias.voidaicarcania.items.ItemMoonMint;
import com.camellias.voidaicarcania.items.ItemNeddlesprout;
import com.camellias.voidaicarcania.items.ItemSecretStick;
import com.camellias.voidaicarcania.items.ItemShulkerBullet;
import com.camellias.voidaicarcania.items.ItemStarbloom;
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
import com.camellias.voidaicarcania.items.crystals.ItemStorageMid;
import com.camellias.voidaicarcania.items.crystals.ItemStorageStrong;
import com.camellias.voidaicarcania.items.crystals.ItemStorageWeak;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadBloom;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadBulb;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadFeather;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadFloat;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadGlow;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadMint;
import com.camellias.voidaicarcania.items.foodstuff.breads.ItemBreadNeddle;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieBloom;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieBulb;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieFeather;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieFloat;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieGlow;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieMint;
import com.camellias.voidaicarcania.items.foodstuff.cookies.ItemCookieNeddle;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieBloom;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieBulb;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieFeather;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieFloat;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieGlow;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieMint;
import com.camellias.voidaicarcania.items.foodstuff.pies.ItemPieNeddle;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetBloom;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetBulb;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetFeather;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetFloat;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetGlow;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetMint;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemBeetNeddle;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomBloom;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomBulb;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomFeather;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomFloat;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomGlow;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomMint;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemMushroomNeddle;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitBloom;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitBulb;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitFeather;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitFloat;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitGlow;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitMint;
import com.camellias.voidaicarcania.items.foodstuff.stews.ItemRabbitNeddle;

import net.minecraft.item.Item;

public class ModItems 
{
	//-----Item list-----//
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item TRANS_SHARD = new ItemTransmutationShard("transmutation_shard");
	public static final Item VOIDIC_SHARD = new ItemVoidicShard("voidic_shard");
	public static final Item VOID_BOTTLE = new ItemVoidBottle("void_bottle");
	public static final Item STORAGE_WEAK = new ItemStorageWeak("weak_void_cluster");
	public static final Item STORAGE_MID = new ItemStorageMid("void_cluster");
	public static final Item STORAGE_STRONG = new ItemStorageStrong("strong_void_cluster");
	
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
	
	//-----Stews-----//
	public static final Item MUSHROOM_BULB = new ItemMushroomBulb("mushroom_stew_1", 6);
	public static final Item MUSHROOM_FLOAT = new ItemMushroomFloat("mushroom_stew_2", 6);
	public static final Item MUSHROOM_GLOW = new ItemMushroomGlow("mushroom_stew_3", 6);
	public static final Item MUSHROOM_NEDDLE = new ItemMushroomNeddle("mushroom_stew_4", 6);
	public static final Item MUSHROOM_BLOOM = new ItemMushroomBloom("mushroom_stew_5", 6);
	public static final Item MUSHROOM_MINT = new ItemMushroomMint("mushroom_stew_6", 6);
	public static final Item MUSHROOM_FEATHER = new ItemMushroomFeather("mushroom_stew_7", 6);
	
	public static final Item RABBIT_BULB = new ItemRabbitBulb("rabbit_stew_1", 10);
	public static final Item RABBIT_FLOAT = new ItemRabbitFloat("rabbit_stew_2", 10);
	public static final Item RABBIT_GLOW = new ItemRabbitGlow("rabbit_stew_3", 10);
	public static final Item RABBIT_NEDDLE = new ItemRabbitNeddle("rabbit_stew_4", 10);
	public static final Item RABBIT_BLOOM = new ItemRabbitBloom("rabbit_stew_5", 10);
	public static final Item RABBIT_MINT = new ItemRabbitMint("rabbit_stew_6", 10);
	public static final Item RABBIT_FEATHER = new ItemRabbitFeather("rabbit_stew_7", 10);
	
	public static final Item BEET_BULB = new ItemBeetBulb("beetroot_soup_1", 6);
	public static final Item BEET_FLOAT = new ItemBeetFloat("beetroot_soup_2", 6);
	public static final Item BEET_GLOW = new ItemBeetGlow("beetroot_soup_3", 6);
	public static final Item BEET_NEDDLE = new ItemBeetNeddle("beetroot_soup_4", 6);
	public static final Item BEET_BLOOM = new ItemBeetBloom("beetroot_soup_5", 6);
	public static final Item BEET_MINT = new ItemBeetMint("beetroot_soup_6", 6);
	public static final Item BEET_FEATHER = new ItemBeetFeather("beetroot_soup_7", 6);
	
	//-----Breads-----//
	public static final Item BREAD_BULB = new ItemBreadBulb("bread_1", 5);
	public static final Item BREAD_FLOAT = new ItemBreadFloat("bread_2", 5);
	public static final Item BREAD_GLOW = new ItemBreadGlow("bread_3", 5);
	public static final Item BREAD_NEDDLE = new ItemBreadNeddle("bread_4", 5);
	public static final Item BREAD_BLOOM = new ItemBreadBloom("bread_5", 5);
	public static final Item BREAD_MINT = new ItemBreadMint("bread_6", 5);
	public static final Item BREAD_FEATHER = new ItemBreadFeather("bread_7", 5);
	
	//-----Cookies-----//
	public static final Item COOKIE_BULB = new ItemCookieBulb("cookie_1", 2);
	public static final Item COOKIE_FLOAT = new ItemCookieFloat("cookie_2", 2);
	public static final Item COOKIE_GLOW = new ItemCookieGlow("cookie_3", 2);
	public static final Item COOKIE_NEDDLE = new ItemCookieNeddle("cookie_4", 2);
	public static final Item COOKIE_BLOOM = new ItemCookieBloom("cookie_5", 2);
	public static final Item COOKIE_MINT = new ItemCookieMint("cookie_6", 2);
	public static final Item COOKIE_FEATHER = new ItemCookieFeather("cookie_7", 2);
	
	//-----Pies-----//
	public static final Item PIE_BULB = new ItemPieBulb("pumpkin_pie_1", 5);
	public static final Item PIE_FLOAT = new ItemPieFloat("pumpkin_pie_2", 5);
	public static final Item PIE_GLOW = new ItemPieGlow("pumpkin_pie_3", 5);
	public static final Item PIE_NEDDLE = new ItemPieNeddle("pumpkin_pie_4", 5);
	public static final Item PIE_BLOOM = new ItemPieBloom("pumpkin_pie_5", 5);
	public static final Item PIE_MINT = new ItemPieMint("pumpkin_pie_6", 5);
	public static final Item PIE_FEATHER = new ItemPieFeather("pumpkin_pie_7", 5);
	
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
}
