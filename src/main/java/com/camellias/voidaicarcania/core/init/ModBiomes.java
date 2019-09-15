package com.camellias.voidaicarcania.core.init;

import com.camellias.voidaicarcania.common.world.biomes.BiomeFungalPatch;
import com.camellias.voidaicarcania.common.world.biomes.BiomeVoid;
import com.camellias.voidaicarcania.common.world.features.HangingLanternFeature;
import com.camellias.voidaicarcania.common.world.features.VoidFungalFeature;
import com.camellias.voidaicarcania.common.world.features.WhitewoodTreeFeature;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes
{
	public static final Biome VOID = new BiomeVoid();
	public static final Biome FUNGAL_PATCH = new BiomeFungalPatch();
	
	public static void registerBiome()
	{
		initBiome(VOID, "The Void", BiomeType.COOL, Type.DEAD, Type.DRY, Type.MAGICAL, Type.SPOOKY, Type.WASTELAND);
		initBiome(FUNGAL_PATCH, "Fungal Undergrowth", BiomeType.WARM, Type.LUSH, Type.WET, Type.MAGICAL, Type.SPOOKY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		return biome;
	}
	
	public static abstract class Features
	{
		public static final WhitewoodTreeFeature WHITEWOOD_TREE = new WhitewoodTreeFeature(false);
		public static final VoidFungalFeature FUNGAL_FEATURE = new VoidFungalFeature(false);
		public static final HangingLanternFeature HANGING_LANTERN = new HangingLanternFeature(false);
	}
}
