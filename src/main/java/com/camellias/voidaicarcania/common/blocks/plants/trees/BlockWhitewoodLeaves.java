package com.camellias.voidaicarcania.common.blocks.plants.trees;

import java.util.Random;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockWhitewoodLeaves extends BlockBaseGeneric
{
	public BlockWhitewoodLeaves(Material material, String name)
	{
		super(material, name);
		this.setSoundType(SoundType.PLANT);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setLightLevel(0.3F);
	}
	
	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return true;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state)
	{
		return true;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	protected boolean canSilkHarvest()
	{
		return true;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}
}
