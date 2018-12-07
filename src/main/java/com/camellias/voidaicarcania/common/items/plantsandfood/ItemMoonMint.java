package com.camellias.voidaicarcania.common.items.plantsandfood;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemMoonMint extends ItemFood implements IHasModel, IPlantable
{
	public ItemMoonMint(String name, int amount, float saturation, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood); // This is the FoodItem handler. 
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 5*20, 5, false, true));
		}
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		ItemStack stack = player.getHeldItem(hand);
		IBlockState state = world.getBlockState(pos);
		
		if(facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack) 
				&& state.getBlock().canSustainPlant(state, world, pos, EnumFacing.UP, this) && world.isAirBlock(pos.up()))
		{
			world.setBlockState(pos.up(), ModBlocks.BLOCK_MOON_MINT.getDefaultState());
			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		else return EnumActionResult.FAIL;
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return ModBlocks.BLOCK_MOON_MINT.getDefaultState();
	}

	
}
