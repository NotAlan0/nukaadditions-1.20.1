package net.notalan.nukaadditions.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.notalan.nukaadditions.NukaAdditionsMod;
import terrablender.api.Region;
import terrablender.api.Regions;

public class ModTerrablender {
    //Registers the biome so it spawns in the region
    public static void registerBiomes() {
        Regions.register(new TestRegion1(ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, "overworld"), 10));
    }
}
