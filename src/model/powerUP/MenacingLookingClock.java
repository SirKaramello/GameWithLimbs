package model.powerUP;

import model.Body;

/**
 * Die Zeit bleibt für eine gewisse Zeit stehen und der Spieler kann sich bewegen und der Gegner jedoch nicht.
 */

public class MenacingLookingClock  extends PowerUP{


    public MenacingLookingClock(Body body){
        setuBody(body);
        filePath="assets/images/pU/menacing.png";
        setTimeStopCount(0);
        setAmountOfST(5);
        setSTOP(false);
        setPowerUpType(3);
        x=Math.random()*1800;
        yMax=400+(int)(Math.random()*(500));
        setMyImage(createNewImage(getFilePath()));
    }

}
