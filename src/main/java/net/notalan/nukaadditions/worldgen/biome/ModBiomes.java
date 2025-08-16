package net.notalan.nukaadditions.worldgen.biome;

import com.nukateam.nukacraft.common.foundation.world.BiomeSettings;
import com.nukateam.nukacraft.common.foundation.world.features.ModDefaultFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.placed.BiomePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModVegetationPlacements;
import com.nukateam.nukacraft.common.registery.entities.ModMobs;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.worldgen.ModPlacedFeatures;

import javax.annotation.Nullable;
import java.util.HashMap;

public class ModBiomes {
    //Sets the biome
    //public static final ResourceKey<Biome> TEST_BIOME = register("test_biome");
    public static final ResourceKey<Biome> CRANBERRY_BOG = register("cranberry_bog");
    public static final ResourceKey<Biome> POISON_VALLEY = register("poison_valley");
    public static final ResourceKey<Biome> SAVAGE_DIVIDE = register("savage_divide");
    public static final ResourceKey<Biome> GLOW_SEA = register("glow_sea");
    public static final ResourceKey<Biome> ASH_HEAP = register("ash_heap");
    public static final ResourceKey<Biome> WASTED_DESERT = register("wasted_desert");
    public static final ResourceKey<Biome> CITY_WASTES = register("city_wastes");
    public static final ResourceKey<Biome> RADS_RIVER = register("rads_river");
    private static final HashMap<ResourceKey<Biome>, BiomeSettings> biomeSettings = new HashMap();

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(CRANBERRY_BOG, cranberryBog(placedFeatures, worldCarvers));
        context.register(POISON_VALLEY, poisonValley(placedFeatures, worldCarvers));
        context.register(SAVAGE_DIVIDE, savageDivide(placedFeatures, worldCarvers));
        context.register(GLOW_SEA, glowSea(placedFeatures, worldCarvers));
        context.register(ASH_HEAP, ashHeap(placedFeatures, worldCarvers));
        context.register(WASTED_DESERT, wastedDesert(placedFeatures, worldCarvers));
        context.register(CITY_WASTES, cityWastes(placedFeatures, worldCarvers));
        context.register(RADS_RIVER, radsRiver(placedFeatures, worldCarvers));
    }

    public static void setupBiomeSettings() {
        biomeSettings.put(CRANBERRY_BOG, (new BiomeSettings()).setFogDensity(1.0F));
        biomeSettings.put(POISON_VALLEY, (new BiomeSettings()).setFogDensity(1.0F));
        biomeSettings.put(SAVAGE_DIVIDE, (new BiomeSettings()).setFogDensity(1.0f));
        biomeSettings.put(ASH_HEAP, (new BiomeSettings()).setFogDensity(0.5F));
        biomeSettings.put(GLOW_SEA, (new BiomeSettings()).setFogDensity(0.05F));
        biomeSettings.put(WASTED_DESERT, (new BiomeSettings().setFogDensity(0.05F)));
        biomeSettings.put(CITY_WASTES, (new BiomeSettings().setFogDensity(0.5f)));
    }

    @Nullable
    public static BiomeSettings getBiomeSettings(Holder<Biome> biome) {
        for(ResourceKey<Biome> key : biomeSettings.keySet()) {
            if (biome.is(key)) {
                return (BiomeSettings)biomeSettings.get(key);
            }
        }

        return null;
    }

    private static void addFeature(BiomeGenerationSettings.Builder builder, GenerationStep.Decoration step, ResourceKey<PlacedFeature> feature) {
        builder.addFeature(step, feature);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static Biome cranberryBog(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        //Vanilla Features
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);

        //Tree
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEWDROP_TREE_PLACED_KEY);

        //Plants
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_TOXIC_FERN_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_DEWDROP_SAPLING_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_DEAD_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_GUT_FUNGI_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_CRANBERRY_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_BOGPAD_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CRANBERRY_GRASS_PLACED_KEY);

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.9F)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(mobBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(-10990522)
                        .waterColor(-11386816)
                        .waterFogColor(-11590620)
                        .skyColor(-3024201)
                        .foliageColorOverride(-6797754)
                        .grassColorOverride(-7714230)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome poisonValley(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        //Tree
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ASH_TREE_PLACED_KEY);

        //Plants
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ASH_GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.POISON_GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_BROC_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_ASTER_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_THISTLE_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_DEAD_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_MUTTFRUIT_BUSH_PLACED_KEY);

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.DISK_ASHSTONE_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LAKES, ModPlacedFeatures.LAKE_ACID_SURFACE_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5F)
                .downfall(0.5F)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(mobBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(-5399162)
                        .waterColor(-9547964)
                        .waterFogColor(11648455)
                        .skyColor(-7964315)
                        .foliageColorOverride(1783388)
                        .grassColorOverride(-861768)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome savageDivide(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        //Tree
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.IMMORTAL_TREE_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.RUSTY_TREE_PLACED_KEY);

        //Plants
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_COMMON_BERRY_BUSH1_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_COMMON_BERRY_BUSH2_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_COMMON_BERRY_BUSH3_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STRANGE_GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_MUTTFRUIT_BUSH_PLACED_KEY);
        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.7F)
                .downfall(0.4F)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(-10990522)
                        .waterColor(-11386816)
                        .waterFogColor(-11386816)
                        .skyColor(16246715)
                        .foliageColorOverride(12563018)
                        .grassColorOverride(12563018)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome glowSea(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        //Tree
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GLOW_TREE_PLACED_KEY);

        //Plants
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GRASS_ASH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GLOW_GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_BOMB_BERRY_BUSH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_RADROSE_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_FUSION_FRUIT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_MEGA_HATTER_PLACED_KEY);


        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.5F)
                .downfall(0.9F)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(16766566)
                        .waterColor(3882546)
                        .waterFogColor(2308637)
                        .skyColor(16246715)
                        .foliageColorOverride(9076070)
                        .grassColorOverride(9076070)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome ashHeap(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        addFeature(biomeBuilder, GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        addFeature(biomeBuilder, GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.DISK_ASHDIRT_PLACED_KEY);

        //Tree
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HEAP_TREE_PLACED_KEY);

        //Plants
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GRASS_ASH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HEAP_GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.RUSTY_BUSH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_ZANDER_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_CRACKBERRY_BUSH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_SOOT_FLOWER_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_FIRE_FUNGI_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_GLOW_FUNGUS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_STARLIGHT_BERRY_PLACED_KEY);

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.2F)
                .downfall(0.5F)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(-10990522)
                        .waterColor(-9551310)
                        .waterFogColor(11648455)
                        .skyColor(-10990522)
                        .foliageColorOverride(-10465466)
                        .grassColorOverride(-11187642)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.0219F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome wastedDesert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        //Tree
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HEAP_TREE_PLACED_KEY);

        //Plants
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ASH_GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.RUSTY_BUSH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_DEAD_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_HOLLYHOCK_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_CRACKBERRY_BUSH_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_BROC_PLANT_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_MUTTFRUIT_BUSH_PLACED_KEY);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.DISK_ASHSTONE_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.GRASS_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.COARSE_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.MUD_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1F)
                .downfall(0.5F)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(mobBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(14668703)
                        .waterColor(11972266)
                        .waterFogColor(6447206)
                        .skyColor(10855336)
                        .foliageColorOverride(8941887)
                        .grassColorOverride(15645038)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome cityWastes(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));

        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.commonSpawns(mobBuilder);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        //Tree

        //Plants

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);
        //addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CRATER_PLACED_KEY);
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.DEBRIS_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.2F)
                .downfall(0.5F)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(-10990522)
                        .waterColor(-9551310)
                        .waterFogColor(11648455)
                        .skyColor(-10990522)
                        .foliageColorOverride(-10465466)
                        .grassColorOverride(-11187642)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.0219F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

    private static Biome radsRiver(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        // Mobs
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
//        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 20, 4, 6));
//        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 20, 4, 6));
//        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.ANT.get(), 20, 4, 6));
//        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.MOLERAT.get(), 20, 4, 6));
//        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.DEATHCLAW.get(), 10, 2, 4));
//        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 20, 2, 4));
//        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.RAIDER.get(), 20, 4, 10));
//
//        BiomeDefaultFeatures.farmAnimals(mobBuilder);
        BiomeDefaultFeatures.oceanSpawns(mobBuilder, 3, 4, 15);

        // Features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeBuilder);

        //Ores/Underground
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        //Tree
        BiomeDefaultFeatures.addWaterTrees(biomeBuilder);

        //Plants
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);

        //Stuff
        addFeature(biomeBuilder, GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SCRAP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.2F)
                .downfall(0.5F)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .fogColor(7169882)
                        .waterColor(7568258)
                        .waterFogColor(6250861)
                        .skyColor(8946034)
                        .foliageColorOverride(-10465466)
                        .grassColorOverride(-11187642)

                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build())
                .build();
    }

}
