package com.camellias.voidaicarcania.enchants;

import java.util.Random;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModEnchants;
import com.camellias.voidaicarcania.init.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EnchantAlchemy extends Enchantment 
{
	public EnchantAlchemy(String name, Rarity rarity, EnumEnchantmentType type, EntityEquipmentSlot[] slots)
	{
		super(rarity, type, slots);
		this.setName(name);
		this.setRegistryName(name);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public int getMaxLevel()
	{
		return 1;
	}
	
	@SubscribeEvent
	public static void onMinedDrop(HarvestDropsEvent event)
	{
		if(event.getHarvester() != null)
		{
			if(!event.getHarvester().world.isRemote)
			{
				int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchants.ALCHEMY, event.getHarvester());
				
				if(level > 0)
				{
					World world = event.getWorld();
					BlockPos pos = event.getPos();
					IBlockState state = event.getState();
					Random rand = world.rand;
					
					if(state.getBlock() == Blocks.COAL_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? Items.IRON_INGOT : state.getBlock().getItemDropped(state, rand, 0)));
					}
					
					if(state.getBlock() == Blocks.IRON_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? Items.GOLD_INGOT : state.getBlock().getItemDropped(state, rand, 0)));
					}
					
					if(state.getBlock() == Blocks.GOLD_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? Items.DIAMOND : state.getBlock().getItemDropped(state, rand, 0)));
					}
					
					if(state.getBlock() == Blocks.DIAMOND_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? Items.EMERALD : state.getBlock().getItemDropped(state, rand, 0)));
					}
					
					if(state.getBlock() == Blocks.EMERALD_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? ModItems.CRYSTAL : state.getBlock().getItemDropped(state, rand, 0)));
					}
					
					if(state.getBlock() == Blocks.LAPIS_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? Items.REDSTONE : state.getBlock().getItemDropped(state, rand, 0), 8));
					}
					
					if(state.getBlock() == Blocks.REDSTONE_ORE || state.getBlock() == Blocks.LIT_REDSTONE_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? Items.GLOWSTONE_DUST : state.getBlock().getItemDropped(state, rand, 0), 5));
					}
					
					if(state.getBlock() == Blocks.QUARTZ_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? ModItems.ENARGITE : state.getBlock().getItemDropped(state, rand, 0)));
					}
					
					if(state.getBlock() == ModBlocks.BLOCK_BORNITE_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(rand.nextInt(25) == 0 ? ModItems.CRYSTAL : state.getBlock().getItemDropped(state, rand, 0)));
					}
				}
			}
		}
	}
}
