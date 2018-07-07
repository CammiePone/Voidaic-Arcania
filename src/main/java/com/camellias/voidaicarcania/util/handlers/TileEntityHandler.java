package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.blocks.blockaltar.TileEntityAltar;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityAltar.class, "altar");
	}
}
