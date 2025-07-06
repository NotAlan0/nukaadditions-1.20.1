package net.notalan.nukaadditions.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, NukaAdditionsMod.MOD_ID);

    public static final RegistryObject<MenuType<ScrapBenchMenu>> SCRAP_BENCH_MENU =
            registerMenuType("scrap_bench_menu", ScrapBenchMenu::new);

    public static final RegistryObject<MenuType<ChemBenchMenu>> CHEM_BENCH_MENU =
            registerMenuType("chem_bench_menu", ChemBenchMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
