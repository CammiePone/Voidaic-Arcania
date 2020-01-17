package com.camellias.voidaicarcania.common.entities.misc;

import java.util.Random;

import com.camellias.voidaicarcania.api.capabilities.essence.EssenceProvider;
import com.camellias.voidaicarcania.api.capabilities.essence.IEssence;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntitySpell extends Entity
{
	public Chunk chunk = world.getChunk(getPosition());
	public Random rand = new Random();
	public int essence;
	public int potency;
	public int volatility;
	
	public EntitySpell(World world)
	{
		super(world);
	}
	
	@Override
	public void setDead()
	{
		super.setDead();
		
		if(chunk.hasCapability(EssenceProvider.essenceCapability, null))
		{
			IEssence cap = chunk.getCapability(EssenceProvider.essenceCapability, null);
		}
	}
	
	@Override
	public void onEntityUpdate()
	{
		if(!world.isRemote)
		{
			if(ticksExisted % 20 == 0)
			{
				if(chunk.hasCapability(EssenceProvider.essenceCapability, null))
				{
					IEssence cap = chunk.getCapability(EssenceProvider.essenceCapability, null);
					
					if(cap.getEssence() > 0)
					{
						cap.setEssence(cap.getEssence() - 1);
						essence++;
					}
				}
				
				if(essence % 250 == 0)
				{
					if(rand.nextInt(10) == volatility++)
					{
						setDead();
					}
					
					volatility++;
				}
			}
		}
	}
	
	@Override
	public boolean canBePushed()
	{
		return false;
	}
	
	@Override
	public boolean isPushedByWater()
	{
		return false;
	}
	
	@Override
	protected void entityInit()
	{
		
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		
	}
}
