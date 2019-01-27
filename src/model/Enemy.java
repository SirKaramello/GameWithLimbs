package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.io.File;

public class Enemy extends Body {

    //Attribute
    private double tan;
    private String state;
    private boolean lel;

    //Referenzen
    private GraphicsEnvironment gd;

    /**
     * Konstruktor der Klasse Enemy
     * @param uiController der UiController der übergeben wird beim Methodenaufruf , yey.
     */
    public Enemy(UIController uiController , Body enemy){
        super(uiController);
        this.enemy=enemy;
        mode2="stand";
        mode="none";
        setRandomStats();
        state="attack";
        width=body.getTile(0,0).getWidth();
        height=body.getTile(0,0).getHeight();
    }

    /**
     *
     */
    public void setRandomStats(){
        for(int i=0;i<stats.length;i++){
            stats[i]=(int)(10+Math.random()*300);
        }
    }
    /**
     * Zeichnet den Gegner
     * @param drawTool ist das Werkzeug zum zeichnen von Objekten
     */
    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
    }

    /**
     * Bewegt und ändert den Modus des Gegners
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    @Override
    public void update(double dt) {
        if (bg != null && bg.getMode().equals("fight")) {
            super.update(dt);
            time+=10*dt;
            if(time>=8){
                time=0;
            }
            if (time >= 8) {
                time = 0;
            }
            if (state.equals("attack")) {
                double tan = Math.atan2(enemy.getY() - y, enemy.getX() - x);
                x += Math.cos(tan) * stats[2] * dt;
                y += Math.sin(tan) * stats[2] * dt;
                if(x<=enemy.getX()){
                    mode="right";
                }else {
                    mode = "left";
                }
            }
            if (lel) {
                tan = Math.atan2(Math.random() * gd.getDefaultScreenDevice().getDisplayMode().getHeight() - y, Math.random() * gd.getDefaultScreenDevice().getDisplayMode().getWidth() - x);
            }
            if(enemy.collidesWith(enemy)){
                mode2="fightE";
                fighting(dt);
            }else{
                mode2="stand";
            }
            if (state.equals("flea")) {
                lel = false;
                x += Math.cos(tan) * stats[2] * dt;
                y += Math.sin(tan) * stats[2] * dt;
            }

        }
        if (stats[0] <= 20) {
            state = "flea";
        } else{
            state = "attack";
        }
        if(stats[0]<=0){
            x=gd.getDefaultScreenDevice().getDisplayMode().getWidth()-100;
            y=gd.getDefaultScreenDevice().getDisplayMode().getHeight()/2;
            stats[0]=256;
        }
        System.out.println(mode +" Gegner");
        System.out.println(mode2 +" GegnerMode2");
    }


    /**
     *
     * @return gibt die Distanz des Spielers zurück
     */
    public double getDistanceToPlayer(){
        return Math.sqrt(Math.pow(x-enemy.getX(),2)+Math.pow(y-enemy.getY(),2));
    }


}
