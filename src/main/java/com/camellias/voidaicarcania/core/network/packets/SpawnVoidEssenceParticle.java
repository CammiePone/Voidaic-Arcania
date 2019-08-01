package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.client.particles.VoidEssenceParticle;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

@SuppressWarnings({"unused", "WeakerAccess"})
public class SpawnVoidEssenceParticle implements IMessage {
	public double x, y, z, motionX, motionY, motionZ;
	
	public SpawnVoidEssenceParticle() {
	}
	
	public SpawnVoidEssenceParticle(double x, double y, double z, double motionX, double motionY, double motionZ) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
	}
	
	public SpawnVoidEssenceParticle(double x, double y, double z) {
		this(x, y, z, 0, 0, 0);
	}
	
	public SpawnVoidEssenceParticle(BlockPos pos, double colorX, double colorY, double colorZ) {
		this(pos.getX(), pos.getY(), pos.getZ(), colorX, colorY, colorZ);
	}
	
	public SpawnVoidEssenceParticle(BlockPos pos) {
		this(pos, 0, 0, 0);
	}
	
	@Override
	public void fromBytes(ByteBuf byteBuf) {
		x = byteBuf.readDouble();
		y = byteBuf.readDouble();
		z = byteBuf.readDouble();
		motionX = byteBuf.readDouble();
		motionY = byteBuf.readDouble();
		motionZ = byteBuf.readDouble();
	}
	
	@Override
	public void toBytes(ByteBuf byteBuf) {
		byteBuf.writeDouble(x);
		byteBuf.writeDouble(y);
		byteBuf.writeDouble(z);
		byteBuf.writeDouble(motionX);
		byteBuf.writeDouble(motionY);
		byteBuf.writeDouble(motionZ);
	}
	
	public static class Handler implements IMessageHandler<SpawnVoidEssenceParticle, IMessage> {
		@Override
		public IMessage onMessage(SpawnVoidEssenceParticle message, MessageContext ctx) {
			if (ctx.side.isClient())
				Minecraft.getMinecraft().addScheduledTask(() -> Minecraft.getMinecraft().effectRenderer.addEffect(new VoidEssenceParticle(Minecraft.getMinecraft().player.world, message.x, message.y, message.z, message.motionX, message.motionY, message.motionZ)));
			return null;
		}
	}
}