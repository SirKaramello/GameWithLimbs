package model.weapons;

import model.Body;
import model.Item;

public class Silver extends Item {
    public Silver(Body body) {
        super(body);
        setuStamina(getuStamina()-90);
        setuStrength(50);
        setName("Silver");
        setCost(90);
    }
}
