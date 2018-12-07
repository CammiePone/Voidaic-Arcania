package com.camellias.voidaicarcania.common.items.plantsandfood;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;


public class ItemVoidMelonSeed extends Item implements IHasModel, IPlantable
{
	public ItemVoidMelonSeed(String name)
	{
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		ItemStack stack = player.getHeldItem(hand);
		IBlockState state = world.getBlockState(pos);
		
		if(facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack) 
				&& state.getBlock().canSustainPlant(state, world, pos, EnumFacing.UP, this) && world.isAirBlock(pos.up()))
		{
			world.setBlockState(pos.up(), ModBlocks.BLOCK_MELON_CROP.getDefaultState());
			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		else return EnumActionResult.FAIL;
	}
	
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) 
	{
		return ModBlocks.BLOCK_MELON_CROP.getDefaultState();
	}
	
}
