package model.powerUP;
import model.Body;

public class SuspiciousLookingMushroom extends PowerUP {

    public SuspiciousLookingMushroom(Body body){
        setuBody(body);
        setTimeStopCount(0);
        setAmountOfST(5);
        setuSpeed(100);
        setSTOP(false);
        setPowerUpType(0);
        x=800+(int)(Math.random()*1000);
        yMax=400+(int)(Math.random()*(500));
        System.out.println(yMax);
        setMyImage(createNewImage("assets/images/pU/mosh.png"));
    }
}
