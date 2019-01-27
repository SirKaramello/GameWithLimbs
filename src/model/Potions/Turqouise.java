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

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 30);
        setuStrength(getuStrength() + 10);
    }
}
