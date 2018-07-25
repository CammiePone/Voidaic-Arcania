package com.camellias.voidaicarcania.items.armour;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.armour.models.ModelEnargiteArmour;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmourEnargite extends ItemArmor implements IHasModel
{
	public ArmourEnargite(ArmorMaterial material, int index, EntityEquipmentSlot slot, String name)
	{
		super(material, index, slot);
		
		this.setUnlocalizedName(name);         
		this.setRegistryName(name);
		this.setCreativeTab(Main.metaltab);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
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
					ModelEnargiteArmour armourModel = ModelEnargiteArmour.INSTANCE_HEAD;
					
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
					ModelEnargiteArmour armourModel = ModelEnargiteArmour.INSTANCE_CHEST;
					
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
					ModelEnargiteArmour armourModel = ModelEnargiteArmour.INSTANCE_LEGS;
					
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
					ModelEnargiteArmour armourModel = ModelEnargiteArmour.INSTANCE_BOOTS;
					
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
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
