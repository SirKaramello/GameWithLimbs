package model.powerUP;

import model.Body;

/** nicht in dieser klasse weiterarbeiten, es wird umverlagert zu Items */

public abstract class PowerUP {

    private Body uBody;
    private int uHp;
    private int uStamina;
    private int uSpeed;
    private int uStrength;
    private int uResistance;

    public Body getuBody() {
        return uBody;
    }

    public int getuHp() {
        return uHp;
    }

    public int getuStamina() {
        return uStamina;
    }

    public int getuSpeed() {
        return uSpeed;
    }

    public void setuBody(Body uBody) {
        this.uBody = uBody;
    }

    public void setuHp(int uHp) {
        this.uHp = uHp;
    }

    public void setuStamina(int uStamina) {
        this.uStamina = uStamina;
    }

    public void setuSpeed(int uSpeed){
        this.uSpeed = uSpeed;
    }

    public int getuStrength() {
        return uStrength;
    }

    public void setuStrength(int uStrength) {
        this.uStrength = uStrength;
    }

    public int getuResistance() {
        return uResistance;
    }

    public void setuResistance(int uResistance) {
        this.uResistance = uResistance;
    }



}

