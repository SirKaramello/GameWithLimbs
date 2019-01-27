package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Stärke und Geschwindigkeit des Spielers erhöht
 */

public class Brownish extends Item {
    public Brownish(Body body) {
        super(body);
        setName("brownish");
        setCost(50);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 50);
        setuStrength(getuStrength() + 10);
        setuSpeed(getuSpeed() + 10);
    }
}
