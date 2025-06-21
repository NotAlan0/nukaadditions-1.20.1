package net.notalan.nukaadditions.worldgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.notalan.nukaadditions.NukaAdditionsMod;

import java.util.List;

public class ModPlacedFeatures {
    //region Ore Keys
    public static final ResourceKey<PlacedFeature> URAN_ORE_PLACED_KEY = registerKey("uranium_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<PlacedFeature> TITAN_ORE_PLACED_KEY = registerKey("titan_ore_placed");
    public static final ResourceKey<PlacedFeature> ALUMINIUM_ORE_PLACED_KEY = registerKey("aluminium_ore_placed");
    public static final ResourceKey<PlacedFeature> ULTRACITE_ORE_PLACED_KEY = registerKey("ultracite_ore_placed");
    public static final ResourceKey<PlacedFeature> QUARTZ_ORE_PLACED_KEY = registerKey("quartz_ore_placed");
    //endregion

    //region Tree Keys
    public static final ResourceKey<PlacedFeature> DEWDROP_TREE_PLACED_KEY = registerKey("dewdrop_tree_placed");
    public static final ResourceKey<PlacedFeature> ASH_TREE_PLACED_KEY = registerKey("ash_tree_placed");
    public static final ResourceKey<PlacedFeature> GLOW_TREE_PLACED_KEY = registerKey("glow_tree_placed");
    public static final ResourceKey<PlacedFeature> HEAP_TREE_PLACED_KEY = registerKey("heap_tree_placed");
    public static final ResourceKey<PlacedFeature> IMMORTAL_TREE_PLACED_KEY = registerKey("immortal_tree_placed");
    public static final ResourceKey<PlacedFeature> RUSTY_TREE_PLACED_KEY = registerKey("rusty_tree_placed");
    //endregion

    //region Plant Keys
    public static final ResourceKey<PlacedFeature> PATCH_TOXIC_FERN_PLACED_KEY = registerKey("patch_toxic_fern_placed");
    public static final ResourceKey<PlacedFeature> PATCH_DEWDROP_SAPLING_PLACED_KEY = registerKey("patch_dewdrop_sapling_placed");
    public static final ResourceKey<PlacedFeature> PATCH_DEAD_PLANT_PLACED_KEY = registerKey("patch_dead_plant_placed");
    public static final ResourceKey<PlacedFeature> PATCH_GUT_FUNGI_PLACED_KEY = registerKey("patch_gut_fungi_placed");
    public static final ResourceKey<PlacedFeature> PATCH_CRANBERRY_PLACED_KEY = registerKey("patch_cranberry_placed");
    public static final ResourceKey<PlacedFeature> PATCH_BOGPAD_PLACED_KEY = registerKey("patch_bogpad_placed");
    public static final ResourceKey<PlacedFeature> CRANBERRY_GRASS_PLACED_KEY = registerKey("cranberry_grass_placed");
    public static final ResourceKey<PlacedFeature> PATCH_FUSION_FRUIT_PLACED_KEY= registerKey("patch_fusion_fruit_place");
    public static final ResourceKey<PlacedFeature> PATCH_MEGA_HATTER_PLACED_KEY= registerKey("patch_mega_hatter_place");
    public static final ResourceKey<PlacedFeature> PATCH_ASTER_PLANT_PLACED_KEY= registerKey("patch_aster_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BROC_PLANT_PLACED_KEY= registerKey("patch_broc_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_COMMON_BERRY_BUSH1_PLACED_KEY= registerKey("patch_common_berry_bush1");
    public static final ResourceKey<PlacedFeature> PATCH_COMMON_BERRY_BUSH2_PLACED_KEY= registerKey("patch_common_berry_bush2");
    public static final ResourceKey<PlacedFeature> PATCH_COMMON_BERRY_BUSH3_PLACED_KEY= registerKey("patch_common_berry_bush3");
    public static final ResourceKey<PlacedFeature> PATCH_THISTLE_PLANT_PLACED_KEY= registerKey("patch_thistle_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_SOOT_FLOWER_PLANT_PLACED_KEY= registerKey("patch_soot_flower_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_HOLLYHOCK_PLANT_PLACED_KEY= registerKey("patch_hollyhock_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_FEVER_BLOSSOM_PLANT_PLACED_KEY= registerKey("patch_fever_blossom_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_CRACKBERRY_BUSH_PLACED_KEY= registerKey("patch_crackberry_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_MUTTFRUIT_BUSH_PLACED_KEY= registerKey("patch_muttfruit_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BRAIN_FUNGUS_PLACED_KEY= registerKey("patch_brain_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_GLOW_FUNGUS_PLACED_KEY= registerKey("patch_glow_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOMB_BERRY_BUSH_PLACED_KEY= registerKey("patch_bomb_berry_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_QUANTUM_LEAF_BUSH_PLACED_KEY= registerKey("patch_quantum_leaf_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_NEUTRON_BUSH_PLACED_KEY= registerKey("patch_neutron_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_MIND_FUNGUS_PLACED_KEY= registerKey("patch_mind_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_RADASTER_PLANT_PLACED_KEY= registerKey("patch_radaster_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_RADROSE_PLANT_PLACED_KEY= registerKey("patch_radrose_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BLAST_CAP_PLACED_KEY= registerKey("patch_blast_cap_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_FIRE_FUNGI_PLACED_KEY= registerKey("patch_fire_fungi_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_INVERT_PLANT_PLACED_KEY= registerKey("patch_invert_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOOM_BLOSSOM_PLANT_PLACED_KEY= registerKey("patch_boom_blossom_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_STARLIGHT_BERRY_PLACED_KEY= registerKey("patch_starlight_berry");
    public static final ResourceKey<PlacedFeature> PATCH_GINS_PLACED_KEY= registerKey("patch_gins_common");
    public static final ResourceKey<PlacedFeature> PATCH_DATURANA_PLACED_KEY= registerKey("patch_daturana_common");
    public static final ResourceKey<PlacedFeature> PATCH_PUNGA_PLACED_KEY= registerKey("patch_punga_common");
    public static final ResourceKey<PlacedFeature> PATCH_CORAL_PLACED_KEY= registerKey("patch_coral_common");
    public static final ResourceKey<PlacedFeature> PATCH_AGAVE_RARE_PLACED_KEY= registerKey("patch_agave_common");
    public static final ResourceKey<PlacedFeature> PATCH_SLIT_BEAN_BUSH_PLACED_KEY= registerKey("patch_slit_bean_bush");
    public static final ResourceKey<PlacedFeature> PATCH_BLOOD_LEAF_PLACED_KEY= registerKey("patch_blood_leaf_common");
    public static final ResourceKey<PlacedFeature> PATCH_ZANDER_PLACED_KEY= registerKey("patch_zander");
    public static final ResourceKey<PlacedFeature> PATCH_RUSTY_BUSH_PLACED_KEY= registerKey("patch_rusty_bush");
    public static final ResourceKey<PlacedFeature> ASH_GRASS_PLACED_KEY= registerKey("ash_grass");
    public static final ResourceKey<PlacedFeature> STRANGE_GRASS_PLACED_KEY= registerKey("strange_grass");
    public static final ResourceKey<PlacedFeature> POISON_GRASS_PLACED_KEY= registerKey("poison_grass");
    public static final ResourceKey<PlacedFeature> GRASS_ASH_PLACED_KEY= registerKey("grass_ash");
    public static final ResourceKey<PlacedFeature> GLOW_GRASS_PLACED_KEY= registerKey("glow_grass");
    public static final ResourceKey<PlacedFeature> HEAP_GRASS_PLACED_KEY= registerKey("heap_grass");
    public static final ResourceKey<PlacedFeature> RUSTY_BUSH_PLACED_KEY= registerKey("rusty_bush_patch");
    //endregion

    //region Stuff Keys
    public static final ResourceKey<PlacedFeature> SCRAP_PLACED_KEY = registerKey("scrap_placed");
    public static final ResourceKey<PlacedFeature> DISK_ASHSTONE_PLACED_KEY = registerKey("disk_ashstone_placed");
    public static final ResourceKey<PlacedFeature> DISK_ASHDIRT_PLACED_KEY = registerKey("disk_ashdirt_placed");
    public static final ResourceKey<PlacedFeature> LAKE_ACID_SURFACE_PLACED_KEY = registerKey("lake_acid_surface_placed");

    public static final ResourceKey<PlacedFeature> MUD_PLACED_KEY = registerKey("mud_placed");
    public static final ResourceKey<PlacedFeature> GRASS_PLACED_KEY = registerKey("grass_placed");
    public static final ResourceKey<PlacedFeature> COARSE_PLACED_KEY = registerKey("coarse_placed");

    public static final ResourceKey<PlacedFeature> CRATER_PLACED_KEY = registerKey("crater_placed");
    public static final ResourceKey<PlacedFeature> DEBRIS_PLACED_KEY = registerKey("debris_placed");
    //endregion

    public static void bootstrap(BootstapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //region Ores
        register(context, URAN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_URAN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))));

        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))));

        register(context, LEAD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_LEAD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(45))));

        register(context, TITAN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TITAN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))));

