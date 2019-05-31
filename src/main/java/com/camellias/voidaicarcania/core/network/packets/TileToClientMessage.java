package com.camellias.voidaicarcania.core.network.packets;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.common.tileentities.TEGeneric;
import com.camellias.voidaicarcania.core.util.PacketUtils;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TileToClientMessage implements IMessage, IMessageHandler<TileToClientMessage, IMessage>
{
	private long pos;
	private NBTTagCompound nbt;
	
	public TileToClientMessage() {}
	
	public TileToClientMessage(BlockPos pos, NBTTagCompound nbt)
	{
		this.pos = pos.toLong();
		this.nbt = nbt;
	}
	
	public void toBytes(ByteBuf buffer)
	{
		buffer.writeLong(pos);
		PacketUtils.writeNBTTagCompoundToBuffer(buffer, nbt);
	}
	
	public void fromBytes(ByteBuf buffer)
	{
		pos = buffer.readLong();
		nbt = PacketUtils.readNBTTagCompoundFromBuffer(buffer);
	}
	
	public IMessage onMessage(final TileToClientMessage message, MessageContext ctx)
	{
		Minecraft.getMinecraft().addScheduledTask(new Runnable()
		{
			public void run()
			{
				World world = Main.proxy.getClientWorld();
				BlockPos bp = BlockPos.fromLong(message.pos);
				
				if((world != null) && (bp != null))
				{
					TileEntity te = world.getTileEntity(bp);
					
					if((te != null) && ((te instanceof TEGeneric)))
					{
						((TEGeneric)te).messageFromServer(message.nbt == null ? new NBTTagCompound() : message.nbt);
					}
				}
			}
		});
		
		return null;
	}
}
