package com.camellias.voidaicarcania.core.network;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.core.network.packets.OverlayMessage;
import com.camellias.voidaicarcania.core.network.packets.PressKeyMessage;

import com.camellias.voidaicarcania.core.network.packets.SpawnVoidEssenceParticle;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
	private static int nextId = 0;
	
	public static int next()
	{
		return nextId++;
	}
	
	public static void init()
	{
		INSTANCE.registerMessage(PressKeyMessage.PacketHandler.class, PressKeyMessage.class, next(), Side.SERVER);
		INSTANCE.registerMessage(PressKeyMessage.PacketHandler.class, PressKeyMessage.class, next(), Side.CLIENT);
		
		INSTANCE.registerMessage(OverlayMessage.PacketHandler.class, OverlayMessage.class, next(), Side.CLIENT);
		
		INSTANCE.registerMessage(SpawnVoidEssenceParticle.Handler.class, SpawnVoidEssenceParticle.class, next(), Side.CLIENT);
	}
}
