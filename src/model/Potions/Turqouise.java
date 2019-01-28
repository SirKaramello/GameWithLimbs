package model.Potions;

import model.Body;
import model.Item;

/**
 * TRank der Stärker macht
 */
public class Turqouise extends Item {
    public Turqouise(Body body) {
        super(body);
        setName("Turqouise");
        setCost(30);
    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuStrength(getuStrength() + 10);
    }
}
