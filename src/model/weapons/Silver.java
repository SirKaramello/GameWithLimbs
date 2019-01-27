package model.weapons;

import model.Item;

public class Silver extends Item {
    public Silver() {
        setuStamina(getuStamina()-90);
        setuStrength(50);
        setName("Silver");
        setCost(90);
    }
}
