package model.Potions;

import model.Body;
import model.Item;

public class Orange extends Item {
    public Orange(Body body) {
        super(body);
        setuStamina(getuStamina()-70);
        setuResistance(10000000,30);
        setName("Orange");
        setCost(70);
    }
}
