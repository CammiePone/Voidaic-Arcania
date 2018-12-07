package com.camellias.voidaicarcania.world.biomes;

import com.camellias.voidaicarcania.common.entities.EntityVoidWraith;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeVoid extends Biome
{
	public BiomeVoid() 
	{
		super(new BiomeProperties("Void").setRainDisabled().setWaterColor(1638437));
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntityVoidWraith.class, 2, 1, 1));
	}
	
	@SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature)
    {
        return 0;
    }
	
	public boolean ignorePlayerSpawnSuitability()
    {
        return true;
    }
}
