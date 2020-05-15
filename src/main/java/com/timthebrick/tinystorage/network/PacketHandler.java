package com.timthebrick.tinystorage.network;

import com.timthebrick.tinystorage.common.reference.References;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {

    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static int nextID(){
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(References.MOD_ID, "tinystorage"), () -> "1.0", s -> true, s-> true);
    }

}
