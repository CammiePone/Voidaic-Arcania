package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.common.tileentities.altar.TileVoidaicAltar;
import com.camellias.voidaicarcania.common.tileentities.altar.TileWhitewoodPedestal;
import com.camellias.voidaicarcania.common.tileentities.misc.TileRift;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileRift.class, new ResourceLocation(Reference.MODID + ":void_rift"));
		GameRegistry.registerTileEntity(TileVoidaicAltar.class, new ResourceLocation(Reference.MODID + ":voidaic_altar"));
		GameRegistry.registerTileEntity(TileWhitewoodPedestal.class, new ResourceLocation(Reference.MODID + ":whitewood_pedestal"));
	}
}
