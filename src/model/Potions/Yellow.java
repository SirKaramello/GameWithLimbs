package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Leben gibt
 */

public class Yellow extends Item {
    public Yellow(Body body) {
        super(body);
        setName("yellow");
        setCost(70);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 70);
        setuHp(getuHp() + 3);
    }


}
