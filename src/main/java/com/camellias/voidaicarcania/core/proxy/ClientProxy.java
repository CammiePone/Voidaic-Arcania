package com.camellias.voidaicarcania.core.proxy;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public EntityPlayer getPlayer(final MessageContext context)
	{
		if(context.side.isClient())
		{
			return Minecraft.getMinecraft().player;
		}
		else
		{
			return context.getServerHandler().player;
		}
	}
	
	@Override
	public IThreadListener getThreadListener(final MessageContext context)
	{
		if(context.side.isClient())
		{
			return Minecraft.getMinecraft();
		}
		else
		{
			return context.getServerHandler().player.server;
		}
	}
	
	@Override
    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule)
	{
        return Minecraft.getMinecraft().addScheduledTask(runnableToSchedule);
	}
}
