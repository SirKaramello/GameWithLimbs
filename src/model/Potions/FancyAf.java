package model.Potions;

import model.Body;
import model.Item;

public class FancyAf extends Item {
    public FancyAf(Body body) {
        super(body);
        setuStamina(getuStamina()-200);
        setuHp(getuHp()+3);
        setuSpeed(getuSpeed()+10);
        setuStrength(getuStrength()+10);
        setName("fancy af");
        setCost(200);
    }
}
