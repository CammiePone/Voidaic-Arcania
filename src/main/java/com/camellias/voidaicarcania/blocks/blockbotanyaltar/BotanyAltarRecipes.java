package com.camellias.voidaicarcania.blocks.blockbotanyaltar;

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

public class BotanyAltarRecipes
{
	private static final BotanyAltarRecipes INSTANCE = new BotanyAltarRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	
	public static BotanyAltarRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private BotanyAltarRecipes() 
	{
		ItemStack ALCHEMY_BOOK = new ItemStack(Items.ENCHANTED_BOOK);
		ItemStack CLOUDSTEP_BOOK = new ItemStack(Items.ENCHANTED_BOOK);
		
		EnchantmentData ALCHEMY = new EnchantmentData(ModEnchants.ALCHEMY, 1);
		EnchantmentData CLOUDSTEP = new EnchantmentData(ModEnchants.CLOUDSTEP, 1);
		
		ItemEnchantedBook.addEnchantment(ALCHEMY_BOOK, ALCHEMY);
		ItemEnchantedBook.addEnchantment(CLOUDSTEP_BOOK, CLOUDSTEP);
		
		addBotanyAltarRecipe(new ItemStack(ModBlocks.BLOCK_VOID_WEED), new ItemStack(Items.FEATHER), new ItemStack(ModItems.FEATHERWEED));
		addBotanyAltarRecipe(new ItemStack(ModItems.BULLET), new ItemStack(Blocks.BROWN_MUSHROOM), new ItemStack(ModItems.FLOATSHROOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.BULLET), new ItemStack(Blocks.RED_MUSHROOM), new ItemStack(ModItems.FLOATSHROOM));
		addBotanyAltarRecipe(new ItemStack(Items.GLOWSTONE_DUST), new ItemStack(Items.NETHER_WART), new ItemStack(ModItems.GLOWGROWTH));
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.MELON_SEEDS), new ItemStack(ModItems.MELON_SEED));
		addBotanyAltarRecipe(new ItemStack(ModItems.DARK_CAMELLIA), new ItemStack(ModItems.CRYSTAL), new ItemStack(ModItems.MOON_MINT));
		addBotanyAltarRecipe(new ItemStack(Items.DYE, 1, 2), new ItemStack(Items.STICK), new ItemStack(ModItems.NEDDLESPROUT));
		addBotanyAltarRecipe(new ItemStack(ModItems.WRAITH_WISP), new ItemStack(Items.NETHER_STAR), new ItemStack(ModItems.STARBLOOM));
		addBotanyAltarRecipe(new ItemStack(ModBlocks.BLOCK_VOID_MELON), new ItemStack(ModItems.TRANSROOT), new ItemStack(ModItems.TRANSROOT, 2));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_BULB));
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_FLOAT));
		addBotanyAltarRecipe(new ItemStack(ModItems.GLOWGROWTH), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_GLOW));
		addBotanyAltarRecipe(new ItemStack(ModItems.NEDDLESPROUT), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_NEDDLE));
		addBotanyAltarRecipe(new ItemStack(ModItems.STARBLOOM), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_BLOOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.MOON_MINT), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_MINT));
		addBotanyAltarRecipe(new ItemStack(ModItems.FEATHERWEED), new ItemStack(Items.MUSHROOM_STEW), new ItemStack(ModItems.MUSHROOM_FEATHER));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_BULB));
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_FLOAT));
		addBotanyAltarRecipe(new ItemStack(ModItems.GLOWGROWTH), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_GLOW));
		addBotanyAltarRecipe(new ItemStack(ModItems.NEDDLESPROUT), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_NEDDLE));
		addBotanyAltarRecipe(new ItemStack(ModItems.STARBLOOM), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_BLOOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.MOON_MINT), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_MINT));
		addBotanyAltarRecipe(new ItemStack(ModItems.FEATHERWEED), new ItemStack(Items.RABBIT_STEW), new ItemStack(ModItems.RABBIT_FEATHER));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_BULB));
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_FLOAT));
		addBotanyAltarRecipe(new ItemStack(ModItems.GLOWGROWTH), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_GLOW));
		addBotanyAltarRecipe(new ItemStack(ModItems.NEDDLESPROUT), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_NEDDLE));
		addBotanyAltarRecipe(new ItemStack(ModItems.STARBLOOM), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_BLOOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.MOON_MINT), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_MINT));
		addBotanyAltarRecipe(new ItemStack(ModItems.FEATHERWEED), new ItemStack(Items.BEETROOT_SOUP), new ItemStack(ModItems.BEET_FEATHER));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_BULB));
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_FLOAT));
		addBotanyAltarRecipe(new ItemStack(ModItems.GLOWGROWTH), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_GLOW));
		addBotanyAltarRecipe(new ItemStack(ModItems.NEDDLESPROUT), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_NEDDLE));
		addBotanyAltarRecipe(new ItemStack(ModItems.STARBLOOM), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_BLOOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.MOON_MINT), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_MINT));
		addBotanyAltarRecipe(new ItemStack(ModItems.FEATHERWEED), new ItemStack(Items.BREAD), new ItemStack(ModItems.BREAD_FEATHER));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_BULB));
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_FLOAT));
		addBotanyAltarRecipe(new ItemStack(ModItems.GLOWGROWTH), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_GLOW));
		addBotanyAltarRecipe(new ItemStack(ModItems.NEDDLESPROUT), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_NEDDLE));
		addBotanyAltarRecipe(new ItemStack(ModItems.STARBLOOM), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_BLOOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.MOON_MINT), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_MINT));
		addBotanyAltarRecipe(new ItemStack(ModItems.FEATHERWEED), new ItemStack(Items.COOKIE), new ItemStack(ModItems.COOKIE_FEATHER));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.VOID_BULB), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_BULB));
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_FLOAT));
		addBotanyAltarRecipe(new ItemStack(ModItems.GLOWGROWTH), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_GLOW));
		addBotanyAltarRecipe(new ItemStack(ModItems.NEDDLESPROUT), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_NEDDLE));
		addBotanyAltarRecipe(new ItemStack(ModItems.STARBLOOM), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_BLOOM));
		addBotanyAltarRecipe(new ItemStack(ModItems.MOON_MINT), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_MINT));
		addBotanyAltarRecipe(new ItemStack(ModItems.FEATHERWEED), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(ModItems.PIE_FEATHER));
		
		addBotanyAltarRecipe(new ItemStack(ModItems.CRYSTAL), new ItemStack(Items.BOOK), ALCHEMY_BOOK);
		addBotanyAltarRecipe(new ItemStack(ModItems.FLOATSHROOM), new ItemStack(Items.BOOK), CLOUDSTEP_BOOK);
		
		addBotanyAltarRecipe(new ItemStack(Items.COAL), new ItemStack(ModItems.TRANSROOT), new ItemStack(Items.IRON_INGOT));
		addBotanyAltarRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.TRANSROOT), new ItemStack(Items.GOLD_INGOT));
		addBotanyAltarRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.TRANSROOT), new ItemStack(Items.DIAMOND));
		addBotanyAltarRecipe(new ItemStack(Items.DIAMOND), new ItemStack(ModItems.TRANSROOT), new ItemStack(Items.EMERALD));
		addBotanyAltarRecipe(new ItemStack(Items.EMERALD), new ItemStack(ModItems.TRANSROOT), new ItemStack(ModItems.CRYSTAL));
		addBotanyAltarRecipe(new ItemStack(Items.DYE, 1, 4), new ItemStack(ModItems.TRANSROOT), new ItemStack(Items.REDSTONE));
		addBotanyAltarRecipe(new ItemStack(Items.REDSTONE), new ItemStack(ModItems.TRANSROOT), new ItemStack(Items.GLOWSTONE_DUST));
		addBotanyAltarRecipe(new ItemStack(Items.QUARTZ), new ItemStack(ModItems.TRANSROOT), new ItemStack(ModItems.ENARGITE));
		addBotanyAltarRecipe(new ItemStack(ModItems.ENARGITE), new ItemStack(ModItems.TRANSROOT), new ItemStack(ModItems.CRYSTAL));
	}

	public void addBotanyAltarRecipe(ItemStack input1, ItemStack input2, ItemStack result) 
	{
		if(getBotanyAltarResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
	}
	
	public ItemStack getBotanyAltarResult(ItemStack input1, ItemStack input2) 
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
