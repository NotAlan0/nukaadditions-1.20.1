package net.notalan.nukaadditions.mixin;

import com.nukateam.nukacraft.common.events.RadiationTracker;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(RadiationTracker.class)
public class RadiationTrackerAccessor {
    @Invoker("rareTick")
    void rareTick(TickEvent.PlayerTickEvent event) {
        throw new AssertionError(); // will be overwritten by Mixin at runtime
    }
}
