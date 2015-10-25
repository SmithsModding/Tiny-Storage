package com.smithsmodding.tinystorage.client.gui.inventory.implementations;

import com.smithsmodding.tinystorage.common.reference.References;
import com.smithsmodding.tinystorage.common.tileentity.implementations.TileEntityQuarryChest;
import com.smithsmodding.tinystorage.util.client.Colours;
import com.smithsmodding.tinystorage.client.gui.GuiTinyStorage;
import com.smithsmodding.tinystorage.common.inventory.implementations.ContainerQuarryChest;
import com.smithsmodding.tinystorage.common.reference.Names;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiQuarryChest extends GuiTinyStorage {

    private TileEntityQuarryChest tileEntity;

    public GuiQuarryChest (InventoryPlayer inventoryPlayer, TileEntityQuarryChest tileEntity) {
        super(new ContainerQuarryChest(inventoryPlayer, tileEntity), tileEntity);
        this.tileEntity = tileEntity;
        if (this.tileEntity.getState() == 0) {
            xSize = 176;
            ySize = 133;
        } else if (this.tileEntity.getState() == 1) {
            xSize = 176;
            ySize = 151;
        } else if (this.tileEntity.getState() == 2) {
            xSize = 176;
            ySize = 169;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer (int x, int y) {
        if (tileEntity.hasOwner()) {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()) + " - " + tileEntity.getOwner(), 8, 6, Colours.INV_GRAY);
        } else {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()), 8, 6, Colours.INV_GRAY);
        }
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 8, ySize - 95 + 2, Colours.INV_GRAY);
        this.drawFG(0, 0, x, y);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer (float opacity, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (tileEntity.getState() == 0) {
            this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiChestSmall.png"));
        } else if (tileEntity.getState() == 1) {
            this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiChestMedium.png"));
        } else if (tileEntity.getState() == 2) {
            this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":textures/gui/guiChestLarge.png"));
        }
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        drawBG(0, 0, x, y);
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    public void drawFG (int ox, int oy, int x, int y) {
        super.drawFG(ox, oy, x, y);
    }

    @Override
    public void drawBG (int ox, int oy, int x, int y) {
        super.drawBG(ox, oy, x, y);
    }

    @Override
    public void initGui () {
        super.initGui();
    }

}