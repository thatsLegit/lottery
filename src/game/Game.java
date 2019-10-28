package game;

import database.Bet;
import gui.input.MainFrame;
import gui.input.TablePanelModel;
import gui.output.AdditionalPanel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {

    private static List<WinningLottery> lotteryList = new LinkedList<>();

    public static void CreateLottery(){

        Random rnd = new Random();

        //set any value for lottery numbers here if you want to do a test
        int number1 = rnd.nextInt(20) + 1;
        int number2 = rnd.nextInt(20) + 1;
        int number3 = rnd.nextInt(20) + 1;
        int number4 = rnd.nextInt(20) + 1;
        int number5 = rnd.nextInt(10) + 1;

        //redo random if all numbers aren't different
        while (number1 == number2 || number1==number3 || number1==number4 || number2==number3 || number2==number4 || number3==number4){
            number1 = rnd.nextInt(20) + 1;
            number2 = rnd.nextInt(20) + 1;
            number3 = rnd.nextInt(20) + 1;
            number4 = rnd.nextInt(20) + 1;
        }

        for (int i = 0; i< TablePanelModel.db.size(); i++){
            if (TablePanelModel.db.get(i).getIsSuperBet()) {
                WinningLottery winningLottery4numbers = new WinningLottery(number1, number2, number3, number4, number5);
                lotteryList.add(winningLottery4numbers);
            }
            else if (!TablePanelModel.db.get(i).getIsSuperBet()){
                WinningLottery winningLottery5numbers = new WinningLottery(number1, number2, number3, number4, null);
                lotteryList.add(winningLottery5numbers);
            }
        }
    }

    public static Integer calculateFittingNumbers(WinningLottery winningLottery, Bet bet) {
        int fNumbers = 0;
        LinkedList<Integer> winningLotteryList = new LinkedList<>();
        winningLotteryList.add(winningLottery.getN1Lottery());
        winningLotteryList.add(winningLottery.getN2Lottery());
        winningLotteryList.add(winningLottery.getN3Lottery());
        winningLotteryList.add(winningLottery.getN4Lottery());
        winningLotteryList.add(winningLottery.getN5Lottery());
        LinkedList<Integer> betList = new LinkedList<>();
        betList.add(bet.getNumber1());
        betList.add(bet.getNumber2());
        betList.add(bet.getNumber3());
        betList.add(bet.getNumber4());
        betList.add(bet.getNumber5());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                if (betList.get(i) == winningLotteryList.get(j)) {
                    fNumbers++;
                    break;
                }
            }
        }
        return fNumbers;
    }

    public static Integer calculateGainCoefficient(WinningLottery winningLottery, Bet bet) {
        int k;

        //Affects an initial coefficient independant from the superbet
        if (calculateFittingNumbers(winningLottery, bet).equals(3)){
            k = 5;
        }
        else if (calculateFittingNumbers(winningLottery, bet).equals(4)){
            k = 50;
        }
        else k = 0;

        //Take superbet multiplier into account
        if (bet.getIsSuperBet()){
            if (bet.getNumber5().equals(winningLottery.getN5Lottery())){
                k = k*5;
            }
        }
        return k;
    }

    public List<WinningLottery> getLotteryNumbers() {
        return lotteryList;
    }

    public Integer totalBets() {
        int amountValue = 0;
        for (int i=0;i<MainFrame.controller.getBet().size();i++){
            amountValue += MainFrame.controller.getBet().get(0).getBetAmountValue();
        }
        return amountValue;
    }

    public Integer totalGains() {
        //multiply each bet by the bet multiplier (depending on the fitting numbers) and return the final gain
        int gain = 0;
        for (int i = 0; i<MainFrame.controller.getBet().size();i++){
            gain += (int) AdditionalPanel.additionalPanelModel.getValueAt(i, 0)*(int) AdditionalPanel.additionalPanelModel.getValueAt(i, 2);
        }
        return gain;
    }
}
