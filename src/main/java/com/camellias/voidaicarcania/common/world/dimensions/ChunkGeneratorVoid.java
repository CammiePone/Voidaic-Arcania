package com.camellias.voidaicarcania.common.world.dimensions;

import java.util.List;
import java.util.Random;

import com.camellias.voidaicarcania.core.init.ModBiomes;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.ForgeEventFactory;

public class ChunkGeneratorVoid implements IChunkGenerator
{
	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	
	private final Random rand;
	private final World world;
	private double[] buffer;
	private int chunkX = 0;
    private int chunkZ = 0;
	
	public ChunkGeneratorVoid(World world, boolean useless, long rand, BlockPos pos)
	{
		this.world = world;
		this.rand = new Random(rand);
	}
	
	public void setBlocksInChunk(int i, int j, ChunkPrimer primer)
	{
		for(int x = 0; x < 16; ++x)
		{
			for(int z = 0; z < 16; ++z)
			{
				IBlockState iblockstate;
				
				for(int y = 255; y >= 248; y--)
				{
					if(y > 255 - this.rand.nextInt(3) || y == 255)
					{
						primer.setBlockState(x, y, z, BEDROCK);
					}
				}
			}
		}
	}
	
	@Override
	public Chunk generateChunk(int x, int z)
	{
		this.chunkX = x;
		this.chunkZ = z;
		this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);
		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
		byte[] abyte = chunk.getBiomeArray();
		
		for(int i = 0; i < abyte.length; ++i)
		{
			abyte[i] = (byte)Biome.getIdForBiome(ModBiomes.VOID);
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	@Override
	public void populate(int x, int z)
	{
		BlockFalling.fallInstantly = true;
		ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
        BlockPos blockpos = new BlockPos(x * 16, 0, z * 16);
        
        this.world.getBiome(blockpos.add(16, 0, 16)).decorate(this.world, this.world.rand, blockpos);
        
        ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
        BlockFalling.fallInstantly = false;
	}
	
	@Override
	public boolean generateStructures(Chunk chunk, int x, int z)
	{
		return false;
	}
	
	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
	{
		return this.world.getBiome(pos).getSpawnableList(creatureType);
	}
	
	@Override
	public BlockPos getNearestStructurePos(World world, String structureName, BlockPos position, boolean findUnexplored)
	{
		return null;
	}
	
	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z)
	{
		
	}
	
	@Override
	public boolean isInsideStructure(World world, String structureName, BlockPos pos)
	{
		return false;
	}
}
