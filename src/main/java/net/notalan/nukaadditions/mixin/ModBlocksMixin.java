package net.notalan.nukaadditions.mixin;

import com.nukateam.nukacraft.common.datagen.utils.annotations.BlockStateGen;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import com.nukateam.nukacraft.common.registery.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.function.Supplier;

@Mixin(ModBlocks.class)
public abstract class ModBlocksMixin
{
    /*
    @Shadow
    @Final
    @Mutable
    public static RegistryObject<Block> RAW_URANIUM_BLOCK;

    @Inject(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/nukateam/nukacraft/common/registery/blocks/ModBlocks;registerBlock(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 0), cancellable = true)
    //@Inject(method = "<clinit>", at = @At("TAIL"))
    private static void redirectRawUraniumBlock(CallbackInfo ci) {
        RAW_URANIUM_BLOCK = ModBlocksAccessor.callRegisterBlock("raw_uranium_block",
                () -> new RadioactiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE).lightLevel((state) -> 5), 0.1f));
        // No need to cancel if you're just overriding assignment
    }

     */
}