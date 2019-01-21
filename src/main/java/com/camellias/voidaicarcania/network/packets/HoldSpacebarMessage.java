package com.camellias.voidaicarcania.network.packets;

import com.camellias.voidaicarcania.Main;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class HoldSpacebarMessage implements IMessage
{
	public HoldSpacebarMessage()
	{
		
	}
	
	public int playerID;
	
	public HoldSpacebarMessage(EntityPlayer player)
	{
		this.playerID = player.getEntityId();
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(playerID);
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.playerID = buf.readInt();
	}
	
//-------------------------------------------------------------------------------------------------------------------------//
	
		public static class HoldSpacebarPacketHandler implements IMessageHandler<HoldSpacebarMessage, IMessage>
		{
			@Override
			public IMessage onMessage(HoldSpacebarMessage message, MessageContext ctx)
			{
				Main.proxy.getThreadListener(ctx).addScheduledTask(() ->
				{
					if(Main.proxy.getPlayer(ctx) != null)
					{
						EntityPlayer player = (EntityPlayer) Main.proxy.getPlayer(ctx).world.getEntityByID(message.playerID);
						GameSettings settings = Minecraft.getMinecraft().gameSettings;
						KeyBinding jump = settings.keyBindJump;
						
						//settings.isKeyDown(jump);
						player.motionY = 0.25D;
					}
				});
				
				return null;
			}
		}
}
