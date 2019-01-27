package model.Potions;

import model.Body;
import model.Item;

public class Turqouise extends Item {
    public Turqouise(Body body) {
        super(body);
        setuStamina(getuStamina()-30);
        setuStrength(getuStrength()+10);
        setName("Turqouise");
        setCost(30);
    }
}
