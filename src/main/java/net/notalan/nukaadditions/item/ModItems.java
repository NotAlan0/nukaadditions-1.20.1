package net.notalan.nukaadditions.item;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.notalan.nukaadditions.NukaAdditionsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import java.util.function.Supplier;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NukaAdditionsMod.MOD_ID);

    //region Items
    //public static final RegistryObject<Item> CHEESECAT = ITEMS.register("cheese_cat",
    //        () -> new Item(new Item.Properties()));

    //endregion

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
