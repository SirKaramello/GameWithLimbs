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
    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - getCost());
        setuHp(getuHp() + 3);
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
