package model.weapons;

import model.Body;
import model.Item;

public class PurpleSword extends Item {
    public PurpleSword (Body body) {
        super(body);
        setuStamina(getuStamina()-75);
        setuStrength(28);
        setuSpeed(getuSpeed()+2);
        setName("purpleSword");
        setCost(75);
    }
}
