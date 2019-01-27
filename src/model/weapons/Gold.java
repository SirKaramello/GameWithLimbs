package model.weapons;

import model.Item;

public class Gold extends Item {
    public Gold(){
        setuStamina(getuStamina()-300);
        setuStrength(80);
        setName("Gold");
        setCost(300);
    }

}
