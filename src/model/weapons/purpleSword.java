package model.weapons;

import model.Item;

public class purpleSword extends Item {
    public purpleSword (){
        setuStamina(getuStamina()-75);
        setuStrength(28);
        setuSpeed(getuSpeed()+2);
        setName("purpleSword");
        setCost(75);
    }
}
