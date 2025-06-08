package net.notalan.nukaadditions.block;

import com.nukateam.nukacraft.NukaCraft;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NukaAdditionsMod.MOD_ID);

    //region Blocks
    public static final RegistryObject<Block> SHELTERFLOOR_CONNECTING = registryBlock("shelterfloor_connecting",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> WHITESTEEL_CONNECTING = registryBlock("whitesteel_connecting",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_COLUMN = registryBlock("steel_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PLATING = registryBlock("steel_plating",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> WHITESTEEL_COLUMN_CONNECTING = registryBlock("whitesteel_column_connecting",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PANEL = registryBlock("steel_panel",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SHELTERFLOOR_STAIRS = registryBlock("shelterfloor_stairs",
            () -> new StairBlock(SHELTERFLOOR_CONNECTING.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SHELTERFLOOR_SLAB = registryBlock("shelterfloor_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAD_STONE = registryBlock("rad_stone",
            () -> new RadioactiveBlock(BlockBehaviour.Properties.copy(Blocks.STONE), 0.1f));
    public static final RegistryObject<Block> ASPHALT = registryBlock("asphalt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> ASPHALT_CENTER = registryBlock("asphalt_center",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> ASPHALT_EDGE = registryBlock("asphalt_edge",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> BLACKSTEEL_COLUMN = registryBlock("blacksteel_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> REINFORCED_CONCRETE_CONNECTING = registryBlock("reinforced_concrete_connecting",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> REINFORCED_COLUMN = registryBlock("reinforced_column",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> REINFORCED_PANEL = registryBlock("reinforced_panel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> REINFORCED_FLOOR = registryBlock("reinforced_floor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> REDSTEEL_CONNECTING = registryBlock("redsteel_connecting",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BLUESTEEL_CONNECTING = registryBlock("bluesteel_connecting",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //endregion

    //region Stuff
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
    //endregion
}
