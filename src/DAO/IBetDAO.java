package DAO;

import java.util.List;

import Models.Bet;
import gui.input.FormEvent;

public interface IBetDAO {
    public List<Bet> getBet();
    public void addBet(FormEvent e);
}
