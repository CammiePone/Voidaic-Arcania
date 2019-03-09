package com.camellias.voidaicarcania.api.capabilities.Infused;

import net.minecraft.nbt.NBTTagCompound;

public interface IInfused {

	boolean infused();

	void setInfused(boolean value);

	NBTTagCompound saveNBT();

	void loadNBT(NBTTagCompound compound);

}
