package model.weapons;

import model.Body;
import model.Item;

/**
 * Stock welcher ganz kleines bisschen stärker macht.
 */
public class Stick extends Item {
    public Stick(Body body) {
        super(body);
        setName("Stick");
        setCost(15);
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
        setuStrength(getuStrength()+6);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate() {
        setuStrength(getuStrength() - 6);
    }
}
