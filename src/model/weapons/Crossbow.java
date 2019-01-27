package model.weapons;

import model.Item;

public class Crossbow extends Item {
    public Crossbow(){
        setuStamina(getuStamina()-75);
        setuStrength(30);
        setName("Crossbow");
        setCost(75);
    }

}
