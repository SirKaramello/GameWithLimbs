package model.Potions;

import model.Item;

public class expensive extends Item {
    public expensive(){
        setuStamina(getuStamina()-300);
        setuHp(getuHp()+3);
        setuSpeed(getuSpeed()+10);
        setuStrength(getuStrength()+10);
        setuResistance(100000,60);
        setName("expensive");
        setCost(300);
    }
}
