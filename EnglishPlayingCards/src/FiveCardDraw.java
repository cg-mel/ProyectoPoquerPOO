import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class FiveCardDraw extends PokerBaseClass{
    public FiveCardDraw(){
        super();
    }
    @Override
    public void gameSteps(){
        giveStarterCards(5);
        firstBet();
        cycleBets();
        cardDiscardPhase();
        cycleBets();
        showAllCards();
    }
    public void cardDiscardPhase(){
        System.out.println("Descarte");
        JOptionPane.showMessageDialog(null, "Descarte", "5 Card Draw", JOptionPane.INFORMATION_MESSAGE);
        currentPlayer=0;
        for(int i=0; i<players.size(); i++){
            cardRemover();
            cardReplacer();
            cycleToNextPlayer();
        }
    }
    public void cardRemover() {
        String[] cardsString = new String[5];
        for (int i = 0; i < 5; i++) {
            String cardString = players.get(currentPlayer).getCardSuit(i) + players.get(currentPlayer).getCardValue(i);
            cardsString[i] = cardString;
        }
        Object[] cardsToRemove = {cardsString[0], cardsString[1], cardsString[2], cardsString[3], cardsString[4], "Todas", "Terminar"};
        int choice;
        ArrayList<Integer> selectRemove = new ArrayList<>();
        do {
            choice = JOptionPane.showOptionDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", elije cartas a descartar", "5 Card Draw", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, cardsToRemove, cardsToRemove[0]);
            System.out.println(choice);
            selectRemove.add(choice);
        } while (choice != 5 && choice != 6);
        if (selectRemove.getLast()==5) {
            players.get(currentPlayer).clearHand();
            JOptionPane.showMessageDialog(null, "Se han descartado todas las cartas", "5 Card Draw", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            selectRemove.removeLast();
            Collections.sort(selectRemove);
            if(!selectRemove.isEmpty()){
                for(int i=selectRemove.size()-1; i>=0; i--){
                    players.get(currentPlayer).takeCardFromHand(selectRemove.get(i));
                }
            }
        }
        players.get(currentPlayer).printHand();
    }
    public void firstBet(){
        JOptionPane.showMessageDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", ingrese su apuesta", "Primera apuesta", JOptionPane.INFORMATION_MESSAGE);
        do {
            currentTopBet = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta."));
        }while(currentTopBet > players.get(currentPlayer).getCoins() || currentTopBet < 1);
        players.get(currentPlayer).takeCoins(currentTopBet);
        players.get(currentPlayer).setLastBet(currentTopBet);
    }
    public void cardReplacer(){
        if(players.get(currentPlayer).getHandSize()<5){
            for(int i=0; i<=5-players.get(currentPlayer).getHandSize();i++)
                players.get(currentPlayer).addCardToHand(deck.giveRandomCard());
        }
    }
}
