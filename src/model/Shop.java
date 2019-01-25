package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shop extends GraphicalObject {

    protected int currentShopPage;
    protected int currentItem;

    protected UIController uic;
    protected BufferedImage icon;
    protected BufferedImage shields;
    protected BufferedImage potions;
    protected BufferedImage weappons;
    protected BufferedImage frame;
    protected BufferedImage [] weaponInfos = new BufferedImage[8];
    protected BufferedImage [] potionInfos = new BufferedImage[8];
    protected BufferedImage [] shieldInfos = new BufferedImage[2];

    protected Item shopItems [][] = new Item[3][8];

    public Shop(UIController uiController) {
        uic=uiController;
        GraphicsEnvironment gd= GraphicsEnvironment.getLocalGraphicsEnvironment();
        icon = createNewImage("assets/images/Shop/Shop Icon.png");
        shields = createNewImage("assets/images/Shop/Shop Toll Schilder.png");
        potions = createNewImage("assets/images/Shop/Shop Toll Tränke.png");
        weappons = createNewImage("assets/images/Shop/Shop Toll Waffen.png");
        frame = createNewImage("assets/images/Shop/Fetter Rahmen.png");

        weaponInfos[0] = createNewImage("assets/images/weapons/Sword (0).png");
        weaponInfos[1] = createNewImage("assets/images/weapons/AX (1).png");
        weaponInfos[2] = createNewImage("assets/images/weapons/Morning Star (2).png");
        weaponInfos[3] = createNewImage("assets/images/weapons/Crossbow (3.png");
        weaponInfos[4] = createNewImage("assets/images/weapons/purple sword (4).png");
        weaponInfos[5] = createNewImage("assets/images/weapons/stick (5).png");
        weaponInfos[6] = createNewImage("assets/images/weapons/silver (6).png");
        weaponInfos[7] = createNewImage("assets/images/weapons/gold (7).png");

        potionInfos[0] = createNewImage("assets/images/potionInfos/turqouise (0).png");
        potionInfos[1] = createNewImage("assets/images/potionInfos/green-yellowy (1).png");
        potionInfos[2] = createNewImage("assets/images/potionInfos/brownish (2).png");
        potionInfos[3] = createNewImage("assets/images/potionInfos/orange (3).png");
        potionInfos[4] = createNewImage("assets/images/potionInfos/yellow (4).png");
        potionInfos[5] = createNewImage("assets/images/potionInfos/galaxy (5).png");
        potionInfos[6] = createNewImage("assets/images/potionInfos/fancy af (6).png");
        potionInfos[7] = createNewImage("assets/images/potionInfos/expensive (7).png");

        shieldInfos[0] = createNewImage("assets/images/schilder/shield (0).png");
        shieldInfos[1] = createNewImage("assets/images/schilder/backpack (1).png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(icon,100,80);
    }

    public void drawShopShield(DrawTool drawTool){
        drawTool.drawImage(shields,550,250);
    }

    public void drawShopWeapon(DrawTool drawTool){
        drawTool.drawImage(weappons,550,250);
    }

    public void drawShopPotions(DrawTool drawTool){
        drawTool.drawImage(potions,550,250);
    }

    public void drawShopFrame(DrawTool drawTool,int pX,int pY){
        drawTool.drawImage(frame,pX,pY);
    }

    public int getCurrentShopPage() {
        return currentShopPage;
    }

    public void setCurrentShopPage(int currentShopPage) {
        this.currentShopPage = currentShopPage;
    }

    public int getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }

    public void drawSpecifiedInfos (DrawTool drawTool){
        int first = this.getCurrentShopPage();
        int second = this.getCurrentItem();
        for (int i= 0; i < 8; i++) {
            if (first == 0) {
                if (second == i) {
                    drawTool.drawImage(weaponInfos[i], 1055, 300);
                }
            }
            if (first == 1) {
                if (second == i) {
                    drawTool.drawImage(potionInfos[i], 1055, 300);
                }
            }
            if (first == 2) {
                if (second == 0) {
                    drawTool.drawImage(shieldInfos[0], 1055, 300);
                }
                if (second == 1) {
                    drawTool.drawImage(shieldInfos[1], 1055, 300);
                }
            }
        }
    }


}
