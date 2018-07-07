package com.camellias.voidaicarcania.entities;

import javax.annotation.Nullable;

import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.handlers.LootTableHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityVoidWraith extends EntityMob
{
	protected static final DataParameter<Byte> WRAITH_FLAGS = EntityDataManager.<Byte>createKey(EntityVex.class, DataSerializers.BYTE);
	
 	@Nullable
 	private BlockPos boundOrigin;
	
	public EntityVoidWraith(World world)
	{
		super(world);
		this.moveHelper = new EntityVoidWraith.AIMoveControl(this);
		this.isImmuneToFire = false;
		this.setSize(1.0F, 1.0F);
	}
	
	@Override
	public boolean getCanSpawnHere() 
	{
		return true;
	}
	
	@Override
	public void move(MoverType type, double x, double y, double z)
    {
        super.move(type, x, y, z);
        this.doBlockCollisions();
    }
	
	@Override
	public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5F);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
    }
	
	@Override
	public void initEntityAI()
    {
        super.initEntityAI();
        
        this.tasks.addTask(1, new EntityVoidWraith.AIChargeAttack());
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.VOIDIC_SHARD, false));
        this.tasks.addTask(4, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityVoidWraith.AIMoveRandom());
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true, new Class[] {EntityVoidWraith.class}));
    }
	
	@Override
	public void onUpdate()
    {
		this.noClip = true;
        super.onUpdate();
        this.noClip = false;
        this.setNoGravity(true);
        
        if(this.ticksExisted == 20 * 90)
        {
        	this.despawnEntity();
        }
    }
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.WRAITH;
	}
	
	@Override
	public SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }
	
	@Override
	public SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }
	
	@Override
	public SoundEvent getHurtSound(DamageSource source)
    {
        return SoundEvents.ENTITY_CAT_HISS;
    }
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		
		if (compound.hasKey("BoundX"))
		{
			this.boundOrigin = new BlockPos(compound.getInteger("BoundX"), compound.getInteger("BoundY"), compound.getInteger("BoundZ"));
		}
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		
		if (this.boundOrigin != null)
		{
			compound.setInteger("BoundX", this.boundOrigin.getX());
			compound.setInteger("BoundY", this.boundOrigin.getY());
			compound.setInteger("BoundZ", this.boundOrigin.getZ());
		}
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(WRAITH_FLAGS, Byte.valueOf((byte)0));
	}
	
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return super.onInitialSpawn(difficulty, livingdata);
	}
	
	@Override
	public void fall(float distance, float damageMultiplier)
    {
    }
	
	@Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }
	
	@Nullable
	public BlockPos getBoundOrigin()
	{
		return this.boundOrigin;
	}
	
	public void setBoundOrigin(@Nullable BlockPos boundOriginIn)
	{
		this.boundOrigin = boundOriginIn;
	}
	
	public boolean isCharging()
	{
		return this.getWraithFlag(1);
	}
	
	public void setCharging(boolean charging)
	{
		this.setWraithFlag(1, charging);
	}
	
	private boolean getWraithFlag(int mask)
	{
		int i = ((Byte)this.dataManager.get(WRAITH_FLAGS)).byteValue();
		return (i & mask) != 0;
	}
	
	private void setWraithFlag(int mask, boolean value)
	{
		int i = ((Byte)this.dataManager.get(WRAITH_FLAGS)).byteValue();
		
		if (value)
		{
			i = i | mask;
		}
		else
		{
			i = i & ~mask;
		}
		
		this.dataManager.set(WRAITH_FLAGS, Byte.valueOf((byte)(i & 255)));
	}
	
	class AIMoveControl extends EntityMoveHelper
	{
		public AIMoveControl(EntityVoidWraith wraith)
		{
			super(wraith);
		}
		
		public void onUpdateMoveHelper()
		{
			if (this.action == EntityMoveHelper.Action.MOVE_TO)
			{
				double d0 = this.posX - EntityVoidWraith.this.posX;
				double d1 = this.posY - EntityVoidWraith.this.posY;
				double d2 = this.posZ - EntityVoidWraith.this.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				d3 = (double)MathHelper.sqrt(d3);
				
				if (d3 < EntityVoidWraith.this.getEntityBoundingBox().getAverageEdgeLength())
				{
					this.action = EntityMoveHelper.Action.WAIT;
					EntityVoidWraith.this.motionX *= 0.5D;
					EntityVoidWraith.this.motionY *= 0.5D;
					EntityVoidWraith.this.motionZ *= 0.5D;
				}
				else
				{
					EntityVoidWraith.this.motionX += d0 / d3 * 0.05D * this.speed;
					EntityVoidWraith.this.motionY += d1 / d3 * 0.05D * this.speed;
					EntityVoidWraith.this.motionZ += d2 / d3 * 0.05D * this.speed;
				}
			}
		}
	}
	
	class AIChargeAttack extends EntityAIBase
	{
		public AIChargeAttack()
		{
			this.setMutexBits(1);
		}
		
		public boolean shouldExecute()
		{
			if (EntityVoidWraith.this.getAttackTarget() != null && !EntityVoidWraith.this.getMoveHelper().isUpdating() 
					&& EntityVoidWraith.this.rand.nextInt(7) == 0)
			{	
				return EntityVoidWraith.this.getDistanceSq(EntityVoidWraith.this.getAttackTarget()) > 4.0D;
			}
			else
			{	
				return false;
			}
		}
		
		public boolean shouldContinueExecuting()
		{
			return EntityVoidWraith.this.getMoveHelper().isUpdating() && EntityVoidWraith.this.isCharging() 
					&& EntityVoidWraith.this.getAttackTarget() != null && EntityVoidWraith.this.getAttackTarget().isEntityAlive();
		}
		
		public void startExecuting()
		{
			EntityLivingBase entitylivingbase = EntityVoidWraith.this.getAttackTarget();
			Vec3d vec3d = entitylivingbase.getPositionEyes(1.0F);
			EntityVoidWraith.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
			EntityVoidWraith.this.setCharging(true);
			EntityVoidWraith.this.playSound(SoundEvents.ENTITY_CAT_HISS, 1.0F, 1.0F);
		}
		
		public void resetTask()
		{
			EntityVoidWraith.this.setCharging(false);
		}
		
		public void updateTask()
		{
			EntityLivingBase entitylivingbase = EntityVoidWraith.this.getAttackTarget();
			
			if (EntityVoidWraith.this.getEntityBoundingBox().intersects(entitylivingbase.getEntityBoundingBox()))
			{
				EntityVoidWraith.this.attackEntityAsMob(entitylivingbase);
				EntityVoidWraith.this.setCharging(false);
			}
			else
			{
				double d0 = EntityVoidWraith.this.getDistanceSq(entitylivingbase);
				
				if (d0 < 9.0D)
				{
					Vec3d vec3d = entitylivingbase.getPositionEyes(1.0F);
					EntityVoidWraith.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
				}
			}
		}
	}
	
	class AIMoveRandom extends EntityAIBase
	{
		public AIMoveRandom()
		{
			this.setMutexBits(1);
		}
		
		public boolean shouldExecute()
		{
			return !EntityVoidWraith.this.getMoveHelper().isUpdating() && EntityVoidWraith.this.rand.nextInt(7) == 0;
		}
		
		public boolean shouldContinueExecuting()
		{
			return false;
		}
		
		public void updateTask()
		{
			BlockPos blockpos = EntityVoidWraith.this.getBoundOrigin();
			
			if (blockpos == null)
			{
				blockpos = new BlockPos(EntityVoidWraith.this);
			}
			
			for (int i = 0; i < 3; ++i)
			{
				BlockPos blockpos1 = blockpos.add(EntityVoidWraith.this.rand.nextInt(15) - 7, EntityVoidWraith.this.rand.nextInt(11) - 5, 
						EntityVoidWraith.this.rand.nextInt(15) - 7);
				
				if (EntityVoidWraith.this.world.isAirBlock(blockpos1))
				{
					EntityVoidWraith.this.moveHelper.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, 
							(double)blockpos1.getZ() + 0.5D, 0.25D);
					
					if (EntityVoidWraith.this.getAttackTarget() == null)
					{
						EntityVoidWraith.this.getLookHelper().setLookPosition((double)blockpos1.getX() + 0.5D, 
								(double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.0F, 20.0F);
					}	
					
					break;
				}
			}
		}
	}	
}
