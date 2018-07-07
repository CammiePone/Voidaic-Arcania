package com.camellias.voidaicarcania.util;

import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class AspectRegistry 
{
	public static void registry()
	{
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.TRANS_SHARD), new AspectList().add(Aspect.CRYSTAL, 22)
				.add(Aspect.DESIRE, 22).add(Aspect.MAGIC, 11).add(Aspect.LIGHT, 11).add(Aspect.SENSES, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.VOIDIC_SHARD), new AspectList().add(Aspect.VOID, 22)
				.add(Aspect.CRYSTAL, 22).add(Aspect.DESIRE, 22).add(Aspect.MAGIC, 11).add(Aspect.LIGHT, 11).add(Aspect.SENSES, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.VOID_BOTTLE), new AspectList().add(Aspect.VOID, 49)
				.add(Aspect.CRYSTAL, 47).add(Aspect.DESIRE, 44).add(Aspect.MAGIC, 22).add(Aspect.LIGHT, 22).add(Aspect.SENSES, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.DWARF_BRICK), new AspectList().add(Aspect.MAN, 3)
				.add(Aspect.EARTH, 3));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.FLOATSHROOM), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.VOID_BULB), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.GLOWGROWTH), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.LIGHT, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.DARK_CAMELLIA), new AspectList().add(Aspect.PLANT, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.MELON_SEED), new AspectList().add(Aspect.PLANT, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.CHORUS_TEA), new AspectList().add(Aspect.ELDRITCH, 12));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.WRAITH_WISP), new AspectList().add(Aspect.BEAST, 15)
				.add(Aspect.VOID, 10).add(Aspect.SOUL, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.VOID_STAR), new AspectList().add(Aspect.VOID, 64)
				.add(Aspect.AURA, 64));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.VOID_HEART), new AspectList().add(Aspect.LIFE, 32)
				.add(Aspect.BEAST, 32).add(Aspect.DARKNESS, 32).add(Aspect.VOID, 64));
		
		
		
		
		
		
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDSTONE), new AspectList().add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDSTONE_PILLAR), new AspectList().add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDSTONE_TILES), new AspectList().add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDSTONE_TILES_CRACKED), new AspectList().add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDGLASS), new AspectList().add(Aspect.CRYSTAL, 10).add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDSAND), new AspectList().add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDSTONE_SMOOTH), new AspectList().add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_DWARFBRICK), new AspectList().add(Aspect.MAN, 12)
				.add(Aspect.EARTH, 12));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_DWARF_STAIRS), new AspectList().add(Aspect.MAN, 12)
				.add(Aspect.EARTH, 12));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_DARK_BRICK), new AspectList().add(Aspect.EARTH, 15));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_DARK_BRICK_CHISELED), new AspectList().add(Aspect.EARTH, 15));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_CONSTRUCT), new AspectList().add(Aspect.VOID, 32)
				.add(Aspect.EARTH, 32).add(Aspect.ELDRITCH, 32));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_ARCANE_EARTH), new AspectList().add(Aspect.EARTH, 10)
				.add(Aspect.MAGIC, 25));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_LANTERN), new AspectList().add(Aspect.LIGHT, 15).add(Aspect.VOID, 5)
				.add(Aspect.ELDRITCH, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_STEM), new AspectList().add(Aspect.VOID, 20));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOID_CROP), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_GLOWGROWTH), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.LIGHT, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_FLOATSHROOM), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOIDTEA), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOID_MELON), new AspectList().add(Aspect.PLANT, 25));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOID_FLOWER), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_VOID_WEED), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.VOID, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_WHITEWOOD), new AspectList().add(Aspect.PLANT, 10));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_WHITEWOOD_LEAVES), new AspectList().add(Aspect.PLANT, 5));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_ALTAR), new AspectList().add(Aspect.CRYSTAL, 50)
				.add(Aspect.CRAFT, 10).add(Aspect.MAGIC, 25));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.BLOCK_BOTANY_ALTAR), new AspectList().add(Aspect.PLANT, 10)
				.add(Aspect.CRAFT, 10).add(Aspect.MAGIC, 25));
	}
}
