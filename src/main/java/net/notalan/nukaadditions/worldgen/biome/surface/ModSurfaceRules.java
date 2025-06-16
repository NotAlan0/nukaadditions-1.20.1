package net.notalan.nukaadditions.worldgen.biome.surface;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.registery.blocks.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.notalan.nukaadditions.worldgen.biome.ModBiomes;

public class ModSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                surfaceRuleForWastedDesert()
        );
    }

    private static SurfaceRules.RuleSource surfaceRuleForWastedDesert() {
        // Occasional dirt
        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(ModBiomes.WASTED_DESERT),
                SurfaceRules.sequence(

                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(Noises.SURFACE, -0.5, -0.3),
                                SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())
                        )),

                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(
                                SurfaceRules.noiseCondition(Noises.SURFACE, -0.2, 0.1),
                                SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState())
                        )),

                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()))
                ));
    }
}
