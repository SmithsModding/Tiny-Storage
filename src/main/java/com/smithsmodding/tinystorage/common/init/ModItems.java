package com.smithsmodding.tinystorage.common.init;

import java.util.ArrayList;
import java.util.List;

import com.smithsmodding.tinystorage.common.item.*;
import com.smithsmodding.tinystorage.common.reference.References;
import net.minecraft.item.Item;

import com.smithsmodding.tinystorage.common.core.TinyStorageLog;
import com.smithsmodding.tinystorage.common.reference.Names;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(References.MOD_ID)
public class ModItems {
	public static List<Item> tinyStorageItems = new ArrayList<Item>();
	
	public static Item itemStorageUpgrade = new ItemStorageComponent();
	public static Item itemChestFilter = new ItemChestFilter();
	public static Item itemChestLock = new ItemChestLock();
	public static Item itemDebugTool = new ItemDebugTool();
	public static Item itemStorageBag = new ItemStorageBag();
	public static Item itemFriendSetter = new ItemFriendSetter();
	
	public static void init(){
		TinyStorageLog.info("Initialising Items");
		
		registerItem(itemStorageUpgrade, Names.Items.STORAGE_COMPONENT);
		registerItem(itemChestFilter, Names.Items.CHEST_FILTER);
		registerItem(itemChestLock, Names.Items.CHEST_LOCK);
		registerItem(itemDebugTool, Names.Items.DEBUG_TOOL);
        registerItem(itemStorageBag, Names.Items.STORAGE_BAG);
		registerItem(itemFriendSetter, Names.Items.FRIEND_SETTER);
	}
	
	private static void registerItem(Item item, String name){
		TinyStorageLog.info("Attempting to register item: " + item.getUnlocalizedName());
		try {
			GameRegistry.registerItem(item, name);
			tinyStorageItems.add(item);
		} catch (Exception e) {
			TinyStorageLog.error(e);
		}
	}

}