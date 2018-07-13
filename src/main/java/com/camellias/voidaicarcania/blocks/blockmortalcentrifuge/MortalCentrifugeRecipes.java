package com.camellias.voidaicarcania.blocks.blockmortalcentrifuge;

import java.util.Map;
import java.util.Map.Entry;

import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModEnchants;
import com.camellias.voidaicarcania.init.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;

public class MortalCentrifugeRecipes
{
	private static final MortalCentrifugeRecipes INSTANCE = new MortalCentrifugeRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	
	public static MortalCentrifugeRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private MortalCentrifugeRecipes() 
	{
		addCentrifugeRecipe(new ItemStack(Blocks.GLASS), new ItemStack(ModItems.INFUSED_INGOT), new ItemStack(ModItems.SORTIGELLIUM));
		addCentrifugeRecipe(new ItemStack(ModItems.TRANS_SHARD), new ItemStack(ModItems.INFUSED_INGOT), new ItemStack(ModItems.MYTHRIL));
	}

	public void addCentrifugeRecipe(ItemStack input1, ItemStack input2, ItemStack result) 
	{
		if(getCentrifugeResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
	}
	
	public ItemStack getCentrifugeResult(ItemStack input1, ItemStack input2) 
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
