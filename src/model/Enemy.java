package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.view.DrawTool;

import java.io.File;

public class Enemy extends Body {

    private double[] hidden,input, output;

    private int gen;

    private Body player;

    /**
     * Konstruktor der Klasse Enemy
     * @param uiController der UiController der übergeben wird beim Methodenaufruf , yey.
     */
    public Enemy(UIController uiController, Body player){
        super(uiController);
        hidden=new double[1];
        createData();
        x=500;
        this.player=player;
        gen=1;
        output=new double[3];
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
            if (output[i] >= i && output[i] <= i + 1) {
                mode = i;
            }
        }
        if(time>=8){
            time=0;
        }

        double tan=Math.atan2(output[0]-y,output[1]-x);
        x+=Math.cos(tan)*stats[2]*dt;
        y+=Math.sin(tan)*stats[2]*dt;
        //datas[0]=getDistanceToPlayer();
    }

    /**
     * Es lernt , Daten sind toll . Es wird schlau , irgendwann
     */
    public void studyTheShitOuttaDat(){
        if(player.getStat(0)<=0){
            //Freude
        }
        if(stats[0]<=0){
            //Böse
        }

    }

    /**
     *
     * @return gibt die Distanz des Spielers zurück
     */
    public double getDistanceToPlayer(){
        return Math.sqrt(Math.pow(x-player.getX(),2)+Math.pow(y-player.getY(),2));
    }

    /**
     * Es speichert einen File mit Informationen
     */

    /**
     * Es erstellt einen File mit ohne Informationen
     */
    public void createData(){
         File f=new File("assets/data/","Data");
         try {
             f.createNewFile();
         }catch (Exception e){
             System.out.println("ES SCHMERZT!!!!!!");
         }
    }

}
