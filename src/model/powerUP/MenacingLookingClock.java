package model.powerUP;

import model.Body;

/**
 * Die Zeit bleibt für eine gewisse Zeit stehen und der Spieler kann sich bewegen und der Gegner jedoch nicht.
 */

public class MenacingLookingClock  extends PowerUP{

    private double timeStopCount;

    public MenacingLookingClock(Body body){
        filePath="assets/images/pU/menacing.png";
        setTimeStopCount(0);
        setAmountOfST(5);
        setSTOP(false);
        setPowerUpType(3);
        x=Math.random()*1800;
        yMax=500+(int)(Math.random()*1080);
        setMyImage(createNewImage(getFilePath()));
    }

    public void update(double dt) {
       // super.update(dt);
        double timeStop = this.getTimeStopCount();
        while (this.getTimeStopCount() < 0) {
            if (!this.isSTOP()) {
                this.setSTOP(false);
            }
            while (this.getTimeStopCount() >= 0) {
                if (!this.isSTOP()) {
                    this.setSTOP(true);
                }
            }
        }
    }

}
