package net.notalan.nukaadditions.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NukaAdditionsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ASPHALT);
        blockWithItem(ModBlocks.ASPHALT_CENTER);
        blockWithItem(ModBlocks.ASPHALT_EDGE);

        blockWithItem(ModBlocks.BLACKSTEEL_COLUMN);
        blockWithItem(ModBlocks.BLACKSTEEL_CONNECTING);

        blockWithItem(ModBlocks.BLUESTEEL_CONNECTING);
        blockWithItem(ModBlocks.GREENSTEEL_CONNECTING);
        blockWithItem(ModBlocks.REDSTEEL_CONNECTING);
        blockWithItem(ModBlocks.YELLOWSTEEL_CONNECTING);

        blockWithItem(ModBlocks.RUSTED_GREENSTEEL_CONNECTING);
        blockWithItem(ModBlocks.RUSTED_REDSTEEL_CONNECTING);

        blockWithItem(ModBlocks.WHITESTEEL_COLUMN_CONNECTING);
        blockWithItem(ModBlocks.WHITESTEEL_CONNECTING);

        blockWithItem(ModBlocks.STEEL_COLUMN);
        blockWithItem(ModBlocks.STEEL_PANEL);
        blockWithItem(ModBlocks.STEEL_PLATING);

        blockWithItem(ModBlocks.SHELTERFLOOR_CONNECTING);
        blockWithItem(ModBlocks.SHELTERFLOOR_SLAB);
        blockWithItem(ModBlocks.SHELTERFLOOR_STAIRS);

        blockWithItem(ModBlocks.REINFORCED_COLUMN);
        blockWithItem(ModBlocks.REINFORCED_FLOOR);
        blockWithItem(ModBlocks.REINFORCED_CONCRETE_CONNECTING);
        blockWithItem(ModBlocks.REINFORCED_PANEL);

        blockWithItem(ModBlocks.RAD_STONE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
