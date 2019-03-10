package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.client.renderer.tileentity.TileEntityRiftRender;
import com.camellias.voidaicarcania.common.tileentities.TileEntityRift;

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
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRift.class, new TileEntityRiftRender());
	}
}
