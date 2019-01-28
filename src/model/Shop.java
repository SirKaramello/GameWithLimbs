package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import akkgframework.model.abitur.datenstrukturen.List;
import control.ProgramController;
import model.Potions.*;
import model.weapons.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shop extends GraphicalObject {
    //Attribute
    protected int currentShopPage,currentItem;
    //Referenzen
    protected UIController uic;
    protected BufferedImage icon,frame,shields,potions,weapons;
    protected BufferedImage [] weaponInfos = new BufferedImage[8];
    protected BufferedImage [] potionInfos = new BufferedImage[8];
    protected BufferedImage [] shieldInfos = new BufferedImage[2];
    protected Body sp;
    protected Item shopItems [][] = new Item[3][8];

    /**
     * Der Konstruktor der Klasse Shop.
     * Alle Fotos werden erzeugt und unter bestimmten Pfaden abgespeichert.
     * @param uiController
     */
    public Shop(UIController uiController,Body player) {
        uic=uiController;
        GraphicsEnvironment gd= GraphicsEnvironment.getLocalGraphicsEnvironment();
        icon = createNewImage("assets/images/Shop/Shop Icon.png");
        shields = createNewImage("assets/images/Shop/Shop Toll Schilder.png");
        potions = createNewImage("assets/images/Shop/Shop Toll Tränke.png");
        weapons = createNewImage("assets/images/Shop/Shop Toll Waffen.png");
        frame = createNewImage("assets/images/Shop/Fetter Rahmen.png");

        weaponInfos[0] = createNewImage("assets/images/weapons/Sword (0).png");
        weaponInfos[1] = createNewImage("assets/images/weapons/AX (1).png");
        weaponInfos[2] = createNewImage("assets/images/weapons/Morning Star (2).png");
        weaponInfos[3] = createNewImage("assets/images/weapons/Crossbow (3.png");
        weaponInfos[4] = createNewImage("assets/images/weapons/purple sword (4).png");
        weaponInfos[5] = createNewImage("assets/images/weapons/stick (5).png");
        weaponInfos[6] = createNewImage("assets/images/weapons/Silver (6).png");
        weaponInfos[7] = createNewImage("assets/images/weapons/Gold (7).png");

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

        sp = player;
        shopItemsAdden();


    }

    /**
     * Das Shop Icon wird gezeichnet
     * @param drawTool hiermit wird gezeichnet,
     */

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(icon,100,80);
    }

    /**
     * Die verschiedenen Shopseiten werden gezeichnet.
     * @param drawTool
     */
    public void drawShopShield(DrawTool drawTool){
        drawTool.drawImage(shields,550,250);
        drawTool.drawText(550,200,"Du hast " + sp.getLire() + " Lire(die Währung in diesem Spiel) zur Verfügung");
    }

    public void drawShopWeapon(DrawTool drawTool){
        drawTool.drawImage(weapons,550,250);
        drawTool.drawText(550,200,"Du hast " + sp.getLire() + " Lire(die Währung in diesem Spiel) zur Verfügung");
    }

    public void drawShopPotions(DrawTool drawTool){
        drawTool.drawImage(potions,550,250);
        drawTool.drawText(550,200,"Du hast " + sp.getLire() + " Lire(die Währung in diesem Spiel) zur Verfügung");
    }

    /**
     * Shopframe wird gezeichnet
     * @param drawTool zeichenwerkezug
     * @param pX x koordinate des shop
     * @param pY y koordinate desshops
     */
    public void drawShopFrame(DrawTool drawTool,int pX,int pY){
        drawTool.drawImage(frame,pX,pY);
    }

    /**
     * @return Übergibt die jetzige Zahl der Shopseite
     */
    public int getCurrentShopPage() {
        return currentShopPage;
    }

    /**
     * Setzt die jetzige Shopseite zu einer neuen
     * @param currentShopPage die Zahl der Shopseite
     */
    public void setCurrentShopPage(int currentShopPage) {
        this.currentShopPage = currentShopPage;
    }

    /**
     * @return Gibt das aktuelle Item zurück
     */
    public int getCurrentItem() {
        return currentItem;
    }

    /**
     * Setzt das aktuelle Item
     * @param currentItem die Zahl für das setzen des neues Items
     */
    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }

    /**
     * @return gibt den Namen des Items zurück
     */
    public String getTheCurrentShopItemName(){
        return shopItems[getCurrentShopPage()][getCurrentItem()].getName();
    }

    /**
     * @return Gibt den Preis des jetzigen Items
     */
    public int getTheCurrentShopItemCost(){
        return shopItems[getCurrentShopPage()][getCurrentItem()].getCost();
    }

    /**
     * Die Infos zu den Items werden gezeichnet.
     * @param drawTool
     */
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

    /**
     * Alle Items werden in das Shop Array getan.
     */

   public void shopItemsAdden(){
        shopItems [0][0] = new Sword(sp);
        shopItems [0][1] = new Ax(sp);
        shopItems [0][2] = new MorningStar(sp);
        shopItems [0][3] = new Crossbow(sp);
        shopItems [0][4] = new PurpleSword(sp);
        shopItems [0][5] = new Stick(sp);
        shopItems [0][6] = new Silver(sp);
        shopItems [0][7] = new Gold(sp);
        shopItems [1][0] = new Turqouise(sp);
        shopItems [1][1] = new GreenYellowy(sp);
        shopItems [1][2] = new Brownish(sp);
        shopItems [1][3] = new Orange(sp);
        shopItems [1][4] = new Yellow(sp);
        shopItems [1][5] = new Galaxy(sp);
        shopItems [1][6] = new FancyAf(sp);
        shopItems [1][7] = new Expensive(sp);
        shopItems [2][2] = new Shield(sp);
    }

    /**
     * Packt das gekaufte Item in das Inventar
     * @param inventar das inventar in welches das objekt hinzugefügt wird
     */
    public void shopItemKaufen(List<Item> inventar){
        inventar.append(shopItems[this.getCurrentShopPage()][this.getCurrentItem()]);
    }

    /**
     * Kauft das ausgewählte Item
     */
    public void gekauft(){
        shopItems[getCurrentShopPage()][getCurrentItem()].gotBought();
    }
}
