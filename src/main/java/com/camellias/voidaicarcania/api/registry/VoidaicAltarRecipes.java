package com.camellias.voidaicarcania.api.registry;
 
import java.util.Collection;
import java.util.HashMap;

import com.camellias.voidaicarcania.api.spells.SpellType;
import com.camellias.voidaicarcania.core.init.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
 
public class VoidaicAltarRecipes
{
	public static final VoidaicAltarRecipes INSTANCE = new VoidaicAltarRecipes();
	private final HashMap<String, VoidaicAltarRecipeHelper> recipes = new HashMap<String, VoidaicAltarRecipeHelper>();
	
	public void init()
	{
		//Example Recipe (NEEDS TO BE REMOVED LATER)
		addItemRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.GOLD_INGOT), new ItemStack(Blocks.GLASS), 100, new ItemStack(ModItems.VOID_RESONATOR));
	}
	
	private String BuildKeyComponent(ItemStack input)
	{
		if(input == null)
		{
			return "NULL";    
		}
		
		return Integer.toString(Item.getIdFromItem(input.getItem())) + Integer.toString(input.getMetadata());
	}
	
	private String BuildKey(ItemStack input1, ItemStack input2, ItemStack input3)
	{
		return BuildKeyComponent(input1) + BuildKeyComponent(input2) + BuildKeyComponent(input3);
	}
	
	/**
	 * Used to add shapeless item recipes to the Voidaic Altar.
	 *
	 * @param input1 - The first ingredient (an ItemStack, to allow for metadata. Do NOT change stack size, else it won't work).
	 * @param input2 - The second ingredient (an ItemStack, to allow for metadata. Do NOT change stack size, else it won't work).
	 * @param input3 - The third ingredient (an ItemStack, to allow for metadata. Do NOT change stack size, else it won't work).
	 * @param voidEssenceCost - How much Void Essence the recipe requires. Has to be higher than 0, else the recipe won't work.
	 * @param result - The resulting ItemStack of the recipe.
	 * @return
	 */
	public void addItemRecipe(ItemStack input1, ItemStack input2, ItemStack input3, int voidEssenceCost, ItemStack result)
	{
		String key = BuildKey(input1, input2, input3);
		recipes.put(key, new VoidaicAltarRecipeHelper(input1, input2, input3, voidEssenceCost, result));
	}
	
	/**
	 * Used to add shapeless spell recipes to the Voidaic Altar.
	 *
	 * @param input1 - The first ingredient (an ItemStack, to allow for metadata. Do NOT change stack size, else it won't work).
	 * @param input2 - The second ingredient (an ItemStack, to allow for metadata. Do NOT change stack size, else it won't work).
	 * @param input3 - The third ingredient (an ItemStack, to allow for metadata. Do NOT change stack size, else it won't work).
	 * @param voidEssenceCost - How much Void Essence the recipe requires. Has to be higher than 0, else the recipe won't work.
	 * @param result - The resulting ISpellType of the recipe.
	 * @return
	 */
	public void addSpellRecipe(ItemStack input1, ItemStack input2, ItemStack input3, int voidEssenceCost, SpellType... spellType)
	{
		String key = BuildKey(input1, input2, input3);
		recipes.put(key, new VoidaicAltarRecipeHelper(input1, input2, input3, voidEssenceCost, spellType));
	}
	
	/**
	 * Specifically for CraftTweaker support. Please, do not use this if you're making an addon, or support, for VA.
	 * 
	 * @param input1
	 * @param input2
	 * @param input3
	 * @param voidEssenceCost
	 * @param result
	 */
	public void removeItemRecipe(ItemStack input1, ItemStack input2, ItemStack input3, int voidEssenceCost, ItemStack result)
	{
		String key = BuildKey(input1, input2, input3);
		
		if(recipes.containsKey(key))
		{
			VoidaicAltarRecipeHelper recipe = recipes.get(key);
			
			if(recipe.voidEssenceCost == voidEssenceCost && BuildKeyComponent(recipe.result) == BuildKeyComponent(result))
			{
				recipes.remove(key);
			}
		}
	}
	
	/**
	 * Specifically for CraftTweaker support. Please, do not use this if you're making an addon, or support, for VA.
	 * 
	 * @param input1
	 * @param input2
	 * @param input3
	 * @param voidEssenceCost
	 * @param result
	 */
	public void removeSpellRecipe(ItemStack input1, ItemStack input2, ItemStack input3, int voidEssenceCost, SpellType... spellType)
	{
		String key = BuildKey(input1, input2, input3);
		
		if(recipes.containsKey(key))
		{
			VoidaicAltarRecipeHelper recipe = recipes.get(key);
			
			if(recipe.voidEssenceCost == voidEssenceCost && recipe.spellType == spellType)
			{
				recipes.remove(key);
			}
		}
	}
	
	public Collection<VoidaicAltarRecipeHelper> getRecipes()
	{
		return recipes.values();
	}
	
	public int getVoidEssenceCost(ItemStack input1, ItemStack input2, ItemStack input3)
	{
		String key = BuildKey(input1, input2, input3);
		
		if(recipes.containsKey(key))
		{
			VoidaicAltarRecipeHelper recipe = recipes.get(key);
			return recipe.voidEssenceCost;
		}
		
		return 0;
	}
	
	public VoidaicAltarRecipeHelper getRecipe(ItemStack input1, ItemStack input2, ItemStack input3)
	{
		String Key = BuildKey(input1, input2, input3);
		
		if (recipes.containsKey(Key))
		{
			VoidaicAltarRecipeHelper recipe = recipes.get(Key);
			return recipe;
		}
		
		return null;
	}
	
	public ItemStack getRecipeResult(ItemStack input1, ItemStack input2, ItemStack input3)
	{
		String key = BuildKey(input1, input2, input3);
		
		if(recipes.containsKey(key))
		{
			VoidaicAltarRecipeHelper recipe = recipes.get(key);
			return recipe.result;
		}
		
		return null;
	}
}