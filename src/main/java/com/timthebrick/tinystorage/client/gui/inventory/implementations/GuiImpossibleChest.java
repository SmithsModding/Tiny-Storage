package com.timthebrick.tinystorage.client.gui.inventory.implementations;

import com.timthebrick.tinystorage.client.gui.inventory.GuiTinyStorage;
import com.timthebrick.tinystorage.client.gui.widgets.GuiScrollBar;
import com.timthebrick.tinystorage.client.gui.widgets.IGuiWidget;
import com.timthebrick.tinystorage.client.gui.widgets.IWidgetReceptor;
import com.timthebrick.tinystorage.core.TinyStorageLog;
import com.timthebrick.tinystorage.inventory.implementations.ContainerImpossibleChest;
import com.timthebrick.tinystorage.reference.Colours;
import com.timthebrick.tinystorage.reference.Names;
import com.timthebrick.tinystorage.reference.References;
import com.timthebrick.tinystorage.tileentity.implementations.TileEntityImpossibleChest;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiImpossibleChest extends GuiTinyStorage {

    private TileEntityImpossibleChest tileEntity;
    protected GuiScrollBar scrollBar;

    public GuiImpossibleChest(InventoryPlayer inventoryPlayer, TileEntityImpossibleChest tileEntity) {
        super(new ContainerImpossibleChest(inventoryPlayer, tileEntity), tileEntity);
        this.tileEntity = tileEntity;
        xSize = 194;
        ySize = 222;
    }

    @Override
    public void addWidgets() {
        if (scrollBar == null) {
            TinyStorageLog.info("Creating scroll bar");
            this.scrollBar = new GuiScrollBar(this, 174, 18, 106);
            this.addWidget(scrollBar);
        } else {
            scrollBar.adjustPosition();
        }
        super.addWidgets();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        if (tileEntity.hasOwner()) {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()) + " - " + tileEntity.getOwner(), 8, 6, Colours.INV_GRAY);
        } else {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()), 8, 6, Colours.INV_GRAY);
        }
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 8, ySize - 95 + 2, Colours.INV_GRAY);
        drawFG(0, 0, x, y);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiImpossibleChest.png"));
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        drawBG(0, 0, x, y);
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    public void drawFG(int ox, int oy, int x, int y) {
        super.drawFG(ox, oy, x, y);
    }

    @Override
    public void drawBG(int ox, int oy, int x, int y) {
        handleWidgetVisibility();
        super.drawBG(ox, oy, x, y);
    }

    @Override
    protected void mouseClicked(int xCoord, int yCoord, int btn) {
        if (scrollBar != null) {
            scrollBar.mouseClicked(xCoord, yCoord, btn);
        }
        super.mouseClicked(xCoord, yCoord, btn);
    }

    @Override
    protected void mouseClickMove(int x, int y, int button, long time) {
        if (scrollBar != null) {
            scrollBar.mouseClickMove(x, y, button, time);
            return;
        }
        super.mouseClickMove(x, y, button, time);
    }

    @Override
    protected void mouseMovedOrUp(int x, int y, int button) {
        if (scrollBar != null) {
            scrollBar.mouseMovedOrUp(x, y, button);
            scrollBar = null;
        }
        super.mouseMovedOrUp(x, y, button);
    }

    @Override
    public void handleWidgetFunctionality(IGuiWidget widget) {
        TinyStorageLog.info(widget.toString());
        if (this.container instanceof IWidgetReceptor) {
            ((IWidgetReceptor) container).handleWidgetInteraction(widget);
        }
        super.handleWidgetFunctionality(widget);
    }

    @Override
    public void handleWidgetVisibility() {
        if (this.scrollBar != null) {
            this.scrollBar.setVisibility(true);
        }
        super.handleWidgetVisibility();
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addWidgets();
    }
}
