package model.Potions;

import model.Item;

public class Brownish extends Item {
    public Brownish(){
        setuStamina(getuStamina()-50);
        setuStrength(getuStrength()+10);
        setuSpeed(getuSpeed()+10);
        setName("brownish");
        setCost(50);
    }
}
