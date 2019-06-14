package com.camellias.voidaicarcania.common.world.features;

import java.util.Random;

import com.camellias.voidaicarcania.common.blocks.plants.trees.BlockWhitewoodLog;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WhitewoodTreeFeature  extends WorldGenAbstractTree
{
	private static final IBlockState TRUNK = ModBlocks.WHITEWOOD_LOG.getDefaultState().withProperty(BlockWhitewoodLog.AXIS, Axis.Y);
	private static final IBlockState LEAF = ModBlocks.WHITEWOOD_LEAVES.getDefaultState();
	
	public WhitewoodTreeFeature(boolean notify)
	{
		super(notify);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int treeHeight = (rand.nextInt(3) + 7);
		int x = pos.getX();
		int z = pos.getZ();
		
		BlockPos pos0 = new BlockPos(x, 255, z);
		
		while(world.getBlockState(pos0).getBlock() != Blocks.AIR)
		{
			pos0 = pos0.down();

			continue;
		}
		
		BlockPos blockpos = pos0.up();
		IBlockState state = world.getBlockState(blockpos);
		boolean isSoil = state.getBlock() == Blocks.BEDROCK;
		
		if(!(isSoil))
		{
			return false;
		}
		else
		{
			for(int j2 = 0; j2 < treeHeight; ++j2)
			{
				int k2 = pos0.getY() - j2;
				BlockPos blockpos1 = new BlockPos(x, k2, z);
				state = world.getBlockState(blockpos1);
				
				//Generate trees
				if(state.getBlock().isAir(state, world, blockpos1) || state.getBlock().isLeaves(state, world, blockpos1))
				{
					//Logs
					this.placeLogsAt(world, blockpos1);
					
					/*for(int i = 0; i < 5; i++)
					{
						//Leaves
						pos0 = pos0.down((j2 - 2) - i);
						this.placeLeafAt(world, pos0.north().west());
						this.placeLeafAt(world, pos0.north());
						this.placeLeafAt(world, pos0.north().east());
						this.placeLeafAt(world, pos0.west());
						this.placeLeafAt(world, pos0.east());
						this.placeLeafAt(world, pos0.south().west());
						this.placeLeafAt(world, pos0.south());
						this.placeLeafAt(world, pos0.east());
						
						pos0 = pos0.down((j2 - 4));
						this.placeLeafAt(world, pos0.north());
						this.placeLeafAt(world, pos0.west());
						this.placeLeafAt(world, pos0.east());
						this.placeLeafAt(world, pos0.south());
						
						pos0 = pos0.down((j2 - 5));
						this.placeLeafAt(world, pos0.north());
						this.placeLeafAt(world, pos0.west());
						this.placeLeafAt(world, pos0.east());
						this.placeLeafAt(world, pos0.south());
						
						pos0 = pos0.down((j2 - 6));
						this.placeLeafAt(world, pos0);
					}*/
				}
			}
			
			return true;
		}
	}
	
	private void placeLogsAt(World world, BlockPos pos)
	{
		this.setBlockAndNotifyAdequately(world, pos, TRUNK);
	}
	
	private void placeLeafAt(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		
		if(state.getBlock().isAir(state, world, pos))
		{
			this.setBlockAndNotifyAdequately(world, pos, LEAF);
		}
	}
}
