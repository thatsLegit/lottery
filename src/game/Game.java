package game;

import gui.output.RetrievalTableModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {

    private static List<WinningLottery> lotteryList = new LinkedList<>();

    public static void CreateLottery(){

        Random rnd = new Random();

        for (int i=0;i<RetrievalTableModel.db.size();i++){
            if (RetrievalTableModel.db.get(i).getIsSuperBet()) {
                int number1 = rnd.nextInt(20) + 1;
                int number2 = rnd.nextInt(20) + 1;
                int number3 = rnd.nextInt(20) + 1;
                int number4 = rnd.nextInt(20) + 1;
                int number5 = rnd.nextInt(10) + 1;
                WinningLottery winningLottery4numbers = new WinningLottery(number1, number2, number3, number4, number5);
                lotteryList.add(winningLottery4numbers);
            }
            else if (!RetrievalTableModel.db.get(i).getIsSuperBet()){
                int number1 = rnd.nextInt(20) + 1;
                int number2 = rnd.nextInt(20) + 1;
                int number3 = rnd.nextInt(20) + 1;
                int number4 = rnd.nextInt(20) + 1;
                WinningLottery winningLottery5numbers = new WinningLottery(number1, number2, number3, number4, null);
                lotteryList.add(winningLottery5numbers);
            }
        }
    }

    public List<WinningLottery> getLotteryNumbers() {
        return lotteryList;
    }
}
