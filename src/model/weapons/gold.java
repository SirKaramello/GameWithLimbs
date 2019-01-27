package model.weapons;

import model.Item;

public class gold extends Item {
    public gold(){
        setuStamina(getuStamina()-300);
        setuStrength(80);
        setName("gold");
        setCost(300);
    }

}
