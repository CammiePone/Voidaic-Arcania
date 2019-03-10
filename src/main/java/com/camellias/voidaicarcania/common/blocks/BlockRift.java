package com.camellias.voidaicarcania.common.blocks;

import java.util.Random;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.common.tileentities.TileEntityRift;
import com.camellias.voidaicarcania.common.world.dimensions.TeleporterVoid;
import com.camellias.voidaicarcania.core.init.ModBlocks;
import com.camellias.voidaicarcania.core.init.ModItems;
import com.camellias.voidaicarcania.core.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRift extends Block implements IHasModel
{
	private static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
	
	public BlockRift(Material material, String name)
	{
		super(material);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		this.setLightLevel(0.25F);
		this.setBlockUnbreakable();
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isPassable(IBlockAccess world, BlockPos pos)
	{
		return true;
	}
	
	
	@Override
	public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		if(!entity.getEntityWorld().isRemote)
		{
			if(entity.dimension != -64)
			{
				if(!(entity instanceof EntityPlayer))
				{
					TeleporterVoid.teleportToDimension(entity, -64, entity.posX, 120, entity.posZ);
				}
				else
				{
					if(entity instanceof EntityPlayerMP)
					{
						TeleporterVoid.teleportToDimension((EntityPlayerMP) entity, -64, entity.posX, 120, entity.posZ);
					}
				}
			}
			else
			{
				if(!(entity instanceof EntityPlayer))
				{
					TeleporterVoid.teleportToDimension(entity, 0, entity.posX, 2.2D, entity.posZ);
				}
				else
				{
					if(entity instanceof EntityPlayerMP)
					{
						TeleporterVoid.teleportToDimension((EntityPlayerMP) entity, 0, entity.posX, 2.2D, entity.posZ);
					}
				}
			}
		}
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		world.setTileEntity(pos, new TileEntityRift());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing side)
	{
		IBlockState blockstate = access.getBlockState(pos.offset(side));
		Block block = blockstate.getBlock();
		return !blockstate.isOpaqueCube() && block != ModBlocks.RIFT;
    }
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return MapColor.PURPLE;
	}
	
	@Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityRift();
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
