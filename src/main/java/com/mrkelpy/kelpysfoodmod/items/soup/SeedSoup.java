package com.mrkelpy.kelpysfoodmod.items.soup;

import com.mrkelpy.kelpysfoodmod.utils.ItemUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class implements all the logic and features of the SeedSoup item.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SeedSoup extends Item {

    private static final Item.Properties itemProperties = SeedSoup.buildProperties();

    public SeedSoup() {
        super(itemProperties);
    }

    /**
     * Handles the creation of the item properties for this item.
     * @return [Item.Properties] The item properties.
     */
    private static Properties buildProperties() {

        Properties properties = new Properties();
        properties.food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build());
        properties.tab(CreativeModeTab.TAB_FOOD);

        return properties;
    }


    /**
     * Expands upon the behaviour of the finishUsingItem method to give a stick back to the player
     * after finishing eating a Seed Soup.
     * @param itemStack The ItemStack of the Seed Soup.
     * @param world The level where the item was used.
     * @param livingEntity The entity that finished using the item
     * @return [ItemStack]
     */
    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity livingEntity) {

        if (!world.isClientSide() && livingEntity instanceof ServerPlayer serverplayer)
            ItemUtils.giveItem(new ItemStack(Items.BOWL), serverplayer);

        return super.finishUsingItem(itemStack, world, livingEntity);
    }
}
