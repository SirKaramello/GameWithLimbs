package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Shop extends GraphicalObject {

    protected UIController uic;
    protected BufferedImage icon;
    protected BufferedImage shields;
    protected BufferedImage potions;
    protected BufferedImage weappons;

    public Shop(UIController uiController) {
        uic=uiController;
        icon = createNewImage("/assets/images/Shop/Shop Icon.png");
        shields = createNewImage("/assets/images/Shop/Shop Toll Schilder.png");
        potions = createNewImage("/assets/images/Shop/Shop Toll Tränke.png");
        weappons = createNewImage("/assets/images/Shop/Shop Toll Waffen.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(icon,500,500);
    }
}
