package model.Potions;

import model.Item;

public class turqouise extends Item {
    public turqouise(){
        setuStamina(getuStamina()-30);
        setuStrength(getuStrength()+10);
        setName("turqouise");
        setCost(30);
    }
}
