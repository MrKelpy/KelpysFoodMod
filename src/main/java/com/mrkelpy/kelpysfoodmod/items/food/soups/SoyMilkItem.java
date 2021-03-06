package com.mrkelpy.kelpysfoodmod.items.food.soups;

import com.mrkelpy.kelpysfoodmod.setup.Registration;
import com.mrkelpy.kelpysfoodmod.utils.ItemUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class implements all the logic and features of the SoyMilk item.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SoyMilkItem extends Item {

    private static final Properties itemProperties = SoyMilkItem.buildProperties();

    public SoyMilkItem() {
        super(itemProperties);
    }

    /**
     * Handles the creation of the item properties for this item.
     * @return [Item.Properties] The item properties.
     */
    private static Properties buildProperties() {

        Properties properties = new Properties();
        properties.food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).alwaysEat().build());
        properties.tab(Registration.CUSTOM_TAB_ITEMS);
        properties.stacksTo(1);
        properties.craftRemainder(Items.BUCKET);

        return properties;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }


    /**
     * Expands upon the behaviour of the finishUsingItem method to give a stick back to the player
     * after finishing drinking the Soy Milk.
     * @param itemStack The ItemStack of the Soy Milk.
     * @param world The level where the item was used.
     * @param livingEntity The entity that finished using the item
     * @return [ItemStack]
     */
    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity livingEntity) {

        if (!world.isClientSide() && livingEntity instanceof ServerPlayer serverplayer) {
            ItemUtils.giveItem(new ItemStack(Items.BUCKET), serverplayer);
        }

        return super.finishUsingItem(itemStack, world, livingEntity);
    }
}
