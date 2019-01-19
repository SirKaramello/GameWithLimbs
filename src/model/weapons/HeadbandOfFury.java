package model.weapons;

import model.Body;

public class HeadbandOfFury extends Weapon{
    public HeadbandOfFury(Body body){
        setwBody(body);
        setwHp(body.getHP());
        setwStamina(body.getStamina());
        setwSpeed(body.getSpeed());
        //setwResistance();
        //setwStrength();
    }
}
