package model;

public class Shield extends Item {
    public Shield(){
        setuStamina(getuStamina()-80);
        setuResistance(10000000,120);
        setName("shield");
        setCost(80);
    }
}
