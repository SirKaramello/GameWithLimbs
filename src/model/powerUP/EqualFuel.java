package model.powerUP;

import model.Body;

/**
 * Die Stärke wird dermassen erhöht, dass der gegenüber in einem Schlag stirbt(der Spieler sowohl als auch der Gegner)
 */
public class EqualFuel extends PowerUP{
    public EqualFuel(Body body,double[] xC){
        filePath="assets/images/pU/menacing.png";
        setTimeStopCount(0);
        setAmountOfST(5);
        setSTOP(false);
        yMax=200+(int)(Math.random()*1080);
        System.out.println(yMax);
        setMyImage(createNewImage(getFilePath()));
    }
}
