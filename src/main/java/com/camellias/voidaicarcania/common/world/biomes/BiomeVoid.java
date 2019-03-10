package com.camellias.voidaicarcania.common.world.biomes;

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
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public int getSkyColorByTemp(float currentTemperature)
    {
        return 0;
    }
	
	@Override
	public boolean ignorePlayerSpawnSuitability()
    {
        return true;
    }
}
