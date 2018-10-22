package com.camellias.voidaicarcania.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.util.handlers.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityVoidDaemon extends EntityMob
{
	private int angerLevel;
	private UUID angerTargetUUID;
	
	public EntityVoidDaemon(World world)
	{
		super(world);
		this.isImmuneToFire = true;
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
        this.targetTasks.addTask(0, new EntityVoidDaemon.AIHurtByAggressor(this));
        this.targetTasks.addTask(1, new EntityVoidDaemon.AITargetAggressor(this));
    }
	
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		
		if (this.isAngry())
        {
            --this.angerLevel;
        }
		
		if (this.angerLevel > 0 && this.angerTargetUUID != null && this.getRevengeTarget() == null)
        {
            EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(entityplayer);
            this.attackingPlayer = entityplayer;
            this.recentlyHit = this.getRevengeTimer();
        }
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        super.setEquipmentBasedOnDifficulty(difficulty);

        if(this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD)
        {
        	this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        }
    }
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getTrueSource();

            if (entity instanceof EntityPlayer)
            {
                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(source, amount);
        }
    }
	
	@Override
	public void setRevengeTarget(@Nullable EntityLivingBase livingBase)
    {
        super.setRevengeTarget(livingBase);

        if (livingBase != null)
        {
            this.angerTargetUUID = livingBase.getUniqueID();
        }
    }
	
	private void becomeAngryAt(Entity entity)
    {
        this.angerLevel = 400 + this.rand.nextInt(400);

        if (entity instanceof EntityLivingBase)
        {
            this.setRevengeTarget((EntityLivingBase)entity);
        }
    }
	
	@Override
	public SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_STRAY_AMBIENT;
    }
	
	@Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.DAEMON;
    }
	
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
	
	public boolean isAngry()
    {
        return this.angerLevel > 0;
    }
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setShort("Anger", (short)this.angerLevel);

        if (this.angerTargetUUID != null)
        {
            compound.setString("HurtBy", this.angerTargetUUID.toString());
        }
        else
        {
            compound.setString("HurtBy", "");
        }
    }

	@Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.angerLevel = compound.getShort("Anger");
        String s = compound.getString("HurtBy");

        if (!s.isEmpty())
        {
            this.angerTargetUUID = UUID.fromString(s);
            EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(entityplayer);

            if (entityplayer != null)
            {
                this.attackingPlayer = entityplayer;
                this.recentlyHit = this.getRevengeTimer();
            }
        }
    }
    
    
	
	static class AIHurtByAggressor extends EntityAIHurtByTarget
    {
        public AIHurtByAggressor(EntityVoidDaemon daemon)
        {
            super(daemon, true);
        }
        
        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
        {
            super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

            if(creatureIn instanceof EntityVoidDaemon)
            {
                ((EntityVoidDaemon)creatureIn).becomeAngryAt(entityLivingBaseIn);
            }
        }
    }
	
	static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        public AITargetAggressor(EntityVoidDaemon daemon)
        {
            super(daemon, EntityPlayer.class, true);
        }
        
        public boolean shouldExecute()
        {
            return ((EntityVoidDaemon)this.taskOwner).isAngry() && super.shouldExecute();
        }
    }
}
