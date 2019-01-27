package model.Potions;

import model.Body;
import model.Item;

/**
 * TRank der Stärker macht
 */
public class Turqouise extends Item {
    public Turqouise(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 30);
            setuStrength(getuStrength() + 10);
        }
        setName("Turqouise");
        setCost(30);
    }
}
