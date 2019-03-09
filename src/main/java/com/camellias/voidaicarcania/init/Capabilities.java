package com.camellias.voidaicarcania.init;

import java.util.concurrent.Callable;

import com.camellias.voidaicarcania.api.capabilities.Corruption.CorruptionStorage;
import com.camellias.voidaicarcania.api.capabilities.Corruption.DefaultCorruptionCapability;
import com.camellias.voidaicarcania.api.capabilities.Corruption.ICorruption;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.DefaultEssenceCapability;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceStorage;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.IEssence;
import com.camellias.voidaicarcania.api.capabilities.Infused.DefaultInfusedCapability;
import com.camellias.voidaicarcania.api.capabilities.Infused.IInfused;
import com.camellias.voidaicarcania.api.capabilities.Infused.InfusedStorage;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class Capabilities {

	public static void init()
	{
		CapabilityManager.INSTANCE.register(IEssence.class, new EssenceStorage(), new ItemCapabilityFactory());
		CapabilityManager.INSTANCE.register(IInfused.class, new InfusedStorage(), new InfusedCapabilityFactory());
		CapabilityManager.INSTANCE.register(ICorruption.class, new CorruptionStorage(), new CorruptionCapabilityFactory());
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

	private static class CorruptionCapabilityFactory implements Callable<ICorruption>
	{
		@Override
		public ICorruption call() throws Exception
		{
			return new DefaultCorruptionCapability();
		}
	}
}
