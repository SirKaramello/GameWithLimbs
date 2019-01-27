package model.weapons;

import model.Body;
import model.Item;

/**
 * Armbrust die Stärke erhöht
 */
public class Crossbow extends Item {
    public Crossbow(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 75);
            setuStrength(30);
        }
            setName("Crossbow");
            setCost(75);

    }

}
