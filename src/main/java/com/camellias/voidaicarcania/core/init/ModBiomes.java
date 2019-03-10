package com.camellias.voidaicarcania.core.init;

import com.camellias.voidaicarcania.common.world.biomes.BiomeVoid;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes
{
	public static final Biome VOID = new BiomeVoid();
	
	public static void registerBiome()
	{
		initBiome(VOID, "The Void", BiomeType.COOL, Type.DEAD, Type.DRY, Type.MAGICAL, Type.SPOOKY, Type.WASTELAND);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		return biome;
	}
}
