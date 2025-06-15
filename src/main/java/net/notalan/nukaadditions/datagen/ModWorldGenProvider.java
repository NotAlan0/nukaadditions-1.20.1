package net.notalan.nukaadditions.datagen;

import com.nukateam.nukacraft.common.foundation.world.features.ModDefaultFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.placed.BiomePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModVegetationPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.worldgen.ModBiomeModifiers;
import net.notalan.nukaadditions.worldgen.ModConfiguredFeatures;
import net.notalan.nukaadditions.worldgen.ModPlacedFeatures;
import net.notalan.nukaadditions.worldgen.biome.ModBiomes;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NukaAdditionsMod.MOD_ID));
    }
}
