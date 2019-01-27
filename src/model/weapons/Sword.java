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

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 30);
        setuStrength(10);
    }
}
