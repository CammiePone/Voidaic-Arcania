package com.camellias.voidaicarcania.api.capabilities.corruption.chunk;

import net.minecraft.nbt.NBTTagCompound;

public interface IChunkCorruption
{
	boolean isCorrupted();
	
	void setCorrupted(boolean value);
	
	int getCorruption();
	
	void setCorruption(int amount);
	
	NBTTagCompound saveNBT();
	
	void loadNBT(NBTTagCompound compound);
}
