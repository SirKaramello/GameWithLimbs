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
    private int droppedItems;

    // Referenzen
    private UIController uiController;  // diese Referenz soll auf ein Objekt der Klasse uiController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Display programmZeitAnzeige;
    private SoundController soundController;
    private Body body;
    private Background bg;
    private Enemy enemies;
    private PowerUP[] pFTS ;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
        pFTS = new PowerUP[3];
        body=new Player(uiController);
        pFTS[0]=new MenacingLookingClock(body);
        pFTS[1]=new SuspiciousLookingMushroom(body);
        pFTS[2]=new HylianShield(body);
        body.meetPowerUs(pFTS);
        bg=new Background(body, uiController);
        body.meetBg(bg);
        enemies= new Enemy(uiController,body);
        body.meetEnemy(enemies);
        enemies.meetBg(bg);
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
        for(int i=0;i<pFTS.length;i++){
            uiController.registerObject(pFTS[i]);
            if (i+1<pFTS.length && pFTS[i].collidesWith(pFTS[i+1])){
                pFTS[i].jump();
            }
        }
        timer = 0;
    }

    /**
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        programTimer += dt;

        // ******************************************* Ab hier euer eigener Code! *******************************************
    }

    public void updateStoppedTime(double dt, double timeStopCount){
        timer = 5;
        timer = timer - dt;
    }






}
