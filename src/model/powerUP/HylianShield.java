package model.powerUP;
import model.Body;

/**
 * Man wird resistänter gegen Schaden wird aber langsamer und die Ausdauer verringert sich.
 */

public class HylianShield extends PowerUP {

    public HylianShield(Body body){
        filePath="assets/images/pU/hyl.png";
        setTimeStopCount(0);
        setuSpeed(-100);
        setSTOP(false);
        yMax=200+(int)(Math.random()*1080);
        x=Math.random()*1800;
        setuResistance(body.getResistance()+10);
        setMyImage(createNewImage(getFilePath()));
    }

}
