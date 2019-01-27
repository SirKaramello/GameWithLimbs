package model.weapons;

import model.Body;
import model.Item;

public class Crossbow extends Item {
    public Crossbow(Body body) {
        super(body);
        setuStamina(getuStamina()-75);
        setuStrength(30);
        setName("Crossbow");
        setCost(75);
    }

}
