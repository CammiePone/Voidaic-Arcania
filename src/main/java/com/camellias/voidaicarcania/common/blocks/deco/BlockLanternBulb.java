package com.camellias.voidaicarcania.common.blocks.deco;

import java.util.List;

import com.camellias.voidaicarcania.common.blocks.BlockBaseGeneric;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLanternBulb extends BlockBaseGeneric
{
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(.0625 * 3, .0625 * 3, .0625 * 3, .0625 * 13, .0625 * 16, .0625 * 13);

	public BlockLanternBulb(Material material, String name) 
	{
		super(material, name);
		this.setHardness(3.0F);
		this.setLightLevel(0.7F);
		this.setSoundType(SoundType.PLANT);
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
	public boolean isFullBlock(IBlockState state) 
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
		return BlockRenderLayer.CUTOUT;
	}

	@Override //Bounding box
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOUNDING_BOX;
	}
	
	@Override //Collision box
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_)
	{
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}
	
	/*public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return this.canBePlacedOn(WorldIn, pos.up());
	}
	
	public boolean canBePlacedOn(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos).isTopSolid() || worldIn.getBlockState(pos).getBlock() instanceof ModBlocks.LANTERN_STEM;
	}*/
	
}
