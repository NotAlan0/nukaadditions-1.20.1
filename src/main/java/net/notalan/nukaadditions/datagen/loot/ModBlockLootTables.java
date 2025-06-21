package net.notalan.nukaadditions.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.block.ModBlocks;

import java.util.Iterator;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
//        this.add(ModBlocks.POOP_ORE.get(),
//                block -> createCopperOreDrops(ModBlocks.POOP_ORE.get(), ModItems.RAW_POOP.get()));

        this.dropSelf(ModBlocks.ASPHALT.get());
        this.dropSelf(ModBlocks.ASPHALT_EDGE.get());
        this.dropSelf(ModBlocks.ASPHALT_CENTER.get());

        this.dropSelf(ModBlocks.STEEL_PLATING.get());
        this.dropSelf(ModBlocks.STEEL_PANEL.get());
        this.dropSelf(ModBlocks.STEEL_COLUMN.get());

        this.dropSelf(ModBlocks.BLACKSTEEL_COLUMN.get());
        this.dropSelf(ModBlocks.BLACKSTEEL_CONNECTING.get());

        this.dropSelf(ModBlocks.BLUESTEEL_CONNECTING.get());
        this.dropSelf(ModBlocks.GREENSTEEL_CONNECTING.get());
        this.dropSelf(ModBlocks.REDSTEEL_CONNECTING.get());
        this.dropSelf(ModBlocks.YELLOWSTEEL_CONNECTING.get());

        this.dropSelf(ModBlocks.RUSTED_GREENSTEEL_CONNECTING.get());
        this.dropSelf(ModBlocks.RUSTED_REDSTEEL_CONNECTING.get());

        this.dropSelf(ModBlocks.WHITESTEEL_COLUMN_CONNECTING.get());
        this.dropSelf(ModBlocks.WHITESTEEL_CONNECTING.get());

        this.dropSelf(ModBlocks.SHELTERFLOOR_CONNECTING.get());
        this.dropSelf(ModBlocks.SHELTERFLOOR_SLAB.get());
        this.dropSelf(ModBlocks.SHELTERFLOOR_STAIRS.get());

        this.dropSelf(ModBlocks.REINFORCED_COLUMN.get());
        this.dropSelf(ModBlocks.REINFORCED_FLOOR.get());
        this.dropSelf(ModBlocks.REINFORCED_CONCRETE_CONNECTING.get());
        this.dropSelf(ModBlocks.REINFORCED_PANEL.get());
    }

//    protected LootTable.Builder createCopperOreDrops(Block pBlock, Item item) {
//        return createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionCondition(pBlock,
//                        LootItem.lootTableItem(Items.RAW_COPPER)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
//                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
