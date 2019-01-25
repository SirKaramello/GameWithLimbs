package model;

public class UpgradeInfo {
    private int reqSouls;
    private int addedNumber;

    public UpgradeInfo(){
        reqSouls = 2;
        addedNumber = 10;
    }

    public void setReqSouls(int reqSouls) {
        this.reqSouls = reqSouls;
    }

    public void setAddedNumber(int addedNumber) {
        this.addedNumber = addedNumber;
    }

    public int getReqSouls() {
        return reqSouls;
    }

    public int getAddedNumber() {
        return addedNumber;
    }

}
