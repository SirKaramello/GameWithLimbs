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
        setuSpeed(getuSpeed() + 2);
    }
    /**
     * aktiviert das Item
     */
    public void activate(){
        setuStrength(getuStrength()+28);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate() {
        setuStrength(getuStrength() - 28);
    }

}
