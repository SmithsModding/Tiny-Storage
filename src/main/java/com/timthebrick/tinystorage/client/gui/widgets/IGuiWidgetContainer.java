package com.timthebrick.tinystorage.client.gui.widgets;

import java.util.ArrayList;

public interface IGuiWidgetContainer {

    ArrayList<IGuiWidgetAdvanced> getContainedWidgets();

    boolean getKeyCaptured();

}
