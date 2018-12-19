package com.camellias.voidaicarcania.world.gen;

import java.util.Random;

import com.camellias.voidaicarcania.init.ModBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator cinnabar;
	private WorldGenerator peacock;
	private WorldGenerator nether_heart;
	
	public WorldGenCustomOres()
	{
		cinnabar = new WorldGenMinable(ModBlocks.BLOCK_CINNIBAR_ORE.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		peacock = new WorldGenMinable(ModBlocks.BLOCK_BORNITE_ORE.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.NETHERRACK));
		nether_heart = new WorldGenMinable(ModBlocks.BLOCK_NETHERHEART_ORE.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:
			runGenerator(peacock, world, random, chunkX, chunkZ, 60, 0, 128);
			runGenerator(nether_heart, world, random, chunkX, chunkZ, 60, 0, 128);
			
			break;
			
		case 0:
			runGenerator(cinnabar, world, random, chunkX, chunkZ, 80, 0, 128);
			
			break;
			
		case 1:
			
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random random, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight > 0 || maxHeight > 256) throw new IllegalArgumentException("Generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunkZ * 16 + random.nextInt(16);
			
			gen.generate(world, random, new BlockPos(x, y, z));
		}
	}
}
