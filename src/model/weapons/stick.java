package model.weapons;

import model.Item;

public class stick extends Item {
    public stick() {
        setuStamina(getuStamina()-15);
        setuStrength(6);
        setName("Stick");
        setCost(15);
    }
}
