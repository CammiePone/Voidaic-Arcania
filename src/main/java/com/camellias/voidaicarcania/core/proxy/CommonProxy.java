package com.camellias.voidaicarcania.core.proxy;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy 
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		
	}
	
	public World getClientWorld()
	{
		return null;
	}
	
	public EntityPlayer getPlayer(final MessageContext context)
	{
		if(context.side.isServer())
		{
			return context.getServerHandler().player;
		} 
		else
		{
			throw new WrongSideException("Tried to get the player from a client-side MessageContext on the dedicated server");
		}
	}
	
	public IThreadListener getThreadListener(final MessageContext context)
	{
		if(context.side.isServer())
		{
			return context.getServerHandler().player.server;
		}
		else
		{
			throw new WrongSideException("Tried to get the IThreadListener from a client-side MessageContext on the dedicated server");
		}
	}
	
	public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule)
	{
		throw new IllegalStateException("This should only be called from client side");
	}
	
	class WrongSideException extends RuntimeException
	{
		public WrongSideException(final String message)
		{
			super(message);
		}

		public WrongSideException(final String message, final Throwable cause)
		{
			super(message, cause);
		}
	}
}
