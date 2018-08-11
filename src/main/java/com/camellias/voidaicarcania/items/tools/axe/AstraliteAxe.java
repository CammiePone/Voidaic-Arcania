package com.camellias.voidaicarcania.items.tools.axe;

import java.util.Set;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class AstraliteAxe extends ItemTool implements IHasModel
{
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, 
			Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, 
			Blocks.WOODEN_PRESSURE_PLATE);
	
	public AstraliteAxe(String name, ToolMaterial material)
	{
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.metaltab);
		
		this.attackSpeed = -3.0F;
		this.attackDamage = 8.0F;
		
		ModItems.ITEMS.add(this);
	}
	
	@SubscribeEvent
	public static void onAttack(AttackEntityEvent event)
	{
		EntityPlayer player = event.getEntityPlayer();
		EntityLivingBase target = (EntityLivingBase) event.getTarget();
		
		if(player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ModItems.ASTRALITE_AXE)
		{
			target.motionY = 1.0D;
			
			System.out.println("Astralite Battleaxe Attack");
		}
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 
        		super.getDestroySpeed(stack, state) : this.efficiency;
    }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
