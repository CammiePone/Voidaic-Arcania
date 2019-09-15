package com.camellias.voidaicarcania.common.world.biomes;

import java.util.Random;

import com.camellias.voidaicarcania.core.init.ModBiomes;
import com.camellias.voidaicarcania.core.init.ModEntities;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeFungalPatch extends Biome
{
	public BiomeFungalPatch()
	{
		super(new BiomeProperties("Fungal_Patch").setRainDisabled().setWaterColor(1638437));
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        this.decorator.treesPerChunk = 5;
        
        ModEntities.VOID_BIOME.add("Fungal_Patch");
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
		return rand.nextInt(20) == 0 ? ModBiomes.Features.HANGING_LANTERN : super.getRandomTreeFeature(rand);
	}
}
