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
import net.notalan.nukaadditions.recipe.ScrappingRecipe;
import org.jetbrains.annotations.Nullable;

public class ScrappingCategory implements IRecipeCategory<ScrappingRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, "scrapping");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID,
            "textures/gui/scrap_bench_gui.png");

    public static final RecipeType<ScrappingRecipe> SCRAPPING_TYPE =
            new RecipeType<>(UID, ScrappingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ScrappingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SCRAP_BENCH.get()));
    }

    @Override
    public RecipeType<ScrappingRecipe> getRecipeType() {
        return SCRAPPING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.nukaadditions.scrap_bench");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ScrappingRecipe scrappingRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(scrappingRecipe.getIngredients().get(0));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(scrappingRecipe.getResultItem(null));
    }
}
