package model.Potions;

import model.Body;
import model.Item;

/**
 * Trank der Leben, Stärke, Geschwindigkeit und Resistenz auf Zeit erhöht
 */

public class Expensive extends Item {
    public Expensive(Body body) {
        super(body);
        setName("expensive");
        setCost(300);
    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuHp(getuHp() + 3);
        setuSpeed(getuSpeed() + 10);
        setuStrength(getuStrength() + 10);
        setuResistance(100000, 60);
    }
    /**
     * aktiviert das Item
     */
    public void activate(){
        setuHp(getuHp() + 3);
        setuSpeed(getuSpeed() + 10);
        setuStrength(getuStrength() + 10);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate(){

    }

}
