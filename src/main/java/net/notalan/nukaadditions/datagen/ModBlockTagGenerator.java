package net.notalan.nukaadditions.datagen;

import com.nukateam.ntgl.common.foundation.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NukaAdditionsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SHELTERFLOOR_CONNECTING.get(), //1
                        ModBlocks.SHELTERFLOOR_SLAB.get(),
                        ModBlocks.SHELTERFLOOR_STAIRS.get(),
                        ModBlocks.STEEL_COLUMN.get(),
                        ModBlocks.STEEL_PANEL.get(),        //5
                        ModBlocks.STEEL_PLATING.get(),
                        ModBlocks.WHITESTEEL_CONNECTING.get(),
                        ModBlocks.WHITESTEEL_COLUMN_CONNECTING.get(),
                        ModBlocks.BLACKSTEEL_COLUMN.get(),
                        ModBlocks.BLACKSTEEL_CONNECTING.get(),  //10
                        ModBlocks.REINFORCED_COLUMN.get(),
                        ModBlocks.REINFORCED_FLOOR.get(),
                        ModBlocks.REINFORCED_CONCRETE_CONNECTING.get(),
                        ModBlocks.REINFORCED_PANEL.get(),
                        ModBlocks.BLUESTEEL_CONNECTING.get(),   //15
                        ModBlocks.REDSTEEL_CONNECTING.get(),
                        ModBlocks.GREENSTEEL_CONNECTING.get(),
                        ModBlocks.YELLOWSTEEL_CONNECTING.get(),
                        ModBlocks.RUSTED_GREENSTEEL_CONNECTING.get(),
                        ModBlocks.RUSTED_REDSTEEL_CONNECTING.get(), //20
                        ModBlocks.ASPHALT_CENTER.get(),
                        ModBlocks.ASPHALT.get(),
                        ModBlocks.ASPHALT_EDGE.get(),
                        ModBlocks.RAD_STONE.get()
                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUSTED_REDSTEEL_CONNECTING.get(),
                        ModBlocks.RUSTED_GREENSTEEL_CONNECTING.get(),
                        ModBlocks.ASPHALT_CENTER.get(),
                        ModBlocks.ASPHALT.get(),
                        ModBlocks.ASPHALT_EDGE.get(),
                        ModBlocks.RAD_STONE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SHELTERFLOOR_CONNECTING.get(), //1
                        ModBlocks.SHELTERFLOOR_SLAB.get(),
                        ModBlocks.SHELTERFLOOR_STAIRS.get(),
                        ModBlocks.STEEL_COLUMN.get(),
                        ModBlocks.STEEL_PANEL.get(),        //5
                        ModBlocks.STEEL_PLATING.get(),
                        ModBlocks.WHITESTEEL_CONNECTING.get(),
                        ModBlocks.WHITESTEEL_COLUMN_CONNECTING.get(),
                        ModBlocks.BLACKSTEEL_COLUMN.get(),
                        ModBlocks.BLACKSTEEL_CONNECTING.get(),  //10
                        ModBlocks.REINFORCED_COLUMN.get(),
                        ModBlocks.REINFORCED_FLOOR.get(),
                        ModBlocks.REINFORCED_CONCRETE_CONNECTING.get(),
                        ModBlocks.REINFORCED_PANEL.get(),
                        ModBlocks.BLUESTEEL_CONNECTING.get(),   //15
                        ModBlocks.REDSTEEL_CONNECTING.get(),
                        ModBlocks.GREENSTEEL_CONNECTING.get(),
                        ModBlocks.YELLOWSTEEL_CONNECTING.get()
                );
    }
}
