package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.abitur.datenstrukturen.List;
import akkgframework.model.abitur.datenstrukturen.Queue;
import akkgframework.view.DrawTool;
import model.Item;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.*;

public class Player extends Body {

    private char[] save;

    private Limb[] legs ,arms;
    private List<Item> inventory;
    private Queue[] upgrades = new Queue[5];
    private Queue<UpgradeInfo> healthPath,staminaPath,speedPath,strengthPath,resistancePath;

    public Player(UIController uiController){
        super(uiController);
        inventory=new List<>();
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
        super.draw(drawTool);
    }

    public void update(double dt){
        if(bg!=null && bg.getMode().equals("fight")  ) {
            live(dt);
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e){
        if(e.getWheelRotation()>=1){

        }
    }

    /**
     * Bewegungen des Spielers und alles was er zum Leben braucht
     * @param dt Zeit seit dem letzten Aufruf der Methode
     */
    public void live(double dt){
        time+=10*dt;
        System.out.println(mode);
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
        fighting(dt);
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
            fileWriter.write(":"+statsMax[0]+":"+statsMax[1]+":"+statsMax[2]+":"+statsMax[3]+":"+statsMax[4]+":"+statsMax[5]+":");
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Konnte nicht gespeichert werden");
        }
    }

    private void getNewItem(Item item){
        inventory.toFirst();
        inventory.append(item);
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


}
