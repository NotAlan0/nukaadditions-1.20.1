package net.notalan.nukaadditions.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class TestRegion1 extends Region {
    //Sets the Region for the Biome
    public TestRegion1(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MANGROVE_SWAMP, ModBiomes.CRANBERRY_BOG);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, ModBiomes.POISON_VALLEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, ModBiomes.SAVAGE_DIVIDE);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SWAMP, ModBiomes.GLOW_SEA);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, ModBiomes.ASH_HEAP);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, ModBiomes.WASTED_DESERT);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, ModBiomes.WASTED_DESERT);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, ModBiomes.CITY_WASTES);
        });
    }
}
