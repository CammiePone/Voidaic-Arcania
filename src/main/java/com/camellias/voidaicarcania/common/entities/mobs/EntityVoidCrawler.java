package com.camellias.voidaicarcania.common.entities.mobs;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityVoidCrawler extends EntityMob
{
	public EntityVoidCrawler(World world)
	{
		super(world);
		this.experienceValue = 5;
	}
	
	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3F);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
	}
	
	@Override
	public void initEntityAI()
	{
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
	{
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
	}
	
	@Override
	public SoundEvent getAmbientSound()
	{
		return SoundEvents.ENTITY_STRAY_AMBIENT;
	}
	
	/*@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableHandler.DAEMON;
	}*/
	
	@Override
	public SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_PLAYER_DEATH;
	}
	
	@Override
	public SoundEvent getHurtSound(DamageSource source)
	{
		return SoundEvents.ENTITY_GENERIC_HURT;
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry())
		{
			this.setAngry(false);
		}
	}
	
	@Override
	public void setAttackTarget(@Nullable EntityLivingBase entitylivingbase)
	{
		super.setAttackTarget(entitylivingbase);
		
		this.setAngry(true);
	}
	
	public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner)
	{
		if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast))
		{
			if (target instanceof EntityWolf)
			{
				EntityWolf entitywolf = (EntityWolf)target;

				if (entitywolf.isTamed() && entitywolf.getOwner() == owner)
				{
					return false;
				}
			}

			if (target instanceof EntityPlayer && owner instanceof EntityPlayer && !((EntityPlayer)owner).canAttackPlayer((EntityPlayer)target))
			{
				return false;
			}
			else
			{
				return !(target instanceof AbstractHorse) || !((AbstractHorse)target).isTame();
			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean isAngry()
	{
		return false;
	}
	
	public void setAngry(boolean angry)
	{
		
	}
}
