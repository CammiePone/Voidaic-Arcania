package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.renderer.tileentity.TileRiftRenderer;
import com.camellias.voidaicarcania.client.renderer.tileentity.TileWhitewoodPedestalRenderer;
import com.camellias.voidaicarcania.common.tileentities.altar.TileWhitewoodPedestal;
import com.camellias.voidaicarcania.common.tileentities.misc.TileRift;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class RenderHandler
{
	@SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileRift.class, new TileRiftRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileWhitewoodPedestal.class, new TileWhitewoodPedestalRenderer());
	}
}
