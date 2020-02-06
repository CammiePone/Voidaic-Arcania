package com.camellias.voidaicarcania.core.util;

import net.minecraft.world.chunk.Chunk;

@FunctionalInterface
public interface ScanCallBack
{
	public void onScan(Chunk chunk, int x, int y, int z);
}
