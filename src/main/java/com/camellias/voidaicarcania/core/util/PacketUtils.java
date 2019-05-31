package com.camellias.voidaicarcania.core.util;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;

public class PacketUtils
{
	public static void writeNBTTagCompoundToBuffer(ByteBuf bb, NBTTagCompound nbt)
	{
		if (nbt == null)
		{
			bb.writeByte(0);
		}
		else
		{
			try
			{
				CompressedStreamTools.write(nbt, new ByteBufOutputStream(bb));
			}
			catch (IOException ioexception)
			{
				throw new io.netty.handler.codec.EncoderException(ioexception);
			}
		}
	}
	
	public static NBTTagCompound readNBTTagCompoundFromBuffer(ByteBuf bb)
	{
		int i = bb.readerIndex();
		byte b0 = bb.readByte();
		
		if (b0 == 0)
		{
			return null;
		}
		
		bb.readerIndex(i);
		try
		{
			return CompressedStreamTools.read(new ByteBufInputStream(bb), new NBTSizeTracker(2097152L));
		}
		catch (IOException localIOException)
		{
			
		}
	    
		return null;
	}
}
