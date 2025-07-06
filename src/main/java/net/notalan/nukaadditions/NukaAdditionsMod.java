package net.notalan.nukaadditions;

import com.mojang.logging.LogUtils;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.notalan.nukaadditions.block.ModBlocks;
import net.notalan.nukaadditions.block.entity.ModBlockEntities;
import net.notalan.nukaadditions.item.ModBannerPatterns;
import net.notalan.nukaadditions.item.ModCreativeModeTabs;
import net.notalan.nukaadditions.item.ModItems;
import net.notalan.nukaadditions.recipe.ModRecipes;
import net.notalan.nukaadditions.screen.ChemBenchScreen;
import net.notalan.nukaadditions.screen.ModMenuTypes;
import net.notalan.nukaadditions.screen.ScrapBenchScreen;
import net.notalan.nukaadditions.worldgen.biome.surface.ModSurfaceRules;
import net.notalan.nukaadditions.worldgen.biome.ModTerrablender;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NukaAdditionsMod.MOD_ID)
public class NukaAdditionsMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "nukaadditions";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public NukaAdditionsMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBannerPatterns.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModTerrablender.registerBiomes();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            //Regions.register(new TestRegion1(ResourceLocation.fromNamespaceAndPath(MOD_ID, "overworld_1"), 2));
            //Regions.register(new TestRegion2(ResourceLocation.fromNamespaceAndPath(MOD_ID, "overworld_2"), 2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        /*

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.MORA);
            event.accept(ModItems.CHEESECAT);
        }

         */
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            Block newBlock = new RadioactiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE).lightLevel((state) -> 5), 0.1f);

            Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath("nukacraft", "raw_uranium_block"), newBlock);
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.SCRAP_BENCH_MENU.get(), ScrapBenchScreen::new);
            MenuScreens.register(ModMenuTypes.CHEM_BENCH_MENU.get(), ChemBenchScreen::new);
        }
    }
}
