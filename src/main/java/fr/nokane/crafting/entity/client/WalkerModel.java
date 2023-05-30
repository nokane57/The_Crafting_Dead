package fr.nokane.crafting.entity.client;

import fr.nokane.crafting.entity.custom.WalkerEntity;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WalkerModel extends GeoModel<WalkerEntity> {
    @Override
    public ResourceLocation getModelResource(WalkerEntity animatable) {
        return new ResourceLocation(Constants.MOD_ID, "geo/walker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WalkerEntity animatable) {
        return WalkerRenderer.LOCATION_BY_VARIANT.get(animatable.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(WalkerEntity animatable) {
        return new ResourceLocation(Constants.MOD_ID, "animations/walker.animation.json");
    }

//    @Override
//    public void setCustomAnimations(WalkerEntity animatable, long instanceId, AnimationState<WalkerEntity> animationState) {
//        CoreGeoBone head = getAnimationProcessor().getBone("head");
//
//        if (head != null) {
//            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
//            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
//            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
//        }
//    }
}
