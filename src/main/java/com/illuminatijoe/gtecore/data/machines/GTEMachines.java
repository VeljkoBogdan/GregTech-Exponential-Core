package com.illuminatijoe.gtecore.data.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.registry.registrate.entry.MachineEntry;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.mui.GTSingleblockMachinePanels;

import net.minecraft.network.chat.Component;

import com.illuminatijoe.gtecore.GTECore;
import com.illuminatijoe.gtecore.data.GTECoreRecipeTypes;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.genericGeneratorTankSizeFunction;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerTieredMachines;
import static net.minecraft.util.CommonColors.GRAY;

public class GTEMachines {

    public static final MachineEntry<MachineDefinition>[] BIOMASS_BURNER = registerTieredMachines(
            GTECore.GTE_REGISTRATE, "biomass_burner",
            (holder, tier) -> new SimpleGeneratorMachine(holder, tier, 0.1f, genericGeneratorTankSizeFunction),
            (tier, builder) -> builder.langValue("%s Biomass Burner %s".formatted(VLVH[tier], VLVT[tier]))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GTECoreRecipeTypes.BIOMASS_BURNING)
                    .ui(GTSingleblockMachinePanels.GENERAL_MACHINE)
                    .recipeModifier(SimpleGeneratorMachine::recipeModifier, true)
                    .addOutputLimit(ItemRecipeCapability.CAP, 0)
                    .addOutputLimit(FluidRecipeCapability.CAP, 0)
                    .workableTieredHullModel(GTCEu.id("block/machines/electric_furnace"))
                    .tooltips(Component.literal("Satisfactory!").withColor(GRAY))
                    .register(),
            GTValues.tiersBetween(LV, HV));

    public static final MachineEntry<MachineDefinition>[] COAL_GENERATOR = registerTieredMachines(
            GTECore.GTE_REGISTRATE, "coal_generator",
            (holder, tier) -> new SimpleGeneratorMachine(holder, tier, 0.1f, genericGeneratorTankSizeFunction),
            (tier, builder) -> builder.langValue("%s Coal Generator %s".formatted(VLVH[tier], VLVT[tier]))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GTECoreRecipeTypes.COAL_BURNING)
                    .ui(GTSingleblockMachinePanels.GENERAL_MACHINE)
                    .recipeModifier(SimpleGeneratorMachine::recipeModifier, true)
                    .addOutputLimit(ItemRecipeCapability.CAP, 0)
                    .addOutputLimit(FluidRecipeCapability.CAP, 0)
                    .workableTieredHullModel(GTCEu.id("block/generators/boiler/coal"))
                    .tooltips(Component.literal("Nothing beats the old fashioned").withColor(GRAY))
                    .register(),
            GTValues.tiersBetween(LV, HV));

    public static void init() {}
}
