package model.weapons;

import model.Body;
import model.Item;

/**
 * Stock welcher ganz kleines bisschen stärker macht.
 */
public class Stick extends Item {
    public Stick(Body body) {
        super(body);
        setName("Stick");
        setCost(15);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 15);
        setuStrength(6);
    }
}
