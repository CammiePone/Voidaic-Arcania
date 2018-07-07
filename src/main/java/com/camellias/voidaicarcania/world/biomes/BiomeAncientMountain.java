package com.camellias.voidaicarcania.world.biomes;

import java.util.Random;

import com.camellias.voidaicarcania.entities.EntityVoidWraith;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeAncientMountain extends Biome
{
	public BiomeAncientMountain() 
	{
		super(new BiomeProperties("AncientMountain").setBaseHeight(2.0F).setHeightVariation(0.1F).setTemperature(0.6F).setRainDisabled().setWaterColor(7485952));
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        //terrain
               
        this.topBlock = Blocks.COBBLESTONE.getDefaultState();
        this.fillerBlock = Blocks.STONE.getDefaultState();
	}
	
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
		this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}