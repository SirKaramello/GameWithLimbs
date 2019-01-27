package model.weapons;

import model.Body;
import model.Item;

/**
 * Goldschwert welches Stärke erhöht
 */

public class Gold extends Item {
    public Gold(Body body) {
        super(body);
            setName("Gold");
            setCost(300);

    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 300);
        setuStrength(80);
    }
}
