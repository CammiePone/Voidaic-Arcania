package com.camellias.voidaicarcania.core.init;

import java.util.ArrayList;
import java.util.List;

import com.camellias.voidaicarcania.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class ModEntities
{
	public static final List<EntityEntry> REGISTRY = new ArrayList<>();
	private static int entity_id = 0;
	
	private static final EntityEntry createEntityEntry(Class<? extends Entity> clazz, String name)
	{
		EntityEntry entry = EntityEntryBuilder.create().entity(clazz).id(new ResourceLocation(Reference.MODID, name), 
				entity_id++).name(name).tracker(64, 1, true).build();
		REGISTRY.add(entry);
		
		return entry;
	}
}
