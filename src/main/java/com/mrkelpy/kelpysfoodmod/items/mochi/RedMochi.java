package com.mrkelpy.kelpysfoodmod.items.mochi;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class implements all the logic and features of the RedMochi item.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RedMochi extends Item {

    private static final Item.Properties itemProperties = RedMochi.buildProperties();

    public RedMochi() {
        super(itemProperties);
    }

    /**
     * Handles the creation of the item properties for this item.
     * @return [Item.Properties] The item properties.
     */
    private static Properties buildProperties() {

        Properties properties = new Properties();
        properties.food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).alwaysEat().fast().build());
        properties.tab(CreativeModeTab.TAB_FOOD);

        return properties;
    }
}