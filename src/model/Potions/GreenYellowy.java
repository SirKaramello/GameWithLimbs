package model.Potions;

import model.Body;
import model.Item;

public class GreenYellowy extends Item {
    public GreenYellowy(Body body) {
        super(body);
        setuStamina(getuStamina()-30);
        setuSpeed(getuSpeed()+10);
        setName("green-yellowy");
        setCost(30);
    }
}
