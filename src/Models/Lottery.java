package Models;

public class Lottery {

    private static int count = 0;
    private Integer iDLottery;
    private Integer n1Lottery;
    private Integer n2Lottery;
    private Integer n3Lottery;
    private Integer n4Lottery;
    private Integer n5Lottery;

    public Lottery(Integer n1Lottery, Integer n2Lottery, Integer n3Lottery, Integer n4Lottery, Integer n5Lottery) {
        this.iDLottery = count;
        count++;
        this.n1Lottery = n1Lottery;
        this.n2Lottery = n2Lottery;
        this.n3Lottery = n3Lottery;
        this.n4Lottery = n4Lottery;
        this.n5Lottery = n5Lottery;
    }

    public Integer getiDLottery() {
        return iDLottery;
    }

    public void setiDLottery(Integer iDLottery) {
        this.iDLottery = iDLottery;
    }

    public Integer getN1Lottery() {
        return n1Lottery;
    }

    public void setN1Lottery(Integer n1Lottery) {
        this.n1Lottery = n1Lottery;
    }

    public Integer getN2Lottery() {
        return n2Lottery;
    }

    public void setN2Lottery(Integer n2Lottery) {
        this.n2Lottery = n2Lottery;
    }

    public Integer getN3Lottery() {
        return n3Lottery;
    }

    public void setN3Lottery(Integer n3Lottery) {
        this.n3Lottery = n3Lottery;
    }

    public Integer getN4Lottery() {
        return n4Lottery;
    }

    public void setN4Lottery(Integer n4Lottery) {
        this.n4Lottery = n4Lottery;
    }

    public Integer getN5Lottery() {
        return n5Lottery;
    }

    public void setN5Lottery(Integer n5Lottery) {
        this.n5Lottery = n5Lottery;
    }
}
