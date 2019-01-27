package model.Potions;

import model.Item;

public class Galaxy extends Item {
    public Galaxy(){
        setuStamina(getuStamina()-110);
        setuHp(getuHp()+3);
        setuResistance(1000000,20);
        setName("Galaxy");
        setCost(110);
    }
}
