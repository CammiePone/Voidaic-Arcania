package com.camellias.voidaicarcania.entities;

import com.camellias.voidaicarcania.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityVoidConstruct extends EntityMob
{
	private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, 
			BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.<Integer>createKey(EntityVoidConstruct.class, DataSerializers.VARINT);
	
	private int attackTimer;
	private int blockBreakCounter;
	
	public EntityVoidConstruct(World world) 
	{
		super(world);
		this.isImmuneToFire = true;
		this.setSize(2.0F, 3.5F);
		this.getPositionEyes(3.0F);
		this.experienceValue = 400;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25F);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
    }
	
	@Override
	public void initEntityAI()
    {
        super.initEntityAI();
        
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[] {EntityVoidConstruct.class}));
    }
	
	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount)
	{
		if(damageAmount > 20F)
		{
			damageAmount = 20F;
		}
		
		super.damageEntity(damageSrc, damageAmount);
	}
	
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
        
        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }
    }
	
	@Override
	protected void onDeathUpdate()
	{
		world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ, 1.0F, 1.0F, 1.0F, null);
		
		this.setDead();
		if(!world.isRemote)
		{
			world.createExplosion(this, this.posX, this.posY, this.posZ, 6.0F, true);
			
			EntityVoidHeartBoss heartBoss = new EntityVoidHeartBoss(world);
			heartBoss.setLocationAndAngles(this.posX, this.posY + 1, this.posZ, this.rotationYaw, this.rotationPitch);
			this.world.spawnEntity(heartBoss);
		}
	}
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
    {
        this.attackTimer = 20;
        this.world.setEntityState(this, (byte)4);
        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 
        		(float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue());

        if (flag)
        {
            entity.motionY += 0.4000000059604645D;
            this.applyEnchantments(this, entity);
        }

        this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_IRONGOLEM_HURT;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }
	
	@Override
    protected void playStepSound(BlockPos pos, Block block)
    {
        this.playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0F, 1.0F);
    }
	
	@SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
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
			this.heal(1.0F);
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
