package model.weapons;

import model.Body;
import model.Item;

public class Stick extends Item {
    public Stick(Body body) {
        super(body);
        setuStamina(getuStamina()-15);
        setuStrength(6);
        setName("Stick");
        setCost(15);
    }
}
