package com.camellias.voidaicarcania.enchants;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModEnchants;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EnchantCloudStep extends Enchantment
{
	public EnchantCloudStep(String name, Rarity rarity, EnumEnchantmentType type, EntityEquipmentSlot[] slots)
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
	public static void cloudStep(LivingUpdateEvent event)
	{
		if(!event.getEntity().world.isRemote && event.getEntityLiving() instanceof EntityPlayerMP)
		{
			int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchants.CLOUDSTEP, event.getEntityLiving());
			EntityPlayerMP player = (EntityPlayerMP) event.getEntityLiving();
			
			if(level > 0)
			{
				World world = event.getEntity().world;
				int r = level + 1;
				BlockPos pos = event.getEntity().getPosition();
				
				for(int x = -r; x <= r; x++)
				{
					for(int z = -r; z <= r; z++)
					{
						BlockPos blockpos = pos.add(x + 1, -1, z + 1);
						
						if(blockpos.distanceSq(pos.getX(), pos.getY(), pos.getZ()) > r * r)
						{
							continue;
						}
						
						IBlockState state = world.getBlockState(blockpos);
						
						if(state.getBlock() == Blocks.AIR && !player.isSneaking())
						{
							world.setBlockState(blockpos, ModBlocks.BLOCK_VOIDCLOUD.getDefaultState());
						}
					}
				}
			}
		}
	}
}
