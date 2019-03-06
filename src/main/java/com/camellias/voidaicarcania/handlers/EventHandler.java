package com.camellias.voidaicarcania.handlers;

import java.util.LinkedList;
import java.util.Queue;

import com.camellias.voidaicarcania.util.Edit;
import com.camellias.voidaicarcania.util.ScanCallBack;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
	@SubscribeEvent
	public void onChunkPopulate(PopulateChunkEvent.Post event)
	{
		Chunk chunk = event.getWorld().getChunk(event.getChunkX(), event.getChunkZ());
		
		final Queue<Edit> editQueue = new LinkedList();
		
		scanChunk(chunk, 140, (c, i, j, k) ->
		{
			BlockPos pos = new BlockPos(i, j, k);
			IBlockState state = chunk.getBlockState(pos);
			editQueue.offer(get(pos, state));
		});
		
		while(editQueue.peek() != null)
		{
			final Edit edit = editQueue.poll();
			BlockPos pos = edit.pos;
			
			chunk.setBlockState(pos.up(16), edit.state);
			if(pos.getY() < 16)
			{
				chunk.setBlockState(pos, AIR);
			}
			
			recycleBin.offer(edit);
		}
	}
	
	
	
//-----------------------------------------------------------------------------------------------------------------------//
	
	
	
	public static final IBlockState AIR = Blocks.AIR.getDefaultState();
	
	public void scanChunk(Chunk chunk, int yMax, ScanCallBack function)
	{
		loopChunk(chunk, 0, 0, 0, 16, yMax, 16, function);
	}
	
	public void loopChunk(Chunk chunk, int x, int y, int z, int w, int h, int d, ScanCallBack function)
	{
		for(int i = x; i < w; i++)
		{
			for(int j = y; j < h; j++)
			{
				for(int k = z; k < d; k++)
				{
					function.onScan(chunk, i, j, k);
				}
			}
		}
	}
	
	Queue<Edit> recycleBin = new LinkedList();
	public Edit get(BlockPos pos, IBlockState state)
	{
		if(recycleBin.peek() != null)
		{
			Edit edit = recycleBin.poll();
			edit.pos = pos;
			edit.state = state;
			return edit;
		}
		
		return new Edit(pos, state);
	}
}
