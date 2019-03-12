package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.client.renderer.hud.OverlayRenderer;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OverlayMessage implements IMessage
{
	private int chunkEssence;
	private int chunkCorruption;
	private int playerCorruption;
	
	public OverlayMessage() {}
	
	public OverlayMessage(int chunkEssence, int chunkCorruption, int playerCorruption)
	{
		this.chunkEssence = chunkEssence;
		this.chunkCorruption = chunkCorruption;
		this.playerCorruption = playerCorruption;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.chunkEssence = buf.readInt();
		this.chunkCorruption = buf.readInt();
		this.playerCorruption = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(chunkEssence);
		buf.writeInt(chunkCorruption);
		buf.writeInt(playerCorruption);
	}
	
//-------------------------------------------------------------------------------------------------------------------------//
	
	public static class OverlayPacketHandler implements IMessageHandler<OverlayMessage, IMessage>
	{
		@Override
		public IMessage onMessage(OverlayMessage message, MessageContext ctx)
		{
			Main.proxy.getThreadListener(ctx).addScheduledTask(() ->
			{
				OverlayRenderer.instance.setEssenceCorruption(message.chunkEssence, message.chunkCorruption, message.playerCorruption);
			});
			return null;
		}
	}
}
