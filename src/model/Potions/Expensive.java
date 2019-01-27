package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Leben, Stärke, Geschwindigkeit und Resistenz auf Zeit erhöht
 */

public class Expensive extends Item {
    public Expensive(Body body) {
        super(body);
        if (getBought()) {
            setuStamina(getuStamina() - 300);
            setuHp(getuHp() + 3);
            setuSpeed(getuSpeed() + 10);
            setuStrength(getuStrength() + 10);
            setuResistance(100000, 60);
        }
        setName("expensive");
        setCost(300);
    }
}
