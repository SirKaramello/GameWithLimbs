package model.weapons;

import model.Body;
import model.Item;

public class Sword extends Item {
    public Sword(Body body) {
        super(body);
        setuStamina(getuStamina()-30);
        setuStrength(10);
        setName("Sword");
        setCost(30);
    }
}
