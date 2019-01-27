package model.weapons;

import model.Body;
import model.Item;

/**
 * Silbernes Schwert, welches Stärker macht.
 */

public class Silver extends Item {
    public Silver(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 90);
            setuStrength(50);
        }
        setName("Silver");
        setCost(90);
    }
}
