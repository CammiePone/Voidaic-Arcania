package com.camellias.voidaicarcania.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class Edit
{
	public BlockPos pos;
	public IBlockState state;
	
	public Edit(BlockPos pos, IBlockState state)
	{
		this.pos = pos;
		this.state = state;
	}
}
