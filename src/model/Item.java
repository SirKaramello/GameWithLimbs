package model;

import akkgframework.model.fundamental.GraphicalObject;

import java.awt.image.BufferedImage;


public abstract class Item extends GraphicalObject {

    private Body uBody;
    private int powerUpType;
    private double TimeStopCount;
    private int amountOfST;
    private boolean STOP;
    private String name;
    private int cost;
    private Boolean bought;

    public Item(Body body){
        uBody=body;
        bought = false;
    }

    private boolean isActive;

    public Body getuBody() {
        return uBody;
    }

    public void setuBody(Body uBody) {
        this.uBody = uBody;
    }

    public int getuHp() {
        return uBody.getHP();
    }

    public int getuStamina() {
        return uBody.getLire();
    }

    public int getuSpeed() {
        return uBody.getSpeed();
    }

    public void setuHp(int uHp) {
        uBody.setHp(uHp);
    }

    public void setuStamina(int uStamina) {
        uBody.setLire(uStamina);
    }

    public void setuSpeed(int uSpeed){
        uBody.setSpeed(uSpeed);
    }

    public int getuStrength() {
        return uBody.getStrength();
    }

    public void setuStrength(int uStrength) {
        uBody.setStrength(uStrength);
    }

    public int getuResistance() {
        return uBody.getResistance();
    }

    public void setuResistance(int uResistance, int Time) {
        uBody.setResistance(uResistance, Time);
    }

    public int getPowerUpType() {
        return powerUpType;
    }

    public void setPowerUpType(int powerUpType) {
        this.powerUpType = powerUpType;
    }

    public double getTimeStopCount() {
        return TimeStopCount;
    }

    public int getAmountOfST() {
        return amountOfST;
    }

    public void setAmountOfST(int amountOfST) {
        this.amountOfST = amountOfST;
    }

    public boolean isSTOP() {
        return STOP;
    }

    public void setSTOP(boolean STOP) {
        this.STOP = STOP;
    }

    public void setTimeStopCount(double timeStopCount) {
        TimeStopCount = timeStopCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    public void createNew(){
        bought = true;
    }

    public abstract void gotBought();

    public void setuLire(int d){
        uBody.setLire(d);
    }

    public int getuLire(){
        return uBody.getLire();
    }

}

