package fr.nokane.crafting;

import com.mojang.logging.LogUtils;
import fr.nokane.crafting.entity.ModEntity;
import fr.nokane.crafting.entity.client.WalkerRenderer;
import fr.nokane.crafting.item.ModItems;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(Constants.MOD_ID)
public class CraftingDead {

    private static final Logger logger = LogUtils.getLogger();


    // Constructeur
    public CraftingDead() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Events Registry
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModEntity.register(modEventBus);
    }

    // Common Setup
    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // creatif Tabs
    private void addCreative(CreativeModeTabEvent.BuildContents event) {

    }

    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntity.WALKER.get(), WalkerRenderer::new);
        }
    }
}
