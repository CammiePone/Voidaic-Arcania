package com.camellias.voidaicarcania.common.tileentities.altar;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.core.init.ModBlocks;

import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileVoidaicAltar extends TileEntity implements ITickable
{
	public static final int SLOTS = 4;
	public int voidEssence;
	public int maxEssence = 5000;
	private boolean isCasting = false;
	private boolean isInputEssence = false;
	private boolean isCraftingItem = false;
	private boolean isCraftingSpell = false;
	
	private BlockPattern pattern = FactoryBlockPattern.start().aisle(
			"0003000", "0302030", "0022200", "3221223", "0022200", "0302030", "0003000")
			.where('1', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.ALTAR)))
			.where('2', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.CATALYST)))
			.where('3', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.PEDESTAL)))
			.where('0', BlockWorldState.hasState(BlockStateMatcher.ANY)).build();
	
	public ItemStackHandler handler = new ItemStackHandler(SLOTS)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			TileVoidaicAltar.this.markDirty();
		}
	};
	
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		BlockPos pos1 = getPos();
		return new SPacketUpdateTileEntity(pos1, 0, getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
		NBTTagCompound nbt = super.getUpdateTag();
		writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public void onDataPacket(NetworkManager manager, SPacketUpdateTileEntity packet)
	{
		NBTTagCompound tag = packet.getNbtCompound();
		readFromNBT(tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		if(nbt.hasKey("items"))
		{
			handler.deserializeNBT((NBTTagCompound) nbt.getTag("items"));
		}
		
		if(nbt.hasKey("isCasting"))
		{
			isCasting = nbt.getBoolean("isCasting");
		}
		
		if(nbt.hasKey("voidEssence"))
		{
			voidEssence = nbt.getInteger("voidEssence");
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setTag("items", handler.serializeNBT());
		nbt.setBoolean("isCasting", isCasting);
		nbt.setInteger("voidEssence", voidEssence);
		
		return nbt;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return true;
		}
		
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(handler);
		}
		
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void update()
	{
		if(isCasting)
		{
			if(!isValidStructure()) stopCasting();
		}
	}
	
	public boolean isValidStructure()
	{
		return pattern.match(world, pos) != null;
	}
	
	public void startCasting(EntityPlayer player)
	{
		if(!world.isRemote && isValidStructure())
		{
			if(getEssenceFromPedestals() <= 0)
			{
				isCasting = true;
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence >= (voidEssence + getEssenceFromPedestals()))
			{
				isCasting = true;
				isInputEssence = true;
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence < (voidEssence + getEssenceFromPedestals()) && maxEssence > voidEssence)
			{
				player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.notenoughspace").getUnformattedText()));
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence < (voidEssence + getEssenceFromPedestals()) && maxEssence == voidEssence)
			{
				player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.isfull").getUnformattedText()));
			}
		}
	}
	
	public void stopCasting()
	{
		if(!world.isRemote)
		{
			Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
			
			for(MutableBlockPos allBlockPos : blocksWithin)
			{
				if(world.getTileEntity(allBlockPos) instanceof TileWhitewoodPedestal)
				{
					TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(allBlockPos);
					IBlockState state = world.getBlockState(allBlockPos);
					ItemStack stack = pedestal.handler.getStackInSlot(0);
					
					if(stack.hasCapability(EssenceProvider.essenceCapability, null))
					{
						if(isInputEssence)
						{
							voidEssence += getEssenceFromPedestals();
							isCasting = false;
							isInputEssence = false;
						}
						if(isCraftingItem)
						{
							isCasting = false;
							isCraftingItem = false;
						}
						if(isCraftingSpell)
						{
							isCasting = false;
							isCraftingSpell = false;
						}
						
						stack.shrink(1);
						world.notifyBlockUpdate(allBlockPos, state, state, 2);
					}
				}
			}
			
			world.setBlockToAir(pos.north(2));
			world.setBlockToAir(pos.north().west());
			world.setBlockToAir(pos.north());
			world.setBlockToAir(pos.north().east());
			world.setBlockToAir(pos.west(2));
			world.setBlockToAir(pos.west());
			world.setBlockToAir(pos.east());
			world.setBlockToAir(pos.east(2));
			world.setBlockToAir(pos.south().west());
			world.setBlockToAir(pos.south());
			world.setBlockToAir(pos.south().east());
			world.setBlockToAir(pos.south(2));
		}
	}
	
	public boolean isCasting()
	{
		return isCasting;
	}
	
	public int getEssenceFromPedestals()
	{
		Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
		int essence = 0;
		
		for(MutableBlockPos allBlockPos : blocksWithin)
		{
			if(world.getTileEntity(allBlockPos) instanceof TileWhitewoodPedestal)
			{
				TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(allBlockPos);
				ItemStack stack = pedestal.handler.getStackInSlot(0);
				
				if(stack.hasCapability(EssenceProvider.essenceCapability, null))
				{
					essence += stack.getCapability(EssenceProvider.essenceCapability, null).getEssence();
				}
			}
		}
		
		return essence;
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return !isInvalid() && player.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}
}