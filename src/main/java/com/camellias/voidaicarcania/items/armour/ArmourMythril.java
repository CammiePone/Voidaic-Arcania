package com.camellias.voidaicarcania.items.armour;

import java.util.List;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.Reference;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.armour.models.ModelMythrilArmour;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ArmourMythril extends ItemArmor implements IHasModel
{
	public ArmourMythril(ArmorMaterial material, int index, EntityEquipmentSlot slot, String name)
	{
		super(material, index, slot);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("\u00A77Full Set Bonus:");
		tooltip.add("   \u00A77-50% Magic Damage Taken");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped biped)
	{
		if(stack != null)
		{
			if(stack.getItem() instanceof ItemArmor)
			{
				if(slot == EntityEquipmentSlot.HEAD)
				{
					ModelMythrilArmour armourModel = ModelMythrilArmour.INSTANCE_HEAD;
					
					armourModel.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
					armourModel.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;
					
					armourModel.isSneak = biped.isSneak;
					armourModel.isRiding = biped.isRiding;
					armourModel.isChild = biped.isChild;
					armourModel.rightArmPose = biped.rightArmPose;
					armourModel.leftArmPose = biped.leftArmPose;
					
					return armourModel;
				}
				
				if(slot == EntityEquipmentSlot.CHEST)
				{
					ModelMythrilArmour armourModel = ModelMythrilArmour.INSTANCE_CHEST;
					
					armourModel.bipedBody.showModel = slot == EntityEquipmentSlot.CHEST;
					armourModel.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
					armourModel.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
					
					armourModel.isSneak = biped.isSneak;
					armourModel.isRiding = biped.isRiding;
					armourModel.isChild = biped.isChild;
					armourModel.rightArmPose = biped.rightArmPose;
					armourModel.leftArmPose = biped.leftArmPose;
					
					return armourModel;
				}
				
				if(slot == EntityEquipmentSlot.LEGS)
				{
					ModelMythrilArmour armourModel = ModelMythrilArmour.INSTANCE_LEGS;
					
					armourModel.bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS;
					armourModel.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS;

					armourModel.isSneak = biped.isSneak;
					armourModel.isRiding = biped.isRiding;
					armourModel.isChild = biped.isChild;
					armourModel.rightArmPose = biped.rightArmPose;
					armourModel.leftArmPose = biped.leftArmPose;
					
					return armourModel;
				}
				
				if(slot == EntityEquipmentSlot.FEET)
				{
					ModelMythrilArmour armourModel = ModelMythrilArmour.INSTANCE_BOOTS;
					
					armourModel.bipedRightLeg.showModel = slot == EntityEquipmentSlot.FEET;
					armourModel.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.FEET;

					armourModel.isSneak = biped.isSneak;
					armourModel.isRiding = biped.isRiding;
					armourModel.isChild = biped.isChild;
					armourModel.rightArmPose = biped.rightArmPose;
					armourModel.leftArmPose = biped.leftArmPose;
					
					return armourModel;
				}
			}
		}
		
		return null;
	}
	
	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) 
	{
		EntityEquipmentSlot head = EntityEquipmentSlot.HEAD;
		EntityEquipmentSlot body = EntityEquipmentSlot.CHEST;
		EntityEquipmentSlot legs = EntityEquipmentSlot.LEGS;
		EntityEquipmentSlot feet = EntityEquipmentSlot.FEET;
		
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if(player.getItemStackFromSlot(head).getItem() == ModItems.MYTHRIL_HELM
					&& player.getItemStackFromSlot(body).getItem() == ModItems.MYTHRIL_CHEST
					&& player.getItemStackFromSlot(legs).getItem() == ModItems.MYTHRIL_LEGS
					&& player.getItemStackFromSlot(feet).getItem() == ModItems.MYTHRIL_BOOTS
					&& event.getSource().isMagicDamage())
			{
				event.setAmount(event.getAmount() / 2.0F);
			}
		}
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
