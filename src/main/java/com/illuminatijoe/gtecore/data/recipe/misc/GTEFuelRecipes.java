package com.illuminatijoe.gtecore.data.recipe.misc;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import com.illuminatijoe.gtecore.GTECore;

import static com.illuminatijoe.gtecore.data.GTECoreRecipeTypes.BIOMASS_BURNING;
import static com.illuminatijoe.gtecore.data.GTECoreRecipeTypes.COAL_BURNING;

public class GTEFuelRecipes {

    public static void init(RecipeOutput provider) {
        bio(provider, "dried_kelp", Items.DRIED_KELP, 200);
        bio(provider, "dried_kelp_block", Items.DRIED_KELP_BLOCK, 4000);
        bio(provider, "stick", Items.STICK, 100);
        bio(provider, "bamboo", Items.BAMBOO, 50);
        bio(provider, "saplings", ItemTags.SAPLINGS, 100);
        bio(provider, "planks", ItemTags.PLANKS, 300);
        bio(provider, "logs", ItemTags.LOGS, 300);
        bio(provider, "seeds", Tags.Items.SEEDS, 40);
        bio(provider, "fruits", Tags.Items.FOODS_FRUIT, 240);
        bio(provider, "vegetables", Tags.Items.FOODS_VEGETABLE, 200);

        coal(provider, "coals", ItemTags.COALS, 1600);
        coal(provider, "coal_block", Items.COAL_BLOCK, 16000);
        coal(provider, "blaze_rod", Items.BLAZE_ROD, 2400);
    }

    private static void bio(RecipeOutput provider, String name, TagKey<Item> tag, int ticks) {
        BIOMASS_BURNING.recipeBuilder(GTECore.id("biomass_burning_" + name))
                .inputItems(tag)
                .EUt(-32)
                .duration(ticks)
                .save(provider);
    }

    private static void bio(RecipeOutput provider, String name, ItemLike item, int ticks) {
        BIOMASS_BURNING.recipeBuilder(GTECore.id("biomass_burning_" + name))
                .inputItems(new ItemStack(item))
                .EUt(-32)
                .duration(ticks)
                .save(provider);
    }

    private static void coal(RecipeOutput provider, String name, ItemLike item, int ticks) {
        COAL_BURNING.recipeBuilder(GTECore.id("coal_burning_" + name))
                .inputItems(new ItemStack(item))
                .EUt(-32)
                .duration(ticks)
                .save(provider);
    }

    private static void coal(RecipeOutput provider, String name, TagKey<Item> tag, int ticks) {
        COAL_BURNING.recipeBuilder(GTECore.id("coal_burning_" + name))
                .inputItems(tag)
                .EUt(-32)
                .duration(ticks)
                .save(provider);
    }
}
