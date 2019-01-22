package model.powerUP;
import model.Body;

public class SuspiciousLookingMushroom extends PowerUP {

    public SuspiciousLookingMushroom(Body body){
        setuBody(body);
        setuHp(-(body.getHP()/8));
        setuStamina((body.getStamina()/4));
        setuSpeed(body.getSpeed());
        setuResistance(-(body.getResistance())/8);
        setuStrength(body.getStrength());
    }
}
