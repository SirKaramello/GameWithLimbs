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

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 75);
        setuStrength(30);
    }
}
