package model.weapons;

import model.Body;
import model.Item;

public class Gold extends Item {
    public Gold(Body body) {
        super(body);
        setuStamina(getuStamina()-300);
        setuStrength(80);
        setName("Gold");
        setCost(300);
    }

}
