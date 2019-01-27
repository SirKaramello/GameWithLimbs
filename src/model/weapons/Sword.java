package model.weapons;

import model.Item;

public class Sword extends Item {
    public Sword(){
        setuStamina(getuStamina()-30);
        setuStrength(10);
        setName("Sword");
        setCost(30);
    }
}
