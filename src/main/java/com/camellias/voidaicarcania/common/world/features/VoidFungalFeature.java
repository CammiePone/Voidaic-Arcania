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

public class VoidFungalFeature  extends WorldGenAbstractTree
{
	private static final IBlockState STEM = ModBlocks.FUNGAL_STEM.getDefaultState().withProperty(BlockWhitewoodLog.AXIS, Axis.Y);
	private static final IBlockState DISC = ModBlocks.FUNGAL_WALL.getDefaultState();
	
	public VoidFungalFeature(boolean notify)
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
		
		while((world.getBlockState(pos0).getBlock() != Blocks.AIR) && (world.getBlockState(pos0.up()).getBlock() != Blocks.BEDROCK))
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
					
					//Leaves
					BlockPos pos1 = pos0;
					int leafY = pos1.getY() - treeHeight;
					
					pos1 = new BlockPos(x, leafY + 7, z);
					this.placeLeafAt(world, pos1.north().west());
					this.placeLeafAt(world, pos1.north());
					this.placeLeafAt(world, pos1.north().east());
					this.placeLeafAt(world, pos1.west());
					this.placeLeafAt(world, pos1.east());
					this.placeLeafAt(world, pos1.south().west());
					this.placeLeafAt(world, pos1.south());
					this.placeLeafAt(world, pos1.south().east());
					
					pos1 = new BlockPos(x, leafY + 5, z);
					this.placeLeafAt(world, pos1.north().west());
					this.placeLeafAt(world, pos1.north());
					this.placeLeafAt(world, pos1.north().east());
					this.placeLeafAt(world, pos1.west());
					this.placeLeafAt(world, pos1.east());
					this.placeLeafAt(world, pos1.south().west());
					this.placeLeafAt(world, pos1.south());
					this.placeLeafAt(world, pos1.south().east());
					
					pos1 = new BlockPos(x, leafY + 2, z);
					this.placeLeafAt(world, pos1.north().west());
					this.placeLeafAt(world, pos1.north());
					this.placeLeafAt(world, pos1.north().east());
					this.placeLeafAt(world, pos1.west());
					this.placeLeafAt(world, pos1.east());
					this.placeLeafAt(world, pos1.south().west());
					this.placeLeafAt(world, pos1.south());
					this.placeLeafAt(world, pos1.south().east());
				}
			}
			
			return true;
		}
	}
	
	private void placeLogsAt(World world, BlockPos pos)
	{
		this.setBlockAndNotifyAdequately(world, pos, STEM);
	}
	
	private void placeLeafAt(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		
		if(state.getBlock().isAir(state, world, pos))
		{
			this.setBlockAndNotifyAdequately(world, pos, DISC);
		}
	}
}
