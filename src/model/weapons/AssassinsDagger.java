package model.weapons;

import model.Body;

public class AssassinsDagger extends Weapon {
    public AssassinsDagger(Body body){
        setwBody(body);
        setwHp(-(body.getHP()/8));
        setwStamina((body.getStamina()/2));
        setwSpeed(body.getSpeed());
        setwResistance(-body.getResistance()/2);
        setwStrength(-body.getStrength()/3);
    }
}
