package Models;

public class Bet {

    private static int count = 0;
    private int id;
    private Integer number1;
    private Integer number2;
    private Integer number3;
    private Integer number4;
    private Integer number5;
    private Boolean isSuperBet;
    private Integer betAmountValue;

    public Bet(Integer number1, Integer number2, Integer number3, Integer number4, Integer number5, Boolean isSuperBet, Integer betAmountValue) {
        this.id = count;
        count++;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.isSuperBet = isSuperBet;
        this.betAmountValue = betAmountValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getNumber3() {
        return number3;
    }

    public void setNumber3(Integer number3) {
        this.number3 = number3;
    }

    public Integer getNumber4() {
        return number4;
    }

    public void setNumber4(Integer number4) {
        this.number4 = number4;
    }

    public Integer getNumber5() {
        return number5;
    }

    public void setNumber5(Integer number5) {
        this.number5 = number5;
    }

    public Boolean getIsSuperBet() {
        return isSuperBet;
    }

    public void setIsSuperBet(Boolean bet) {
        isSuperBet = bet;
    }

    public Integer getBetAmountValue() {
        return betAmountValue;
    }

    public void setBetAmountValue(Integer betAmountValue) {
        this.betAmountValue = betAmountValue;
    }
}
