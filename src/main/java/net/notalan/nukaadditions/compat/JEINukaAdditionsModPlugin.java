package net.notalan.nukaadditions.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mod.azure.azurelib.core.math.functions.limit.Min;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.notalan.nukaadditions.recipe.ChemistryRecipe;
import net.notalan.nukaadditions.recipe.ScrappingRecipe;
import net.notalan.nukaadditions.screen.ChemBenchScreen;
import net.notalan.nukaadditions.screen.ScrapBenchScreen;

import java.util.List;

@JeiPlugin
public class JEINukaAdditionsModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ScrappingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ChemistryCategory(registration.getJeiHelpers().getGuiHelper()));
    }

//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
//
//        List<ScrappingRecipe> scrappingRecipes = recipeManager.getAllRecipesFor(ScrappingRecipe.Type.INSTANCE);
//        registration.addRecipes(ScrappingCategory.SCRAPPING_TYPE, scrappingRecipes);
//
//        List<ChemistryRecipe> chemistryRecipes = recipeManager.getAllRecipesFor(ChemistryRecipe.Type.INSTANCE);
//        registration.addRecipes(ChemistryCategory.CHEMISTRY_TYPE, chemistryRecipes);
//    }
//
//    @Override
//    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
//        registration.addRecipeClickArea(ScrapBenchScreen.class, 60, 30, 20, 30,
//                ScrappingCategory.SCRAPPING_TYPE);
//
//        registration.addRecipeClickArea(ChemBenchScreen.class, 60, 30, 20, 30,
//                ChemistryCategory.CHEMISTRY_TYPE);
//    }
}
