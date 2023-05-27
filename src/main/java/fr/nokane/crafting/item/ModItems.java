package fr.nokane.crafting.item;

import fr.nokane.crafting.entity.ModEntity;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);


    public static final RegistryObject<Item> WALKER_SPAWN_EGG = ITEMS.register("walker_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntity.WALKER, 0xD57E36, 0x1D0D09,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
