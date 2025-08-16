package net.notalan.nukaadditions.recipe;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, NukaAdditionsMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ScrappingRecipe>> SCRAPPING_SERIALIZER =
            SERIALIZERS.register("scrapping", () -> ScrappingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ChemistryRecipe>> ACIDIFYING_SERIALIZER =
            SERIALIZERS.register("chemistry", () -> ChemistryRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
