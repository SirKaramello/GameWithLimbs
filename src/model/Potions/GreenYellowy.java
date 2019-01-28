package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Geschwindigkeit erhöht
 */
public class GreenYellowy extends Item {
    public GreenYellowy(Body body) {
        super(body);
        setName("green-yellowy");
        setCost(30);
    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuStamina(getuStamina() - 30);
        setuSpeed(getuSpeed() + 10);
    }
}
