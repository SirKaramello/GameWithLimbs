package model.weapons;

import model.Body;
import model.Item;

public class MorningStar extends Item {
    public MorningStar(Body body) {
        super(body);
        setuStamina(getuStamina()-50);
        setuSpeed(getuSpeed()-2);
        setuStrength(20);
        setName("MorningStar");
        setCost(50);
    }
}
