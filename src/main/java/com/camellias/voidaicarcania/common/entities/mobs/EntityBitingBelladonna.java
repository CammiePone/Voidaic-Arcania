package com.camellias.voidaicarcania.common.entities.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityBitingBelladonna extends EntityMob
{
	public EntityBitingBelladonna(World world)
	{
		super(world);
		this.setSize(0.8F, 2.25F);
		this.experienceValue = 5;
		this.setNoGravity(true);
	}
	
	@Override
	public float getEyeHeight()
	{
		return 0.3F;
	}
	
	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0F);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}
}
