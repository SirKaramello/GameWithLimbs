package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Body extends GraphicalObject {

    protected double  time,mode,mode2;
    protected int[] stats  ;
    protected double[] hitbox;

    private Limb[] legs ,arms;
    protected Tileset body , fight, stand;
    protected UIController uic;
    protected BufferedImage[] bars;
    private Enemy enemy;

    //0=hp 1=stamina 2=speed 3=strength 4=resistance
    public Body(UIController uiController){
        uic=uiController;
        hitbox=new double[4];
        stats=new int[5];
        stats[2]=300;
        width=20;height=width*2;
        body=new Tileset("assets/images/runningb.png",256,360);
        fight=new Tileset("assets/images/fighting.png",256,360);
        stand= new Tileset("assets/images/stan.png",256,360);
        bars=new BufferedImage[2];
        bars[0]=createNewImage("assets/images/layout/hpbar.png");
        bars[1]=createNewImage("assets/images/layout/stbar.png");
        for(int i=0;i<stats.length-3;i++){
            stats[i]=bars[i].getWidth();
        }
        mode=6;
    }

    /**
     * Zeichnet jegliche Animation des Körpers mit einem Tileset
     * @param drawTool ist das werkzeug zum zeichnen von Objekten
     */
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.camera(x,y/3);
        for(int i=0;i<bars[0].getWidth();i+=32){
            drawTool.setCurrentColor(0,70,100,255);
            drawTool.drawFilledRectangle(10+i,10,32,32);
        }
        for(int i=0;i<bars[1].getWidth();i+=32){
            drawTool.setCurrentColor(0,125,100,255);
            drawTool.drawFilledRectangle(10+i,52,32,32);
        }
        drawTool.drawImage(bars[0],10,10);
        drawTool.drawImage(bars[1],10,52);
        if(mode==0 && mode2==0) {
            drawTool.drawImage(body.getTile((int) time, 0), x, y);
        }
        if(mode==1 && mode2==0) {
            drawTool.flipImage(body.getTile((int) (time),0),x,y,-256,360);
        }
        if(mode==2 && mode2==0) {
            drawTool.drawImage(body.getTile((int) time, 2), x, y);
        }
        if(mode==3 && mode2==0) {
            drawTool.drawImage(body.getTile((int) time, 1), x, y);
        }
        if(mode2==4 && mode==1) {
            drawTool.flipImage(fight.getTile((int) time, 0), x, y,-256,360);
        }
        if(mode2==5 && mode==1) {
            drawTool.flipImage(fight.getTile((int) time, 1), x, y,-256,360);
        }
        if(mode2==4 ) {
            drawTool.drawImage(fight.getTile((int) time, 0), x, y);
        }
        if(mode2==5 ) {
            drawTool.drawImage(fight.getTile((int) time, 1), x, y);
        }
        if(mode==6) {
            drawTool.drawImage(stand.getTile((int) time, 0), x, y);
        }
        if(mode2==7) {
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
        if(!uic.isKeyDown(KeyEvent.VK_D) && !uic.isKeyDown(KeyEvent.VK_S) && !uic.isKeyDown(KeyEvent.VK_W) && !uic.isKeyDown(KeyEvent.VK_A)){
            mode=6;
        }
        if(uic.isKeyDown(KeyEvent.VK_S)){
            y+=stats[2]*dt;
            mode=3;
        }
        if(uic.isKeyDown(KeyEvent.VK_W)){
            y-=stats[2]*dt;
            mode=2;
        }
        if(uic.isKeyDown(KeyEvent.VK_A)){
            x-=stats[2]*dt;
            mode=1;
        }
        if(uic.isKeyDown(KeyEvent.VK_D)){
            x+=stats[2]*dt;
            mode=0;
        }
        if(time>=8){
            time=0;
        }
        if(stats[0]<=0){
            mode=-1;
        }
        if(mode2==4 || mode2==5){
            if(time>=4 && time<5) {
                hitbox((int) (x + fight.getTile((int) (time), 0).getWidth() / 2), y + 10, 75, 20);
            }else if(time>=7 && time<8){
                hitbox((int) (x + fight.getTile((int) (time), 0).getWidth() / 2), y +fight.getTile((int) (time), 0).getHeight() , 75, 20);
            }
        }
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
     * Stellt die Kampfmodi des Spielers ein wenn linke oder rechte Maustaste betätigt wird.
     * @param e jeweilige Maustaste die gedrückt wurde
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==1){
            mode2=4;
        }
        if(e.getButton()==3){
            mode2=5;
        }
    }

    /**
     * Wenn eine Taste gedrückt wird , passiert etwas!
     * @param key jeweilige Taste die gedrückt wurde
     */
    public void keyPressed(int key){
        if(key==KeyEvent.VK_SPACE){
            mode2=7;
        }else{
            mode2=0;
        }
    }

    public int getStat(int i){
        return stats[i];
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
}
