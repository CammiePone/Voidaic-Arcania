package com.camellias.voidaicarcania.blocks.beacons.healbeacon;

import java.util.Random;

import com.camellias.voidaicarcania.blocks.beacons.BlockBeaconBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHealBeacon extends BlockBeaconBase
{
	public BlockHealBeacon(String name, Material material)
	{
		super(name, material);
	}
	
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
	{
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityHealBeacon();
	}
}
