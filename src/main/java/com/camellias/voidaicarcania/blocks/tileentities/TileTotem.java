package com.camellias.voidaicarcania.blocks.tileentities;

import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.util.TileEntityNBT;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class TileTotem extends TileEntityNBT implements ITickable
{
	
	private boolean isFormed = false;

	@Override
	public void update() 
	{		
		//CheckOncePerSecond
		if(world.getTotalWorldTime()%20 == 0 && isFormed && !checkStructure())
        {
            isFormed = false;
            if(!world.isRemote)
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        }
	}
	
	public boolean formStructure()
    {
        return isFormed = checkStructure();
    }

    public boolean isFormed()
    {
        return isFormed;
    }
    
    /**
     * Checks if the blocks around this block resembles a valid structure
     */
    private boolean checkStructure()
    {
        for(int x = pos.getX() - 1; x <= pos.getX() + 1; x++)
            for(int y = pos.getY(); y <= pos.getY() - 2; y++)
                for(int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++)
                {
                    //Don't need to check this block!
                    if(x == pos.getX() && y == pos.getY() && z == pos.getZ())
                        continue;
                    IBlockState state = world.getBlockState(new BlockPos(x, y, z));
                    Block block = state.getBlock();
                    //Middle block must be air!
                    if(x == pos.getX() && y == pos.getY() + 1 && z == pos.getZ())
                    {
                        if(state.getMaterial() != Material.AIR)
                            return false;
                    }
                    //Check if the block is a stone block
                    else if(block != ModBlocks.BLOCK_VOIDSTONE_PILLAR)
                        return false;
                }

        //If it got this far, the structure must be good!
        return true;
    }

}
