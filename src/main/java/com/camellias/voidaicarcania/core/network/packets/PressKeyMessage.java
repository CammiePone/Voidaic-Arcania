package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.Main;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PressKeyMessage implements IMessage
{
	public PressKeyMessage()
	{
		
	}
	
	public int playerID;
	
	public PressKeyMessage(EntityPlayer player)
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
	
	public static class PacketHandler implements IMessageHandler<PressKeyMessage, IMessage>
	{
		@Override
		public IMessage onMessage(PressKeyMessage message, MessageContext ctx)
		{
			Main.proxy.getThreadListener(ctx).addScheduledTask(() ->
			{
				if(Main.proxy.getPlayer(ctx) != null)
				{
					EntityPlayer player = (EntityPlayer) Main.proxy.getPlayer(ctx).world.getEntityByID(message.playerID);
					Vec3d look = player.getLookVec();
					float front = player.moveForward, strafe = player.moveStrafing;
					
					if(front >= 0)
					{
						Vec3d horAxis = look.crossProduct(new Vec3d(0, 1, 0)).normalize().scale(-strafe / 10);
						
						player.motionX += (front * (horAxis.x + look.x)) / 80;
						player.motionY += (front * (horAxis.y + look.y)) / 80;
						player.motionZ += (front * (horAxis.z + look.z)) / 80;

						if(((player.motionX * player.motionX) + (player.motionY * player.motionY) + (player.motionZ * player.motionZ)) > 1)
						{
							Vec3d limit = new Vec3d(player.motionX, player.motionY, player.motionZ).normalize().scale(2);
							
							player.motionX = limit.x;
							player.motionY = limit.y;
							player.motionZ = limit.z;
						}
					}
					else
					{
						player.motionX /= 1.1;
						player.motionY /= 1.1;
						player.motionZ /= 1.1;
					}
				}
			});
			
			return null;
		}
	}
}