        register(context, ALUMINIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ALUMINIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));

        register(context, ULTRACITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ULTRACITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));

        register(context, QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_QUARTZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))));
        //endregion

        //region Trees
        register(context, DEWDROP_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEWDROP_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1f,1)));
        register(context, ASH_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASH_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        register(context, GLOW_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GLOW_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        register(context, HEAP_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HEAP_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        register(context, IMMORTAL_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.IMMORTAL_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        register(context, RUSTY_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUSTY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.2F, 1)));
        //endregion

        //region Plants
        register(context, PATCH_TOXIC_FERN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_TOXIC_FERN_KEY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_DEWDROP_SAPLING_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_DEWDROP_SAPLING_KEY), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_DEAD_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_DEAD_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(22), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_GUT_FUNGI_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_GUT_FUNGI_KEY), List.of(RarityFilter.onAverageOnceEvery(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_CRANBERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_CRANBERRY_KEY), List.of(RarityFilter.onAverageOnceEvery(22), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BOGPAD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_BOGPAD_KEY), worldSurfaceSquaredWithCount(5));
        register(context, CRANBERRY_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRANBERRY_GRASS_KEY), List.of(NoiseThresholdCountPlacement.of(-0.3, 1, 12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_FUSION_FRUIT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FUSFRUIT_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_MEGA_HATTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEGAMORH_MUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_ASTER_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASTER_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_COMMON_BERRY_BUSH1_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRACKBERRY_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_COMMON_BERRY_BUSH2_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARLIGHT_BERRY_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_COMMON_BERRY_BUSH3_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUTTFRUIT_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BROC_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BROC_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_THISTLE_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THISTLE_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(35), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_SOOT_FLOWER_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOOT_FLOWER_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_HOLLYHOCK_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HOLLYHOCK_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_FEVER_BLOSSOM_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FEVER_BLOSSOM_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(26), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_CRACKBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRACKBERRY_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(31), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_MUTTFRUIT_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUTTFRUIT_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BRAIN_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BRAIN_FUNGUS_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(22), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_GLOW_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GLOW_FUNGUS_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BOMB_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BOMBBERRY_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_QUANTUM_LEAF_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUANTUMLEAF_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_NEUTRON_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NEUTRON_BUSH_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(23), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_MIND_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MINDFUNGUS_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_RADASTER_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RADASTER_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(28), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_RADROSE_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RADROSE_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BLAST_CAP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLASTCAP_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(23), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_FIRE_FUNGI_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FIREFUNGI_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_INVERT_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.INVERT_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BOOM_BLOSSOM_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BOOMBLOSSOM_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_STARLIGHT_BERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARLIGHT_BERRY_PLANT_KEY), List.of(RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_GINS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_GINS_BUSH_KEY), List.of(RarityFilter.onAverageOnceEvery(19), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_DATURANA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_DEAD_DATURAN_KEY), List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_PUNGA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_DEAD_PUNGA_KEY), List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_CORAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_DEAD_CORAL_KEY), List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_AGAVE_RARE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_AGAVE_BUSH_KEY), List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_SLIT_BEAN_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SLIT_BEANS_KEY), List.of(RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_BLOOD_LEAF_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_BLOODLEAF_KEY), List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_ZANDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_XANDER_KEY), List.of(RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, PATCH_RUSTY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_RUSTY_BUSH_KEY), List.of(RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, HEAP_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_HEAP_GRASS_KEY), List.of(NoiseThresholdCountPlacement.of(-0.4, 2, 2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RUSTY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_RUSTY_BUSH_KEY), List.of(NoiseThresholdCountPlacement.of(-0.4, 2, 2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, GLOW_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_GLOW_GRASS_KEY), List.of(NoiseThresholdCountPlacement.of(-0.8, 3, 3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, GRASS_ASH_PLACED_KEY, configuredFeatures.getOrThrow(VegetationFeatures.PATCH_GRASS), List.of(NoiseThresholdCountPlacement.of(-0.8, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, STRANGE_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_STRANGE_GRASS_KEY), List.of(NoiseThresholdCountPlacement.of(-0.3, 1, 12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, ASH_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_ASH_GRASS_KEY), List.of(NoiseThresholdCountPlacement.of(-0.3, 2, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, POISON_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_POISON_GRASS_KEY), List.of(NoiseThresholdCountPlacement.of(-0.4, 2, 2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        //endregion

        //region Stuff
        register(context, SCRAP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCRAP_KEY),
                ImmutableList.of(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, DISK_ASHSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASHSTONE_KEY),
                ImmutableList.of(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(4),InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, DISK_ASHDIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASHDIRT_KEY),
                ImmutableList.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, LAKE_ACID_SURFACE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAKE_ACID_KEY),
                ImmutableList.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PACKED_MUD_KEY),
                ImmutableList.of(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRASS_BLOCK_KEY),
                ImmutableList.of(CountPlacement.of(2), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, COARSE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COARSE_DIRT_KEY),
                ImmutableList.of(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        //register(context, CRATER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRATER_KEY),
        //        ImmutableList.of(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, DEBRIS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEBRIS_KEY),
                ImmutableList.of(CountPlacement.of(2), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        //endregion
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithCount(int pCount) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
