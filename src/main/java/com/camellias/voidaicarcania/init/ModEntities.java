package com.camellias.voidaicarcania.init;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.entities.EntityVoidConstruct;
import com.camellias.voidaicarcania.entities.EntityVoidHeartBoss;
import com.camellias.voidaicarcania.entities.EntityVoidHeartPassive;
import com.camellias.voidaicarcania.entities.EntityVoidWraith;
import com.camellias.voidaicarcania.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities 
{
	public static void registerEntities()
	{
		registerEntity("void_wraith", EntityVoidWraith.class, ConfigHandler.ENTITY_VOID_WRAITH, 100, 12, 3289650);
		registerEntity("void_construct", EntityVoidConstruct.class, ConfigHandler.ENTITY_VOID_CONSTRUCT, 50, 12, 3289650);
		registerEntity("heart_boss", EntityVoidHeartBoss.class, ConfigHandler.ENTITY_HEART_BOSS, 50, 12, 3289650);
		registerEntity("heart_passive", EntityVoidHeartPassive.class, ConfigHandler.ENTITY_HEART_PASSIVE, 50, 12, 3289650);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int colour1, int colour2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), 
				entity, name, id, Main.instance, range, 1, true, colour1, colour2);
	}
}
