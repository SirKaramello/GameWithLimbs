package model.Potions;

import model.Item;

public class fancyAf extends Item {
    public fancyAf(){
        setuStamina(getuStamina()-200);
        setuHp(getuHp()+3);
        setuSpeed(getuSpeed()+10);
        setuStrength(getuStrength()+10);
        setName("fancy af");
        setCost(200);
    }
}
