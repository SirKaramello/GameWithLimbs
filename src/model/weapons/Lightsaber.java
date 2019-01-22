package model.weapons;

import model.Body;

public class Lightsaber extends Weapon {
    public Lightsaber(Body body){
            setwBody(body);
            setwHp(0);
            setwStamina((body.getStamina()));
            setwSpeed(-(body.getSpeed()));
            setwResistance(body.getResistance());
            setwStrength(body.getStrength());
    }

}
