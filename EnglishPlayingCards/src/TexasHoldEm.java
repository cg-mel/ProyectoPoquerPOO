import javax.swing.*;
import java.util.Random;

public class TexasHoldEm extends PokerBaseClass{
    public TexasHoldEm(){
        super();
    }
    @Override
    public void gameSteps(){
        theBlinds();
        giveStarterCards(2);
        JOptionPane.showMessageDialog(null, "PreFlop", "Texas", JOptionPane.INFORMATION_MESSAGE);
        preFlop();
        JOptionPane.showMessageDialog(null, "Flop", "Texas", JOptionPane.INFORMATION_MESSAGE);
        flop();
        JOptionPane.showMessageDialog(null, "4th Street", "Texas", JOptionPane.INFORMATION_MESSAGE);
        fourthStreet();
        showAllCards();
        if(getPlayersInPlay()>1){
            JOptionPane.showMessageDialog(null, "5th Street", "Texas", JOptionPane.INFORMATION_MESSAGE);
            fifthStreet();
            if(getPlayersInPlay()>1) {
                JOptionPane.showMessageDialog(null, "Showdown", "Texas", JOptionPane.INFORMATION_MESSAGE);
                showdown();
            }
        }
        cycleToNextPlayer();
        declareWinner();
    }

    public void theBlinds(){
        JOptionPane.showMessageDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", ingrese su apuesta", "Big Blind", JOptionPane.INFORMATION_MESSAGE);
        do {
            currentTopBet = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta."));
        }while(currentTopBet > players.get(currentPlayer).getCoins() || currentTopBet < 1);
        players.get(currentPlayer).takeCoins(currentTopBet);
        players.get(currentPlayer).setLastBet(currentTopBet);
        cycleToNextPlayer();
        JOptionPane.showMessageDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", su apuesta será de: " + (currentTopBet/2), "Big Blind", JOptionPane.INFORMATION_MESSAGE);
        players.get(currentPlayer).takeCoins(currentTopBet/2);
        players.get(currentPlayer).setLastBet(currentTopBet/2);
        showPlayersStatus();
    }
    public void preFlop(){
        cycleBets();
    }
    public void flop(){
        for (int i=0; i<3; i++)
            boardCards.add(deck.giveRandomCard());
        currentPlayer=players.size();
        cycleBets();
    }
    public void fourthStreet(){
        boardCards.add(deck.giveRandomCard());
        cycleBets();
    }
    public void fifthStreet(){
        boardCards.add(deck.giveRandomCard());
        cycleBets();
    }
    public void showdown(){
        if(getPlayersInPlay()>1){
            //showdown
        }
    }
}
