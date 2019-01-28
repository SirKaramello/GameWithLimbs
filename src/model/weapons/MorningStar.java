package model.weapons;

import model.Body;
import model.Item;

/**
 * Morgenstern, welcher Stärker und Langsamer macht.
 */

public class MorningStar extends Item {
    public MorningStar(Body body) {
        super(body);
        setName("MorningStar");
        setCost(50);

    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuSpeed(getuSpeed() - 2);
        setuStrength(getuStrength()+20);
    }
}
