package model;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GraphicalObject {

    private String mode;
    private double mouseX,mouseY;

    private BufferedImage[] images;
    private Body player;
    private PointerInfo a;

    /**
     * Der Konstruktor der Klasse Background
     * @param player <- das , ist der Spieler!
     */
    public Background(Body player){
        mode="fight";
        this.player=player;
        images=new BufferedImage[2];
        images[0]= createNewImage("assets/images/wip.png");
        images[1]=createNewImage("assets/images/menue.png");
    }

    /**
     * Zeichnet die Hintergründe , die sich im laufe des Spieles verändern.
     * @param drawTool
     */
    @Override
    public void draw(DrawTool drawTool) {
        if(mode.equals("fight")) {
            drawTool.camera(-player.getX()/7,-player.getY()/7);
            drawTool.drawImage(images[0], -100, -450);
        }
    }

    /**
     * Kümmert sich umd die Maus Kooooooordinaten
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    @Override
    public void update(double dt) {
        a = MouseInfo.getPointerInfo();
        mouseX=a.getLocation().getX();
        mouseY=a.getLocation().getY();
        System.out.println(mouseX+" / "+mouseY);
    }

    /**
     * Wenn eine Taste gedrückt wird , passiert etwas! Vielleicht...
     * @param key Taste die gedrückt wurde
     */
    @Override
    public void keyPressed(int key) {
        //if(key== KeyEvent.VK_ESCAPE){
         //   mode="menue";
        //}

    }
}
