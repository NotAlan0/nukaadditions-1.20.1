package net.notalan.nukaadditions.block.custom;

import com.nukateam.ntgl.common.foundation.block.RotatedObjectBlock;
import com.nukateam.ntgl.common.util.util.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
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
import net.notalan.nukaadditions.block.ModBlocks;
import net.notalan.nukaadditions.block.entity.ChemBenchBlockEntity;
import net.notalan.nukaadditions.block.entity.ModBlockEntities;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChemBenchBlock extends RotatedObjectBlock implements EntityBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap();

    public ChemBenchBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        ArrayList<VoxelShape> shapes = new ArrayList();
        switch (pState.getValue(FACING)) {
            case NORTH -> shapes.add(box(-16, 0, 0, 16, 14, 16));
            case EAST -> shapes.add(box(0, 0, -16, 16, 14, 16));
            case WEST -> shapes.add(box(0, 0, 0, 16, 14, 32));
            default -> shapes.add(box(0, 0, 0, 32, 14, 16));
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

        if (pLevel.getBlockState(PosWest).getBlock() instanceof ChemBenchSide) {
            pLevel.destroyBlock(PosWest, !pIsMoving);
        } else if (pLevel.getBlockState(PosNorth).getBlock() instanceof ChemBenchSide) {
            pLevel.destroyBlock(PosNorth, !pIsMoving);
        } else if (pLevel.getBlockState(PosSouth).getBlock() instanceof ChemBenchSide) {
            pLevel.destroyBlock(PosSouth, !pIsMoving);
        } else if (pLevel.getBlockState(PosEast).getBlock() instanceof ChemBenchSide) {
            pLevel.destroyBlock(PosEast, !pIsMoving);
        }

        if (pLevel.getBlockState(PosWest).getBlock() instanceof ChemBenchBlock) {
            pLevel.destroyBlock(PosWest, !pIsMoving);
        } else if (pLevel.getBlockState(PosNorth).getBlock() instanceof ChemBenchBlock) {
            pLevel.destroyBlock(PosNorth, !pIsMoving);
        } else if (pLevel.getBlockState(PosSouth).getBlock() instanceof ChemBenchBlock) {
            pLevel.destroyBlock(PosSouth, !pIsMoving);
        } else if (pLevel.getBlockState(PosEast).getBlock() instanceof ChemBenchBlock) {
            pLevel.destroyBlock(PosEast, !pIsMoving);
        }
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        Direction facing = pState.getValue(FACING);
        BlockState sideBlockState = (ModBlocks.CHEM_BENCH_SIDE.get()).defaultBlockState().setValue(FACING, facing);
        if (facing == Direction.NORTH) {
            if (!pLevel.getBlockState(pPos.west()).isAir() && !(pLevel.getBlockState(pPos.west()).getBlock() instanceof BushBlock)) {
                pLevel.destroyBlock(pPos, true);
            } else {
                pLevel.setBlock(pPos.west(), sideBlockState, 3);
            }
        }

        if (facing == Direction.EAST) {
            if (!pLevel.getBlockState(pPos.north()).isAir() && !(pLevel.getBlockState(pPos.north()).getBlock() instanceof BushBlock)) {
                pLevel.destroyBlock(pPos, true);
            } else {
                pLevel.setBlock(pPos.north(), sideBlockState, 3);
            }
        }

        if (facing == Direction.SOUTH) {
            if (!pLevel.getBlockState(pPos.east()).isAir() && !(pLevel.getBlockState(pPos.east()).getBlock() instanceof BushBlock)) {
                pLevel.destroyBlock(pPos, true);
            } else {
                pLevel.setBlock(pPos.east(), sideBlockState, 3);
            }
        }

        if (facing == Direction.WEST) {
            if (!pLevel.getBlockState(pPos.south()).isAir() && !(pLevel.getBlockState(pPos.south()).getBlock() instanceof BushBlock)) {
                pLevel.destroyBlock(pPos, true);
            } else {
                pLevel.setBlock(pPos.south(), sideBlockState, 3);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof ChemBenchBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (ChemBenchBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_) {
        return p_152134_ == p_152133_ ? (BlockEntityTicker<A>)p_152135_ : null;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ChemBenchBlockEntity(pPos, pState);
    }

    @Override
    public @org.jetbrains.annotations.Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.CHEM_BENCH_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
}
