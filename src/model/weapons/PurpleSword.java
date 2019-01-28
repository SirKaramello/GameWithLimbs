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

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuStrength(getuStrength()+28);
        setuSpeed(getuSpeed() + 2);
    }
}
