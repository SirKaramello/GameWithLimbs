package model.Potions;

import model.Item;

public class Orange extends Item {
    public Orange() {
        setuStamina(getuStamina()-70);
        setuResistance(10000000,30);
        setName("Orange");
        setCost(70);
    }
}
