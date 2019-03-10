package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.common.tileentities.TileEntityRift;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityRift.class, new ResourceLocation(Reference.MODID + ":void_rift"));
	}
}
