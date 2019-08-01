package com.camellias.voidaicarcania.common.tileentities.altar;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.IEssence;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipeHelper;
import com.camellias.voidaicarcania.api.registry.VoidaicAltarRecipes;
import com.camellias.voidaicarcania.client.particles.VoidEssenceParticle;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModItems;

import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.network.packets.SpawnVoidEssenceParticle;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
		
		if(nbt.hasKey("isFillingChunk"))
		{
			isFillingChunk = nbt.getBoolean("isFillingChunk");
		}
		
		if(nbt.hasKey("voidEssence"))
		{
			voidEssence = nbt.getInteger("voidEssence");
		}
		
		if(nbt.hasKey("ticks"))
		{
			ticks = nbt.getInteger("ticks");
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
		nbt.setBoolean("isFillingChunk", isFillingChunk);
		nbt.setInteger("voidEssence", voidEssence);
		nbt.setInteger("ticks", ticks);
		
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
		if (!world.isRemote)
		{
			if(isCasting)
			{
				if(!isValidStructure()) stopCasting(true);
				//TODO Filling chunk
				if(isFillingChunk)
				{
					Chunk chunk = world.getChunk(pos);
					
					for(int i = 0; i < 20; i++)
					{
						double posX = getPos().getX() + 0.5D;
						double posY = getPos().getY() + 1D;
						double posZ = getPos().getZ() + 0.5D;
						double motionX = ((world.rand.nextInt(8) - 4)) * 0.01D;
						double motionY = (world.rand.nextInt(3) + 3) * 0.1D;
						double motionZ = ((world.rand.nextInt(8) - 4)) * 0.01D;
						NetworkHandler.INSTANCE.sendToDimension(new SpawnVoidEssenceParticle(posX, posY, posZ, motionX, motionY, motionZ), world.provider.getDimension());
					}
					
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
							isCasting = false;
							isFillingChunk = false;
						}
					}
				}
				
				//TODO Crafting item/spell
				if(isCraftingItem || isCraftingSpell)
				{
					if(ticks <= voidEssence && ticks > 0)
					{
						ticks--;
						voidEssence--;
						
						Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
						
						for(MutableBlockPos allBlockPos : blocksWithin)
						{
							if(world.getTileEntity(allBlockPos) instanceof TileWhitewoodPedestal)
							{
								TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(allBlockPos);
								
								double posX = (pedestal.getPos().getX() + 0.5D);
								double posY = pedestal.getPos().getY() + 1D;
								double posZ = (pedestal.getPos().getZ() + 0.5D);
								double motionX = ((pos.getX() + 0.5D) - posX) * 0.06D;
								double motionY = ((pos.getY() + 4D) - posY) * 0.06D;
								double motionZ = ((pos.getZ() + 0.5D) - posZ) * 0.06D;
								NetworkHandler.INSTANCE.sendToDimension(new SpawnVoidEssenceParticle(posX, posY, posZ, motionX, motionY, motionZ), world.provider.getDimension());
								
								int xyz = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
								int xzy = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(2), handler.getStackInSlot(1));
								int yzx = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(0));
								int yxz = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(1), handler.getStackInSlot(0), handler.getStackInSlot(2));
								int zxy = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(2), handler.getStackInSlot(0), handler.getStackInSlot(1));
								int zyx = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(2), handler.getStackInSlot(1), handler.getStackInSlot(0));
								
								int getVoidEssence = xyz != 0 ? xyz : xzy != 0 ? xzy :
										yzx != 0 ? yzx : yxz != 0 ? yxz :
												zxy != 0 ? zxy : zyx;
								
								if(ticks <= (getVoidEssence / 2))
								{
									posX = getPos().getX() + 0.5D;
									posY = getPos().getY() + 3.9D;
									posZ = getPos().getZ() + 0.5D;
									motionX = ((world.rand.nextInt(8) - 4)) * 0.01D;
									motionY = (world.rand.nextInt(3) + 3) * -0.1D;
									motionZ = ((world.rand.nextInt(8) - 4)) * 0.01D;
									NetworkHandler.INSTANCE.sendToDimension(new SpawnVoidEssenceParticle(posX, posY, posZ, motionX, motionY, motionZ), world.provider.getDimension());
								}
							}
						}
					}
					else if(ticks == 0)
					{
						stopCasting(false);
					}
				}
				
				//TODO Filling altar
				if(isInputEssence)
				{
					if(ticks < 200)
					{
						ticks++;
						
						Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
						
						for(MutableBlockPos allBlockPos : blocksWithin)
						{
							if(world.getTileEntity(allBlockPos) instanceof TileWhitewoodPedestal)
							{
								TileWhitewoodPedestal pedestal = (TileWhitewoodPedestal) world.getTileEntity(allBlockPos);
								
								if(!pedestal.handler.getStackInSlot(0).isEmpty())
								{
									double posX = (pedestal.getPos().getX() + 0.5D);
									double posY = pedestal.getPos().getY() + 1D;
									double posZ = (pedestal.getPos().getZ() + 0.5D);
									double motionX = ((pos.getX() + 0.5D) - posX) * 0.06D;
									double motionZ = ((pos.getZ() + 0.5D) - posZ) * 0.06D;
									NetworkHandler.INSTANCE.sendToDimension(new SpawnVoidEssenceParticle(posX, posY, posZ, motionX, 0, motionZ), world.provider.getDimension());
								}
							}
						}
					}
					else {
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
		if(!world.isRemote && !isCasting)
		{
			VoidaicAltarRecipeHelper abc = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
			VoidaicAltarRecipeHelper acb = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(0), handler.getStackInSlot(2), handler.getStackInSlot(1));
			VoidaicAltarRecipeHelper bca = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(0));
			VoidaicAltarRecipeHelper bac = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(1), handler.getStackInSlot(0), handler.getStackInSlot(2));
			VoidaicAltarRecipeHelper cab = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(2), handler.getStackInSlot(0), handler.getStackInSlot(1));
			VoidaicAltarRecipeHelper cba = VoidaicAltarRecipes.INSTANCE.getRecipe(handler.getStackInSlot(2), handler.getStackInSlot(1), handler.getStackInSlot(0));
			
			VoidaicAltarRecipeHelper activeRecipe = abc != null ? abc : acb != null ? acb :
					bca != null ? bca : bac != null ? bac :
							cab != null ? cab : cba;
			
			int xyz = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
			int xzy = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(0), handler.getStackInSlot(2), handler.getStackInSlot(1));
			int yzx = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(0));
			int yxz = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(1), handler.getStackInSlot(0), handler.getStackInSlot(2));
			int zxy = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(2), handler.getStackInSlot(0), handler.getStackInSlot(1));
			int zyx = VoidaicAltarRecipes.INSTANCE.getVoidEssenceCost(handler.getStackInSlot(2), handler.getStackInSlot(1), handler.getStackInSlot(0));
			
			int getVoidEssence = xyz != 0 ? xyz : xzy != 0 ? xzy :
					yzx != 0 ? yzx : yxz != 0 ? yxz :
							zxy != 0 ? zxy : zyx;
			
			if(getEssenceFromPedestals() <= 0 && voidEssence >= getVoidEssence && isValidStructure())
			{
				if(activeRecipe != null)
				{
					if(handler.getStackInSlot(0).getItem() == ModItems.SPELL_PAPER
							|| handler.getStackInSlot(1).getItem() == ModItems.SPELL_PAPER
							|| handler.getStackInSlot(2).getItem() == ModItems.SPELL_PAPER)
					{
						isCasting = true;
						isCraftingSpell = true;
						isCraftingItem = false;
						ticks = getVoidEssence;
					}
					else
					{
						isCasting = true;
						isCraftingItem = true;
						isCraftingSpell = false;
						ticks = getVoidEssence;
					}
				}
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence >= (voidEssence + getEssenceFromPedestals()) && !(isCraftingItem || isCraftingSpell) && isValidStructure())
			{
				isCasting = true;
				isInputEssence = true;
			}
			else if(getEssenceFromPedestals() <= getVoidEssence && activeRecipe != null && isValidStructure())
			{
				player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.notenoughessence").getUnformattedText()));
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence < (voidEssence + getEssenceFromPedestals()) && maxEssence > voidEssence && isValidStructure())
			{
				player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.notenoughspace").getUnformattedText()));
			}
			else if(getEssenceFromPedestals() > 0 && maxEssence < (voidEssence + getEssenceFromPedestals()) && maxEssence == voidEssence && isValidStructure())
			{
				player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.isfull").getUnformattedText()));
			}
			
			if(activeRecipe == null && getEssenceFromPedestals() <= 0)
			{
				if(isValidStructure()
						&& handler.getStackInSlot(0).getCount() > 0
						|| handler.getStackInSlot(1).getCount() > 0
						|| handler.getStackInSlot(2).getCount() > 0)
				{
					player.sendMessage(new TextComponentString(TextFormatting.RED + "" + TextFormatting.ITALIC + new TextComponentTranslation(Reference.MODID + ".altar.unknownrecipe").getUnformattedText()));
				}
				else
				{
					if(voidEssence > 0)
					{
						isFillingChunk = true;
						isCasting = true;
					}
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
						ItemStack abc = VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2));
						ItemStack acb = VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(0), handler.getStackInSlot(2), handler.getStackInSlot(1));
						ItemStack bca = VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(0));
						ItemStack bac = VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(1), handler.getStackInSlot(0), handler.getStackInSlot(2));
						ItemStack cab = VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(2), handler.getStackInSlot(0), handler.getStackInSlot(1));
						ItemStack cba = VoidaicAltarRecipes.INSTANCE.getRecipeResult(handler.getStackInSlot(2), handler.getStackInSlot(1), handler.getStackInSlot(0));
						
						ItemStack getResult = abc != null ? abc : acb != null ? acb :
								bca != null ? bca : bac != null ? bac :
										cab != null ? cab : cba != null ? cba : null;
						
						if(getResult != null)
						{
							EntityItem item = new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 1D, pos.getZ() + 0.5D, getResult);
							
							world.spawnEntity(item);
							handler.getStackInSlot(0).shrink(1);
							handler.getStackInSlot(1).shrink(1);
							handler.getStackInSlot(2).shrink(1);
						}
						
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
		int essence = 0;
		if (!world.isRemote)
		{
			Iterable<MutableBlockPos> blocksWithin = BlockPos.getAllInBoxMutable(pos.getX() - 3, pos.getY(), pos.getZ() - 3, pos.getX() + 3, pos.getY(), pos.getZ() + 3);
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
		}
		return essence;
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return !isInvalid() && player.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}
}
