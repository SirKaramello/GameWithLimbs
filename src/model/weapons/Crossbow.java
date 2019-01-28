package model.weapons;

import model.Body;
import model.Item;

/**
 * Armbrust die Stärke erhöht
 */
public class Crossbow extends Item {
    public Crossbow(Body body) {
        super(body);
        setName("Crossbow");
        setCost(75);

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
        setuStrength(getuStrength()+30);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate(){
        setuStrength(getuStrength()-30);
    }

}
