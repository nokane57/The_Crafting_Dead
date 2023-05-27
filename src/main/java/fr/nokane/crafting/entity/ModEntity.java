package fr.nokane.crafting.entity;

import fr.nokane.crafting.entity.custom.WalkerEntity;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntity {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MOD_ID);

    public static final RegistryObject<EntityType<WalkerEntity>> WALKER =
            ENTITY_TYPES.register("walker",
                    () -> EntityType.Builder.of(WalkerEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95F)
                            .build(new ResourceLocation(Constants.MOD_ID, "walker").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
