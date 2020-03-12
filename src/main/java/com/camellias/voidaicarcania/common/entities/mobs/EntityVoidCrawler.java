package com.camellias.voidaicarcania.common.entities.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityVoidCrawler extends EntityMob
{
	public EntityVoidCrawler(World world)
	{
		super(world);
		this.setSize(0.8F, 0.8F);
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0F);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}
}
