package com.camellias.voidaicarcania.blocks.beacons.healbeacon;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityHealBeacon extends TileEntity implements ITickable
{
	public void setName(String name) 
	{
		
	}
	
	private void addEffectsToPlayers()
    {	
		double d0 = (double)(10 + 10);
		
		int k = this.pos.getX();
		int l = this.pos.getY();
		int i1 = this.pos.getZ();
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).grow(d0).expand(0.0D, (double)this.world.getHeight(), 0.0D);
		List<EntityLivingBase> list = getWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(getPos()).grow(4, 4, 4));
	
		for (EntityLivingBase player : list)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2 * 20, 1, true, true));
		}
    }
	
	@Override
	public void update() 
	{
		if (this.world.getTotalWorldTime() % 39L == 0L)
        {
            this.updateAnom();
        }
	}
	
	private void updateAnom() 
	{
		if (this.world != null)
        {
            this.addEffectsToPlayers();
        }
	}
}
