package com.camellias.voidaicarcania.api;

import java.util.HashMap;

import com.camellias.voidaicarcania.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.items.ItemsTC;

public class VoidEssenceList
{
	public static final HashMap<Item, Integer> LIST = new HashMap<>();

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
		ItemStack bedrock = new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK));
		ItemStack ender_chest = new ItemStack(Item.getItemFromBlock(Blocks.ENDER_CHEST));
		ItemStack dragon_egg = new ItemStack(Item.getItemFromBlock(Blocks.DRAGON_EGG));

		wrapper(chorus_fruit, 5);
		wrapper(purpur_slab, 5);
		wrapper(popped_chorus, 10);
		wrapper(purpur_block, 10);
		wrapper(purpur_pillar, 10);
		wrapper(purpur_stairs, 15);
		wrapper(end_stone, 20);
		wrapper(end_bricks, 20);
		wrapper(end_rod, 25);
		wrapper(obsidian, 50);
		wrapper(ender_pearl, 50);
		wrapper(ender_eye, 75);
		wrapper(end_crystal, 150);
		wrapper(enchant_table, 200);
		wrapper(bedrock, 500);
		wrapper(ender_chest, 500);
		wrapper(dragon_egg, 1600);

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

			wrapper(void_nugget, 17);
			wrapper(void_seed, 100);
			wrapper(void_ingot, 150);
			wrapper(void_plate, 150);
			wrapper(void_shovel, 150);
			wrapper(vitium_crystal, 200);
			wrapper(perditio_crystal, 200);
			wrapper(void_hoe, 300);
			wrapper(void_sword, 300);
			wrapper(voidseer_pearl, 400);
			wrapper(void_axe, 450);
			wrapper(void_pick, 450);
			wrapper(eldritch_curio, 500);
			wrapper(twisted_curio, 500);
			wrapper(crimson_rites, 500);
			wrapper(void_boots, 600);
			wrapper(void_helm, 750);
			wrapper(void_robe_hood, 950);
			wrapper(void_legs, 1050);
			wrapper(void_chest, 1200);
			wrapper(void_block, 1350);
			wrapper(void_robe_legs, 1550);
			wrapper(primordial_pearl, 1600);
			wrapper(void_robe_chest, 1700);
			wrapper(primal_crusher, 2400);
		}
	}

	public static void wrapper(ItemStack stack, int i) {
		LIST.put(stack.getItem(), i);
	}
}
