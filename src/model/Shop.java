package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shop extends GraphicalObject {

    protected UIController uic;
    protected BufferedImage icon;
    protected BufferedImage shields;
    protected BufferedImage potions;
    protected BufferedImage weappons;
    protected BufferedImage frame;

    public Shop(UIController uiController) {
        uic=uiController;
        GraphicsEnvironment gd= GraphicsEnvironment.getLocalGraphicsEnvironment();
        icon = createNewImage("assets/images/Shop/Shop Icon.png");
        shields = createNewImage("assets/images/Shop/Shop Toll Schilder.png");
        potions = createNewImage("assets/images/Shop/Shop Toll Tränke.png");
        weappons = createNewImage("assets/images/Shop/Shop Toll Waffen.png");
        frame = createNewImage("assets/images/Shop/Fetter Rahmen.png");
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
}
