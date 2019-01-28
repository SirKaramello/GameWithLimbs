package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Stärke und Geschwindigkeit des Spielers erhöht
 */

public class Brownish extends Item {
    public Brownish(Body body) {
        super(body);
        setName("brownish");
        setCost(50);
    }
    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
    }
    /**
     * aktiviert das Item
     */
    public void activate(){
        setuStrength(getuStrength() + 10);
        setuSpeed(getuSpeed() + 10);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate(){

    }

}
