package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.api.capabilities.Corruption.CorruptionProvider;
import com.camellias.voidaicarcania.api.capabilities.Corruption.ICorruption;
import com.camellias.voidaicarcania.api.capabilities.EssenceCap.EssenceProvider;
import com.camellias.voidaicarcania.common.world.dimensions.ChunkGeneratorVoid;
import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.network.packets.HoldSpacebarMessage;
import com.camellias.voidaicarcania.core.network.packets.OverlayMessage;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

public class EventHandler
{
	public static final IBlockState AIR = Blocks.AIR.getDefaultState();
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		event.player.sendMessage(new TextComponentString("\u00A75\u00A7l[Voidaic Arcania:] \u00A7dThis mod is still in BETA. Gameplay info can currently be found on the VA Wiki:"));
		event.player.sendMessage(ForgeHooks.newChatWithLinks(" https://github.com/CammiePone/Voidaic-Arcania/wiki"));
	}
	
	@SubscribeEvent
	public void onChunkPopulate(PopulateChunkEvent.Pre event)
	{
		Chunk chunk = event.getWorld().getChunk(event.getChunkX(), event.getChunkZ());
		if(event.getGenerator() instanceof ChunkGeneratorVoid)
		{
			for(int x = 0; x < 16; x++)
			{
				for(int z = 0; z < 16; z++)
				{
					for(int y = 0; y <= 5; y++)
					{
						BlockPos pos = new BlockPos(x, y, z);
						chunk.setBlockState(pos, AIR);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityChangeDim(EntityTravelToDimensionEvent event)
	{
		if(event.getEntity() instanceof EntityLivingBase)
		{
			EntityLivingBase entity = (EntityLivingBase) event.getEntity();
			if(event.getDimension() == 0)
			{
				if(entity.world.getBlockState(entity.getPosition().up(1)) != AIR)
				{
					entity.world.setBlockState(entity.getPosition().add(3, 3, 3), AIR);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onWorldTick(WorldTickEvent event)
	{
		if(event.phase == Phase.START)
		{
			World world = event.world;
			
			for(Entity entity : world.loadedEntityList)
			{
				if(!(entity instanceof EntityPlayer))
				{
					if(entity.dimension == -64)
			        {
						entity.setNoGravity(true);
						entity.motionY = 0;
					}
			        else
			        {
			        	if(entity.ticksExisted % 20 == 0) entity.setNoGravity(false);
			        }
				}
			}
			
			for(EntityPlayer player : world.playerEntities)
			{
				Chunk chunk = world.getChunk(player.getPosition());
				
				if(player.ticksExisted % 20 == 0)
				{
					if(chunk.hasCapability(EssenceProvider.essenceCapability, null) && 
							chunk.hasCapability(CorruptionProvider.corruptionCapability, null) &&
							player.hasCapability(CorruptionProvider.corruptionCapability, null))
					{
						int chunkVE = chunk.getCapability(EssenceProvider.essenceCapability, null).getEssence();
						int chunkVC = chunk.getCapability(CorruptionProvider.corruptionCapability, null).getCorruption();
						int playerVC = player.getCapability(CorruptionProvider.corruptionCapability, null).getCorruption();
						NetworkHandler.INSTANCE.sendTo(new OverlayMessage(chunkVE, chunkVC, playerVC), (EntityPlayerMP) player);
						
						if(player.dimension == -64)
						{
							ICorruption corruption = player.getCapability(CorruptionProvider.corruptionCapability, null);
							if(!corruption.isCorrupted())
							{
								corruption.setCorrupted(true);
							}
							else
							{
								if(corruption.getCorruption() <= 1200)
								{
									corruption.setCorruption(corruption.getCorruption() + 1);
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		World world = player.world;
		
		if(player.dimension == -64)
        {
			if(!player.isElytraFlying() || !player.capabilities.isFlying)
			{
				if(world.isRemote)
				{
					GameSettings settings = Minecraft.getMinecraft().gameSettings;
					KeyBinding jump = settings.keyBindJump;
					GuiScreen gui = Minecraft.getMinecraft().currentScreen;
					
					if(settings.isKeyDown(jump) && gui == null)
					{
						NetworkHandler.INSTANCE.sendToAll(new HoldSpacebarMessage(player));
					}
				}
				
				if(player.isSneaking())
				{
					player.motionY = -0.2D;
				}
				if((player.motionY <= 0.15D && player.motionY >= -0.15D))
				{
					player.motionY = player.motionY / 1.025D;
				}
				
				player.setNoGravity(true);
				player.jumpMovementFactor *= 1.5F;
				player.fallDistance = 0.0F;
			}
			else
			{
				player.setNoGravity(false);
			}
		}
	}
}
