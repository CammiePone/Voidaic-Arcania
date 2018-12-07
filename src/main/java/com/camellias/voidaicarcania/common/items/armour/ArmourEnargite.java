package com.camellias.voidaicarcania.common.items.armour;

import com.camellias.voidaicarcania.Main;
import com.camellias.voidaicarcania.client.models.ModelEnargiteArmour;
import com.camellias.voidaicarcania.init.ModItems;
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
		this.setCreativeTab(Main.voidictab);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped biped)
	{
		if(stack != ItemStack.EMPTY)
		{
			if(stack.getItem() instanceof ItemArmor)
			{
				ModelEnargiteArmour armourModel = new ModelEnargiteArmour(slot);
				
				armourModel.isSneak = biped.isSneak;
				armourModel.isRiding = biped.isRiding;
				armourModel.isChild = biped.isChild;
				armourModel.rightArmPose = biped.rightArmPose;
				armourModel.leftArmPose = biped.leftArmPose;
				
				return armourModel;
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
