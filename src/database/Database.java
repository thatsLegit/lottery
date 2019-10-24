package database;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private List<Bet> bets;

    public Database() {
        bets = new LinkedList<Bet>();
    }

    public void addBet(Bet bet) {
        bets.add(bet);
    }

    public List<Bet> getBets() {
        return Collections.unmodifiableList(bets);  //so we can't modify it
    }

    public List<Bet> removeBets(int index) {
        return null;
    }
}
