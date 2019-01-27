package model.weapons;

import model.Body;
import model.Item;

/**
 * Silbernes Schwert, welches Stärker macht.
 */

public class Silver extends Item {
    public Silver(Body body) {
        super(body);
        setName("Silver");
        setCost(90);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 90);
        setuStrength(50);
    }
}
