package model.powerUP;
import model.Body;

/**
 * Man wird resistänter gegen Schaden wird aber langsamer und die Ausdauer verringert sich.
 */

public class HylianShield extends PowerUP {

    public HylianShield(Body body){
        setuBody(body);
        setuHp(body.getHP());
        setuStamina(-(body.getStamina()/8));
        setuSpeed(-(body.getSpeed()/8));
        //resistance und strength fehlen
    }

}
