package net.notalan.nukaadditions.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.block.ModBlocks;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NukaAdditionsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUKAADDITIONS_TAB = CREATIVE_MODE_TABS.register("nukaadditions_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_PLATING.get()))
                    .title(Component.translatable("creativetab.nukaadditions_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SHELTERFLOOR_CONNECTING.get());
                        pOutput.accept(ModBlocks.WHITESTEEL_CONNECTING.get());
                        pOutput.accept(ModBlocks.STEEL_COLUMN.get());
                        pOutput.accept(ModBlocks.STEEL_PLATING.get());
                        pOutput.accept(ModBlocks.WHITESTEEL_COLUMN_CONNECTING.get());
                        pOutput.accept(ModBlocks.STEEL_PANEL.get());
                        pOutput.accept(ModBlocks.SHELTERFLOOR_STAIRS.get());
                        pOutput.accept(ModBlocks.SHELTERFLOOR_SLAB.get());
                        pOutput.accept(ModBlocks.RAD_STONE.get());
                        pOutput.accept(ModBlocks.ASPHALT.get());
                        pOutput.accept(ModBlocks.ASPHALT_CENTER.get());
                        pOutput.accept(ModBlocks.ASPHALT_EDGE.get());
                        pOutput.accept(ModBlocks.BLACKSTEEL_COLUMN.get());
                        pOutput.accept(ModBlocks.REINFORCED_CONCRETE_CONNECTING.get());
                        pOutput.accept(ModBlocks.REINFORCED_COLUMN.get());
                        pOutput.accept(ModBlocks.REINFORCED_PANEL.get());
                        pOutput.accept(ModBlocks.REINFORCED_FLOOR.get());
                        pOutput.accept(ModBlocks.REDSTEEL_CONNECTING.get());
                        pOutput.accept(ModBlocks.BLUESTEEL_CONNECTING.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
