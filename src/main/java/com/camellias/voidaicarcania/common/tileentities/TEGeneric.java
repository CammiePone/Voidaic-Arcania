package com.camellias.voidaicarcania.common.tileentities;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.network.packets.TileToClientMessage;
import com.camellias.voidaicarcania.core.network.packets.TileToServerMessage;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class TEGeneric extends TileEntity
{
	public final void sendMessageToClient(NBTTagCompound nbt, @Nullable EntityPlayerMP player)
	{
		if(player == null)
		{
			if(getWorld() != null)
			{
				NetworkHandler.INSTANCE.sendToAllAround(new TileToClientMessage(getPos(), nbt), new NetworkRegistry.TargetPoint(
						getWorld().provider.getDimension(), pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 128.0D));
			}
		}
		else
		{
			NetworkHandler.INSTANCE.sendTo(new TileToClientMessage(getPos(), nbt), player);
		}
	}
	
	public final void sendMessageToServer(NBTTagCompound nbt)
	{
		NetworkHandler.INSTANCE.sendToServer(new TileToServerMessage(getPos(), nbt));
	}
	
	public void messageFromServer(NBTTagCompound nbt)
	{
		
	}
	
	public void messageFromClient(NBTTagCompound nbt, EntityPlayerMP player)
	{
		
	}
	
	private NBTTagCompound setupNbt()
	{
		NBTTagCompound nbt = super.writeToNBT(new NBTTagCompound());
	    nbt.removeTag("ForgeData");
	    nbt.removeTag("ForgeCaps");
	    return nbt;
	}
	
	public void readSyncNBT(NBTTagCompound nbt)
	{
		
	}
	
	public NBTTagCompound writeSyncNBT(NBTTagCompound nbt)
	{
		return nbt;
	}
	
	public void syncTile(boolean rerender)
	{
		IBlockState state = world.getBlockState(pos);
		world.notifyBlockUpdate(pos, state, state, 2 + (rerender ? 4 : 0));
	}
	
	public EnumFacing getFacing()
	{
		try
		{
			return EnumFacing.byIndex(getBlockMetadata() & 0x7);
		}
		catch (Exception localException)
		{
			
		}
		
		return EnumFacing.UP;
	}
	
	public boolean gettingPower()
	{
		return world.isBlockPowered(getPos());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		readSyncNBT(nbt);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		return writeSyncNBT(super.writeToNBT(nbt));
	}
	
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		return new SPacketUpdateTileEntity(pos, -9, getUpdateTag());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		readSyncNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
		return writeSyncNBT(setupNbt());
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
	{
		return oldState.getBlock() != newState.getBlock();
	}
}
