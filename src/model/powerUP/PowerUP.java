package model.powerUP;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;
import model.Body;

import java.awt.image.BufferedImage;

/** nicht in dieser klasse weiterarbeiten, es wird umverlagert zu Items */

public abstract class PowerUP extends GraphicalObject {
    //Attribute
    private int uStamina,uResistance,amountOfST,uSpeed,uStrength,uHp,powerUpType;
    protected double TimeStopCount,yMax;
    protected boolean STOP,pickedUp;
    protected String filePath;
    //Referenzen
    private Body uBody;

    /**
     * @return gibt den FilePath des Bildes zurücl
     */
    public String getFilePath() {
        return filePath;
    }

    /*
     * @return gibt die neue hp vom Spieler zurücl
     */
    public int getuHp() {
        return uHp;
    }
    /*
     * @return gibt die neue stamina vom Spieler zurücl
     */
    public int getuStamina() {
        return uStamina;
    }
    /*
     * @return gibt die neue speed vom Spieler zurücl
     */
    public int getuSpeed() {
        return uSpeed;
    }
    /*
     * setzt den neuen Spieler
     */
    public void setuBody(Body uBody) {
        this.uBody = uBody;
    }

    /*
     * setzt die neue speed
     */
    public void setuSpeed(int uSpeed){
        this.uSpeed = uSpeed;
    }
    /*
    * @return die neue stärle
    */
    public int getuStrength() {
        return uStrength;
    }
    /*
    * setzt die neue stärle
     */
    public void setuStrength(int uStrength) {
        this.uStrength = uStrength;
    }
    /*
       * @return die neue resistenz
       */
    public int getuResistance() {
        return uResistance;
    }
    /*
       * setzt die resistenz
       */
    public void setuResistance(int uResistance) {
        this.uResistance = uResistance;
    }

    /*
     * @return gibt den Typ des Powerups zurück
     */
    public int getPowerUpType() {
        return powerUpType;
    }

    public void setPowerUpType(int powerUpType) {
        this.powerUpType = powerUpType;
    }


    public void setAmountOfST(int amountOfST) {
        this.amountOfST = amountOfST;
    }

    public void setSTOP(boolean STOP) {
        this.STOP = STOP;
    }

    public void setTimeStopCount(double timeStopCount) {
        TimeStopCount = timeStopCount;
    }

    /**
     * Bewegung
     * @param dt vrstrichene Zeit seit dem letzten Aufruf der MEthode
     */
    public void update(double dt){
        if(y <= yMax){
            y += Math.random()*500*dt;
        }
    }

    /**
     * Lässt die x koordinate random umändern
     */
    public void jump(){
        x=Math.random()*1800;
    }

    /**
     * zeicgnet die powerups
     * @param drawTool das werkzeug
     */
    public void draw(DrawTool drawTool){
        if(!pickedUp && uBody!=null && uBody.getBg()!=null &&uBody.getBg().getMode().equals("fight")){
            drawTool.drawImage(this.getMyImage(), x, y);
        }
    }

    /**
     * setzt pickedUp
     * @param p der neue wahrheitswert
     */
    public void setPickedUp(boolean p){
        pickedUp=p;
    }

    /**
     * @return pickedUp
     */
    public boolean getPickedUp(){
        return pickedUp;
    }

}

