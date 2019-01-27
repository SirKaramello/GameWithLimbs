package model.Potions;

import model.Item;

public class Yellow extends Item {
    public Yellow() {
        setuStamina(getuStamina()-70);
        setuHp(getuHp() + 3);
        setName("yellow");
        setCost(70);
    }
}
