package model.weapons;

import model.Item;

public class Stick extends Item {
    public Stick() {
        setuStamina(getuStamina()-15);
        setuStrength(6);
        setName("Stick");
        setCost(15);
    }
}
