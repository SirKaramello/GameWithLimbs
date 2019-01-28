package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.abitur.datenstrukturen.Queue;
import akkgframework.model.abitur.datenstrukturen.Stack;
import akkgframework.view.DrawTool;
import model.powerUP.PowerUP;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.*;

public class Player extends Body {

    //Attribute
    private char[] save;
    //Referenzen
    private Stack<PowerUP> powerUpInventory;
    private Limb[] legs, arms;
    private Queue<UpgradeInfo>[] upgrades;
    private Queue<UpgradeInfo> healthPath, staminaPath, speedPath, strengthPath, resistancePath;
    private boolean qPressed, notAble, cantUpgrade;

    /**
     * Konstruktor der Klasse Player. Erstellt bei Aufruf ein Objekt der Klasse Player
     *
     * @param uiController
     */
    public Player(UIController uiController) {
        super(uiController);
        powerUpInventory=new Stack<>();
        pFTS = new PowerUP[3];
        inventory=new List<>();
        inventory = new List<>();
        getSaveData();
        handleSave();
        x=100;y=800;
        qPressed = false;
        notAble = false;
        cantUpgrade = false;
        upgrades = new Queue[5];
        healthPath = new Queue<>();
        staminaPath = new Queue<>();
        speedPath = new Queue<>();
        strengthPath = new Queue<>();
        resistancePath = new Queue<>();
        upgrades[0] = healthPath;
        upgrades[1] = staminaPath;
        upgrades[2] = speedPath;
        upgrades[3] = strengthPath;
        upgrades[4] = resistancePath;
        width=body.getTile(0,0).getWidth()/2;
        height=body.getTile(0,0).getHeight()/2;
        fillQueues();
    }

    /**
     * Zeichnet den Spieler
     * @param drawTool werkzeug zum zeichnen
     */
    public void draw(DrawTool drawTool){
        super.draw(drawTool);
        if(mode=="boom"){
            for (int i=0;i<legs.length;i++){
                legs[i].draw(drawTool);
                arms[i].draw(drawTool);
            }
        }
        drawTool.drawText(x - 20, y + 6, "Souls:");
        drawTool.drawText(x - 15, y + 20, stats[5] + "");
        if (qPressed) {
            drawTool.drawText(x - 20.0D, y - 105.0D, "Drücke zwischen 1-5 um zu upgraden");
            drawTool.drawText(x - 20.0D, y - 85.0D, "1:HP 2:Stamina 3:Speed 4:Strength 5:Resistance");
        }

        if (notAble) {
            drawTool.drawText(x - 20.0D, y - 85.0D, "Du hast nicht genug Souls gesammelt!");
        }

        if (cantUpgrade) {
            drawTool.drawText(x - 20.0D, y - 85.0D, "Du kannst diesen Wert nicht mehr upgraden!");
        }
    }

    /**
     * Bewegung des Spielers
     * @param dt zeit seit dem letzten aufruf der methode
     */
    public void update(double dt) {
        if (bg != null && bg.getMode().equals("fight")) {
            super.update(dt);
            live(dt);
            fighting(dt);
            fightCollision(dt);
        }
    }

    /**
     * Wenn das Mausrad gedreht wird passiert etwas
     * @param e
     */
    public void mouseWheelMoved(MouseWheelEvent e){
        nextWeapon(e.getWheelRotation());
        inventory.toFirst();
        inventory.getContent().gotBought();
        System.out.println(inventory.getContent().getName());
        System.out.println(getStrength());
    }

    /**
     * Bewegungen des Spielers und alles was er zum Leben braucht
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    public void live(double dt){
        time+=10*dt;
        fighting(dt);
        if(!uic.isKeyDown(KeyEvent.VK_D) && !uic.isKeyDown(KeyEvent.VK_S) && !uic.isKeyDown(KeyEvent.VK_W) && !uic.isKeyDown(KeyEvent.VK_A) && !mode2.equals("fightE")&& !mode2.equals("fightS")&& !mode2.equals("sword") && !mode2.equals("roll") ){
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
        if(mode2.equals("stand") && stats[1]<bars[1].getWidth()) {
            stats[1]+=32*dt;
        }
        if(mode.equals("boom")){
            legs=new Limb[2];
            arms=new Limb[2];
            legs[0]=new Limb(x,y+height/1.5);
            legs[1]=new Limb(x+width/2,y+height/1.5);
            arms[0]=new Limb(x,y+height/4.5);
            arms[1]=new Limb(x+width,y+height/4.5);
            mode="lel";
        }
        if(enemy.getHP()<=0){
            stats[5]+=enemy.getLire();
        }
    }

    /**
     * Stellt die Kampfmodi des Spielers ein, wenn linke oder rechte Maustaste betätigt wird.
     * @param e jeweilige Maustaste die gedrückt wurde
     */
    @Override
    public void mousePressed(MouseEvent e) {
        mode="fight";
        if(e.getButton()==1 && stats[1]>0 && inventory.isEmpty()){
            mode2="fightE";
        }else if(e.getButton()==1 && stats[1]>0 && !inventory.isEmpty()){
            mode2="sword";
        }
        if(e.getButton()==3 && stats[1]>0 && !inventory.isEmpty()){
            getNextItem();
            System.out.println(inventory.getContent().getName());
        }
        if(e.getButton()==3 && stats[1]>0){
            mode2="fightS";
        }
    }

