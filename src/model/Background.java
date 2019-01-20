package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Background extends GraphicalObject {

    private String mode;
    private double mouseX,mouseY,time,cx,cy;

    private BufferedImage[] images;
    private UIController uic;
    private Body player;
    private PointerInfo a;
    private GraphicsEnvironment gd;

    /**
     * Der Konstruktor der Klasse Background
     * @param player <- das , ist der Spieler!
     */
    public Background(Body player , UIController uiC){
        uic=uiC;
        mode="fight";
        gd=GraphicsEnvironment.getLocalGraphicsEnvironment();
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
            drawTool.camera(100,-cy/3);
            drawTool.drawImage(images[0], -100, -450);
        }
    }

    /**
     * Kümmert sich umd die Maus Kooooooordinaten
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    @Override
    public void update(double dt) {
        cx=player.getX();
        cy=player.getY()-500;
        if(player.getX()+player.getWidth()/2<-100){
            player.setMode("falling");
            mode="death";
        }
        if(cy<=-400){
            cy=-400;
        }
        if(uic.isKeyDown(KeyEvent.VK_ESCAPE)){
            time+=dt;
            if(time>=1){
                System.exit(1);
            }
        }else{
            time =0;
        }
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
