package fr.nokane.crafting.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import fr.nokane.crafting.entity.custom.WalkerEntity;
import fr.nokane.crafting.entity.variant.WalkerVariant;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class WalkerRenderer extends GeoEntityRenderer<WalkerEntity> {

    public static final Map<WalkerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(WalkerVariant.class), (p_114874_) -> {
                p_114874_.put(WalkerVariant.DEFAULT,
                        new ResourceLocation(Constants.MOD_ID, "textures/entities/walker/walker_0.png"));
                p_114874_.put(WalkerVariant.WALKER_1,
                        new ResourceLocation(Constants.MOD_ID, "textures/entities/walker/walker_1.png"));
                p_114874_.put(WalkerVariant.WALKER_2,
                        new ResourceLocation(Constants.MOD_ID, "textures/entities/walker/walker_2.png"));
                p_114874_.put(WalkerVariant.WALKER_3,
                        new ResourceLocation(Constants.MOD_ID, "textures/entities/walker/walker_3.png"));
                p_114874_.put(WalkerVariant.WALKER_4,
                        new ResourceLocation(Constants.MOD_ID, "textures/entities/walker/walker_4.png"));
    });

    public WalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WalkerModel());
    }

    @Override
    public ResourceLocation getTextureLocation(WalkerEntity animatable) {
        return LOCATION_BY_VARIANT.get(animatable.getVariant());
    }

    @Override
    public void render(WalkerEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
