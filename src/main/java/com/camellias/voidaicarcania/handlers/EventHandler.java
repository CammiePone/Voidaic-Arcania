package com.camellias.voidaicarcania.handlers;

import com.camellias.voidaicarcania.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
	public static final IBlockState RIFT = ModBlocks.RIFT.getDefaultState();
	public static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	
	@SubscribeEvent
	public void onChunkPopulate(PopulateChunkEvent.Pre event)
	{
		Chunk chunk = event.getWorld().getChunk(event.getChunkX(), event.getChunkZ());
		
		for(int x = 0; x < 16; x++)
		{
			for(int z = 0; z < 16; z++)
			{
				for(int y = 0; y <= 1; y++)
				{
					BlockPos pos = new BlockPos(x, y, z);
					if(y == 0) chunk.setBlockState(pos, RIFT);
					if(y == 1) chunk.setBlockState(pos, BEDROCK);
				}
			}
		}
	}
}
