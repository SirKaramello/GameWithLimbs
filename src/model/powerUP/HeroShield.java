package model.powerUP;
import model.Body;

public class HeroShield extends PowerUP {

    public HeroShield(Body body){
        setuBody(body);
        setuHp(body.getHP());
        setuStamina(-(body.getStamina()/8));
        setuSpeed(-(body.getSpeed()/8));
        //resistance und strength fehlen
    }

}
