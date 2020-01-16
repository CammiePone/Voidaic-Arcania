package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.api.capabilities.Corruption.CorruptionProvider;
import com.camellias.voidaicarcania.api.capabilities.Essence.EssenceProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OverlayMessage implements IMessage
{
	public NBTTagCompound playerCorruption;
	public NBTTagCompound chunkEssence;
	public NBTTagCompound chunkCorruption;
	
	public OverlayMessage()
	{
	}
	
	public OverlayMessage(NBTTagCompound playerCorruption, NBTTagCompound chunkEssence, NBTTagCompound chunkCorruption)
	{
		this.playerCorruption = playerCorruption;
		this.chunkEssence = chunkEssence;
		this.chunkCorruption = chunkCorruption;
	}
	
	@Override
	public void fromBytes(ByteBuf byteBuf)
	{
		playerCorruption = ByteBufUtils.readTag(byteBuf);
		chunkEssence = ByteBufUtils.readTag(byteBuf);
		chunkCorruption = ByteBufUtils.readTag(byteBuf);
	}
	
	@Override
	public void toBytes(ByteBuf byteBuf)
	{
		ByteBufUtils.writeTag(byteBuf, playerCorruption);
		ByteBufUtils.writeTag(byteBuf, chunkEssence);
		ByteBufUtils.writeTag(byteBuf, chunkCorruption);
	}
	
//-------------------------------------------------------------------------------------------------------------------------//
	
	public static class PacketHandler implements IMessageHandler<OverlayMessage, IMessage>
	{
		@Override
		public IMessage onMessage(OverlayMessage message, MessageContext ctx)
		{
			Main.proxy.getThreadListener(ctx).addScheduledTask(() ->
			{
				EntityPlayerSP player = Minecraft.getMinecraft().player;
				Chunk chunk = player.world.getChunk(player.getPosition());
				
				player.getCapability(CorruptionProvider.corruptionCapability, null).loadNBT(message.playerCorruption);
				chunk.getCapability(EssenceProvider.essenceCapability, null).loadNBT(message.chunkEssence);
				chunk.getCapability(CorruptionProvider.corruptionCapability, null).loadNBT(message.chunkCorruption);
			});
			
			return null;
		}
	}
}
