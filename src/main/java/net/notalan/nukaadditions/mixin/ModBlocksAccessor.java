package net.notalan.nukaadditions.mixin;

import com.nukateam.nukacraft.common.registery.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.common.reflection.qual.Invoke;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Supplier;

@Mixin(ModBlocks.class)
public interface ModBlocksAccessor {
    @Invoker("registerBlock")
    static <T extends Block> RegistryObject<T> callRegisterBlock(String name, Supplier<T> block) {
        throw new AssertionError(); // will be overwritten by Mixin at runtime
    }
}
