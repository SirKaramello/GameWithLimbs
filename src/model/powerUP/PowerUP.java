package model.powerUP;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.Body;

import java.awt.image.BufferedImage;

/** nicht in dieser klasse weiterarbeiten, es wird umverlagert zu Items */

public abstract class PowerUP extends GraphicalObject {

    private Body uBody;
    private int uHp;
    private int uStamina;
    protected int powerUpType;
    private int uSpeed;
    private int uStrength;
    private int uResistance;
    protected double TimeStopCount;
    protected int amountOfST;
    protected boolean STOP;
    protected String filePath;
    protected boolean pickedUp;
    protected double yMax ;

    public String getFilePath() {
        return filePath;
    }


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

    public int getPowerUpType() {
        return powerUpType;
    }

    public void setPowerUpType(int powerUpType) {
        this.powerUpType = powerUpType;
    }

    public double getTimeStopCount() {
        return TimeStopCount;
    }

    public void updateTimeStopCount(PowerUP p) {
        TimeStopCount = p.getAmountOfST();
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

    public void update(double dt){
        if(y <= yMax){
            y += Math.random()*500*dt;
        }
    }

    public void jump(){
        x=Math.random()*1800;
    }

    public void draw(DrawTool drawTool){
        if(!pickedUp && uBody!=null && uBody.getBg()!=null &&uBody.getBg().getMode().equals("fight")){
            drawTool.drawImage(this.getMyImage(), x, y);
        }
    }

    public void setPickedUp(boolean p){
        pickedUp=p;
    }

}

