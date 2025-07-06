package net.notalan.nukaadditions.recipe;

import net.minecraft.world.item.ItemStack;

public class WeightedOutput {
    public final ItemStack stack;
    public final int weight;

    public WeightedOutput(ItemStack stack, int weight) {
        this.stack = stack;
        this.weight = weight;
    }
}
