package com.camellias.voidaicarcania.common.items.baubles.body;

import java.util.List;
import java.util.UUID;

import org.lwjgl.opengl.GL11;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.client.models.ModelCloak;
import com.camellias.voidaicarcania.common.entities.EntityVoidHeartPassive;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.util.IHasModel;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlightCloak extends Item implements IHasModel, IBauble, IRenderBauble
{
	@SideOnly(Side.CLIENT)
	private static ModelCloak model;
	
	public ItemFlightCloak(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.voidictab);
		this.maxStackSize = 1;
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A74Inert");
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity, EnumHand hand)
	{
		if(entity.world.isRemote)
		{
			return false;
		}
		
		if(entity instanceof EntityVoidHeartPassive)
		{
			entity.setDead();
			player.addItemStackToInventory(new ItemStack(ModItems.A_FLIGHT_CLOAK));
			stack.shrink(1);
			
			return true;
		}
		
		return false;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) 
	{
		return BaubleType.BODY;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) 
	{
		if(!world.isRemote) 
		{
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			
			for(int i = 0; i < baubles.getSlots(); i++) 
			{
				if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && 
						baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) 
				{
					baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
					
					if(!player.capabilities.isCreativeMode)
					{
						player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					}
					onEquipped(player.getHeldItem(hand), player);
					break;
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks)
	{
		if (type == RenderType.BODY)
		{
			if (model == null)
			{
				model = new ModelCloak();
			}
			
			GL11.glPushMatrix();
			IRenderBauble.Helper.rotateIfSneaking(player);
			
			if(player.isSprinting())
			{
				GlStateManager.translate(0F, 0F, 0F);
				GlStateManager.rotate(90F / (float) Math.PI, 1.0F, 0.0F, 0.0F);
			}
			
			if(player.hasItemInSlot(EntityEquipmentSlot.CHEST))
			{
				GlStateManager.translate(0F, -0.1F, 0F);
				GlStateManager.scale(1.1F, 1.1F, 1.1F);
			}
			
			GL11.glRotated(180, 1, 0, 0);
			GL11.glTranslated(0, 0, 0.02);
			GL11.glScaled(0.12, 0.12, 0.12);
			IRenderBauble.Helper.translateToChest();
			IRenderBauble.Helper.defaultTransforms();
			
			model.render(player, player.limbSwing, player.limbSwingAmount, player.ticksExisted, player.rotationYaw, player.rotationPitch, 1);
			
			GL11.glPopMatrix();
		}
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
