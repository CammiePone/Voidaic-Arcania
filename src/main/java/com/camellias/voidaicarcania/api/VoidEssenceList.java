package com.camellias.voidaicarcania.api;

import java.util.HashMap;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.util.ItemStackWrapper;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import thaumcraft.api.items.ItemsTC;

public class VoidEssenceList
{
	public static final HashMap<ItemStackWrapper, Integer> LIST = new HashMap<>();

	public static void init()
	{
		ItemStack chorus_fruit = new ItemStack(Items.CHORUS_FRUIT);
		ItemStack purpur_slab = new ItemStack(Item.getItemFromBlock(Blocks.PURPUR_SLAB));
		ItemStack popped_chorus = new ItemStack(Items.CHORUS_FRUIT_POPPED);
		ItemStack purpur_block = new ItemStack(Item.getItemFromBlock(Blocks.PURPUR_BLOCK));
		ItemStack purpur_pillar = new ItemStack(Item.getItemFromBlock(Blocks.PURPUR_PILLAR));
		ItemStack purpur_stairs = new ItemStack(Item.getItemFromBlock(Blocks.PURPUR_STAIRS));
		ItemStack end_stone = new ItemStack(Item.getItemFromBlock(Blocks.END_STONE));
		ItemStack end_bricks = new ItemStack(Item.getItemFromBlock(Blocks.END_BRICKS));
		ItemStack end_rod = new ItemStack(Item.getItemFromBlock(Blocks.END_ROD));
		ItemStack obsidian = new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN));
		ItemStack ender_pearl = new ItemStack(Items.ENDER_PEARL);
		ItemStack ender_eye = new ItemStack(Items.ENDER_EYE);
		ItemStack end_crystal = new ItemStack(Items.END_CRYSTAL);
		ItemStack enchant_table = new ItemStack(Item.getItemFromBlock(Blocks.ENCHANTING_TABLE));
		ItemStack dragon_breath = new ItemStack(Items.DRAGON_BREATH);
		ItemStack bedrock = new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK));
		ItemStack ender_chest = new ItemStack(Item.getItemFromBlock(Blocks.ENDER_CHEST));
		ItemStack dragon_egg = new ItemStack(Item.getItemFromBlock(Blocks.DRAGON_EGG));

		addToList(chorus_fruit, 5);
		addToList(purpur_slab, 5);
		addToList(popped_chorus, 10);
		addToList(purpur_block, 10);
		addToList(purpur_pillar, 10);
		addToList(purpur_stairs, 15);
		addToList(end_stone, 20);
		addToList(end_bricks, 20);
		addToList(end_rod, 25);
		addToList(obsidian, 50);
		addToList(ender_pearl, 50);
		addToList(ender_eye, 75);
		addToList(end_crystal, 150);
		addToList(enchant_table, 200);
		addToList(dragon_breath, 400);
		addToList(bedrock, 500);
		addToList(ender_chest, 500);
		addToList(dragon_egg, 1600);

		if(Main.instance.isThaumcraftLoaded == true)
		{
			ItemStack void_nugget = new ItemStack(ItemsTC.nuggets, 1, 7);
			ItemStack void_seed = new ItemStack(ItemsTC.voidSeed);
			ItemStack void_ingot = new ItemStack(ItemsTC.ingots, 1, 1);
			ItemStack void_plate = new ItemStack(ItemsTC.plate, 1, 3);
			ItemStack void_shovel = new ItemStack(ItemsTC.voidShovel);
			ItemStack vitium_crystal = new ItemStack(Item.getByNameOrId("thaumcraft:crystal_vitium"));
			ItemStack perditio_crystal = new ItemStack(Item.getByNameOrId("thaumcraft:crystal_perditio"));
			ItemStack void_hoe = new ItemStack(ItemsTC.voidHoe);
			ItemStack void_sword = new ItemStack(ItemsTC.voidSword);
			ItemStack voidseer_pearl = new ItemStack(ItemsTC.charmVoidseer);
			ItemStack void_axe = new ItemStack(ItemsTC.voidAxe);
			ItemStack void_pick = new ItemStack(ItemsTC.voidPick);
			ItemStack eldritch_curio = new ItemStack(ItemsTC.curio, 1, 3);
			ItemStack twisted_curio = new ItemStack(ItemsTC.curio, 1, 5);
			ItemStack crimson_rites = new ItemStack(ItemsTC.curio, 1, 6);
			ItemStack void_boots = new ItemStack(ItemsTC.voidBoots);
			ItemStack void_helm = new ItemStack(ItemsTC.voidHelm);
			ItemStack void_robe_hood = new ItemStack(ItemsTC.voidRobeHelm);
			ItemStack void_legs = new ItemStack(ItemsTC.voidLegs);
			ItemStack void_chest = new ItemStack(ItemsTC.voidChest);
			ItemStack void_block = new ItemStack(Item.getByNameOrId("thaumcraft:metal_void"));
			ItemStack void_robe_legs = new ItemStack(ItemsTC.voidRobeLegs);
			ItemStack primordial_pearl = new ItemStack(ItemsTC.primordialPearl);
			ItemStack void_robe_chest = new ItemStack(ItemsTC.voidRobeChest);
			ItemStack primal_crusher = new ItemStack(ItemsTC.primalCrusher);

			addToList(void_nugget, 17);
			addToList(void_seed, 100);
			addToList(void_ingot, 150);
			addToList(void_plate, 150);
			addToList(void_shovel, 150);
			addToList(vitium_crystal, 200);
			addToList(perditio_crystal, 200);
			addToList(void_hoe, 300);
			addToList(void_sword, 300);
			addToList(voidseer_pearl, 400);
			addToList(void_axe, 450);
			addToList(void_pick, 450);
			addToList(eldritch_curio, 500);
			addToList(twisted_curio, 500);
			addToList(crimson_rites, 500);
			addToList(void_boots, 600);
			addToList(void_helm, 750);
			addToList(void_robe_hood, 950);
			addToList(void_legs, 1050);
			addToList(void_chest, 1200);
			addToList(void_block, 1350);
			addToList(void_robe_legs, 1550);
			addToList(primordial_pearl, 1600);
			addToList(void_robe_chest, 1700);
			addToList(primal_crusher, 2400);
		}
	}

	public static void addToList(ItemStack stack, int voidEssence)
	{
		LIST.put(new ItemStackWrapper(stack.getItem(), stack.getMetadata()), voidEssence);
	}
}
