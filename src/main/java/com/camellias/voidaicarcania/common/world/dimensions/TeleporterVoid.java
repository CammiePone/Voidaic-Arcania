package com.camellias.voidaicarcania.common.world.dimensions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterVoid extends Teleporter
{
	private final WorldServer world;
	private double x, y, z;
	
	public TeleporterVoid(WorldServer world, double x, double y, double z)
	{
		super(world);
		
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void placeInPortal(Entity entity, float rotationYaw)
	{
		this.world.getBlockState(new BlockPos((int)this.x, (int)this.y, (int)this.z));
		entity.setPosition(x, y, z);
		entity.motionX = 0.0F;
		entity.motionY = 0.0F;
		entity.motionZ = 0.0F;
	}
	
	public static void teleportToDimension(Entity entity, int dimension, double x, double y, double z)
	{
		int oldDimension = entity.getEntityWorld().provider.getDimension();
		MinecraftServer server = entity.getEntityWorld().getMinecraftServer();
		WorldServer worldServer = server.getWorld(dimension);
		
		if(worldServer == null || server == null)
		{
			throw new IllegalArgumentException("Dimension: " + dimension + " doesn't exist");
		}
		if(entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP entityPlayerMP = (EntityPlayerMP) entity;
			worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, 
				new TeleporterVoid(worldServer, x, y, z));
		}
		
		entity.setPositionAndUpdate(x, y, z);
	}
}
