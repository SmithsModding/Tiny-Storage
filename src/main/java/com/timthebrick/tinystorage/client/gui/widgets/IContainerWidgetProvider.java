package com.timthebrick.tinystorage.client.gui.widgets;

import com.timthebrick.tinystorage.client.gui.inventory.IGuiContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public interface IContainerWidgetProvider extends IScreenWidgetProvider, IGuiContainer {

    /**
     * Add the widgets to the gui
     */
    void addWidgets();

    /**
     * Handle the visibility of the widgets
     */
    void handleWidgetVisibility();

    /**
     * Add a widget to the GUI
     *
     * @param widget The widget to add
     */
    void addWidget(IGuiWidgetSimple widget);

    /**
     * Remove a widget from the GUI
     *
     * @param widget The widget to remove
     */
    void removeWidget(IGuiWidgetSimple widget);

    /**
     * Called whenever a widget does something
     */
    void handleWidgetFunctionality(IGuiWidgetAdvanced widget);

    Minecraft getMinecraft();

    TileEntity getTileEntity();

}