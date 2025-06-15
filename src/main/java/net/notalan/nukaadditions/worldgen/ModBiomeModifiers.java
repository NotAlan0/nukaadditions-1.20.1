package net.notalan.nukaadditions.worldgen;

import com.nukateam.nukacraft.common.foundation.world.features.placed.ModOrePlacements;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.worldgen.biome.ModBiomes;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_URAN_ORE = registerKey("add_uranium_ore");
    public static final ResourceKey<BiomeModifier> ADD_SILVER_ORE = registerKey("add_silver_ore");
    public static final ResourceKey<BiomeModifier> ADD_LEAD_ORE = registerKey("add_lead_ore");
    public static final ResourceKey<BiomeModifier> ADD_TITAN_ORE = registerKey("add_titan_ore");
    public static final ResourceKey<BiomeModifier> ADD_ALUMINIUM_ORE = registerKey("add_aluminium_ore");
    public static final ResourceKey<BiomeModifier> ADD_ULTRACITE_ORE = registerKey("add_ultracite_ore");
    public static final ResourceKey<BiomeModifier> ADD_QUARTZ_ORE = registerKey("add_quartz_ore");

    //public static final ResourceKey<BiomeModifier> ADD_TREE_DEWDROP = registerKey("add_dewdrop");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //region Ores
        //1
        context.register(ADD_URAN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.URAN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //2
        context.register(ADD_SILVER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SILVER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //3
        context.register(ADD_LEAD_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LEAD_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //4
        context.register(ADD_TITAN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TITAN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //5
        context.register(ADD_ALUMINIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ALUMINIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //6
        context.register(ADD_ULTRACITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ULTRACITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //7
        context.register(ADD_QUARTZ_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.QUARTZ_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        //endregion

        //Tree
        //context.register(ADD_TREE_DEWDROP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
        //        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEWDROP_PLACED_KEY)),
        //        GenerationStep.Decoration.VEGETAL_DECORATION));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, name));
    }
}
