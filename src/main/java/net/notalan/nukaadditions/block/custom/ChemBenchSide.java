package net.notalan.nukaadditions.block.custom;

import com.nukateam.ntgl.common.foundation.block.RotatedObjectBlock;
import com.nukateam.ntgl.common.util.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChemBenchSide extends ChemBenchBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap();

    public ChemBenchSide(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.INVISIBLE;
    }

    private VoxelShape getShape(BlockState state) {
        List<VoxelShape> shapes = new ArrayList();
        switch (state.getValue(FACING)) {
            case NORTH -> shapes.add(box((double)0.0F, (double)0.0F, (double)0.0F, (double)32.0F, (double)14.0F, (double)16.0F));
            case EAST -> shapes.add(box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)14.0F, (double)32.0F));
            case WEST -> shapes.add(box((double)0.0F, (double)0.0F, (double)-16.0F, (double)16.0F, (double)14.0F, (double)16.0F));
            default -> shapes.add(box((double)-16.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)14.0F, (double)16.0F));
        }

        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        this.SHAPES.put(state, shape);
        return shape;
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return this.getShape(state);
    }

    public @NotNull InteractionResult use(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        BlockPos bottomPos = pPos.relative(pState.getValue(HorizontalDirectionalBlock.FACING).getClockWise());
        return pLevel.getBlockState(bottomPos).getBlock() instanceof ChemBenchBlock ? pLevel.getBlockState(bottomPos).getBlock().use(pLevel.getBlockState(bottomPos), pLevel, bottomPos, pPlayer, pHand, pHit) : super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
