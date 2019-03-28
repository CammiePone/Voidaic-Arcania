package com.camellias.voidaicarcania.common.world.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.camellias.voidaicarcania.common.world.WorldGenStructure;
import com.camellias.voidaicarcania.common.world.biomes.BiomeVoid;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

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
				
				break;
				
			case -1:
				
				break;
				
			case -64:
				
				fiveBlockStructure(new WorldGenStructure("spike2"), world, rand, chunkX, chunkZ, 100, Blocks.BEDROCK, BiomeVoid.class);
				fiveBlockStructure(new WorldGenStructure("spike4"), world, rand, chunkX, chunkZ, 100, Blocks.BEDROCK, BiomeVoid.class);
				sixBlockStructure(new WorldGenStructure("spike3"), world, rand, chunkX, chunkZ, 100, Blocks.BEDROCK, BiomeVoid.class);
				eightBlockStructure(new WorldGenStructure("spike1"), world, rand, chunkX, chunkZ, 100, Blocks.BEDROCK, BiomeVoid.class);
		}
	}
	
	private void fiveBlockStructure(WorldGenerator generator, World world, Random rand, 
			int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = rand.nextInt(4);
		BlockPos pos = new BlockPos(x, y + (122 - 5), z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(classesList.contains(biome))
		{
			if(rand.nextInt(chance) == 0)
			{
				generator.generate(world, rand, pos);
			}
		}
	}
	
	private void sixBlockStructure(WorldGenerator generator, World world, Random rand, 
			int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = rand.nextInt(4);
		BlockPos pos = new BlockPos(x, y + (122 - 6), z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(classesList.contains(biome))
		{
			if(rand.nextInt(chance) == 0)
			{
				generator.generate(world, rand, pos);
			}
		}
	}
	
	private void sevenBlockStructure(WorldGenerator generator, World world, Random rand, 
			int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = rand.nextInt(4);
		BlockPos pos = new BlockPos(x, y + (122 - 7), z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(classesList.contains(biome))
		{
			if(rand.nextInt(chance) == 0)
			{
				generator.generate(world, rand, pos);
			}
		}
	}
	
	private void eightBlockStructure(WorldGenerator generator, World world, Random rand, 
			int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = rand.nextInt(4);
		BlockPos pos = new BlockPos(x, y + (122 - 8), z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(classesList.contains(biome))
		{
			if(rand.nextInt(chance) == 0)
			{
				generator.generate(world, rand, pos);
			}
		}
	}
}
