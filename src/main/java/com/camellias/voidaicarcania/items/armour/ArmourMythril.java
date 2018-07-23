package com.camellias.voidaicarcania.items.armour;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.init.ModItems;
import com.camellias.voidaicarcania.items.armour.models.ModelMythrilArmour;
import com.camellias.voidaicarcania.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped biped)
	{
		ModelMythrilArmour armourModel = ModelMythrilArmour.INSTANCE;
		
		if(stack != null)
		{
			if(stack.getItem() instanceof ItemArmor)
			{
				armourModel.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
				armourModel.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;
				
				armourModel.bipedBody.showModel = (slot == EntityEquipmentSlot.CHEST) || (slot == EntityEquipmentSlot.CHEST);
				armourModel.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
				armourModel.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
				
				armourModel.bipedRightLeg.showModel = (slot == EntityEquipmentSlot.LEGS) || (slot == EntityEquipmentSlot.FEET);
				armourModel.bipedLeftLeg.showModel = (slot == EntityEquipmentSlot.LEGS) || (slot == EntityEquipmentSlot.FEET);

				armourModel.isSneak = biped.isSneak;
				armourModel.isRiding = biped.isRiding;
				armourModel.isChild = biped.isChild;
				armourModel.rightArmPose = biped.rightArmPose;
				armourModel.leftArmPose = biped.leftArmPose;

				return armourModel;
			}
		}
		
		return armourModel;
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
