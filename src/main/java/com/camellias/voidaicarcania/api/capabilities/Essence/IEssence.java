package com.camellias.voidaicarcania.api.capabilities.essence;

import net.minecraft.nbt.NBTTagCompound;

public interface IEssence {

	boolean effect();

	void setEffect(boolean transformed);

	int getEssence();

	void setEssence(int type);

	NBTTagCompound saveNBT();

	void loadNBT(NBTTagCompound compound);

}