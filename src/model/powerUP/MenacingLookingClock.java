package model.powerUP;

import model.Body;

/**
 * Die Zeit bleibt für eine gewisse Zeit stehen und der Spieler kann sich bewegen und der Gegner jedoch nicht.
 */

public class MenacingLookingClock  extends PowerUP{

    private double timeStopCount;

    public MenacingLookingClock(Body body){
        setuBody(body);
        setuSpeed(body.getSpeed()/8);
        this.timeStopCount = 3 + 0.25 * body.getStamina();
    }
}
