package net.notalan.nukaadditions.worldgen;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.blocks.SlagSludgeBlock;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.DewdropDecorator;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.SapDecorator;
import com.nukateam.nukacraft.common.registery.blocks.ModBlocks;
import com.nukateam.nukacraft.common.registery.blocks.PlantBlocks;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.notalan.nukaadditions.NukaAdditionsMod;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    //region Ore Keys
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_URAN_ORE_KEY = registerKey("uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_LEAD_ORE_KEY = registerKey("lead_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TITAN_ORE_KEY = registerKey("titan_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_ALUMINIUM_ORE_KEY = registerKey("aluminium_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_ULTRACITE_ORE_KEY = registerKey("ultracite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_QUARTZ_ORE_KEY = registerKey("quartz_ore");
    //endregion

    //region Tree Keys
    public static final ResourceKey<ConfiguredFeature<?,?>> DEWDROP_TREE_KEY = registerKey("dewdrop_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> ASH_TREE_KEY = registerKey("ash_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> GLOW_TREE_KEY = registerKey("glow_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> HEAP_TREE_KEY = registerKey("heap_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> IMMORTAL_TREE_KEY = registerKey("immortal_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> RUSTY_TREE_KEY = registerKey("rusty_tree");
    //endregion

    //region Plant Keys
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_TOXIC_FERN_KEY = registerKey("patch_toxic_fern");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_DEWDROP_SAPLING_KEY = registerKey("patch_dewdrop_sapling");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_DEAD_PLANT_KEY = registerKey("patch_dead_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_GUT_FUNGI_KEY = registerKey("patch_gut_fungi");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_CRANBERRY_KEY = registerKey("patch_cranberry");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_BOGPAD_KEY = registerKey("patch_bogpad");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRANBERRY_GRASS_KEY = registerKey("cranberry_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> ASTER_PLANT_KEY = registerKey("aster_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> BROC_PLANT_KEY = registerKey("broc_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> THISTLE_PLANT_KEY = registerKey("thistle_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> SOOT_FLOWER_PLANT_KEY = registerKey("soot_flower_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> HOLLYHOCK_PLANT_KEY = registerKey("hollyhock_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> FEVER_BLOSSOM_PLANT_KEY = registerKey("fever_blossom_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRACKBERRY_BUSH_PLANT_KEY = registerKey("crackberry_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> MUTTFRUIT_BUSH_PLANT_KEY = registerKey("muttfruit_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> BRAIN_FUNGUS_PLANT_KEY = registerKey("brain_fungus_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> GLOW_FUNGUS_PLANT_KEY = registerKey("glow_fungus_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> BOMBBERRY_BUSH_PLANT_KEY = registerKey("bomberry_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> FUSFRUIT_BUSH_PLANT_KEY = registerKey("fusfruit_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> MEGAMORH_MUSH_PLANT_KEY = registerKey("megamorph_mush");
    public static final ResourceKey<ConfiguredFeature<?,?>> QUANTUMLEAF_BUSH_PLANT_KEY = registerKey("quantleaf_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> NEUTRON_BUSH_PLANT_KEY = registerKey("neutron_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> MINDFUNGUS_PLANT_KEY = registerKey("mindfungus_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_DEAD_DATURAN_KEY = registerKey("deaddaturan_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_DEAD_PUNGA_KEY = registerKey("deadpunga_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_DEAD_CORAL_KEY = registerKey("deadcoral_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_AGAVE_BUSH_KEY = registerKey("agave_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_GINS_BUSH_KEY = registerKey("gins_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_BLOODLEAF_KEY = registerKey("bloodleaf_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> RADASTER_PLANT_KEY = registerKey("radaster_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> RADROSE_PLANT_KEY = registerKey("radrose_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> BLASTCAP_PLANT_KEY = registerKey("blastcap_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> FIREFUNGI_PLANT_KEY = registerKey("firefungi_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> INVERT_PLANT_KEY = registerKey("invert_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> BOOMBLOSSOM_PLANT_KEY = registerKey("boomblossom_plant");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_XANDER_KEY = registerKey("patch_xander");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_GLOW_GRASS_KEY = registerKey("patch_glow_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_STRANGE_GRASS_KEY = registerKey("patch_strange_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_SLIT_BEANS_KEY = registerKey("patch_slit_beans");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_ASH_GRASS_KEY = registerKey("patch_ash_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_POISON_GRASS_KEY = registerKey("patch_poison_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_HEAP_GRASS_KEY = registerKey("patch_heap_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_RUSTY_BUSH_KEY = registerKey("patch_rustybush");
    public static final ResourceKey<ConfiguredFeature<?,?>> STARLIGHT_BERRY_PLANT_KEY = registerKey("starberry_plant");
    //endregion

    //region Stuff Keys
    public static final ResourceKey<ConfiguredFeature<?,?>> SCRAP_KEY = registerKey("scrap");
    public static final ResourceKey<ConfiguredFeature<?,?>> ASHSTONE_KEY = registerKey("ashstone");
    public static final ResourceKey<ConfiguredFeature<?,?>> ASHDIRT_KEY = registerKey("ashdirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> LAKE_ACID_KEY = registerKey("lake_acid");

    public static final ResourceKey<ConfiguredFeature<?,?>> PACKED_MUD_KEY = registerKey("packed_mud");
    public static final ResourceKey<ConfiguredFeature<?,?>> GRASS_BLOCK_KEY = registerKey("grass_block");
    public static final ResourceKey<ConfiguredFeature<?,?>> COARSE_DIRT_KEY = registerKey("coarse_dirt");

    public static final ResourceKey<ConfiguredFeature<?,?>> CRATER_KEY = registerKey("crater");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEBRIS_KEY = registerKey("debris");
    //endregion

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest sandReplaceable = new BlockMatchTest(Blocks.SAND);
        RuleTest grassReplaceables = new BlockMatchTest(Blocks.GRASS_BLOCK);
        RuleTest dirtReplaceables = new BlockMatchTest(Blocks.DIRT);
        RuleTest craterReplaceables = new BlockMatchTest(Blocks.COARSE_DIRT);

        //region Ores
        List<OreConfiguration.TargetBlockState> overworldUraniumOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.URANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldLeadOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.LEAD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldTitanOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.BLACK_TITAN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_BLACK_TITAN_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldAluminiumOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.ALUMINIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldUltraciteOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.ULTRACITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ULTRACITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldQuartzOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.QUARTS_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_QUARTS_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_URAN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldUraniumOres, 8));
        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 5));
        register(context, OVERWORLD_LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLeadOres, 7));
        register(context, OVERWORLD_TITAN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitanOres, 11));
        register(context, OVERWORLD_ALUMINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAluminiumOres, 4));
        register(context, OVERWORLD_ULTRACITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldUltraciteOres, 9));
        register(context, OVERWORLD_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldQuartzOres, 7));
        //endregion'

        //region Trees
        register(context, DEWDROP_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CRANBERRYWOOD.get()),
                new ForkingTrunkPlacer(5, 2, 2),

                BlockStateProvider.simple(ModBlocks.CRANBERRY_LEAVES.get()),
                new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),

                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.empty())).decorators(ImmutableList.of(new DewdropDecorator(0.4F), new DewdropDecorator(0.1F))).ignoreVines()
                .build());

        register(context, ASH_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASHWOOD.get()),
                new StraightTrunkPlacer(4, 2, 0),

                BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.empty())).ignoreVines()
                .build());

        register(context, GLOW_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASHWOOD.get()),
                new StraightTrunkPlacer(1, 1, 0),

                BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new SapDecorator(0.1F))).ignoreVines()
                .build());

        register(context, HEAP_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASHWOOD.get()),
                new StraightTrunkPlacer(1, 1, 0),

                BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines()
                .build());

        register(context, IMMORTAL_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASHWOOD.get()),
                new StraightTrunkPlacer(5, 2, 1),

                BlockStateProvider.simple(ModBlocks.EVERGREEN_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)),

                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines()
                .build());

        register(context, RUSTY_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASHWOOD.get()),
                new StraightTrunkPlacer(4, 2, 1),

                BlockStateProvider.simple(ModBlocks.RUSTY_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(0, 2), UniformInt.of(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines()
                .build());
        //endregion

        //region Plants
        register(context, PATCH_TOXIC_FERN_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.TOXICFERN.get()).defaultBlockState(), 1)), 15));
        register(context, PATCH_DEWDROP_SAPLING_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.DEWDROP_SAPLING.get()).defaultBlockState(), 2)), 25));
        register(context, PATCH_DEAD_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.DEAD_PLANT.get()).defaultBlockState(), 1)), 50));
        register(context, PATCH_GUT_FUNGI_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.GUT_SHROOM.get()).defaultBlockState(), 1)), 10));
        register(context, PATCH_CRANBERRY_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.CRANBERRY.get()).defaultBlockState(), 3)), 40));
        register(context, PATCH_BOGPAD_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(12, 8, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(PlantBlocks.BOG_PAD.get())))));
        register(context, CRANBERRY_GRASS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.CRANBERRY_GRASS.get()), 19));
        register(context, ASTER_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.ASTER.get()).defaultBlockState(), 1)), 30));
        register(context, BROC_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.BROC.get()).defaultBlockState(), 1)), 20));
        register(context, THISTLE_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.THISTLE.get()).defaultBlockState(), 3).add((PlantBlocks.ASHGRASS.get()).defaultBlockState(), 7)), 20));
        register(context, SOOT_FLOWER_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.SOOT_FLOWER.get()).defaultBlockState(), 1)), 20));
        register(context, HOLLYHOCK_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.HOLLYHOCK.get()).defaultBlockState(), 1)), 20));
        register(context, FEVER_BLOSSOM_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.FEVERBLOSSOM.get()).defaultBlockState(), 1)), 20));
        register(context, CRACKBERRY_BUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.CRACKBERRY_BUSH.get()).defaultBlockState(), 1)), 15));
        register(context, MUTTFRUIT_BUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.MUTTFRUIT_BUSH.get()).defaultBlockState(), 1)), 10));
        register(context, BRAIN_FUNGUS_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.BRAINFUNGUS.get()).defaultBlockState(), 1)), 20));
        register(context, GLOW_FUNGUS_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.GLOWFUNGUS.get()).defaultBlockState(), 3)), 10));
        register(context, BOMBBERRY_BUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.BOMBBERRY_BUSH.get()).defaultBlockState(), 1)), 10));
        register(context, FUSFRUIT_BUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.FUSFRUIT_BUSH.get()).defaultBlockState(), 1)), 8));
        register(context, MEGAMORH_MUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.MEGA_HATTER_FUNGI.get()).defaultBlockState(), 1)), 12));
        register(context, QUANTUMLEAF_BUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.QUANTUM_LEAF_BUSH.get()).defaultBlockState(), 1)), 10));
        register(context, NEUTRON_BUSH_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.NEUTRON_BUSH.get()).defaultBlockState(), 1)), 10));
        register(context, MINDFUNGUS_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.MINDFUNGUS.get()).defaultBlockState(), 1)), 10));
        register(context, PATCH_DEAD_DATURAN_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.DEAD_DATURAN.get()), 2));
        register(context, PATCH_DEAD_PUNGA_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.DEAD_PUNGA.get()), 2));
        register(context, PATCH_DEAD_CORAL_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.DEAD_CORALLEAF.get()), 1));
        register(context, PATCH_AGAVE_BUSH_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.AGAVE.get()), 1));
        register(context, PATCH_GINS_BUSH_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.GINSENG.get()), 1));
        register(context, PATCH_BLOODLEAF_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.BLOOD_LEAF_BUSH.get()), 1));
        register(context, RADASTER_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.RADASTER.get()).defaultBlockState(), 1)), 30));
        register(context, RADROSE_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.RADROSE.get()).defaultBlockState(), 1)), 20));
        register(context, BLASTCAP_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.BLASTCAP.get()).defaultBlockState(), 1)), 20));
        register(context, FIREFUNGI_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.FIREMUSHROOM.get()).defaultBlockState(), 1)), 18));
        register(context, INVERT_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.INVERT.get()).defaultBlockState(), 1)), 10));
        register(context, BOOMBLOSSOM_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.BOOMBLOSSOM.get()).defaultBlockState(), 1)), 30));
        register(context, PATCH_XANDER_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.ZANDER.get()), 1));
        register(context, PATCH_GLOW_GRASS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.GLOW_GRASS.get()), 36));
        register(context, PATCH_STRANGE_GRASS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.STRANGE_GRASS.get()), 33));
        register(context, PATCH_SLIT_BEANS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.SILT_BEAN_BUSH.get()), 1));
        register(context, PATCH_ASH_GRASS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.ASHGRASS.get()), 32));
        register(context, PATCH_POISON_GRASS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.POISON_GRASS.get()), 66));
        register(context, PATCH_HEAP_GRASS_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.HEAP_GRASS.get()), 26));
        register(context, PATCH_RUSTY_BUSH_KEY, Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(PlantBlocks.RUSTY_BUSH.get()), 12));
        register(context, STARLIGHT_BERRY_PLANT_KEY, Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add((PlantBlocks.STARBERRY.get()).defaultBlockState(), 2)), 31));


        //endregion

        //region Stuff
        register(context, SCRAP_KEY, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(
                BlockStateProvider.simple((ModBlocks.SCRAP_BLOCK.get()).defaultBlockState()),
                List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState())))),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK), UniformInt.of(1, 1), 1));

        register(context, ASHSTONE_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration((ModBlocks.ASHSTONE.get()).defaultBlockState()));

        register(context, ASHDIRT_KEY, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(
                BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState().setValue(SlagSludgeBlock.LAYERS, 8)),
                List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState().setValue(SlagSludgeBlock.LAYERS, 8))))),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK), UniformInt.of(1, 2), 2));

        register(context, LAKE_ACID_KEY, Feature.LAKE, new LakeFeature.Configuration(
                BlockStateProvider.simple((ModFluids.ACID_FLUID.get()).defaultFluidState().createLegacyBlock()),
                BlockStateProvider.simple((ModBlocks.ACID_DIRT.get()).defaultBlockState())));

        register(context, PACKED_MUD_KEY, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(
                BlockStateProvider.simple((Blocks.PACKED_MUD).defaultBlockState()),
                List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                        BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState())))),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND, Blocks.PACKED_MUD, Blocks.COARSE_DIRT), UniformInt.of(3, 6), 3));

        register(context, GRASS_BLOCK_KEY, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(
                BlockStateProvider.simple((Blocks.GRASS_BLOCK).defaultBlockState()),
                List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                        BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState())))),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND, Blocks.PACKED_MUD, Blocks.COARSE_DIRT), UniformInt.of(3, 6), 2));

        register(context, COARSE_DIRT_KEY, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(
                BlockStateProvider.simple((Blocks.COARSE_DIRT).defaultBlockState()),
                List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                        BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState())))),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND, Blocks.PACKED_MUD, Blocks.COARSE_DIRT), UniformInt.of(3, 6), 3));

        //register(context, CRATER_KEY, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(
        //        BlockStateProvider.simple((Blocks.AIR).defaultBlockState()),
        //        List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
        //                BlockStateProvider.simple((ModBlocks.ASH_DIRT.get()).defaultBlockState())))),
        //        BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND, Blocks.PACKED_MUD, Blocks.COARSE_DIRT), UniformInt.of(12, 24), 6));

        register(context, DEBRIS_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(40, 10, 1, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.WHITE_STEEL.get().defaultBlockState(), 3)
                        .add(ModBlocks.WHITE_STEEL_COLUMN.get().defaultBlockState(), 3)
                        .add(ModBlocks.BLACKSTEEL.get().defaultBlockState(), 3)
                        .add(ModBlocks.BLACK_STEEL_SLAB.get().defaultBlockState(), 3)
                        .add(ModBlocks.BLACKSTEEL_STAIRS.get().defaultBlockState(), 3)
                        .add(ModBlocks.BLUESTEEL.get().defaultBlockState(), 3)
                        .add(ModBlocks.REDSTEEL.get().defaultBlockState(), 3)
                        .add(ModBlocks.GREENSTEEL.get().defaultBlockState(), 3)
                        .add(ModBlocks.YELLOW_STEEL.get().defaultBlockState(), 3)
                        .add(ModBlocks.YELLOWSTEEL_COLUMN.get().defaultBlockState(), 3)
                        .add(ModBlocks.WHITEBRICKS.get().defaultBlockState(), 3)
                        .add(ModBlocks.CRACKED_WHITE_BRICKS.get().defaultBlockState(), 3)
                        .add(ModBlocks.WHITEBRICKS_STAIRS.get().defaultBlockState(), 3)
                        .add(ModBlocks.CRACKED_WHITE_BRICKS_STAIRS.get().defaultBlockState(), 3)
                        .add(net.notalan.nukaadditions.block.ModBlocks.ASPHALT.get().defaultBlockState(), 3)
                        .add(net.notalan.nukaadditions.block.ModBlocks.ASPHALT_EDGE.get().defaultBlockState(), 3)
                        .add(net.notalan.nukaadditions.block.ModBlocks.ASPHALT_CENTER.get().defaultBlockState(), 3)
                        .add(net.notalan.nukaadditions.block.ModBlocks.STEEL_PLATING.get().defaultBlockState(), 3)
                        .add(net.notalan.nukaadditions.block.ModBlocks.STEEL_PANEL.get().defaultBlockState(), 3)
                        .add(Blocks.COBBLESTONE.defaultBlockState(), 3)
                        .add(Blocks.GRAY_CONCRETE.defaultBlockState(), 3)
                        .add(Blocks.WHITE_CONCRETE.defaultBlockState(), 3)
                        .add(Blocks.GREEN_CONCRETE.defaultBlockState(), 3)
                        .add(Blocks.BRICKS.defaultBlockState(), 3)
                        .add(Blocks.BRICK_STAIRS.defaultBlockState(), 3)
                        .add(Blocks.BRICK_SLAB.defaultBlockState(), 3))),
                BlockPredicate.allOf(BlockPredicate.solid(), BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.COARSE_DIRT))))));
        //endregion
    }

    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
