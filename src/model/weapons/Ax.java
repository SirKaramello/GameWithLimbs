package model.weapons;


import model.Body;
import model.Item;


/**
 * Axt die Stärke erhöht und LAngsamer macht
 */

public class Ax extends Item {
    public Ax(Body body) {
        super(body);
            if (getBought()) {
                setuStamina(getuStamina() - 25);
                setuSpeed(getuSpeed() - 5);
                setuStrength(8);
            }
                setName("Ax");
                setCost(25);

    }

}
