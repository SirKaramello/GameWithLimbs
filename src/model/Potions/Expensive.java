package model.Potions;

import model.Body;
import model.Item;

public class Expensive extends Item {
    public Expensive(Body body) {
        super(body);
        setuStamina(getuStamina()-300);
        setuHp(getuHp()+3);
        setuSpeed(getuSpeed()+10);
        setuStrength(getuStrength()+10);
        setuResistance(100000,60);
        setName("Expensive");
        setCost(300);
    }
}
