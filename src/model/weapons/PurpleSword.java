package model.weapons;

import model.Body;
import model.Item;

/**
 * Lilanes Schwert, welches Stärke und Geschwindigkeit erhöht
 */

public class PurpleSword extends Item {
    public PurpleSword (Body body) {
        super(body);
        setName("purpleSword");
        setCost(75);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 75);
        setuStrength(28);
        setuSpeed(getuSpeed() + 2);
    }
}
