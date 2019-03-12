package com.camellias.voidaicarcania.common.world.chunkdata;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class WorldEssence extends WorldSavedData
{
	private static final String ESSENCE = "voidEssenceData";
	private static int essenceLevel;
	private static int maxEssence;
	
	public WorldEssence() { super(ESSENCE); }
	public WorldEssence(String name) { super(name); }
	
	public static WorldEssence get(World world)
	{
		MapStorage storage = world.getPerWorldStorage();
		WorldEssence instance = (WorldEssence) storage.getOrLoadData(WorldEssence.class, ESSENCE);
		
		if(instance == null)
		{
			instance = new WorldEssence();
			storage.setData(ESSENCE, instance);
		}
		
		return instance;
	}
	
	public static int getMaxEssence()
	{
		maxEssence = 1600;
		return maxEssence;
	}
	
	public static int setEssence(World world)
	{
		Random rand = new Random();
		essenceLevel = MathHelper.clamp(rand.nextInt(getMaxEssence()), 400, getMaxEssence());
		return essenceLevel;
	}
	
	public static int getEssence()
	{
		return essenceLevel;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		nbt.getFloat("essenceLevel");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		if(nbt.hasKey("essenceLevel")) nbt.setFloat("essenceLevel", getEssence());
		return null;
	}
}
