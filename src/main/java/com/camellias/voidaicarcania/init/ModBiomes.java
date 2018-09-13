package com.camellias.voidaicarcania.init;

import com.camellias.voidaicarcania.util.handlers.ConfigHandler;
import com.camellias.voidaicarcania.world.biomes.BiomeAncientMountain;
import com.camellias.voidaicarcania.world.biomes.BiomeVoid;

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
	public static final Biome ANCIENT_MOUNTAIN = new BiomeAncientMountain();
	
	public static void registerBiomes()
	{
		initBiome(VOID, "void", BiomeType.ICY, Type.VOID, Type.MAGICAL);
		initBiome(ANCIENT_MOUNTAIN, "AncientMountain", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... type)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Voidaic Biomes Registered");
		BiomeDictionary.addTypes(biome, type);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 0));
		BiomeManager.addSpawnBiome(biome);
		
		/*if(ConfigHandler.spawnVoidBiomeOverworld)
		{
			BiomeManager.addSpawnBiome(biome);
		}*/
		
		return biome;
	}
}
