package net.notalan.nukaadditions.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;

public class ModBannerPatterns
{
    public static final DeferredRegister<BannerPattern> BANNERS =
            DeferredRegister.create(Registries.BANNER_PATTERN, NukaAdditionsMod.MOD_ID);

    public static final RegistryObject<BannerPattern> VT_PATTERN = BANNERS.register("vt",
            () -> new BannerPattern("vt"));

    public static void register(IEventBus eventBus) {
        BANNERS.register(eventBus);
    }
}
