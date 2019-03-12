package com.camellias.voidaicarcania.common.world.chunkdata;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class WorldCorruption extends WorldSavedData
{
	private static final String CORRUPTION = "voidCorruptionData";
	private static int corruptionLevel;
	private static int maxCorruption;
	
	public WorldCorruption() { super(CORRUPTION); }
	public WorldCorruption(String name) { super(name); }
	
	public static WorldCorruption get(World world)
	{
		MapStorage storage = world.getPerWorldStorage();
		WorldCorruption instance = (WorldCorruption) storage.getOrLoadData(WorldCorruption.class, CORRUPTION);
		
		if(instance == null)
		{
			instance = new WorldCorruption();
			storage.setData(CORRUPTION, instance);
		}
		
		return instance;
	}
	
	public static int getMaxCorruption()
	{
		maxCorruption = 1000;
		return maxCorruption;
	}
	
	public static int setCorruption(World world)
	{
		Random rand = new Random();
		corruptionLevel = rand.nextInt(getMaxCorruption());
		return corruptionLevel;
	}
	
	public static int getCorruption()
	{
		return corruptionLevel;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		nbt.getFloat("corruptionLevel");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		if(nbt.hasKey("corruptionLevel")) nbt.setFloat("corruptionLevel", getCorruption());
		return null;
	}
}
