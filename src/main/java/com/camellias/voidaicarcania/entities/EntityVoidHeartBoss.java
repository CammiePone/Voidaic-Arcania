package com.camellias.voidaicarcania.entities;

import com.camellias.voidaicarcania.util.handlers.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

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
			world.getClosestPlayerToEntity(this, 30D).sendMessage(new TextComponentString("§5You are worthy, " 
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
		
		if(this.ticksExisted % 30 == 0)
		{
			this.heal(2.0F);
		}
		
		if(!world.isRemote)
		{
			if(this.ticksExisted % 100 == 0)
			{
				EntityVoidWraith entitywraith = new EntityVoidWraith(world);
				entitywraith.copyLocationAndAnglesFrom(this);
				
				this.world.spawnEntity(entitywraith);
			}
			
			if(this.ticksExisted % 50 == 0)
			{
				this.teleportRandomly();
			}
		}
		
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
	
	protected boolean teleportRandomly()
    {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 16.0D;
        double d1 = this.posY + (double)(this.rand.nextInt(16) - 8);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 16.0D;
        
        return this.teleportTo(d0, d1, d2);
    }
	
    private boolean teleportTo(double x, double y, double z)
    {
        EnderTeleportEvent event = new EnderTeleportEvent(this, x, y, z, 0);
        
        if(net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
        {
        	return false;
        }
        
        boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY() + 1, event.getTargetZ());
        
        if(flag)
        {
            this.world.playSound((EntityPlayer)null, this.prevPosX, this.prevPosY, this.prevPosZ, 
            		SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
            
            this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
        }
        
        return flag;
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
