package com.camellias.voidaicarcania.common.items.spells.voidblitz;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ItemSpellVoidBlitz extends Item implements IHasModel 
{
	
	public ItemSpellVoidBlitz(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
        ItemStack itemstack = player.getHeldItem(hand);

    	if (!world.isRemote)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2 * 20, 1, true, false));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 2 * 20, 19, true, false));
			player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 2 * 20, 1, true, false));
			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 2 * 20, 1, true, false));
		}
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}	

