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

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuResistance(1000000, 20);
    }

    /**
     * aktiviert das Item
     */
    public void activate(){
        setuHp(getuHp() + 3);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate(){

    }

}
