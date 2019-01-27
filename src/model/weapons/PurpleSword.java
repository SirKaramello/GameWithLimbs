package model.weapons;

import model.Body;
import model.Item;

/**
 * Lilanes Schwert, welches Stärke und Geschwindigkeit erhöht
 */

public class PurpleSword extends Item {
    public PurpleSword (Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 75);
            setuStrength(28);
            setuSpeed(getuSpeed() + 2);
        }
        setName("purpleSword");
        setCost(75);
    }
}
