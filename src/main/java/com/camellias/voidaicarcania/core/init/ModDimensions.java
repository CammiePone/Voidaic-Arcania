package com.camellias.voidaicarcania.core.init;

import com.camellias.voidaicarcania.common.world.dimensions.DimensionVoid;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions
{
	public static final DimensionType VOID = DimensionType.register("Void", "_void", 100, DimensionVoid.class, false);
	
	public static void registerDimension()
	{
		DimensionManager.registerDimension(-64, VOID);
	}
}
