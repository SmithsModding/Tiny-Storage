package com.smithsmodding.tinystorage.common.proxy;

/**
 * Created by Tim on 19/06/2016.
 */
public interface IProxy {

    ClientProxy getClientProxy ();

    CommonProxy getCommonProxy();

    void initRenderingAndTextures ();

    void registerEventHandlers ();

    void registerKeyBindings ();

    String getMinecraftVersion ();

    void preInit();

    void init();

    void postInit();

    void registerIMCs();
}
