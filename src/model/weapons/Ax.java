package model.weapons;


import model.Body;
import model.Item;

public class Ax extends Item {
    public Ax(Body body) {
        super(body);
            setuStamina(getuStamina()-25);
            setuSpeed(getuSpeed()-5);
            setuStrength(8);
            setName("Ax");
            setCost(25);
    }

}
