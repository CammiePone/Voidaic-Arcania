package com.camellias.voidaicarcania.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityVoidEye extends EntityMob
{
	public EntityVoidEye(World world) 
	{
		super(world);
		this.isImmuneToFire = true;
		this.setSize(1.0F, 1.0F);
		this.getPositionEyes(0.5F);
		this.experienceValue = 0;
		this.setNoGravity(true);
		this.setEntityInvulnerable(true);
	}
	
	@Override
	public boolean isImmuneToExplosions()
	{
		return true;
	}
	
	@Override
	public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0F);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
    }
	
	@Override
	public void initEntityAI()
    {
        super.initEntityAI();
    }
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }
	
	@Override
	public void onEntityUpdate()
	{
		super.onEntityUpdate();
		
		if(this.ticksExisted % 1 == 0)
		{
			this.setLocationAndAngles(this.posX, this.posY + 0.01, this.posZ, this.rotationYaw, this.rotationPitch);
		}
	}
	
	@Override
	public void onLivingUpdate()
	{
		if(this.ticksExisted == 200)
		{
			if(!this.world.isRemote)
			{
				this.setDead();
				
				EntityVoidConstruct constructBoss = new EntityVoidConstruct(world);
				constructBoss.setLocationAndAngles(this.posX, this.posY - 2.7, this.posZ, this.rotationYaw, this.rotationPitch);
				this.world.spawnEntity(constructBoss);
			}
			
			double d0 = (double)this.getPosition().getX() + 0.5D;
			double d1 = (double)this.getPosition().getY() + 0.5D;
			double d2 = (double)this.getPosition().getZ() + 0.5D;
			
			world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	@Override
	protected void updateAITasks()
    {
		super.updateAITasks();
		
		if(this.ticksExisted % 1 == 0)
		{
			this.heal(200.0F);
		}
    }

    @Override
    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
    }
}
