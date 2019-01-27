package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Leben und Resistenz auf Zeit erhöht
 */

public class Galaxy extends Item {
    public Galaxy(Body body) {
        super(body);
        setName("Galaxy");
        setCost(110);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 110);
        setuHp(getuHp() + 3);
        setuResistance(1000000, 20);
    }
}
