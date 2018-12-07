package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.common.blocks.machines.blockaltar.TileEntityAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockbotanyaltar.TileEntityBotanyAltar;
import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.TileEntityMortalCentrifuge;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityAltar.class, "altar");
		GameRegistry.registerTileEntity(TileEntityBotanyAltar.class, "botanical_altar");
		GameRegistry.registerTileEntity(TileEntityMortalCentrifuge.class, "mortal_centrifuge");
	}
}
