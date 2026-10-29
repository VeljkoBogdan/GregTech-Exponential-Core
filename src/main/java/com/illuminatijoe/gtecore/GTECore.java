package com.illuminatijoe.gtecore;

import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLModContainer;

import com.illuminatijoe.gtecore.data.GTECoreRecipeTypes;
import com.illuminatijoe.gtecore.data.machines.GTEMachines;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is the common (client + server) entrypoint for your mod.<br>
 * Most content should be initialised here.<br>
 * Anything which exists exclusively on the client (e.g. renderers) should be initialised in {@link ExampleModClient}
 * instead.
 */
@Mod(GTECore.MOD_ID)
public class GTECore {

    public static final String MOD_ID = "gtecore";
    public static final Logger LOGGER = LogManager.getLogger();
    public static GTRegistrate GTE_REGISTRATE = GTRegistrate.create(GTECore.MOD_ID);

    public GTECore(IEventBus modBus, FMLModContainer container) {
        GTECoreRecipeTypes.init();
        GTEMachines.init();
    }

    /**
     * Create a ResourceLocation in the format "modid:path"
     *
     * @param path path
     * @return ResourceLocation with the namespace of your mod
     */
    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @SubscribeEvent
    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    private void clientSetup(final FMLClientSetupEvent event) {}

    /**
     * (Optional) Used to modify pre-existing materials from GregTech
     * 
     * @param event
     */
    @SubscribeEvent
    private void modifyMaterials(PostMaterialEvent event) {
        // CustomMaterials.modify();
    }
}
