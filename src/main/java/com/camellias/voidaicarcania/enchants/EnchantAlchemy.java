package com.camellias.voidaicarcania.enchants;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModEnchants;

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
					
					if(state.getBlock() == Blocks.COAL_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.IRON_INGOT));
					}
					
					if(state.getBlock() == Blocks.IRON_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
					}
					
					if(state.getBlock() == Blocks.GOLD_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.DIAMOND));
					}
					
					if(state.getBlock() == Blocks.DIAMOND_ORE)
					{
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Items.EMERALD));
					}
				}
			}
		}
	}
}
