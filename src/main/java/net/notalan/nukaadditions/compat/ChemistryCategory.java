package net.notalan.nukaadditions.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.block.ModBlocks;
import net.notalan.nukaadditions.recipe.ChemistryRecipe;
import org.jetbrains.annotations.Nullable;

public class ChemistryCategory implements IRecipeCategory<ChemistryRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, "chemistry");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID,
            "textures/gui/chem_bench_gui.png");

    public static final RecipeType<ChemistryRecipe> CHEMISTRY_TYPE =
            new RecipeType<>(UID, ChemistryRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ChemistryCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CHEM_BENCH.get()));
    }

    @Override
    public RecipeType<ChemistryRecipe> getRecipeType() {
        return CHEMISTRY_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.nukaadditions.chem_bench");
    }

//    @Override
//    public @Nullable IDrawable getBackground() {
//        return this.background;
//    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ChemistryRecipe chemistryRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(chemistryRecipe.getIngredients().get(0));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(chemistryRecipe.getResultItem(null));
    }
}
