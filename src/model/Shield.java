package model;

public class Shield extends Item {
    public Shield(Body body) {
        super(body);
        setName("shield");
        setCost(80);
    }

    /**
     * Verändert die Werte wenn gekauft
     */
    public void gotBought() {
        setuLire(getuLire() - 80);
        setuResistance(10000000, 120);
    }
}
