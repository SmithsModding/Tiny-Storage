package com.smithsmodding.tinystorage.client.registries;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.smithsmodding.tinystorage.api.client.modules.IModelProvidingModule;
import com.smithsmodding.tinystorage.api.client.registries.IModuleModelRegistry;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Author Orion (Created on: 30.06.2016)
 */
public class HashedModuleModelRegistry implements IModuleModelRegistry {

    private HashMap<String, IModel> unbakedModels = new HashMap<>();
    private HashMap<String, IBakedModel> bakedModels = new HashMap<>();

    @Override
    public void registerModuleModel(IModelProvidingModule module, IModel model) {
        registerModuleModel(module.getUniqueID(), model);
    }

    @Override
    public void registerModuleModel(String Id, IModel model) {
        unbakedModels.put(Id, model);
    }

    @Override
    public IModel getModelForModule(String moduleId) {
        return unbakedModels.get(moduleId);
    }

    @Override
    public IModel getModelForModule(IModelProvidingModule module) {
        return getModelForModule(module.getUniqueID());
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
        ImmutableList.Builder<ResourceLocation> builder = new ImmutableList.Builder<>();

        for (IModel model : unbakedModels.values()) {
            builder.addAll(model.getTextures());
        }

        return builder.build();
    }

    @Override
    public ImmutableMap<String, IBakedModel> bakeAll(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        ImmutableMap.Builder<String, IBakedModel> builder = new ImmutableMap.Builder<>();

        for (Map.Entry<String, IModel> entry : unbakedModels.entrySet()) {
            builder.put(entry.getKey(), entry.getValue().bake(state, format, bakedTextureGetter));
        }

        return builder.build();
    }
}
