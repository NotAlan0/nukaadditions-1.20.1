package net.notalan.nukaadditions.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.notalan.nukaadditions.NukaAdditionsMod;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ScrappingRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final List<WeightedOutput> possibleOutputs;
    private final ResourceLocation id;

    public ScrappingRecipe(NonNullList<Ingredient> inputItems, List<WeightedOutput> possibleOutputs, ResourceLocation id) {
        this.inputItems = inputItems;
        this.possibleOutputs = possibleOutputs;
        this.id = id;
    }

    public List<ItemStack> getRandomOutputs(Level level) {
        RandomSource random = level.random;
        int count = 1 + random.nextInt(3); // 1 to 3 items
        List<ItemStack> result = new ArrayList<>();

        List<WeightedOutput> pool = new ArrayList<>(possibleOutputs);
        for (int i = 0; i < count && !pool.isEmpty(); i++) {
            int totalWeight = pool.stream().mapToInt(w -> w.weight).sum();
            int roll = random.nextInt(totalWeight);

            int cumulative = 0;
            for (Iterator<WeightedOutput> it = pool.iterator(); it.hasNext(); ) {
                WeightedOutput output = it.next();
                cumulative += output.weight;
                if (roll < cumulative) {
                    result.add(output.stack.copy());
                    it.remove(); // prevent duplicates
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return possibleOutputs.isEmpty() ? ItemStack.EMPTY : possibleOutputs.get(0).stack.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return possibleOutputs.isEmpty() ? ItemStack.EMPTY : possibleOutputs.get(0).stack.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ScrappingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "scrapping";
    }

    public static class Serializer implements RecipeSerializer<ScrappingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(NukaAdditionsMod.MOD_ID, "scrapping");

        @Override
        public ScrappingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            JsonArray outputsJson = GsonHelper.getAsJsonArray(pSerializedRecipe, "outputs");
            List<WeightedOutput> outputs = new ArrayList<>();

            for (JsonElement element : outputsJson) {
                JsonObject obj = element.getAsJsonObject();
                ItemStack stack = ShapedRecipe.itemStackFromJson(obj);
                int weight = obj.has("weight") ? obj.get("weight").getAsInt() : 1;
                outputs.add(new WeightedOutput(stack, weight));
            }

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ScrappingRecipe(inputs, outputs, pRecipeId);
        }

        @Override
        public @Nullable ScrappingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            int inputCount = pBuffer.readInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(inputCount, Ingredient.EMPTY);
            for (int i = 0; i < inputCount; i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            int outputCount = pBuffer.readInt();
            List<WeightedOutput> outputs = new ArrayList<>();
            for (int i = 0; i < outputCount; i++) {
                ItemStack stack = pBuffer.readItem();
                int weight = pBuffer.readInt();
                outputs.add(new WeightedOutput(stack, weight));
            }

            return new ScrappingRecipe(inputs, outputs, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer , ScrappingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeInt(pRecipe.possibleOutputs.size());
            for (WeightedOutput output : pRecipe.possibleOutputs) {
                pBuffer.writeItem(output.stack);
                pBuffer.writeInt(output.weight);
            }
        }
    }
}
