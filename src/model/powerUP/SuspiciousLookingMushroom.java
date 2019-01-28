package model.powerUP;
import model.Body;

public class SuspiciousLookingMushroom extends PowerUP {

    public SuspiciousLookingMushroom(Body body){
        setTimeStopCount(0);
        setAmountOfST(5);
        setuSpeed(100);
        setSTOP(false);
        setPowerUpType(0);
        x=Math.random()*1800;
        yMax=100+(Math.random()*1080);
        System.out.println(yMax);
        setMyImage(createNewImage("assets/images/pU/mosh.png"));
    }
}
