package com.illuminatijoe.gtecore.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.registry.registrate.builder.GTRecipeTypeBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.entry.GTRecipeTypeEntry;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;

import com.illuminatijoe.gtecore.GTECore;
import com.tterrag.registrate.providers.ProviderType;

public class GTECoreRecipeTypes {

    private static GTRecipeTypeBuilder recipeType(String id, String group) {
        return GTECore.GTE_REGISTRATE.recipeType(id, group).setData(ProviderType.LANG, (ctx, prov) -> {});
    }

    public static final GTRecipeTypeEntry BIOMASS_BURNING = recipeType("biomass_burning", GTRecipeTypes.GENERATOR)
            .setMaxIOSize(1, 1, 0, 0)
            .UI(b -> b.setProgressBar(GTGuiTextures.PROGRESS_ARROW))
            .setEUIO(IO.OUT)
            .setSound(GTSoundEntries.FURNACE)
            .register();

    public static GTRecipeTypeEntry COAL_BURNING = recipeType("coal_burning", GTRecipeTypes.GENERATOR)
            .setMaxIOSize(1, 1, 0, 0)
            .UI(b -> b.setProgressBar(GTGuiTextures.PROGRESS_ARROW))
            .setEUIO(IO.OUT)
            .setSound(GTSoundEntries.FURNACE)
            .register();

    public static void init() {}
}
