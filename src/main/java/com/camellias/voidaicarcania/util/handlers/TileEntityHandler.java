package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.blocks.blockaltar.TileEntityAltar;
import com.camellias.voidaicarcania.blocks.blockbotanyaltar.TileEntityBotanyAltar;
import com.camellias.voidaicarcania.blocks.blockmortalcentrifuge.TileEntityMortalCentrifuge;

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
