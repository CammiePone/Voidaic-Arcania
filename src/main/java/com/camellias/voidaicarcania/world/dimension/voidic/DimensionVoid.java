package com.camellias.voidaicarcania.world.dimension.voidic;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.init.ModBiomes;
import com.camellias.voidaicarcania.init.ModDimensions;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DimensionVoid extends WorldProvider
{
	public DimensionVoid()
	{
		this.biomeProvider = new BiomeProviderSingle(ModBiomes.VOID);
	}
	
	@Override
	public DimensionType getDimensionType()
	{
		return ModDimensions.VOID;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator()
	{
		return new ChunkGeneratorVoid(world, true, world.getSeed(), null);
	}
	
	public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.75F;
    }
	
	@Nullable
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks)
    {
        return null;
    }
	
	@SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float colour1, float colour2)
    {
        int i = 10518688;
        float f = MathHelper.cos(colour1 * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        float f1 = 0.627451F;
        float f2 = 0.5019608F;
        float f3 = 0.627451F;
        f1 = f1 * (f * 0.0F + 0.15F);
        f2 = f2 * (f * 0.0F + 0.15F);
        f3 = f3 * (f * 0.0F + 0.15F);
        return new Vec3d((double)f1, (double)f2, (double)f3);
    }

    @SideOnly(Side.CLIENT)
    public boolean isSkyColored()
    {
        return false;
    }
    
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return this.world.getGroundAboveSeaLevel(new BlockPos(x, 0, z)).getMaterial().blocksMovement();
    }

    public BlockPos getSpawnCoordinate()
    {
        return new BlockPos(0, 50, 0);
    }

    public int getAverageGroundLevel()
    {
        return 50;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z)
    {
        return false;
    }
	
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}
}
