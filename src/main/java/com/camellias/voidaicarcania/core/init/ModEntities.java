package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.common.entities.mobs.EntityBitingBelladonna;
import com.camellias.voidaicarcania.common.entities.mobs.EntityKharonite;
import com.camellias.voidaicarcania.common.entities.mobs.EntityVoidWraith;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModEntities
{
	public static final List<EntityEntry> REGISTRY = new ArrayList<>();
	public static final List<String> VOID_BIOME = new ArrayList<>();
	private static int entity_id = 0;
	
	private static final EntityEntry VOID_WRAITH = createEntityEntry(EntityVoidWraith.class, "void_wraith", 
			0x4e2760, 0x0b070e, EnumCreatureType.MONSTER, 6, 1, 4, VOID_BIOME);
	private static final EntityEntry KHARONITE = createEntityEntry(EntityKharonite.class, "kharonite", 
			0x593f4d, 0x341e3f, EnumCreatureType.AMBIENT, 3, 1, 6, VOID_BIOME);
	private static final EntityEntry BITING_BELLADONNA = createEntityEntry(EntityBitingBelladonna.class, "biting_belladonna",
			0x8426a3, 0x402d3c, EnumCreatureType.MONSTER, 6, 1, 3, VOID_BIOME);
	
	
	
//---------------------------------------------------------------------------------------------------------------------------------------//
	
	
	
	private static final EntityEntry createEntityEntry(Class<? extends Entity> clazz, String name)
	{
		EntityEntry entry = EntityEntryBuilder.create().entity(clazz).id(new ResourceLocation(Reference.MODID, name), 
				entity_id++).name(name).tracker(64, 1, true).build();
		REGISTRY.add(entry);
		
		return entry;
	}
	
	private static EntityEntry createEntityEntry(Class<? extends Entity> clazz, String name, int solidColor, int spotColor, 
			EnumCreatureType type, int weight, int min, int max, List<String> types)
	{
		Set<Biome> biomes = new HashSet<>();
		
		for(String typeName : types)
		{
			biomes.addAll(BiomeDictionary.getBiomes(Type.getType(typeName)));
		}
		
		EntityEntry entry = EntityEntryBuilder.create().entity(clazz).id(new ResourceLocation(Reference.MODID, name), 
				entity_id++).name(Reference.MODID + "." + name).tracker(64, 1, true).egg(solidColor, spotColor).
				spawn(type, weight, min, max, biomes).build();
		
		ForgeRegistries.ENTITIES.register(entry);
		
		return entry;
	}
}
