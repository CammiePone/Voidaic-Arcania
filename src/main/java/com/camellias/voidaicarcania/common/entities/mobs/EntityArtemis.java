package com.camellias.voidaicarcania.common.entities.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityArtemis extends EntityMob
{
	public EntityArtemis(World world)
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.5F);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
	}
}
