package model;

public class Shield extends Item {
    public Shield(Body body) {
        super(body);
        setuStamina(getuStamina()-80);
        setuResistance(10000000,120);
        setName("shield");
        setCost(80);
    }
}
