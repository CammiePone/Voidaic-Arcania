package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.client.render.RenderVoidConstruct;
import com.camellias.voidaicarcania.client.render.RenderVoidDaemon;
import com.camellias.voidaicarcania.client.render.RenderVoidEye;
import com.camellias.voidaicarcania.client.render.RenderVoidHeartBoss;
import com.camellias.voidaicarcania.client.render.RenderVoidHeartPassive;
import com.camellias.voidaicarcania.client.render.RenderVoidWraith;
import com.camellias.voidaicarcania.common.entities.EntityVoidConstruct;
import com.camellias.voidaicarcania.common.entities.EntityVoidDaemon;
import com.camellias.voidaicarcania.common.entities.EntityVoidEye;
import com.camellias.voidaicarcania.common.entities.EntityVoidHeartBoss;
import com.camellias.voidaicarcania.common.entities.EntityVoidHeartPassive;
import com.camellias.voidaicarcania.common.entities.EntityVoidWraith;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidWraith.class, new IRenderFactory<EntityVoidWraith>()
		{
			@Override
			public Render<? super EntityVoidWraith> createRenderFor(RenderManager manager) 
			{
				return new RenderVoidWraith(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidConstruct.class, new IRenderFactory<EntityVoidConstruct>()
		{
			@Override
			public Render<? super EntityVoidConstruct> createRenderFor(RenderManager manager) 
			{
				return new RenderVoidConstruct(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidHeartBoss.class, new IRenderFactory<EntityVoidHeartBoss>()
		{
			@Override
			public Render<? super EntityVoidHeartBoss> createRenderFor(RenderManager manager) 
			{
				return new RenderVoidHeartBoss(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidHeartPassive.class, new IRenderFactory<EntityVoidHeartPassive>()
		{
			@Override
			public Render<? super EntityVoidHeartPassive> createRenderFor(RenderManager manager) 
			{
				return new RenderVoidHeartPassive(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidEye.class, new IRenderFactory<EntityVoidEye>()
		{
			@Override
			public Render<? super EntityVoidEye> createRenderFor(RenderManager manager) 
			{
				return new RenderVoidEye(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDaemon.class, new IRenderFactory<EntityVoidDaemon>()
		{
			@Override
			public Render<? super EntityVoidDaemon> createRenderFor(RenderManager manager) 
			{
				return new RenderVoidDaemon(manager);
			}
		});
	}
}
