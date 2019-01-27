package model.Potions;

import model.Body;
import model.Item;

public class Yellow extends Item {
    public Yellow(Body body) {
        super(body);
        setuStamina(getuStamina()-70);
        setuHp(getuHp() + 3);
        setName("yellow");
        setCost(70);
    }
}
