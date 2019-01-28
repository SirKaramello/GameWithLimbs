package model.powerUP;

import model.Body;

/**
 * Die Stärke wird dermassen erhöht, dass der gegenüber in einem Schlag stirbt(der Spieler sowohl als auch der Gegner)
 */
public class EqualFuel extends PowerUP{
    public EqualFuel(Body body){
        setuBody(body);
        filePath="assets/images/pU/menacing.png";
        setTimeStopCount(0);
        setAmountOfST(5);
        setSTOP(false);
        yMax=400+(int)(Math.random()*(500));
        System.out.println(yMax);
        setMyImage(createNewImage(getFilePath()));
    }
}
