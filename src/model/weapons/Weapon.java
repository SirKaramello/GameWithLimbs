package model.weapons;

import model.Body;

/** nicht in dieser klasse weiterarbeiten, es wird umverlagert zu Items */

public class Weapon {

    private Body wBody;
    private int wHp;
    private int wStamina;
    private int wSpeed;
    private int wStrength;
    private int wResistance;


    public Body getwBody() {
        return wBody;
    }

    public void setwBody(Body wBody) {
        this.wBody = wBody;
    }

    public int getwHp() {
        return wHp;
    }

    public void setwHp(int wHp) {
        this.wHp = wHp;
    }

    public int getwStamina() {
        return wStamina;
    }

    public void setwStamina(int wStamina) {
        this.wStamina = wStamina;
    }

    public int getwSpeed() {
        return wSpeed;
    }

    public void setwSpeed(int wSpeed) {
        this.wSpeed = wSpeed;
    }

    public int getwStrength() {
        return wStrength;
    }

    public void setwStrength(int wStrength) {
        this.wStrength = wStrength;
    }

    public int getwResistance() {
        return wResistance;
    }

    public void setwResistance(int wResistance) {
        this.wResistance = wResistance;
    }

}
