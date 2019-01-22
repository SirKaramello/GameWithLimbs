package model.powerUP;

import model.Body;

/**
 * Die Stärke wird dermassen erhöht, dass der gegenüber in einem Schlag stirbt(der Spieler sowohl als auch der Gegner)
 */
public class EqualFuel extends PowerUP{
    public EqualFuel(Body body){
        setuBody(body);
        setuStrength(body.getStrength()*3);
    }
}
