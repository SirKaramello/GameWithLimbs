package model.powerUP;
import model.Body;

public class SuspiciousLookingMushroom extends PowerUP {

    public SuspiciousLookingMushroom(Body body){
        setuBody(body);
        setuHp(-(body.getHP()/8));
        setuStamina((body.getStamina()/4));
        setuSpeed(body.getSpeed());
        //resistance und strength fehlen
    }
}
