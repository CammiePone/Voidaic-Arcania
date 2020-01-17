package com.camellias.voidaicarcania.core.init;

import java.util.concurrent.Callable;

import com.camellias.voidaicarcania.api.capabilities.corruption.chunk.ChunkCorruptionStorage;
import com.camellias.voidaicarcania.api.capabilities.corruption.chunk.DefaultChunkCorruptionCapability;
import com.camellias.voidaicarcania.api.capabilities.corruption.chunk.IChunkCorruption;
import com.camellias.voidaicarcania.api.capabilities.essence.DefaultEssenceCapability;
import com.camellias.voidaicarcania.api.capabilities.essence.EssenceStorage;
import com.camellias.voidaicarcania.api.capabilities.essence.IEssence;
import com.camellias.voidaicarcania.api.capabilities.infused.DefaultInfusedCapability;
import com.camellias.voidaicarcania.api.capabilities.infused.IInfused;
import com.camellias.voidaicarcania.api.capabilities.infused.InfusedStorage;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModCapabilities
{
	public static void init()
	{
		CapabilityManager.INSTANCE.register(IEssence.class, new EssenceStorage(), new ItemCapabilityFactory());
		CapabilityManager.INSTANCE.register(IInfused.class, new InfusedStorage(), new InfusedCapabilityFactory());
		CapabilityManager.INSTANCE.register(IChunkCorruption.class, new ChunkCorruptionStorage(), new CorruptionCapabilityFactory());
	}

	private static class ItemCapabilityFactory implements Callable<IEssence>
	{
		@Override
		public IEssence call() throws Exception
		{
			return new DefaultEssenceCapability();
		}
	}

	private static class InfusedCapabilityFactory implements Callable<IInfused>
	{
		@Override
		public IInfused call() throws Exception
		{
			return new DefaultInfusedCapability();
		}
	}
	
	private static class CorruptionCapabilityFactory implements Callable<IChunkCorruption>
	{
		@Override
		public IChunkCorruption call() throws Exception
		{
			return new DefaultChunkCorruptionCapability();
		}
	}
}
