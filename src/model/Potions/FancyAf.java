package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Geschwindigkeit,Stärke und Leben des Spielers erhöht
 */

public class FancyAf extends Item {
    public FancyAf(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 200);
            setuHp(getuHp() + 3);
            setuSpeed(getuSpeed() + 10);
            setuStrength(getuStrength() + 10);
        }
        setName("fancy af");
        setCost(200);
    }
}
