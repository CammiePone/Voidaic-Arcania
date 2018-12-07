package com.camellias.voidaicarcania.common.blocks.machines.blockaltar;

import java.util.Map;
import java.util.Map.Entry;

import com.camellias.voidaicarcania.init.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AltarRecipes 
{	
	private static final AltarRecipes INSTANCE = new AltarRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	
	public static AltarRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private AltarRecipes() 
	{
		//Transmutation Orb Recipes (Resources)
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.COAL), new ItemStack(Items.COAL));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.DYE, 1, 4), new ItemStack(Items.DYE, 1, 4));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.GLOWSTONE_DUST), new ItemStack(Items.GLOWSTONE_DUST));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.GOLD_INGOT));
		
		
		//Transmutation Orb Recipes (Drops)
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.ROTTEN_FLESH));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.BONE), new ItemStack(Items.BONE));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.SPIDER_EYE));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.LEATHER), new ItemStack(Items.LEATHER));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.FEATHER), new ItemStack(Items.FEATHER));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.ENDER_PEARL));
		
		
		
		//Void Orb Recipes (Resources)
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.COAL), new ItemStack(Items.COAL));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.DYE, 1, 4), new ItemStack(Items.DYE, 1, 4));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.GLOWSTONE_DUST), new ItemStack(Items.GLOWSTONE_DUST));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.GOLD_INGOT));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(ModItems.CRYSTAL), new ItemStack(ModItems.CRYSTAL));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(ModItems.ENARGITE), new ItemStack(ModItems.ENARGITE));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.DIAMOND), new ItemStack(Items.DIAMOND));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.EMERALD), new ItemStack(Items.EMERALD));
		
		
		//Void Orb Recipes (Drops)
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.ROTTEN_FLESH));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.BONE), new ItemStack(Items.BONE));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.SPIDER_EYE));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.LEATHER), new ItemStack(Items.LEATHER));
		addAltarRecipe(new ItemStack(ModItems.TRANS_ORB), new ItemStack(Items.FEATHER), new ItemStack(Items.FEATHER));
		addAltarRecipe(new ItemStack(ModItems.VOID_ORB), new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.ENDER_PEARL));
		
		
		
		//Misc Recipes
		addAltarRecipe(new ItemStack(Items.DRAGON_BREATH), new ItemStack(Items.ENDER_PEARL), new ItemStack(ModItems.VOID_BOTTLE));
		addAltarRecipe(new ItemStack(Items.GLASS_BOTTLE), new ItemStack(Items.END_CRYSTAL), new ItemStack(Items.DRAGON_BREATH));
		addAltarRecipe(new ItemStack(Items.BRICK), new ItemStack(Items.IRON_NUGGET), new ItemStack(ModItems.DWARF_BRICK));
		addAltarRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.CRYSTAL), new ItemStack(ModItems.INFUSED_INGOT));
		addAltarRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.CRYSTAL), new ItemStack(ModItems.INFUSED_INGOT));
		addAltarRecipe(new ItemStack(ModItems.MERCURY), new ItemStack(ModItems.MOON_MINT), new ItemStack(ModItems.LUNA_ORB));
		
		
		
		//Bauble Recipes
		addAltarRecipe(new ItemStack(ModItems.VOID_STAR), new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.SHIELD_AMULET));
		addAltarRecipe( new ItemStack(ModItems.VOID_STAR), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.INVERSE_AMULET));
		
		addAltarRecipe(new ItemStack(Items.LEATHER), new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.STRENGTH_BELT));
		addAltarRecipe(new ItemStack(Items.LEATHER), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.RESISTANCE_BELT));
		
		addAltarRecipe(new ItemStack(Blocks.WOOL), new ItemStack(Items.STRING), new ItemStack(ModItems.FEAST_COWL));
		addAltarRecipe(new ItemStack(Blocks.WOOL), new ItemStack(Items.BONE), new ItemStack(ModItems.REAPER_COWL));
		
		addAltarRecipe(new ItemStack(Blocks.WOOL), new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.FLIGHT_CLOAK));
		addAltarRecipe(new ItemStack(Blocks.WOOL), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.INVISIBILITY_CLOAK));
		
		addAltarRecipe(new ItemStack(Items.NETHER_STAR), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.VOID_CHARM));
		addAltarRecipe(new ItemStack(Items.NETHER_STAR), new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.LUCK_CHARM));
	}

	
	public void addAltarRecipe(ItemStack input1, ItemStack input2, ItemStack result) 
	{
		if(!getAltarResult(input1, input2).isEmpty()) return;
		this.smeltingList.put(input1, input2, result);
	}
	
	public ItemStack getAltarResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
}
