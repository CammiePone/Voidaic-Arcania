package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.client.renderer.tileentity.TileWhitewoodPedestalRenderer;
import com.camellias.voidaicarcania.common.tileentities.altar.TileWhitewoodPedestal;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SyncTileToClientMessage implements IMessage
{
	public ItemStack stack;
	
	public SyncTileToClientMessage()
	{
		
	}
	
	public SyncTileToClientMessage(ItemStack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		stack = ByteBufUtils.readItemStack(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeItemStack(buf, stack);
	}
	
//-------------------------------------------------------------------------------------------------------------------------//
	
	public static class PacketHandler implements IMessageHandler<SyncTileToClientMessage, IMessage>
	{
		@Override
		public IMessage onMessage(SyncTileToClientMessage message, MessageContext ctx)
		{
			Main.proxy.getThreadListener(ctx).addScheduledTask(() ->
			{
				System.out.println(message.stack);
				TileWhitewoodPedestalRenderer.render.setSyncedItemStack(message.stack);
			});
			
			return null;
		}
	}
}
