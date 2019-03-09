package com.camellias.voidaicarcania.api.capabilities.EssenceCap;

import net.minecraft.nbt.NBTTagCompound;

public interface IEssence {

	boolean effect();

	void setEffect(boolean transformed);

	int essence();

	void setEssence(int type);

	NBTTagCompound saveNBT();

	void loadNBT(NBTTagCompound compound);

}