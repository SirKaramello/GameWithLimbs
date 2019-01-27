package model.weapons;

import model.Body;
import model.Item;

/**
 * Goldschwert welches Stärke erhöht
 */

public class Gold extends Item {
    public Gold(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 300);
            setuStrength(80);
        }
            setName("Gold");
            setCost(300);

    }

}
