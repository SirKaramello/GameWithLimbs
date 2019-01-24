package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Background extends GraphicalObject {

    private String mode;
    private double mouseX,mouseY,time,cx,cy;
    private int currentshop;
    private int frameX;
    private int frameY;
    private boolean frameActive;

    private BufferedImage[] images;
    private UIController uic;
    private Body player;
    private PointerInfo a;
    private GraphicsEnvironment gd;
    private Shop shop;



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
        shop=new Shop(uiC);
        currentshop = 1;
        frameX = 0;
        frameY = 0;
        frameActive = false;

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
        if(mode.equals("menue")){
            drawTool.camera(0,0);
            drawTool.drawImage(images[1],0,0);
            shop.draw(drawTool);
        }
        if(mode.equals("shop")){
            switch (currentshop){
                case 1: shop.drawShopWeapon(drawTool); break;
                case 2: shop.drawShopPotions(drawTool); break;
                case 3: shop.drawShopShield(drawTool); break;
            }
        }
        if(frameActive){
            shop.drawShopFrame(drawTool,frameX,frameY);
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
        if(player.getX()<-100){
            player.setX(-100);
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

    public void mouseCoordinatos(){
        if(mouseX>10 && mouseX<200 && mouseY>100 && mouseY<200){
            mode="shop";
        }
    }

    /**
     * Wenn eine Taste gedrückt wird , passiert etwas! Vielleicht...
     * @param key Taste die gedrückt wurde
     */
    @Override
    public void keyPressed(int key) {
        if(key== KeyEvent.VK_M){
            mode="menue";
        }
        if(key== KeyEvent.VK_N){
            mode="fight";
        }
    }

    public void mousePressed(MouseEvent e){
        if(mouseX>10 && mouseX<600 && mouseY>100 && mouseY<240 && e.getButton()==1 && mode.equals("menue")){
            mode="shop";
        }
        if(mode.equals("shop")) {
            if (mouseY > 785 && mouseY < 875){
                if (mouseX > 555 && mouseX < 655) {
                    currentshop = 1;
                    frameActive = false;
                }
                if (mouseX > 655 && mouseX < 755) {
                    currentshop = 2;
                    frameActive = false;
                }
                if (mouseX > 755 && mouseX < 855){
                    currentshop = 3;
                    frameActive = false;
                }
            }
            if (mouseY > 400 && mouseY < 560 && mouseX > 600 && mouseX < 1000){
                if (mouseY < 470){
                    if (mouseX < 680){
                        frameX = 600;
                        frameY = 380;
                        frameActive = true;
                    }
                    if (mouseX > 708 && mouseX<780){
                        frameX = 708;
                        frameY = 380;
                        frameActive = true;
                    }
                    if (mouseX > 815 && mouseX<890){
                        frameX = 815;
                        frameY = 380;
                        frameActive = true;
                    }
                    if (mouseX > 918){
                        frameX = 918;
                        frameY = 380;
                        frameActive = true;
                    }

                }
                if (mouseY > 500){
                    if (mouseX < 680){
                        frameX = 600;
                        frameY = 485;
                        frameActive = true;
                    }
                    if (mouseX > 708 && mouseX<780){
                        frameX = 708;
                        frameY = 485;
                        frameActive = true;
                    }
                    if (mouseX > 815 && mouseX<890){
                        frameX = 815;
                        frameY = 485;
                        frameActive = true;
                    }
                    if (mouseX > 918){
                        frameX = 918;
                        frameY = 485;
                        frameActive = true;
                    }

                }
            }

        }

    }

}
