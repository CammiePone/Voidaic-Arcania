package com.camellias.voidaicarcania.handlers;

import java.util.HashMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
	@SubscribeEvent
	public void onChunkPopulate(PopulateChunkEvent.Post event)
	{
		Chunk chunk = event.getWorld().getChunk(event.getChunkX(), event.getChunkZ());
		
		for(int x = 0; x < 16; x++)
		{
			for(int y = 0; y < 255 - 16; y++)
			{
				for(int z = 0; z < 16; z++)
				{
					BlockPos pos = new BlockPos(x,y,z);
					IBlockState state = chunk.getBlockState(pos);
					chunk.setBlockState(pos, Blocks.AIR.getDefaultState());
					chunk.setBlockState(pos.up(16), state);
				}        
			}
		}
	}
}
