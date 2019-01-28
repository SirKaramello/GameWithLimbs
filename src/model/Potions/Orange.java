package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Resistenz für 30 sek erhöht
 */
public class Orange extends Item {
    public Orange(Body body) {
        super(body);
        setName("Orange");
        setCost(70);
    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuResistance(10000000, 30);
    }
    /**
     * aktiviert das Item
     */
    public void activate(){

    }
    /**
     * deaktiviert das Item
     */
    public void deactivate(){

    }
}
