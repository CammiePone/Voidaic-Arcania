package com.camellias.voidaicarcania.util.handlers;

import com.camellias.voidaicarcania.entities.EntityVoidConstruct;
import com.camellias.voidaicarcania.entities.EntityVoidHeartBoss;
import com.camellias.voidaicarcania.entities.EntityVoidHeartPassive;
import com.camellias.voidaicarcania.entities.EntityVoidWraith;
import com.camellias.voidaicarcania.entities.render.RenderVoidConstruct;
import com.camellias.voidaicarcania.entities.render.RenderVoidHeartBoss;
import com.camellias.voidaicarcania.entities.render.RenderVoidHeartPassive;
import com.camellias.voidaicarcania.entities.render.RenderVoidWraith;

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
	}
}
