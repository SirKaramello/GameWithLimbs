package model.weapons;

import model.Body;
import model.Item;

/**
 * Morgenstern, welcher Stärker und Langsamer macht.
 */

public class MorningStar extends Item {
    public MorningStar(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 50);
            setuSpeed(getuSpeed() - 2);
            setuStrength(20);
        }
            setName("MorningStar");
            setCost(50);

    }
}
