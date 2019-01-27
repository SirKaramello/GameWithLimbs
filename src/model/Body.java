package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.abitur.datenstrukturen.Queue;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class Body extends GraphicalObject {

    //Attribute;
    protected double  time;
    protected String mode,mode2;
    private char[] save;
    protected int[] stats  ;
    protected double[] hitbox;

    //Referenzen
    private Limb[] legs ,arms;
    protected Tileset body , fight, stand;
    protected UIController uic;
    protected BufferedImage[] bars;
    protected Body enemy;
    private List<Item> inventory;
    private Queue[] upgrades = new Queue[5];
    private Queue<UpgradeInfo> healthPath;
    private Queue<UpgradeInfo> staminaPath;
    private Queue<UpgradeInfo> speedPath;
    private Queue<UpgradeInfo> strengthPath;
    private Queue<UpgradeInfo> resistancePath;
    private int upgrade;

    //0=hp 1=stamina 2=speed 3=strength 4=resistance
    public Body(UIController uiController){
        hitbox=new double[4];
        uic=uiController;
        stats=new int[6];
        body=new Tileset("assets/images/runningb.png",256,360);
        width=256/2;
        height=360;
        fight=new Tileset("assets/images/fighting.png",256,360);
        stand= new Tileset("assets/images/stan.png",256,360);
        bars=new BufferedImage[2];
        bars[0]=createNewImage("assets/images/layout/hpbar.png");
        bars[1]=createNewImage("assets/images/layout/stbar.png");
        stats[0]=bars[0].getWidth();
        stats[1]=bars[1].getWidth();
        mode="stand";
        mode2="none";
        getSaveData();
        handleSave();
        upgrades[0] = healthPath;
        upgrades[1] = staminaPath;
        upgrades[2] = speedPath;
        upgrades[3] = strengthPath;
        upgrades[4] = resistancePath;
        fillQueues();
    }

    public void draw(DrawTool drawTool){
        drawPlayer(drawTool);
    }

    public void update(double dt){
        live(dt);
    }

    /**
     * Zeichnet den wunderbaren , großartigen , unglaublichen Spieler
     * @param drawTool das Werkzeug für das Zeichnen
     */
    public void drawPlayer(DrawTool drawTool){
        for(int i=0;i<stats[0];i++){
            drawTool.setCurrentColor(0,70,100,255);
            drawTool.drawFilledRectangle(10+i,y,1,32);
        }
        for(int i=0;i<stats[1];i++){
            drawTool.setCurrentColor(0,125,100,255);
            drawTool.drawFilledRectangle(10+i,y+30,1,32);
        }
        drawTool.drawImage(bars[0],10,y);
        drawTool.drawImage(bars[1],10,y+30);
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
     * Bewegungen des Spielers und alles was er zum Leben braucht
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    public void live(double dt){
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
        fighting(dt);
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
            mode="falling";
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

    /**
     * Wenn die Maus losgelassen wird wird es aktiviert
     * @param e mouseEvent
     */
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
     * Diese wunderbare Methode liest eine Datei und speichert dann diese in einzelene Charaktere die dann
     * auf dem save char Array gespeichert werden
     */
    public void getSaveData(){
        try {
            FileReader reader = new FileReader("assets/data/save.txt");
            Reader bufferedReader = new BufferedReader(reader);
            FileInputStream fileInputStream= new FileInputStream("assets/data/save.txt");
            int filelength = 0;
            while (bufferedReader.read() != -1) {
                filelength++;
            }
            save = new char[filelength];
            for(int i=0;i<save.length && fileInputStream.available()>0;i++){
                save[i] = (char) (fileInputStream.read());
            }
        }catch (Exception e){
            System.out.println("Konnte nicht gespeichert werden");
        }
    }

    /**
     * Diese Methode setzt die stats zu den die das letzte mal seit dem Aufruf des Programms existiert haben auf
     * und packt die
     */
    public void handleSave(){
        String tmp="";
        int j=1;
        for(int i=0;i<stats.length ;i++){
            while(j<save.length){
                if(j+1<save.length && save[j]!=':'){
                    tmp+="" +save[j];
                }else{
                    break;
                }
                j++;

            }
            stats[i]=Integer.parseInt(tmp);
        }
    }

    public void saveGame(){
        try {
            FileWriter fileWriter = new FileWriter("assets/data/save.txt");
            fileWriter.write(":"+stats[0]+":"+stats[1]+":"+stats[2]+":"+stats[3]+":"+stats[4]+":"+stats[5]+":");
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Konnte nicht gespeichert werden");
        }
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

    private void fillQueues(){
        for(int i = 0;i < upgrades.length; i++){
            UpgradeInfo upgradeHPSTR = new UpgradeInfo();
            UpgradeInfo upgradeSTSPRE = new UpgradeInfo();
            upgradeHPSTR.setAddedNumber(30*i);
            upgradeSTSPRE.setAddedNumber(35*i);
            upgradeHPSTR.setReqSouls(6*i);
            upgradeSTSPRE.setReqSouls(5*i);
            // upgrades[0].enqueue(upgradeHPSTR);
            // upgrades[1].enqueue(upgradeSTSPRE);
            // upgrades[2].enqueue(upgradeSTSPRE);
            // upgrades[3].enqueue(upgradeHPSTR);
            // upgrades[4].enqueue(upgradeSTSPRE);
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
