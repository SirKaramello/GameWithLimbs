package model.weapons;

import model.Body;
import model.Item;

/**
 * Goldschwert welches Stärke erhöht
 */

public class Gold extends Item {
    public Gold(Body body) {
        super(body);
        setName("Gold");
        setCost(300);

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
        setuStrength(getuStrength()+80);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate() {
        setuStrength(getuStrength() - 80);
    }


}
