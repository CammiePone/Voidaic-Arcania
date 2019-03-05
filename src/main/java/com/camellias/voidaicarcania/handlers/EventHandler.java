package com.camellias.voidaicarcania.handlers;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onChunkPopulate(PopulateChunkEvent.Pre event)
	{
		if(event.getWorld() != null)
		{
			World world = event.getWorld();
			
			for(int x = 0; x < 16; x++)
			{
			    for(int z = 0; z < 16; z++)
			    {
			        for(int y = 255; y >= 0; y--)
			        {
			        	BlockPos oldPos = new BlockPos(x * event.getChunkX(), y, z * event.getChunkZ());
						BlockPos newPos = new BlockPos(x * event.getChunkX(), y + 16, z * event.getChunkZ());
						
						world.setBlockState(newPos, world.getBlockState(oldPos));
			        }
			    }
			}
		}
	}
}
