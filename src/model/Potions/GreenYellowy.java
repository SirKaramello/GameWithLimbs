package model.Potions;

import model.Item;

public class GreenYellowy extends Item {
    public GreenYellowy(){
        setuStamina(getuStamina()-30);
        setuSpeed(getuSpeed()+10);
        setName("green-yellowy");
        setCost(30);
    }
}
