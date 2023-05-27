package fr.nokane.crafting.entity.client;

import fr.nokane.crafting.entity.custom.WalkerEntity;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WalkerModel extends GeoModel<WalkerEntity> {
    @Override
    public ResourceLocation getModelResource(WalkerEntity animatable) {
        return new ResourceLocation(Constants.MOD_ID, "geo/walker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WalkerEntity animatable) {
        return new ResourceLocation(Constants.MOD_ID, "textures/entity/walker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WalkerEntity animatable) {
        return new ResourceLocation(Constants.MOD_ID, "animations/walker.animation.json");
    }

    @Override
    public void setCustomAnimations(WalkerEntity animatable, long instanceId, AnimationState<WalkerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
