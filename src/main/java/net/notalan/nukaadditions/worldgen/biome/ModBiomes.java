package net.notalan.nukaadditions.worldgen.biome;

import com.nukateam.nukacraft.common.foundation.world.BiomeSettings;
import com.nukateam.nukacraft.common.registery.entities.ModMobs;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
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
    }

    public static void setupBiomeSettings() {
        biomeSettings.put(CRANBERRY_BOG, (new BiomeSettings()).setFogDensity(1.0F));
        biomeSettings.put(POISON_VALLEY, (new BiomeSettings()).setFogDensity(1.0F));
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

    private static void addFeature(BiomeGenerationSettings.Builder builder, GenerationStep.Decoration step, ResourceKey<PlacedFeature> feature)
    {
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
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 5, 4, 20));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 5, 4, 20));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 5, 4, 10));

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
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.RADROACH.get(), 5, 4, 20));
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModMobs.BLOATFLY.get(), 5, 4, 20));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModMobs.BRAHMIN.get(), 5, 4, 10));

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
}
