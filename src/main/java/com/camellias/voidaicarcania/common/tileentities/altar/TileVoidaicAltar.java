package com.camellias.voidaicarcania.common.tileentities.altar;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.IEssence;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipeHelper;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileVoidaicAltar extends TileEntity implements ITickable
{
	public static final int SLOTS = 3;
	public int voidEssence;
	public int maxEssence = 5000;
	private boolean isCasting = false;
	private boolean isInputEssence = false;
	private boolean isCraftingItem = false;
	private boolean isCraftingSpell = false;
	private boolean isFillingChunk = false;
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
		if(!world.isRemote)
		{
			if(isFillingChunk)
			{
				Chunk chunk = world.getChunk(pos);
				
				if(chunk.hasCapability(EssenceProvider.essenceCapability, null))
				{
					IEssence cap = chunk.getCapability(EssenceProvider.essenceCapability, null);
					
					if(cap.getEssence() < 1500 && voidEssence > 0)
					{
						voidEssence--;
						cap.setEssence(cap.getEssence() + 1);
					}
					else
					{
						isFillingChunk = false;
					}
				}
			}
			
			if(isCasting)
			{
				if(!isValidStructure()) stopCasting(true);
				
				if(isCraftingItem || isCraftingSpell)
				{
					if(ticks <= voidEssence && ticks > 0)
					{
						ticks--;
						voidEssence--;
					}
					else if(ticks == 0)
					{
						stopCasting(false);
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
						stopCasting(false);
					}
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
		if(!world.isRemote && isValidStructure() && !isCasting)
		{
			VoidaicAltarRecipeHelper activeRecipe = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
			
			if(getEssenceFromPedestals() <= 0 && voidEssence >= VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2)))
			{
				if(activeRecipe != null)
				{
					if(handler.getStackInSlot(0).getItem() == ModItems.SPELL_PAPER)
					{
						isCasting = true;
						isCraftingSpell = true;
						isCraftingItem = false;
						ticks = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
					}
					else
					{
						isCasting = true;
						isCraftingItem = true;
						isCraftingSpell = false;
						ticks = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
					}
				}
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence >= (voidEssence + getEssenceFromPedestals()) && !(isCraftingItem || isCraftingSpell))
			{
				isCasting = true;
				isInputEssence = true;
			}
			else if(getEssenceFromPedestals() <= VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2)) && activeRecipe != null)
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
			
			if(activeRecipe == null && getEssenceFromPedestals() <= 0)
			{
				if(handler.getStackInSlot(0).getCount() > 0
					|| handler.getStackInSlot(1).getCount() > 0
					|| handler.getStackInSlot(2).getCount() > 0)
				{
					player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.unknownrecipe").getUnformattedText()));
				}
				else
				{
					if(voidEssence > 0) isFillingChunk = true;
					else player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.isempty").getUnformattedText()));
				}
			}
		}
	}
	
	public void stopCasting(boolean isForced)
	{
		if(!world.isRemote)
		{
			if(!isForced)
			{
				Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
				
				if(isCasting)
				{
					IBlockState state = world.getBlockState(pos);
					
					if(isCraftingItem)
					{
						EntityItem item = new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 1D, pos.getZ() + 0.5D, 
							VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2)));
						
						world.spawnEntity(item);
						handler.getStackInSlot(0).shrink(1);
						handler.getStackInSlot(1).shrink(1);
						handler.getStackInSlot(2).shrink(1);
						isCasting = false;
						isCraftingItem = false;
					}
					if(isCraftingSpell)
					{
						handler.getStackInSlot(0).shrink(1);
						handler.getStackInSlot(1).shrink(1);
						handler.getStackInSlot(2).shrink(1);
						isCasting = false;
						isCraftingSpell = false;
					}
					
					world.notifyBlockUpdate(pos, state, state, 2);
					
					for(MutableBlockPos allBlockPos : blocksWithin)
					{
						if(world.getTileEntity(allBlockPos) instanceof TileWhitewoodPedestal)
						{
							TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(allBlockPos);
							state = world.getBlockState(allBlockPos);
							ItemStack stack = pedestal.handler.getStackInSlot(0);
							
							if(stack.hasCapability(EssenceProvider.essenceCapability, null))
							{
								if(isInputEssence)
								{
									voidEssence += getEssenceFromPedestals();
									isCasting = false;
									isInputEssence = false;
								}
								
								stack.shrink(1);
								world.notifyBlockUpdate(allBlockPos, state, state, 2);
							}
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
			else
			{
				if(isFillingChunk) isFillingChunk = false;
				isCasting = false;
			}
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
