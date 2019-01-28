package model.weapons;

import model.Body;
import model.Item;

/**
 * Silbernes Schwert, welches Stärker macht.
 */

public class Silver extends Item {
    public Silver(Body body) {
        super(body);
        setName("Silver");
        setCost(90);
    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
    }
    /**
     * aktiviert das Item
     */
    public void activate(){
        setuStrength(getuStrength()+50);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate() {
        setuStrength(getuStrength() - 50);
    }


}
