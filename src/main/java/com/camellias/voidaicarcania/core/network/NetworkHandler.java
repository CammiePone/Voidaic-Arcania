package com.camellias.voidaicarcania.core.network;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.core.network.packets.HoldSpacebarMessage;

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
		INSTANCE.registerMessage(HoldSpacebarMessage.HoldSpacebarPacketHandler.class, HoldSpacebarMessage.class, next(), Side.SERVER);
		INSTANCE.registerMessage(HoldSpacebarMessage.HoldSpacebarPacketHandler.class, HoldSpacebarMessage.class, next(), Side.CLIENT);
	}
}