    /**
     * Kollsion des Kampfes
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    public void fightCollision(double dt){
        if(hitbox[0]+hitbox[2]>enemy.getX() && hitbox[0]<enemy.getX()+enemy.getWidth() && hitbox[1]+hitbox[3]>enemy.getY() && hitbox[1]<enemy.getY()+enemy.getHeight() ){
            enemy.setHp((int)((enemy.getHP()-(getStrength()/enemy.getResistance())*dt)));
        }
        if(collidesWith(enemy) && enemy.getMode().equals("fight" )&& time>=5 && time<=7){
            System.out.println("Lel"+stats[0]);
            this.stats[0]-=enemy.getStrength()/(getResistance()*0.01)*dt;
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
        for(int i=0;i<pFTS.length;i++) {
            if (key == KeyEvent.VK_E && collidesWith(pFTS[i])) {
                powerUpInventory.push(pFTS[i]);
                pFTS[i].setPickedUp(true);
            }
        }
        if(key==KeyEvent.VK_R){
            usePowerUP();
        }
        if (key == 81) {
            qPressed = true;
            cantUpgrade = false;
            notAble = false;
        }

        if (qPressed) {
            if (key == 49) {
                doUpgrade(0);
                qPressed = false;
            }

            if (key == 50) {
                doUpgrade(1);
                qPressed = false;
            }
            if (key == 51) {
                doUpgrade(2);
                qPressed = false;
            }

            if (key == 52) {
                doUpgrade(3);
                qPressed = false;
            }

            if (key == 53) {
                doUpgrade(4);
                qPressed = false;
            }
        }
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

    /**
     * Speichert die Stats des Spielers
     */
    public void saveGame(){
        try {
            FileWriter fileWriter = new FileWriter("assets/data/save.txt");
            fileWriter.write(":"+statsMax[0]+":"+statsMax[1]+":"+statsMax[2]+":"+statsMax[3]+":"+statsMax[4]+":"+statsMax[5]+":");
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Konnte nicht gespeichert werden");
        }
    }

    /**
     * wechselt zum nächsten item
     */
    private void getNextItem() {
        if (!inventory.isEmpty()){
            inventory.next();
        }
        if(inventory.getContent()==null){
            inventory.toFirst();
        }
    }

        /**
         * Füllt die Queue mit tollen Dingen
         */
        private void fillQueues () {
            for (int i = 0; i < upgrades.length; i++) {
                UpgradeInfo upgradeHPSTR = new UpgradeInfo();
                UpgradeInfo upgradeSTSPRE = new UpgradeInfo();
                upgradeHPSTR.setAddedNumber(30 * i);
                upgradeSTSPRE.setAddedNumber(35 * i);
                upgradeHPSTR.setReqSouls(6 * i);
                upgradeSTSPRE.setReqSouls(5 * i);
                upgrades[0].enqueue(upgradeHPSTR);
                upgrades[1].enqueue(upgradeSTSPRE);
                upgrades[2].enqueue(upgradeSTSPRE);
                upgrades[3].enqueue(upgradeHPSTR);
                upgrades[4].enqueue(upgradeSTSPRE);
            }
        }
    /**
     * Es werden die Werte aus dem ersten Platz der Queue entnommen, und es wird überprüft ob der Spieler genügend
     * Souls hat.Wenn ja wird der ausgewählte Wert geupgraded/erhöht.
     */

    private void doUpgrade ( int i){
        if (!upgrades[i].isEmpty()) {
            cantUpgrade = false;
            notAble = false;
            int upg;
            int req;
            upg = upgrades[i].front().getAddedNumber();
            req = upgrades[i].front().getReqSouls();
            if (stats[5] > req) {
                stats[i] = stats[i] + upg;
                upgrades[i].dequeue();
                stats[5] = stats[5] - req;
            }

            if (stats[5] < req) {
                notAble = true;
            }
        } else {
            qPressed = false;
            cantUpgrade = true;
        }
    }

    /**
     * Benutzt das PowerUp
     */
    public void usePowerUP() {
        if (!powerUpInventory.isEmpty()) {
            PowerUP powerUpUse = powerUpInventory.top();
            if (powerUpUse.getPowerUpType() < 3) {
                setHp(getHP() + powerUpUse.getuHp());
                setResistance(getResistance() + powerUpUse.getuResistance());
                setSpeed(getSpeed() + powerUpUse.getuSpeed());
                setStamina(getStamina() + powerUpUse.getuStamina());
            } else {
                if (powerUpUse.getPowerUpType() == 3 && enemy.stats[0]>=0) {
                        enemy.setMode("lel");
                }else{
                    enemy.setMode("stand");
                    enemy.stats[0]=256;
                }
            }
            powerUpInventory.pop();
        }
    }


}




