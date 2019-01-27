package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Leben gibt
 */

public class Yellow extends Item {
    public Yellow(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 70);
            setuHp(getuHp() + 3);
        }
        setName("yellow");
        setCost(70);
    }
}
