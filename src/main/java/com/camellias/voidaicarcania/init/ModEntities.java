package com.camellias.voidaicarcania.init;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.common.entities.EntityVoidConstruct;
import com.camellias.voidaicarcania.common.entities.EntityVoidDaemon;
import com.camellias.voidaicarcania.common.entities.EntityVoidEye;
import com.camellias.voidaicarcania.common.entities.EntityVoidHeartBoss;
import com.camellias.voidaicarcania.common.entities.EntityVoidHeartPassive;
import com.camellias.voidaicarcania.common.entities.EntityVoidWraith;
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
		registerEntity("void_daemon", EntityVoidDaemon.class, ConfigHandler.ENTITY_VOID_DAEMON, 100, 12, 3289650);
		registerEntityNoEgg("heart_passive", EntityVoidHeartPassive.class, ConfigHandler.ENTITY_HEART_PASSIVE, 50);
		registerEntityNoEgg("void_eye", EntityVoidEye.class, ConfigHandler.ENTITY_VOID_EYE, 50);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int colour1, int colour2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), 
				entity, name, id, Main.instance, range, 1, true, colour1, colour2);
	}
	
	private static void registerEntityNoEgg(String name, Class<? extends Entity> entity, int id, int range)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), 
				entity, name, id, Main.instance, range, 1, true);
	}
}