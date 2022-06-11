package game;

import gui.input.MainFrame;
import gui.input.TablePanelModel;
import gui.output.AdditionalPanel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Models.Bet;
import Models.Lottery;

public class Game {

    private static List<Lottery> lotteryList = new LinkedList<>();

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
                Lottery lottery4numbers = new Lottery(number1, number2, number3, number4, number5);
                lotteryList.add(lottery4numbers);
            }
            else if (!TablePanelModel.db.get(i).getIsSuperBet()){
                Lottery lottery5numbers = new Lottery(number1, number2, number3, number4, null);
                lotteryList.add(lottery5numbers);
            }
        }
    }

    public static Integer calculateFittingNumbers(Lottery lottery, Bet bet) {
        int fNumbers = 0;
        LinkedList<Integer> lotteryList = new LinkedList<>();
        lotteryList.add(lottery.getN1Lottery());
        lotteryList.add(lottery.getN2Lottery());
        lotteryList.add(lottery.getN3Lottery());
        lotteryList.add(lottery.getN4Lottery());
        lotteryList.add(lottery.getN5Lottery());
        LinkedList<Integer> betList = new LinkedList<>();
        betList.add(bet.getNumber1());
        betList.add(bet.getNumber2());
        betList.add(bet.getNumber3());
        betList.add(bet.getNumber4());
        betList.add(bet.getNumber5());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                if (betList.get(i) == lotteryList.get(j)) {
                    fNumbers++;
                    break;
                }
            }
        }
        return fNumbers;
    }

    public static Integer calculateGainCoefficient(Lottery lottery, Bet bet) {
        int k;

        //Affects an initial coefficient independant from the superbet
        if (calculateFittingNumbers(lottery, bet).equals(3)){
            k = 5;
        }
        else if (calculateFittingNumbers(lottery, bet).equals(4)){
            k = 50;
        }
        else k = 0;

        //Take superbet multiplier into account
        if (bet.getIsSuperBet()){
            if (bet.getNumber5().equals(lottery.getN5Lottery())){
                k = k*5;
            }
        }
        return k;
    }

    public List<Lottery> getLotteryNumbers() {
        return lotteryList;
    }

    public Integer totalBets() {
        int amountValue = 0;
        for (int i=0;i<MainFrame.betDAO.getBet().size();i++){
            amountValue += MainFrame.betDAO.getBet().get(0).getBetAmountValue();
        }
        return amountValue;
    }

    public Integer totalGains() {
        //multiply each bet by the bet multiplier (depending on the fitting numbers) and return the final gain
        int gain = 0;
        for (int i = 0; i<MainFrame.betDAO.getBet().size();i++){
            gain += (int) AdditionalPanel.additionalPanelModel.getValueAt(i, 0)*(int) AdditionalPanel.additionalPanelModel.getValueAt(i, 2);
        }
        return gain;
    }
}
