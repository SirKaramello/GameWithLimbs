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
        setuStrength(getuStrength()+30);
    }
}
