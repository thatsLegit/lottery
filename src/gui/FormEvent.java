package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String number1;
    private String number2;
    private String number3;
    private String number4;
    private String number5;
    private Boolean isBet;
    private String betAmountValue;

    public FormEvent(Object source, String number1, String number2, String number3, String number4, String number5, Boolean isBet, String betAmountValue) {
        super(source);
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.isBet = isBet;
        this.betAmountValue = betAmountValue;
    }

    public Integer getNumber1() {
        return Integer.parseInt(number1);
    }

    public Integer getNumber2() {
        return Integer.parseInt(number2);
    }

    public Integer getNumber3() {
        return Integer.parseInt(number3);
    }

    public Integer getNumber4() {
        return Integer.parseInt(number4);
    }

    public Integer getNumber5() {
        if (!number5.equals("")) {
            return Integer.parseInt(number5);
        }
        return null;
    }

    public Boolean getBet() {
        return isBet;
    }

    public Integer getBetAmountValue() {
        return Integer.parseInt(betAmountValue);
    }
}
