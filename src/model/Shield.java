package model;

public class Shield extends Item {
    public Shield(Body body) {
        super(body);
        setName("shield");
        setCost(80);
    }

    @Override
    public void gotBought() {
        setuStamina(getuStamina() - 80);
        setuResistance(10000000, 120);
    }
}
