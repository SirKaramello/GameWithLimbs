package model.weapons;

import model.Item;

public class silver extends Item {
    public silver () {
        setuStamina(getuStamina()-90);
        setuStrength(50);
        setName("silver");
        setCost(90);
    }
}
