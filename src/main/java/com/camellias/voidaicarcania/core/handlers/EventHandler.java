package com.camellias.voidaicarcania.core.handlers;

import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.network.NetworkHandler;
import com.camellias.voidaicarcania.core.network.packets.HoldSpacebarMessage;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventHandler
{
	public static final IBlockState RIFT = ModBlocks.RIFT.getDefaultState();
	public static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	
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
	
	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event)
	{
		if(!(event.getEntity() instanceof EntityPlayer))
		{
			if(event.getEntity().dimension == -64)
			{
				event.getEntity().setNoGravity(true);
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityChangeDim(EntityTravelToDimensionEvent event)
	{
		if(event.getDimension() == -64)
		{
			event.getEntity().setNoGravity(true);
		}
		else
		{
			event.getEntity().setNoGravity(false);
		}
	}
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		if(event.player.dimension == -64)
        {
        	EntityPlayer player = event.player;
			World world = player.world;
			BlockPos pos = player.getPosition();
			BlockPos blockpos = pos.add(0, -1, 0);
			IBlockState state = player.world.getBlockState(blockpos);
			
			if(!player.isElytraFlying() || !player.capabilities.isFlying)
			{
				if(state.getBlock().isPassable(player.world, blockpos))
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
						player.motionY = -0.25D;
					}
					if((player.motionY <= 0.2D && player.motionY >= -0.2D))
					{
						player.motionY = player.motionY / 1.025D;
					}
					
					player.jumpMovementFactor *= 1.75F;
					player.fallDistance = 0.0F;
				}
			}
		}
	}
}
