package net.notalan.nukaadditions.mixin;

import com.nukateam.nukacraft.common.foundation.blocks.blocks.PowerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PowerBlock.class)
public class PowerBlockMixin {

//    private int calculateTargetStrength(Level world, BlockPos pos) {
//        this.shouldSignal = false;
//        int i = world.getBestNeighborSignal(pos);
//        this.shouldSignal = true;
//        int j = 0;
//        if (i < 15) {
//            for(Direction direction : Direction.values()) {
//                BlockState blockstate = world.getBlockState(pos.relative(direction));
//                j = Math.max(j, this.getWireSignal(blockstate));
//            }
//        }
//
//        return Math.max(i, j - 1);
//    }
}
