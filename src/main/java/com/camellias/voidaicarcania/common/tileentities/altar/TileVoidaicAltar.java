package com.camellias.voidaicarcania.common.tileentities.altar;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipes;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModItems;

import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
	private int ticks;
	
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
		
		if(nbt.hasKey("isInputEssence"))
		{
			isInputEssence = nbt.getBoolean("isInputEssence");
		}
		
		if(nbt.hasKey("isCraftingItem"))
		{
			isCraftingItem = nbt.getBoolean("isCraftingItem");
		}
		
		if(nbt.hasKey("isCraftingSpell"))
		{
			isCraftingSpell = nbt.getBoolean("isCraftingSpell");
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
		nbt.setBoolean("isInputEssence", isInputEssence);
		nbt.setBoolean("isCraftingItem", isCraftingItem);
		nbt.setBoolean("isCraftingSpell", isCraftingSpell);
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
			
			if(isCraftingItem || isCraftingSpell)
			{
				if(ticks < VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost())
				{
					ticks++;
				}
				else if(ticks >= VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost())
				{
					ticks = 0;
					stopCasting();
				}
			}
			
			if(isInputEssence)
			{
				if(ticks < 200)
				{
					ticks++;
				}
				else if(ticks >= 200)
				{
					ticks = 0;
					stopCasting();
				}
			}
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
			if(getEssenceFromPedestals() <= 0 && getEssenceFromPedestals() >= VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost())
			{
				isCasting = true;
				
				if(handler.getStackInSlot(0).getItem() == ModItems.SPELL_PAPER 
					|| handler.getStackInSlot(1).getItem() == ModItems.SPELL_PAPER 
					|| handler.getStackInSlot(2).getItem() == ModItems.SPELL_PAPER 
					|| handler.getStackInSlot(3).getItem() == ModItems.SPELL_PAPER)
				{
					isCraftingSpell = true;
					isCraftingItem = false;
				}
				else
				{
					isCraftingItem = true;
					isCraftingSpell = false;
				}
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence >= (voidEssence + getEssenceFromPedestals()) && !(isCraftingItem || isCraftingSpell))
			{
				isCasting = true;
				isInputEssence = true;
			}
			else if(getEssenceFromPedestals() <= VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost() && VoidaicAltarRecipes.INSTANCE.getRecipes() != null)
			{
				player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.notenoughessence").getUnformattedText()));
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
							stack.shrink(1);
							isCasting = false;
							isInputEssence = false;
						}
						if(isCraftingItem)
						{
							EntityItem item = new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 1D, pos.getZ() + 0.5D, 
								VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(0), handler.getStackInSlot(1), 
								handler.getStackInSlot(2), handler.getStackInSlot(3), VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost()));
							world.spawnEntity(item);
							
							isCasting = false;
							isCraftingItem = false;
						}
						if(isCraftingSpell)
						{
							isCasting = false;
							isCraftingSpell = false;
						}
						
						world.notifyBlockUpdate(allBlockPos, state, state, 2);
						state = world.getBlockState(pos);
						world.notifyBlockUpdate(pos, state, state, 2);
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
