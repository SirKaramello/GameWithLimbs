package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Body extends GraphicalObject {

    //Attribute;
    protected double  time;
    protected String mode,mode2;
    protected int[] stats  ;
    protected int hpMax, stMax;
    protected double[] hitbox;

    //Referenzen
    private Limb[] legs ,arms;
    protected Tileset body , fight, stand;
    protected UIController uic;
    protected BufferedImage[] bars;
    private Enemy enemy;

    //0=hp 1=stamina 2=speed 3=strength 4=resistance
    public Body(UIController uiController){
        hitbox=new double[4];
        uic=uiController;
        stats=new int[5];
        stats[2]=300;
        width=20;height=width*2;
        body=new Tileset("assets/images/runningb.png",256,360);
        fight=new Tileset("assets/images/fighting.png",256,360);
        stand= new Tileset("assets/images/stan.png",256,360);
        bars=new BufferedImage[2];
        bars[0]=createNewImage("assets/images/layout/hpbar.png");
        bars[1]=createNewImage("assets/images/layout/stbar.png");
        stats[0]=bars[0].getWidth();
        stats[1]=bars[1].getWidth();
        mode="stand";
        mode2="nonde";
    }

    /**
     * Zeichnet jegliche Animation des Körpers mit einem Tileset
     * @param drawTool ist das werkzeug zum zeichnen von Objekten
     */
    @Override
    public void draw(DrawTool drawTool) {
        for(int i=0;i<stats[0];i++){
            drawTool.setCurrentColor(0,70,100,255);
            drawTool.drawFilledRectangle(x+i,y,1,32);
        }
        for(int i=0;i<stats[1];i++){
            drawTool.setCurrentColor(0,125,100,255);
            drawTool.drawFilledRectangle(x+i,y+30,1,32);
        }
        drawTool.drawImage(bars[0],x,y);
        drawTool.drawImage(bars[1],x,y+30);
        drawPlayer(drawTool);
    }

    /**
     * Zeichnet den wunderbaren , großartigen , unglaublichen Spieler
     * @param drawTool das Werkzeug für das Zeichnen
     */
    public void drawPlayer(DrawTool drawTool){
        System.out.println(mode +" 2 : "+mode2);
        if(mode.equals("right")) {
            drawTool.drawImage(body.getTile((int) time, 0), x, y);
        }
        if(mode.equals("left") ) {
            drawTool.flipImage(body.getTile((int) (time),0),x,y,-256,360);
        }
        if(mode.equals("up") ) {
            drawTool.drawImage(body.getTile((int) time, 2), x, y);
        }
        if(mode.equals("down")) {
            drawTool.drawImage(body.getTile((int) time, 1), x, y);
        }
        if(mode2.equals("fightE") && mode.equals("left") ) {
            drawTool.flipImage(fight.getTile((int) time, 0), x, y,-256,360);
        }
        if(mode2.equals("fightS") && mode.equals("left") ) {
            drawTool.flipImage(fight.getTile((int) time, 1), x, y,-256,360);
        }
        if(mode2.equals("fightE")  ) {
            drawTool.drawImage(fight.getTile((int) time, 0), x, y);
        }
        if(mode2.equals("fightS")  ) {
            drawTool.drawImage(fight.getTile((int) time, 1), x, y);
        }
        if(mode2.equals("stand")) {
            drawTool.drawImage(stand.getTile((int) time, 0), x, y);
        }
        if(mode2.equals("roll")) {
            drawTool.drawImage(stand.getTile((int) time, 1), x, y);
        }
    }

    /**
     * Ist für die verschiedenen Modi des Spielers verantwortlich , je nach dem , welche Taste man drückt , wird ein anderer
     * Modus eingestellt
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    @Override
    public void update(double dt) {
        time+=10*dt;
        System.out.println(mode);
        if(!uic.isKeyDown(KeyEvent.VK_D) && !uic.isKeyDown(KeyEvent.VK_S) && !uic.isKeyDown(KeyEvent.VK_W) && !uic.isKeyDown(KeyEvent.VK_A) && !mode.equals("fight")){
            mode2="stand";
            mode="none";
        }
        if(uic.isKeyDown(KeyEvent.VK_S)){
            y+=stats[2]*dt;
            mode="down";
        }
        if(uic.isKeyDown(KeyEvent.VK_W)){
            y-=stats[2]*dt;
            mode="up";
        }
        if(uic.isKeyDown(KeyEvent.VK_A)){
            x-=stats[2]*dt;
            mode="left";
        }
        if(uic.isKeyDown(KeyEvent.VK_D)){
            x+=stats[2]*dt;
            mode="right";
        }
        if(time>=8){
            time=0;
        }
        if(stats[0]<=0){
            mode="boom";
        }
        if(mode2.equals("fightE") || mode2.equals("fightS")) {
            if (stats[1] > 0) {
                stats[1] -= 10 * 0.5 * dt;
            } else {
                mode2 = "stand";
            }
            if (time >= 4 && time < 5) {
                hitbox((int) (x + fight.getTile((int) (time), 0).getWidth() / 2), y + 10, 75, 20);
            } else if (time >= 7 && time < 8) {
                hitbox((int) (x + fight.getTile((int) (time), 0).getWidth() / 2), y + fight.getTile((int) (time), 0).getHeight(), 75, 20);
            }
        }
        if(mode2.equals("stand") && stats[1]<bars[1].getWidth()) {
            stats[1]+=32*dt;
        }
        if(mode.equals("boom")){
            legs=new Limb[2];
            arms=new Limb[2];
            legs[0]=new Limb(x,y+height/1.5,10);
            legs[1]=new Limb(x+width/2,y+height/1.5,10);
            arms[0]=new Limb(x,y+height/4.5,10);
            arms[1]=new Limb(x+width,y+height/4.5,10);
            mode="lel";
        }
        System.out.println(stats[1]);
    }


    /**
     *
     * @param x Koordinate der Hitbox
     * @param y Koordinate der Hitbox
     * @param width Breite der Hitbox
     * @param height Höhe der Hitbox
     */
    public void hitbox(double x , double y , double width, double height){
        hitbox[0]=x;
        hitbox[1]=y;
        hitbox[2]=width;
        hitbox[3]=height;
    }


    /**
     * Stellt die Kampfmodi des Spielers ein, wenn linke oder rechte Maustaste betätigt wird.
     * @param e jeweilige Maustaste die gedrückt wurde
     */
    @Override
    public void mousePressed(MouseEvent e) {
        mode="fight";
        if(e.getButton()==1 && stats[1]>0){
            mode2="fightE";
        }
        if(e.getButton()==3 && stats[1]>0){
            mode2="fightS";
        }
    }

    public void mouseReleased(MouseEvent e){
        mode2="stand";
    }

    /**
     * Wenn eine Taste gedrückt wird , passiert etwas!
     * @param key jeweilige Taste die gedrückt wurde
     */
    public void keyPressed(int key){
        if(key==KeyEvent.VK_SPACE && stats[1]>0){
            mode2="roll";
        }
    }

    public int getStat(int i){
        return stats[i];
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode(){
        return mode;
    }

    public String getMode2(){
        return mode2;
    }

    /**
     * Körperteil , Wenn der Spieler auf 0 Leben dropped dann explodiert er in alle Einzelteile und man kann diese
     * kontrollieren.
     */
    private class Limb{
        private double x,y;
        private int hp;

        private Tileset limb;

        /**
         * Konstruktor der Klasse Limb
         * @param x Koordinate des Körperteils
         * @param y Koodrinate des Körperteils
         * @param hp Leben des Körperteils
         */
        public Limb(double x , double y , int hp){
            this.x=x;
            this.y=y;
            this.hp=hp;
        }

        /**
         * Gibt X - Koordinate zurück
         * @return x
         */
        public double getX() {
            return x;
        }

        /**
         * Setzt X - Koordinate neu zu
         * @param x neuer Wert für x
         */
        public void setX(double x) {
            this.x = x;
        }

        /**
         * Gibt Y - Koordinate zurück
         * @return y
         */
        public double getY() {
            return y;
        }

        /**
         * Setzt Y - Koordinate neu zu
         * @param y neuer Wert für y
         */
        public void setY(double y) {
            this.y = y;
        }
    }

    public int getHP(){
        return stats[0];
    }

    public int getStamina(){
        return stats[1];
    }

    public int getSpeed(){
        return stats[2];
    }

    public int getStrength(){
        return stats[3];
    }

    public int getResistance(){
        return stats[4];
    }

    public void setHp(int hp){
        stats[0]=hp;
    }

    public void setStamina(int st){
        stats[1]=st;
    }

    public void setSpeed(int sp){
        stats[2]=sp;
    }

    public void setStrength(int st){
        stats[3]=st;
    }

    public void setResistance(int resistance){
        stats[4]=resistance;
    }

}
