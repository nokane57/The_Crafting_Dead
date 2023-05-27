package fr.nokane.crafting.datagen;

import fr.nokane.crafting.item.ModItems;
import fr.nokane.crafting.utils.Constants;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.WALKER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
