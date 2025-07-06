package net.notalan.nukaadditions.block.custom;

import com.nukateam.ntgl.common.foundation.block.RotatedObjectBlock;
import com.nukateam.ntgl.common.util.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import net.notalan.nukaadditions.block.entity.ModBlockEntities;
import net.notalan.nukaadditions.block.entity.ScrapBenchBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScrappingBenchBlock extends RotatedObjectBlock implements EntityBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap();

    public ScrappingBenchBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        ArrayList<VoxelShape> shapes = new ArrayList();
        switch (pState.getValue(FACING)) {
            case NORTH -> shapes.add(box(1, 0, 2, 15, 15, 12));
            case EAST -> shapes.add(box(4, 0, 1, 14, 15, 15));
            case WEST -> shapes.add(box(2, 0, 1, 12, 15, 15));
            default -> shapes.add(box(1, 0, 4, 15, 15, 14));
        }

        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        this.SHAPES.put(pState, shape);
        return shape;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        BlockPos PosWest = pPos.west();
        BlockPos PosNorth = pPos.north();
        BlockPos PosSouth = pPos.south();
        BlockPos PosEast = pPos.east();

        if (pLevel.getBlockState(PosWest).getBlock() instanceof ScrappingBenchBlock) {
            pLevel.destroyBlock(PosWest, !pIsMoving);
        } else if (pLevel.getBlockState(PosNorth).getBlock() instanceof ScrappingBenchBlock) {
            pLevel.destroyBlock(PosNorth, !pIsMoving);
        } else if (pLevel.getBlockState(PosSouth).getBlock() instanceof ScrappingBenchBlock) {
            pLevel.destroyBlock(PosSouth, !pIsMoving);
        } else if (pLevel.getBlockState(PosEast).getBlock() instanceof ScrappingBenchBlock) {
            pLevel.destroyBlock(PosEast, !pIsMoving);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof ScrapBenchBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (ScrapBenchBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @javax.annotation.Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_) {
        return p_152134_ == p_152133_ ? (BlockEntityTicker<A>)p_152135_ : null;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ScrapBenchBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.SCRAP_BENCH_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
}
