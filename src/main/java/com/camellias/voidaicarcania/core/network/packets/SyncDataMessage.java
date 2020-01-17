package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.api.capabilities.corruption.chunk.ChunkCorruptionProvider;
import com.camellias.voidaicarcania.api.capabilities.essence.EssenceProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SyncDataMessage implements IMessage
{
	public NBTTagCompound chunkEssence;
	public NBTTagCompound chunkCorruption;
	
	public SyncDataMessage()
	{
	}
	
	public SyncDataMessage(NBTTagCompound chunkEssence, NBTTagCompound chunkCorruption)
	{
		this.chunkEssence = chunkEssence;
		this.chunkCorruption = chunkCorruption;
	}
	
	@Override
	public void fromBytes(ByteBuf byteBuf)
	{
		chunkEssence = ByteBufUtils.readTag(byteBuf);
		chunkCorruption = ByteBufUtils.readTag(byteBuf);
	}
	
	@Override
	public void toBytes(ByteBuf byteBuf)
	{
		ByteBufUtils.writeTag(byteBuf, chunkEssence);
		ByteBufUtils.writeTag(byteBuf, chunkCorruption);
	}
	
//-------------------------------------------------------------------------------------------------------------------------//
	
	public static class PacketHandler implements IMessageHandler<SyncDataMessage, IMessage>
	{
		@Override
		public IMessage onMessage(SyncDataMessage message, MessageContext ctx)
		{
			if(ctx.side.isClient())
			{
				Minecraft.getMinecraft().addScheduledTask(() ->
				{
					EntityPlayerSP player = Minecraft.getMinecraft().player;
					Chunk chunk = player.world.getChunk(player.getPosition());
					
					chunk.getCapability(EssenceProvider.essenceCapability, null).loadNBT(message.chunkEssence);
					chunk.getCapability(ChunkCorruptionProvider.corruptionCapability, null).loadNBT(message.chunkCorruption);
				});
			}
			
			return null;
		}
	}
}
