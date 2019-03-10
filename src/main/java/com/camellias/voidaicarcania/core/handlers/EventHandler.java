package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.common.world.dimensions.ChunkGeneratorVoid;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.network.packets.HoldSpacebarMessage;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventHandler
{
	public static final IBlockState RIFT = ModBlocks.RIFT.getDefaultState();
	public static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
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
		
		if(event.getGenerator() instanceof ChunkGeneratorOverworld)
		{
			for(int x = 0; x < 16; x++)
			{
				for(int z = 0; z < 16; z++)
				{
					for(int y = 0; y <= 1; y++)
					{
						BlockPos pos = new BlockPos(x, y, z);
						if(y == 0) chunk.setBlockState(pos, RIFT);
						if(y == 1) chunk.setBlockState(pos, BEDROCK);
					}
				}
			}
		}
		
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
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if(!(event.getEntity() instanceof EntityPlayer))
		{
			Entity entity = event.getEntity();
			if(!entity.world.isRemote)
			{
				World world = entity.world;
				
				if(event.getEntity().dimension == -64)
		        {
					entity.setNoGravity(true);
				}
				
				if(event.getEntity().dimension == 0)
				{
					int y = (int) entity.posY;
					
					if(y < 10)
					{
						entity.setNoGravity(true);
					}
					else
					{
						if(!entity.onGround && entity.motionY < 0.0D)
						{
							entity.motionY *= (y * 0.01);
						}
						entity.setNoGravity(false);
					}
				}
		        else
		        {
		        	if(event.getEntity().ticksExisted % 20 == 0)
		        	{
		        		event.getEntity().setNoGravity(false);
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
					player.motionY = -0.15D;
				}
				if((player.motionY <= 0.1D && player.motionY >= -0.1D))
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
		if(player.dimension == 0)
		{
			int y = (int) player.posY;
			
			if(y < 10)
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
						player.motionY = -0.15D;
					}
					if((player.motionY <= 0.1D && player.motionY >= -0.1D))
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
			else
			{
				if(!world.isRemote)
				{
					if(!player.capabilities.isFlying || !player.isElytraFlying())
					{
						if(!player.onGround && player.motionY < 0.0D)
				        {
				            player.motionY *= (y * 0.01);
				        }
					}
					player.setNoGravity(false);
				}
			}
		}
	}
}
