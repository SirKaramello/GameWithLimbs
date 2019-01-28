package model.weapons;


import model.Body;
import model.Item;


/**
 * Axt die Stärke erhöht und LAngsamer macht
 */

public class Ax extends Item {
    public Ax(Body body) {
        super(body);
        setName("Ax");
        setCost(25);

    }
    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought(){
        setuLire(getuLire() - getCost());
        setuSpeed(getuSpeed() - 5);
    }
    /**
     * aktiviert das Item
     */
    public void activate(){
        setuStrength(getuStrength()+8);
    }
    /**
     * deaktiviert das Item
     */
    public void deactivate() {
        setuStrength(getuStrength() - 8);
    }
}
