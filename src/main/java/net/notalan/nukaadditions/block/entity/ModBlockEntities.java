package net.notalan.nukaadditions.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NukaAdditionsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ScrapBenchBlockEntity>> SCRAP_BENCH_BE =
            BLOCK_ENTITIES.register("scrap_bench", () ->
                    BlockEntityType.Builder.of(ScrapBenchBlockEntity::new,
                            ModBlocks.SCRAP_BENCH.get()).build(null));

    public static final RegistryObject<BlockEntityType<ChemBenchBlockEntity>> CHEM_BENCH_BE =
            BLOCK_ENTITIES.register("chem_bench", () ->
                    BlockEntityType.Builder.of(ChemBenchBlockEntity::new,
                            ModBlocks.CHEM_BENCH.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
