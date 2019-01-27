package control;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.Display;
import akkgframework.control.fundamental.SoundController;
import akkgframework.model.abitur.datenstrukturen.List;
import model.*;
import model.powerUP.*;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute
    private double programTimer;
    private double timer = 0;

    // Referenzen
    private UIController uiController;  // diese Referenz soll auf ein Objekt der Klasse uiController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Display programmZeitAnzeige;
    private SoundController soundController;
    private Body body;
    private Background bg;
    private Enemy enemies;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
        body=new Player(uiController);
        bg=new Background(body, uiController);
        body.meetBg(bg);
        enemies= new Enemy(uiController,body);
        body.meetEnemy(enemies);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     */
    public void startProgram() {
        programTimer = 0;
        // ******************************************* Ab hier euer eigener Code! *******************************************
        uiController.registerObject(bg);
        uiController.registerObject(enemies);
        uiController.registerObject(body);
        timer = 0;
    }

    /**
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        programTimer += dt;
        // ******************************************* Ab hier euer eigener Code! *******************************************
        while(timer < 0){
        }
    }

    public void updateStoppedTime(double dt, double timeStopCount){
        timer = 5;
        timer = timer - dt;
    }



    /*public void itemDrops() {
        int itemOfChoice;
        if (droppedItems < 6) {
            itemOfChoice = (int) (1 + (Math.random() * 2));
        } else {
            itemOfChoice = (int) (1 + (Math.random() * 4));
        }
        if (itemOfChoice == 1) {
            new SuspiciousLookingMushroom(body);
            droppedItems++;
        }

        if (itemOfChoice == 2) {
            new HylianShield(body);
            droppedItems++;
        }

        if (itemOfChoice == 3) {
            new MenacingLookingClock(body);
            droppedItems++;
        }

        if (itemOfChoice == 4) {
            new EqualFuel(body);
            droppedItems++;
        }
    }

    public void updateItemDrops(double dt) {
        itemTimer = itemTimer + (int) dt;
        if (dropTime <= itemTimer) {
            itemDrops();
            dropTime = dropTime + 10;
        }
    }

    public void updateSouls(Body body) {
        // if()
        body.setSouls(body.getSouls() + 1);
    }

    public void pickUpPowerUp(PowerUP pU) {
        powerUpInventory.push(pU);
    }



    public void usePowerUP() {
        if (!powerUpInventory.isEmpty()) {
            PowerUP powerUpUse = powerUpInventory.top();
            if (powerUpUse.getPowerUpType() < 3) {
                body.setHP(body.getHP() + powerUpUse.getuHp());
                body.setResistance(body.getResistance() + powerUpUse.getuResistance());
                body.setSpeed(body.getSpeed() + powerUpUse.getuSpeed());
                body.setStamina(body.getStamina() + powerUpUse.getuStamina());
            } else {
                if (powerUpUse.getPowerUpType() == 4) {
                    powerUpUse.updateTimeStopCount(powerUpUse);
                }

            }
            powerUpInventory.pop();
        }

    }

    public void buyUpgrade(){
    }*/
}
