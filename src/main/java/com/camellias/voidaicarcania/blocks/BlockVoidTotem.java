package com.camellias.voidaicarcania.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;
import com.camellias.voidaicarcania.util.handlers.SoundsHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockVoidTotem extends Block implements IHasModel
{
	
	public BlockVoidTotem(String name, Material material) 
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		this.setSoundType(blockSoundType.GLASS);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World world, BlockPos blockpos, Random rand)
	{	//Temporary fix - replace this later
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.8D, blockpos.getY() + 0.2D, blockpos.getZ() + 0.6D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.2D, blockpos.getY() + 0.4D, blockpos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.4D, blockpos.getY() + 0.8D, blockpos.getZ() + 0.3D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.2D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.3D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.5D, blockpos.getY() + 0.7D, blockpos.getZ() + 0.2D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.8D, blockpos.getY() + 0.7D, blockpos.getZ() + 0.8D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.3D, 0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	protected boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
