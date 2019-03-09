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
	public static final HashMap<Item, Integer> LIST = new HashMap<Item, Integer>();
	
	public static void init()
	{
		LIST.put(Items.CHORUS_FRUIT, 5);
		LIST.put(Item.getItemFromBlock(Blocks.PURPUR_SLAB), 5);
		LIST.put(Items.CHORUS_FRUIT_POPPED, 10);
		LIST.put(Item.getItemFromBlock(Blocks.PURPUR_BLOCK), 10);
		LIST.put(Item.getItemFromBlock(Blocks.PURPUR_PILLAR), 10);
		LIST.put(Item.getItemFromBlock(Blocks.PURPUR_STAIRS), 15);
		LIST.put(Item.getItemFromBlock(Blocks.END_STONE), 20);
		LIST.put(Item.getItemFromBlock(Blocks.END_BRICKS), 20);
		LIST.put(Item.getItemFromBlock(Blocks.END_ROD), 25);
		LIST.put(Item.getItemFromBlock(Blocks.OBSIDIAN), 50);
		LIST.put(Items.ENDER_PEARL, 50);
		LIST.put(Items.ENDER_EYE, 75);
		LIST.put(Items.END_CRYSTAL, 150);
		LIST.put(Item.getItemFromBlock(Blocks.ENCHANTING_TABLE), 200);
		LIST.put(Item.getItemFromBlock(Blocks.BEDROCK), 500);
		LIST.put(Item.getItemFromBlock(Blocks.ENDER_CHEST), 500);
		LIST.put(Item.getItemFromBlock(Blocks.DRAGON_EGG), 1600);
		
		if(Main.instance.isThaumcraftLoaded == true)
		{
			//ItemStack void_nugget = new ItemStack(ItemsTC.nuggets, 1, 7);
			//ItemStack void_ingot = new ItemStack(ItemsTC.ingots, 1, 1);
			//ItemStack void_plate = new ItemStack(ItemsTC.plate, 1, 3);
			//ItemStack vitium_crystal = new ItemStack(Item.getByNameOrId("thaumcraft:crystal_vitium"));
			//ItemStack perditio_crystal = new ItemStack(Item.getByNameOrId("thaumcraft:crystal_perditio"));
			//ItemStack eldritch_curio = new ItemStack(ItemsTC.curio, 1, 3);
			//ItemStack twisted_curio = new ItemStack(ItemsTC.curio, 1, 5);
			//ItemStack crimson_rites = new ItemStack(ItemsTC.curio, 1, 6);
			
			//LIST.put(void_nugget.getItem(), 17);
			LIST.put(ItemsTC.voidSeed, 100);
			//LIST.put(void_ingot.getItem(), 150);
			//LIST.put(void_plate.getItem(), 150);
			LIST.put(ItemsTC.voidShovel, 150);
			//LIST.put(vitium_crystal.getItem(), 200);
			//LIST.put(perditio_crystal.getItem(), 200);
			LIST.put(ItemsTC.voidHoe, 300);
			LIST.put(ItemsTC.voidSword, 300);
			LIST.put(ItemsTC.charmVoidseer, 400);
			LIST.put(ItemsTC.voidAxe, 450);
			LIST.put(ItemsTC.voidPick, 450);
			//LIST.put(eldritch_curio.getItem(), 500);
			//LIST.put(twisted_curio.getItem(), 500);
			//LIST.put(crimson_rites.getItem(), 500);
			LIST.put(ItemsTC.voidBoots, 600);
			LIST.put(ItemsTC.voidHelm, 750);
			LIST.put(ItemsTC.voidRobeHelm, 950);
			LIST.put(ItemsTC.voidLegs, 1050);
			LIST.put(ItemsTC.voidChest, 1200);
			LIST.put(Item.getByNameOrId("thaumcraft:metal_void"), 1350);
			LIST.put(ItemsTC.voidRobeLegs, 1550);
			LIST.put(ItemsTC.primordialPearl, 1600);
			LIST.put(ItemsTC.voidRobeChest, 1700);
			LIST.put(ItemsTC.primalCrusher, 2400);
		}
	}
}
