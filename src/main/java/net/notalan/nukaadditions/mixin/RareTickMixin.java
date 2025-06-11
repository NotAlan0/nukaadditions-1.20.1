package net.notalan.nukaadditions.mixin;

import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.events.RadiationTracker;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.stream.Stream;

@Mixin(RadiationTracker.class)
public class RareTickMixin {
    // Redirect call to AABB.inflate(double)
    @Redirect(
            method = "Lcom/nukateam/nukacraft/common/events/RadiationTracker;rareTick(Lnet/minecraftforge/event/TickEvent$PlayerTickEvent;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/phys/AABB;inflate(D)Lnet/minecraft/world/phys/AABB;"
            )
    )
    private AABB redirectInflate(AABB aabb, double value) {
        // Replace with new value (e.g., configurable)
        return aabb.inflate(3.0D); // Or use your own variable
    }
}
