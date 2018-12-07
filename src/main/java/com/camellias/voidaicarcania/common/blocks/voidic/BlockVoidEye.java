package com.camellias.voidaicarcania.common.blocks.voidic;

import java.util.List;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.common.entities.EntityVoidEye;
import com.camellias.voidaicarcania.init.ModBlocks;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockVoidEye extends Block implements IHasModel
{
	public static final PropertyEnum<EnumFacing.Axis> AXIS = 
			PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
	
	private BlockPattern pattern;
	
	public BlockVoidEye(String name, Material material) 
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(5.0F);
		this.setLightLevel(0.75F);
		this.setCreativeTab(Main.voidictab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(world, pos, state);
        this.trySpawnBoss(world, pos);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A78It whispers for you to place it in a temple...");
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	private void trySpawnBoss(World world, BlockPos pos)
    {
        BlockPattern.PatternHelper patternhelper = this.getPattern().match(world, pos);
        
        if (patternhelper != null)
        {
        	for (int j = 0; j < this.getPattern().getPalmLength(); ++j)
        	{
        		for (int k = 0; k < this.getPattern().getThumbLength(); ++k)
        		{
        			world.setBlockState(patternhelper.translateOffset(j, k, 0).getPos(), Blocks.AIR.getDefaultState(), 2);
        		}
        	}

        	BlockPos blockpos = patternhelper.translateOffset(1, 2, 0).getPos();
        	
        	EntityVoidEye construct = new EntityVoidEye(world);
        	construct.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 1.0D, 
     	  			(double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
     	  	world.spawnEntity(construct);

     	  	for (EntityPlayerMP entityplayermp1 : world.getEntitiesWithinAABB(EntityPlayerMP.class, 
     	  			construct.getEntityBoundingBox().grow(5.0D)))
     	  	{
     	  		CriteriaTriggers.SUMMONED_ENTITY.trigger(entityplayermp1, construct);
     	  	}

     	  	for (int j1 = 0; j1 < 120; ++j1)
     	  	{
     	  		world.spawnParticle(EnumParticleTypes.SNOWBALL, (double)blockpos.getX() + world.rand.nextDouble(), 
     	  				(double)blockpos.getY() + world.rand.nextDouble() * 3.9D, (double)blockpos.getZ() + 
     	  				world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
     	  	}

     	  	for (int k1 = 0; k1 < this.getPattern().getPalmLength(); ++k1)
     	  	{
     	  		for (int l1 = 0; l1 < this.getPattern().getThumbLength(); ++l1)
     	  		{
     	  			BlockWorldState blockworldstate1 = patternhelper.translateOffset(k1, l1, 0);
     	  			world.notifyNeighborsRespectDebug(blockworldstate1.getPos(), Blocks.AIR, false);
     	  		}
     	  	}
        }
    }
	
	protected BlockPattern getPattern()
    {
        if(this.pattern == null)
        {
            this.pattern = FactoryBlockPattern.start().aisle("~#~", "#^#", "~#~")
            		.where('^', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.BLOCK_EYE)))
            		.where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.BLOCK_CONSTRUCT)))
            		.where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return this.pattern;
    }
}
