package gui.output;

import game.Game;
import gui.input.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    private gui.output.ResultTitlePanel resultTitlePanel;
    private gui.output.RetrievalPanel retrievalPanel;
    private LotteryNumbersPanel lotteryNumbersPanel;
    private AdditionalPanel additionalPanel;
    private ResultSouthPanel resultPanel;
    public static Game game;

    public ResultFrame() {

        super("Result");

        //Adding components
        resultTitlePanel = new gui.output.ResultTitlePanel();
        retrievalPanel = new RetrievalPanel();
        lotteryNumbersPanel = new LotteryNumbersPanel();
        additionalPanel = new AdditionalPanel();
        resultPanel = new ResultSouthPanel();
        game = new Game();

        //Data
        retrievalPanel.setData(MainFrame.controller.getBet());  // set the data in retrievalPanel using the gui.input bets
        Game.CreateLottery();
        lotteryNumbersPanel.setLottery(game.getLotteryNumbers()); //set the data for the winning lottery numbers

        //texting in the SouthPanel
        resultPanel.appendText("Total of bets : " + game.totalBets() + System.lineSeparator());
        resultPanel.appendText("Total gain : "  + game.totalGains() + System.lineSeparator());
        resultPanel.appendText("Result : "  + (game.totalGains() - game.totalBets()));

        //sizing
        setMinimumSize(new Dimension(600, 400));
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //color
        getContentPane().setBackground(new Color(80,174,205));  // color of the mainframe, works only on the mainframe
        resultTitlePanel.setBackground(new Color(80,174,205));
        retrievalPanel.setBackground(new Color(80,174,205));
        lotteryNumbersPanel.setBackground(new Color(80,174,205));
        additionalPanel.setBackground(new Color(80,174,205));
        resultPanel.setBackground(new Color(80,174,205));

        //Set the popup location in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //basic organisation stuff for the component in the mainframe
        setLayout(new BorderLayout());
        add(resultTitlePanel, BorderLayout.NORTH);
        add(retrievalPanel, BorderLayout.WEST);
        add(lotteryNumbersPanel, BorderLayout.CENTER);
        add(additionalPanel, BorderLayout.EAST);
        add(resultPanel, BorderLayout.SOUTH);
    }
}
