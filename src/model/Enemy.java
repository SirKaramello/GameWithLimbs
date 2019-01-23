package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.io.File;

public class Enemy extends Body {

    //Attribute
    private double[] input, hidden , output;
    private double succesRate,tan;
    private int gen;
    private boolean lel;

    //Referenzen
    private GraphicsEnvironment gd;

    /**
     * Konstruktor der Klasse Enemy
     * @param uiController der UiController der übergeben wird beim Methodenaufruf , yey.
     */
    public Enemy(UIController uiController , Body enemy){
        super(uiController);
        hidden=new double[3];
        output=new double[3];
        input=new double[3];
        this.enemy=enemy;
        gen=1;
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
        time+=7*dt;
        for(int i=0;i<output.length;i++) {
        }
        if(time>=8){
            time=0;
        }
        if(output[0]<=0.25) {
            double tan = Math.atan2(enemy.getY() - y, enemy.getX() - x);
            x += Math.cos(tan) * stats[2] * dt;
            y += Math.sin(tan) * stats[2] * dt;
        }
        if(lel) {
            tan = Math.atan2(Math.random() * gd.getDefaultScreenDevice().getDisplayMode().getHeight() - y, Math.random() * gd.getDefaultScreenDevice().getDisplayMode().getWidth() - x);
        }
        if(output[0]>0.25 && output[0]<=0.5){
            lel=false;
            x += Math.cos(tan) * stats[2] * dt;
            y += Math.sin(tan) * stats[2] * dt;
        }
        mode2="fightE";
        fighting(dt);
    }

    /**
     * Es lernt , Daten sind toll . Es wird schlau , irgendwann
     */
    public void studyTheShitOuttaDat(){
        if(succesRate<1) {
            input[0] = getDistanceToPlayer();
            for (int i = 0; i < hidden.length; i++) {
                hidden[i] = input[0];
            }
        }
        if(enemy.getStat(0)<=0){
            succesRate=succesRate*1.25;
        }
        if(stats[0]<=0){
            succesRate=succesRate*0.25;
        }
    }

    /**
     *
     * @return gibt die Distanz des Spielers zurück
     */
    public double getDistanceToPlayer(){
        return Math.sqrt(Math.pow(x-enemy.getX(),2)+Math.pow(y-enemy.getY(),2));
    }

    /**
     * Es speichert einen File mit Informationen
     */


}
