package fr.nokane.crafting.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.nokane.crafting.entity.custom.WalkerEntity;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WalkerRenderer extends GeoEntityRenderer<WalkerEntity> {

    public WalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WalkerModel());
    }

    @Override
    public ResourceLocation getTextureLocation(WalkerEntity animatable) {
        return new ResourceLocation(Constants.MOD_ID, "textures/entity/walker/walker.png");
    }

    @Override
    public void render(WalkerEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.4F, 0.4F, 0.4F);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
