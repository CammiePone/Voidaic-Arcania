package com.camellias.voidaicarcania.util.infostorage;

import net.minecraft.nbt.NBTTagCompound;

public class VoidCorruptionCapability
{
	private float corruption = 0.0F;
	
	public VoidCorruptionCapability()
	{
		
	}
	
	public float getVoidEssence()
	{
		return corruption;
	}
	
	public void setVoidEssence(float corruption)
	{
		this.corruption = corruption;
	}
	
	public void copyFrom(VoidCorruptionCapability source)
	{
		corruption = source.corruption;
	}
	
	public void writeToNBT(NBTTagCompound compound)
	{
		compound.setFloat("void_corruption", corruption);
	}
	
	public void readFromNBT(NBTTagCompound compound)
	{
		corruption = compound.getFloat("void_corruption");
	}
}
