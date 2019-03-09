package com.camellias.voidaicarcania.api.capabilities.Corruption;

import net.minecraft.nbt.NBTTagCompound;

public interface ICorruption {

	boolean corrupted();

	void setCorrupted(boolean value);

	int corruption();

	void setCorruption(int amount);

	NBTTagCompound saveNBT();

	void loadNBT(NBTTagCompound compound);

}
