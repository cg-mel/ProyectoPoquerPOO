import javax.swing.*;

public class FiveCardDraw extends PokerBaseClass{
    public FiveCardDraw(){
        super();
    }
    @Override
    public void gameCycle(){
        giveStarterCards(5);
        cycleBets();
        cardDiscardPhase();
        cycleBets();

    }
    public void cardDiscardPhase(){
        System.out.println("Descarte");
        JOptionPane.showMessageDialog(null, "Descarte", "5 Card Draw", JOptionPane.INFORMATION_MESSAGE);
        for(int i=0; i<players.size(); i++){
            cardRemover();
        }
    }
    public void cardRemover(){
        Object[] cardsToRemove = {"1", "2", "3", "4", "5", "Ninguna", "Todas"};
        choice = JOptionPane.showOptionDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", elije cartas a descartar", "5 Card Draw", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, cardsToRemove, cardsToRemove[0]);
    }
}
