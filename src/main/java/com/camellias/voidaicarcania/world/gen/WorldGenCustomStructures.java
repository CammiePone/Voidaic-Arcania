package com.camellias.voidaicarcania.world.gen;

import java.util.ArrayList;
import java.util.Random;

import com.camellias.voidaicarcania.world.biomes.BiomeVoid;
import com.camellias.voidaicarcania.world.gen.generators.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEnd;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Arrays;
import java.util.List;

public class WorldGenCustomStructures implements IWorldGenerator
{
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator generator,
			IChunkProvider provider)
	{
		switch(world.provider.getDimension())
		{
			case 1:
				
				break;
				
			case 0:
				
				//generateStructure2(new WorldGenStructure(""), world, rand, chunkX, chunkZ, 1000, Blocks.STONE, Biome.class);
				
				break;
				
			case -1:
				
				break;
				
			case -64:
				
				generateStructure(new WorldGenStructure("voidtemple"), world, rand, chunkX, chunkZ, 3000, Blocks.AIR, BiomeVoid.class);
				
				generateStructure(new WorldGenStructure("islandruin_1"), world, rand, chunkX, chunkZ, 1000, Blocks.AIR, BiomeVoid.class);
				
				generateStructure(new WorldGenStructure("ruin_garden"), world, rand, chunkX, chunkZ, 1000, Blocks.AIR, BiomeVoid.class);
				
				generateStructure(new WorldGenStructure("islandovergrown"), world, rand, chunkX, chunkZ, 750, Blocks.AIR, BiomeVoid.class);
				
				generateStructure(new WorldGenStructure("islandobelisk"), world, rand, chunkX, chunkZ, 400, Blocks.AIR, BiomeVoid.class);
				
				generateStructure(new WorldGenStructure("islandtall"), world, rand, chunkX, chunkZ, 30, Blocks.AIR, BiomeVoid.class);
				
				generateStructure(new WorldGenStructure("islandcluster_1"), world, rand, chunkX, chunkZ, 20, Blocks.AIR, BiomeVoid.class);
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random rand, 
			int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = rand.nextInt(256);
		BlockPos pos = new BlockPos(x, y, z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(rand.nextInt(chance) == 0)
				{
					generator.generate(world, rand, pos);
				}
			}
		}
	}
	
	private void generateStructure2(WorldGenerator generator, World world, Random rand, 
			int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = rand.nextInt(256);
		BlockPos pos = new BlockPos(x, y, z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(rand.nextInt(chance) == 0)
				{
					generator.generate(world, rand, pos);
				}
			}
		}
	}
}
