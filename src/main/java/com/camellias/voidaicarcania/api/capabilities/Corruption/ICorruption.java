package com.camellias.voidaicarcania.api.capabilities.Corruption;

import net.minecraft.nbt.NBTTagCompound;

public interface ICorruption {

	boolean isCorrupted();

	void setCorrupted(boolean value);

	int getCorruption();

	void setCorruption(int amount);

	NBTTagCompound saveNBT();

	void loadNBT(NBTTagCompound compound);

}
