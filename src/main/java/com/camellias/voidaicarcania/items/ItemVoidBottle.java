package com.camellias.voidaicarcania.items;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;
import com.camellias.voidaicarcania.world.dimension.voidic.TeleporterVoid;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemVoidBottle extends Item implements IHasModel
{
	protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            worldIn.setBlockState(pos, state, 11);
        }
    }
	
	public ItemVoidBottle(String name)
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
            if (world.getBlockState(pos).getBlock() != Blocks.AIR)
            {
            	world.destroyBlock(pos, false);
            }
        }
        
        /*if (!world.isRemote)
        {            
            if (world.getBlockState(pos).getBlock() == Blocks.BEDROCK && player.posY > 1)
            {
            	world.destroyBlock(pos, false);
            }
        }*/
        
        /*if (facing != EnumFacing.DOWN && !world.isRemote && world.getBlockState(pos).getBlock() == Blocks.BEDROCK && player.posY <= 1)
        {
        	ItemStack itemstack = player.getHeldItem(hand);
        	
    		this.setBlock(itemstack, player, world, pos, ModBlocks.BLOCK_PORTAL.getDefaultState());
        }*/
        
        ItemStack itemstack = player.getHeldItem(hand);
        
        if (!player.capabilities.isCreativeMode)
        {
        	player.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
        	itemstack.shrink(1);
        }
		return EnumActionResult.SUCCESS;
    }
}
