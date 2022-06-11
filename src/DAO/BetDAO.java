package DAO;

import gui.input.FormEvent;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

import Models.Bet;

public class BetDAO implements IBetDAO {

    private List<Bet> bets;

    public BetDAO() {
        bets = new LinkedList<Bet>();
    }

    public List<Bet> getBet(){
        return Collections.unmodifiableList(bets);
    }

    public void addBet(FormEvent e) {
        Integer number1 = e.getNumber1();
        Integer number2 = e.getNumber2();
        Integer number3 = e.getNumber3();
        Integer number4 = e.getNumber4();
        Integer number5 = e.getNumber5();
        Boolean isBet = e.getIsSuperBet();
        Integer betAmountValue = e.getBetAmountValue();

        Bet bet = new Bet(number1, number2, number3, number4, number5, isBet, betAmountValue);
        bets.add(bet);
    }
}