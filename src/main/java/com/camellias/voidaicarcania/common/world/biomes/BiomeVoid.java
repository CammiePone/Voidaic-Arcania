package com.camellias.voidaicarcania.common.world.biomes;

import java.util.Random;

import com.camellias.voidaicarcania.core.init.ModBiomes;
import com.camellias.voidaicarcania.core.init.ModEntities;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
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
        
        this.decorator.treesPerChunk = 1;
        
        ModEntities.VOID_BIOME.add("Void");
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
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	{
		return rand.nextInt(20) == 0 ? ModBiomes.Features.WHITEWOOD_TREE : super.getRandomTreeFeature(rand);
	}
}
