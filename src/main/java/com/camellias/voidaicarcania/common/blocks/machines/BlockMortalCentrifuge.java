package com.camellias.voidaicarcania.common.blocks.machines;

import java.util.Random;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.common.blocks.machines.blockmortalcentrifuge.TileEntityMortalCentrifuge;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;
import com.camellias.voidaicarcania.util.handlers.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMortalCentrifuge extends Block implements IHasModel
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool SMELTING = PropertyBool.create("smelting");
	
	public BlockMortalCentrifuge(String name, Material material) 
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(3.0F);
		this.setCreativeTab(Main.voidictab);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(SMELTING, false));
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public static void setState(boolean active, World world, BlockPos pos) 
	{
		IBlockState state = world.getBlockState(pos);
		TileEntity tileentity = world.getTileEntity(pos);
		
		if(active)
		{
			world.setBlockState(pos, ModBlocks.BLOCK_MORTAL_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING))
					.withProperty(SMELTING, true));
		}
		else
		{
			world.setBlockState(pos, ModBlocks.BLOCK_MORTAL_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING))
					.withProperty(SMELTING, false));
		}
		
		if(tileentity != null) 
		{
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
	{
		boolean smelting = (state.getValue(SMELTING).booleanValue());
		
		if(smelting == true)
		{
			double d0 = (double)pos.getX() + 0.5D;
			double d1 = (double)pos.getY() + 1.5D;
			double d2 = (double)pos.getZ() + 0.5D;
			
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, 0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, -0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.02D, -0.006D, 0.0D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, -0.02D, -0.006D, 0.0D);
			
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, 0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, -0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.02D, -0.006D, 0.0D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, -0.02D, -0.006D, 0.0D);
			
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, 0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, -0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.02D, -0.006D, 0.0D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, -0.02D, -0.006D, 0.0D);
			
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, 0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.0D, -0.006D, -0.02D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0.02D, -0.006D, 0.0D);
			world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, -0.02D, -0.006D, 0.0D);
			
			setLightLevel(1.0F);
		}
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.BLOCK_MORTAL_FURNACE);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntityMortalCentrifuge tileEntity = (TileEntityMortalCentrifuge)world.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(world, pos, tileEntity);
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public ItemStack getItem(World world, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ModBlocks.BLOCK_MORTAL_FURNACE);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isTranslucent(IBlockState state)
	{
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, 
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			player.openGui(Main.instance, ConfigHandler.GUI_MORTAL_FURNACE, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityMortalCentrifuge();
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, 
			int meta, EntityLivingBase placer, EnumHand hand) 
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) 
	{
		return state.withRotation(mirror.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {SMELTING,FACING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing).withProperty(SMELTING, false);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
}