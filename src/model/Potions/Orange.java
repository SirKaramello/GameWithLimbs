package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Resistenz für 30 sek erhöht
 */
public class Orange extends Item {
    public Orange(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 70);
            setuResistance(10000000, 30);
        }
        setName("Orange");
        setCost(70);
    }
}
