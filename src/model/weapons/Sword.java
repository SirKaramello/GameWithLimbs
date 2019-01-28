package model.weapons;

import model.Body;
import model.Item;

public class Sword extends Item {

    /**
     * Schwert, welches Sich stärker macht.
     */
    public Sword(Body body) {
        super(body);
        setName("Sword");
        setCost(30);
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
        setuStrength(getuStrength()+10);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate() {
        setuStrength(getuStrength() -10);
    }

}
