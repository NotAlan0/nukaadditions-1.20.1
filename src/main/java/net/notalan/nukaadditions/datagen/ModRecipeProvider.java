package net.notalan.nukaadditions.datagen;

import com.nukateam.nukacraft.common.registery.items.ModFood;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.block.ModBlocks;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
//    private static final List<ItemLike> POO_SMELTABLES = List.of(ModItems.RAW_POOP.get(),
//            ModBlocks.POOP_ORE.get(), ...);

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
//        oreBlasting(pWriter, POO_SMELTABLES, RecipeCategory.MISC, ModItems.POO.get(), 0.25f, 100, "poo");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PANEL.get(), 6)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.STEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHEM_BENCH.get())
                .pattern("BIB")
                .pattern("SSS")
                .pattern("IWI")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.GLASS_BOTTLE)
                .define('I', Items.IRON_BARS)
                .define('W', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.WHITE_STEEL.get())
                .unlockedBy(getHasName(ModItems.ACID.get()), has(ModItems.ACID.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCRAP_BENCH.get())
                .pattern("SYS")
                .pattern("LFL")
                .pattern("SCS")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('Y', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.YELLOW_STEEL.get())
                .define('L', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.BLUESTEEL.get())
                .define('F', Blocks.BLAST_FURNACE)
                .define('C', ModItems.SCRAP.get())
                .unlockedBy(getHasName(ModItems.SCRAP.get()), has(ModItems.SCRAP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CIRCUIT.get())
                .pattern("GG")
                .pattern("RR")
                .pattern("PP")
                .define('G', Items.GOLD_INGOT)
                .define('R', Items.REDSTONE)
                .define('P', ModItems.PLASTIC.get())
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGNET.get())
                .pattern("SS")
                .pattern("CR")
                .define('C', Items.COPPER_INGOT)
                .define('S', ModItems.CERAMIC.get())
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REDUCER.get())
                .pattern("C")
                .pattern("S")
                .pattern("S")
                .define('C', Items.COPPER_INGOT)
                .define('S', ModItems.STEEL_INGOT.get())
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.TERMINAL.get())
                .pattern("AGA")
                .pattern("PMP")
                .pattern("ACA")
                .define('C', ModItems.CIRCUIT.get())
                .define('A', ModItems.ALUMINIUM_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('M', ModItems.MAGNET.get())
                .define('G', Blocks.GLASS)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.DOOR_TERMINAL.get())
                .pattern("PBP")
                .pattern("SCS")
                .pattern("SRS")
                .define('C', ModItems.CIRCUIT.get())
                .define('S', ModItems.STEEL_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('R', Items.REDSTONE)
                .define('B', Items.STONE_BUTTON)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.NUKACOLA_VENDING.get())
                .pattern("RRR")
                .pattern("RNC")
                .pattern("WIW")
                .define('R', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.REDSTEEL.get())
                .define('W', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.WHITE_STEEL.get())
                .define('C', ModItems.CIRCUIT.get())
                .define('N', ModFood.NUKA_COLA.get())
                .define('I', Blocks.PACKED_ICE)
                .unlockedBy(getHasName(ModFood.NUKA_COLA.get()), has(ModFood.NUKA_COLA.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.MODERN_FRIDGE_MAIN.get())
                .pattern("BBB")
                .pattern("S S")
                .pattern("BIB")
                .define('B', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.BLUESTEEL.get())
                .define('S', ModItems.STEEL_INGOT.get())
                .define('I', Blocks.PACKED_ICE)
                .unlockedBy(getHasName(Blocks.PACKED_ICE), has(Blocks.PACKED_ICE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.NUKACOLA_FRIDGE_MACHINE.get())
                .pattern("RRR")
                .pattern("S S")
                .pattern("WIW")
                .define('R', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.REDSTEEL.get())
                .define('W', com.nukateam.nukacraft.common.registery.blocks.ModBlocks.WHITE_STEEL.get())
                .define('S', ModItems.STEEL_INGOT.get())
                .define('I', Blocks.PACKED_ICE)
                .unlockedBy(getHasName(Blocks.PACKED_ICE), has(Blocks.PACKED_ICE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.VTARMOR.get(), 8)
                .pattern("CGC")
                .pattern("GCG")
                .pattern("CGC")
                .define('C', Items.CLAY)
                .define('G', Blocks.GRAVEL)
                .unlockedBy(getHasName(Items.CLAY), has(Items.CLAY))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.PA_STATION.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        //region Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.STEELFLOOR.get(), 4)
                .pattern("YAY")
                .pattern("ASA")
                .pattern("YAY")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('A', ModItems.ALUMINIUM_INGOT.get())
                .define('Y', Items.YELLOW_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.POWERBLOCK.get(), 6)
                .pattern("SSS")
                .pattern("CCC")
                .pattern("SSS")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('C', ModItems.COPPER_WIRE.get())
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.BLACKSTEEL.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" S ")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.BLACK_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.WHITE_STEEL.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" S ")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.WHITE_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.REDSTEEL.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" S ")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.RED_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.BLUESTEEL.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" S ")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.BLUE_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.GREENSTEEL.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" S ")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.GREEN_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.YELLOW_STEEL.get(), 4)
                .pattern(" S ")
                .pattern("SBS")
                .pattern(" S ")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('B', Items.YELLOW_DYE)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        //endregion

        //region Doors
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.VAULT_BLASTDOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.RUSTY_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.CAGE_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.STORE_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.RED_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.GREEN_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.WHITE_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.HARD_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, com.nukateam.nukacraft.common.registery.blocks.ModBlocks.RED_ROCKET_DOOR.get())
                .pattern("CTC")
                .pattern("PTP")
                .pattern("T T")
                .define('T', ModItems.BLACK_TITAN_INGOT.get())
                .define('P', ModItems.PLASTIC.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.BLACK_TITAN_INGOT.get()), has(ModItems.BLACK_TITAN_INGOT.get()))
                .save(pWriter);

        //endregion
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  NukaAdditionsMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
