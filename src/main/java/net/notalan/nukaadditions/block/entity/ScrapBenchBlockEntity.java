package net.notalan.nukaadditions.block.entity;

import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import com.nukateam.nukacraft.common.registery.items.ModWeapons;
import net.minecraft.Optionull;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.notalan.nukaadditions.recipe.ScrappingRecipe;
import net.notalan.nukaadditions.screen.ScrapBenchMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ScrapBenchBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(1 + OUTPUT_SLOTS); // input + multiple outputs

    private static final int INPUT_SLOT = 0;
    private static final int FIRST_OUTPUT_SLOT = 1;
    private static final int OUTPUT_SLOTS = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public ScrapBenchBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SCRAP_BENCH_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ScrapBenchBlockEntity.this.progress;
                    case 1 -> ScrapBenchBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ScrapBenchBlockEntity.this.progress = pValue;
                    case 1 -> ScrapBenchBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.nukaadditions.scrap_bench");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ScrapBenchMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("scrap_bench.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("scrap_bench.progress");
    }


    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<ScrappingRecipe> recipe = getCurrentRecipe();
//        ItemStack result = recipe.get().getResultItem(null);
//
//        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
//
//        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
//                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        List<ItemStack> results = recipe.get().getRandomOutputs(this.level);

        for (ItemStack output : results) {
            insertIntoOutputSlots(output);
        }
    }

    private boolean hasRecipe() {
        Optional<ScrappingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }
//        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());
//
//        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
        List<ItemStack> results = recipe.get().getRandomOutputs(this.level);

        for (ItemStack stack : results) {
            if (!canInsertIntoAnyOutputSlot(stack)) {
                return false;
            }
        }
        return true;
    }

    private Optional<ScrappingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(ScrappingRecipe.Type.INSTANCE, inventory, level);
    }

//    private boolean canInsertItemIntoOutputSlot(Item item) {
//        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
//    }
//
//    private boolean canInsertAmountIntoOutputSlot(int count) {
//        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
//    }

    private void insertIntoOutputSlots(ItemStack stack) {
        for (int slot = FIRST_OUTPUT_SLOT; slot < FIRST_OUTPUT_SLOT + OUTPUT_SLOTS; slot++) {
            ItemStack existing = itemHandler.getStackInSlot(slot);

            if (existing.isEmpty()) {
                itemHandler.setStackInSlot(slot, stack.copy());
                return;
            } else if (ItemStack.isSameItemSameTags(existing, stack) &&
                    existing.getCount() + stack.getCount() <= existing.getMaxStackSize()) {
                existing.grow(stack.getCount());
                itemHandler.setStackInSlot(slot, existing);
                return;
            }
        }
        // Optionally: drop remaining items if inventory is full
        Containers.dropItemStack(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), stack);
    }

    private boolean canInsertIntoAnyOutputSlot(ItemStack stack) {
        for (int slot = FIRST_OUTPUT_SLOT; slot < FIRST_OUTPUT_SLOT + OUTPUT_SLOTS; slot++) {
            ItemStack existing = itemHandler.getStackInSlot(slot);
            if (existing.isEmpty() || (ItemStack.isSameItemSameTags(existing, stack) &&
                    existing.getCount() + stack.getCount() <= existing.getMaxStackSize())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}
