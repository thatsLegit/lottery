package controller;

import database.Bet;
import database.Database;
import gui.input.FormEvent;

import java.util.List;

public class Controller {
    //This class is just an intermediary between the gui and the database

    public List<Bet> getBet(){
        return db.getBets();
    }

    private Database db = new Database();

    public void addBet(FormEvent e) {
        Integer number1 = e.getNumber1();
        Integer number2 = e.getNumber2();
        Integer number3 = e.getNumber3();
        Integer number4 = e.getNumber4();
        Integer number5 = e.getNumber5();
        Boolean isBet = e.getIsSuperBet();
        Integer betAmountValue = e.getBetAmountValue();

        Bet bet = new Bet(number1, number2, number3, number4, number5, isBet, betAmountValue);
        db.addBet(bet);
    }
}
