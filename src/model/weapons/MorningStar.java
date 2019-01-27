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

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 50);
        setuSpeed(getuSpeed() - 2);
        setuStrength(20);
    }
}
