package com.camellias.voidaicarcania.common.items.voidic;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemTransmutationShard extends Item implements IHasModel
{
	public ItemTransmutationShard(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
        	ItemStack itemstack = player.getHeldItem(hand);
            
            if (world.getBlockState(pos).getBlock() == Blocks.DRAGON_EGG)
            {
            	player.addItemStackToInventory(new ItemStack(ModItems.VOIDIC_SHARD));
            }
            
            if (!player.capabilities.isCreativeMode)
            {
            	itemstack.shrink(1);
            }
        }
		return EnumActionResult.SUCCESS;
    }
}
