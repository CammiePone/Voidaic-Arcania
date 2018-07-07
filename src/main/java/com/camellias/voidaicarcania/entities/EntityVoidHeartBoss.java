package com.camellias.voidaicarcania.entities;

import com.camellias.voidaicarcania.util.handlers.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityVoidHeartBoss extends EntityMob
{
	private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, 
			BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
	
	public EntityVoidHeartBoss(World world) 
	{
		super(world);
		this.isImmuneToFire = true;
		this.setSize(1.0F, 1.0F);
		this.getPositionEyes(0.5F);
		this.experienceValue = 400;
		this.setNoGravity(true);
	}
	
	@Override
	public boolean isImmuneToExplosions()
	{
		return true;
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.HEART;
	}
	
	@Override
	public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0F);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
    }
	
	@Override
	public void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true, new Class[] {EntityVoidHeartBoss.class}));
    }
	
	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount)
	{
		if(damageAmount > 10F)
		{
			damageAmount = 10F;
		}
		
		super.damageEntity(damageSrc, damageAmount);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
    {
        this.world.setEntityState(this, (byte)4);
        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if (flag)
        {
            entity.motionY += 0.8000000119209290D;
            this.applyEnchantments(this, entity);
        }
        
        return flag;
    }
	
	@Override
	protected void onDeathUpdate() 
	{
		this.setDead();
		if(!world.isRemote)
		{
			world.getClosestPlayerToEntity(this, 30D).sendMessage(new TextComponentString("You are worthy, " 
					+ world.getClosestPlayerToEntity(this, 30D).getDisplayNameString() 
					+ ". Give me an item, and I shall imbue it with power."));
			
			EntityVoidHeartPassive heartPassive = new EntityVoidHeartPassive(world);
			heartPassive.copyLocationAndAnglesFrom(this);
			this.world.spawnEntity(heartPassive);
		}
	}
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SLIME_SQUISH;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.BLOCK_SLIME_BREAK;
    }
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.BLOCK_NOTE_BASEDRUM;
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }
	
	@Override
	protected void updateAITasks()
    {
		super.updateAITasks();
		
		if(this.ticksExisted % 20 == 0)
		{
			this.heal(3.0F);
		}
		
		if(this.ticksExisted == 100)
		{
			EntityVoidWraith entitywraith = new EntityVoidWraith(world);
			entitywraith.copyLocationAndAnglesFrom(this);
			
			this.world.spawnEntity(entitywraith);
			this.ticksExisted = 0;
		}
		
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
	
	@Override
	public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }
	
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }
	
	public boolean isNonBoss()
    {
        return false;
    }

    @Override
    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
        this.bossInfo.setName(this.getDisplayName());
    }
}
