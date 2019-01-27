package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Body extends GraphicalObject {

    //Attribute;
    protected double  time,deTe;
    protected String mode,mode2;
    protected int[] stats, statsMax ;
    protected double[] hitbox;

    //Referenzen
    protected Tileset body , fight, stand;
    protected UIController uic;
    protected BufferedImage[] bars;
    protected Body enemy;
    protected Background bg;

    //0=hp 1=stamina 2=speed 3=strength 4=resistance 5=souls
    public Body(UIController uiController){
        hitbox=new double[4];
        uic=uiController;
        stats=new int[6];
        statsMax=new int[6];
        body=new Tileset("assets/images/runningb.png",256,360);
        width=256/2;
        height=256;
        fight=new Tileset("assets/images/fighting.png",256,360);
        stand= new Tileset("assets/images/stan.png",256,360);
        bars=new BufferedImage[2];
        bars[0]=createNewImage("assets/images/layout/hpbar.png");
        bars[1]=createNewImage("assets/images/layout/stbar.png");
        stats[0]=bars[0].getWidth();
        stats[1]=bars[1].getWidth();
        stats[5]=100;
        mode="stand";
        mode2="none";
    }

    public void draw(DrawTool drawTool){
        if(bg!=null && bg.getMode().equals("fight") && stats[0]>0) {
            drawPlayer(drawTool);
        }
    }

    public void update(double dt){
        //checkIfBodyIsInArena();
        // deTe = dt;
    }

    /**
     * Zeichnet den wunderbaren , großartigen , unglaublichen Spieler
     * @param drawTool das Werkzeug für das Zeichnen
     */
    public void drawPlayer(DrawTool drawTool){
        for(int i=0;i<stats[0];i++){
            drawTool.setCurrentColor(0,70,100,255);
            drawTool.drawFilledRectangle(x-20+i,y-40,1,32);
        }
        for(int i=0;i<stats[1];i++){
            drawTool.setCurrentColor(0,125,100,255);
            drawTool.drawFilledRectangle(x-20+i,y-70,1,32);
        }
        drawTool.drawImage(bars[0],x-20,y-40);
        drawTool.drawImage(bars[1],x-20,y-70);
        drawTool.drawText(x-20,y+6,"Souls:");
        drawTool.drawText(x-15,y+20,stats[5]+"");
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
        if(mode2.equals("sword")){
            drawTool.drawImage(fight.getTile((int) time, 2), x, y);
        }
        if(mode2.equals("fightS")  ) {
            drawTool.drawImage(fight.getTile((int) time, 1), x, y);
        }
        if(mode2.equals("stand") && mode.equals("none") ) {
            drawTool.drawImage(stand.getTile((int) time, 0), x, y);
        }
        if(mode2.equals("roll") && mode.equals("none")) {
            drawTool.drawImage(stand.getTile((int) time, 1), x, y);
        }
    }


    /**
     * Hitbox der Faust und generelles Kämpfchen
     * @param dt
     */
    public void fighting(double dt){
        if(mode2.equals("fightE") || mode2.equals("fightS")) {
            if (stats[1] > 0) {
                stats[1] -= 10 * 0.5 * dt;
            } else {
                mode2 = "stand";
            }
            if (time >= 4 && time < 5) {
                hitbox((int) (x + fight.getTile((int) (time), 0).getWidth() / 2), y + 10, 75, 20);
                System.out.println("JAAAA");
            } else if (time >= 7 && time < 8) {
                hitbox((int) (x + fight.getTile((int) (time), 0).getWidth() / 2), y + fight.getTile((int) (time), 0).getHeight(), 75, 20);
            }
            if(hitbox[0]+hitbox[2]>enemy.getX() && hitbox[0]<enemy.getX()+enemy.getWidth() && hitbox[1]+hitbox[3]>enemy.getY() && hitbox[1]<enemy.getY()+enemy.getHeight() ){
                enemy.setHp(enemy.getHP()-enemy.getStrength()/getResistance());
                System.out.println("ist trueeee");
            }
        }
    }

    /**
     * Checkt ob der Spieler in der Arena ist und wenn dann setzt er denn Mode auf falling
     * @return gibt true zurück wenn der Spieler in der Arena ist
     */
    public boolean checkIfBodyIsInArena(){
        if(y<=400 || y>=1000){
            bg.setMode("falling");
            return true;
        }
        return false;
    }

    /**
     * Der Spieler trifft den Gegner
     * @param en der übergebene Gegner
     */
    public void meetEnemy(Enemy en){
        enemy=en;
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

    public void meetBg(Background bg){
        this.bg=bg;
    }



    /**
     * Gibt den Stat zurück den man haben will
     * @param i gibt den Index an
     * @return
     */
    public int getStat(int i){
        return stats[i];
    }

    /**
     * Setzt den Modus des Spielers zurück
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gibt den Modus des Spielers zurück
     * @return
     */
    public String getMode(){
        return mode;
    }

    /**
     * Gibt den 2. Modus des Spielers zurück der für Kämpfen un rollen zustädnig ist
     * @return
     */
    public String getMode2(){
        return mode2;
    }



    /**
     * Körperteil , Wenn der Spieler auf 0 Leben dropped dann explodiert er in alle Einzelteile und man kann diese
     * kontrollieren.
     */
    protected class Limb{
        private double x,y;

        private Tileset limb;

        /**
         * Konstruktor der Klasse Limb
         * @param x Koordinate des Körperteils
         * @param y Koodrinate des Körperteils
         */
        public Limb(double x , double y ){
            this.x=x;
            this.y=y;
        }

        public void draw(DrawTool drawTool){
            drawTool.drawRectangle(x,y,20,10);
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

    public int getLire(){
        return stats[5];
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

    public void setResistance(int resistance,int time){
        double tmp = deTe;
        while (tmp+time < deTe)
            stats[4]=resistance;
    }

}
