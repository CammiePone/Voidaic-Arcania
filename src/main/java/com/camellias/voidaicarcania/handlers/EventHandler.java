package com.camellias.voidaicarcania.handlers;

import java.util.HashMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.world.BlockEvent.FluidPlaceBlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
	public static final IBlockState AIR = Blocks.AIR.getDefaultState();
	
	@SubscribeEvent
	public void onChunkPopulate(PopulateChunkEvent.Post event)
	{
		HashMap<BlockPos, IBlockState> map = new HashMap<BlockPos, IBlockState>();
		Chunk chunk = event.getWorld().getChunk(event.getChunkX(), event.getChunkZ());
		
		for(int x = 0; x < 16; x++)
		{
			for(int y = 0; y < 140; y++)
			{
				for(int z = 0; z < 16; z++)
				{
					BlockPos pos = new BlockPos(x, y, z);
					map.put(pos, chunk.getBlockState(pos));
					
				}
			}
		}
		
		for(int x = 0; x < 16; x++)
		{
			for(int y = 0; y < 140; y++)
			{
				for(int z = 0; z < 16; z++)
				{
					BlockPos pos = new BlockPos(x, y, z);
					chunk.setBlockState(pos.up(16), map.get(pos));
					if(y < 16)
					{
						chunk.setBlockState(pos, AIR);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onFluidPlace(FluidPlaceBlockEvent event)
	{
		int y = event.getLiquidPos().getY();
		
		if(y < 16)
		{
			event.setCanceled(true);
		}
	}
}
