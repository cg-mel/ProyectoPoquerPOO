import javax.swing.*;
import java.util.ArrayList;

public abstract class PokerBaseClass {
    protected Deck deck;
    protected ArrayList<Player> players;
    private int numberOfPlayers;
    protected int baseCoins = 30;
    protected int currentPlayer;
    protected int currentTopBet;
    protected ArrayList<Card> boardCards;
    protected HandEvaluator cardEvaluator;
    protected int winner;

    public PokerBaseClass() {
        players = new ArrayList<>();
        //preguntar por los jugadores aqui
        do{
            numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
        }while (numberOfPlayers<2 || numberOfPlayers>10);
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(JOptionPane.showInputDialog("Ingrese el nombre del jugador: " + (i+1)), baseCoins));
        }
        winner = -1;
        gameCycle();
        //Preguntar si se quiere repetir el juego aqui
    }

    public void gameCycle() {
        boardCards = new ArrayList<>();
        System.out.println("Players in play: " + getPlayersInPlay());
        int response;
        do {
            currentPlayer = 0;
            deck = new Deck();
            gameSteps();
            response = JOptionPane.showConfirmDialog(null, "Continuar juego?", "-", JOptionPane.YES_NO_OPTION);
            for(int i=1; i<players.size();i++){
                players.get(i).clearHand();
                players.get(i).setPlaying(true);
                players.get(i).setLastBet(0);
                currentTopBet = 0;
            }
            boardCards.clear();
        } while (response == 0);
    }
    public void giveStarterCards (int cardsNum){
        for(int i = 0; i < numberOfPlayers; i++)
            for(int j = 0; j < cardsNum; j++)
                players.get(i).addCardToHand(deck.giveRandomCard());
    }
    public void gameSteps(){}

    public void cycleToNextPlayer(){
        do{
            currentPlayer++;
            if(currentPlayer >= players.size())
                currentPlayer = 0;
        }while(!players.get(currentPlayer).isPlaying());
        System.out.println("Current Player: " + currentPlayer);
    }
    public void showPlayersStatus(){
        System.out.println("--- Player Status -------------");
        for(int i = 0; i < numberOfPlayers; i++)
            System.out.println(players.get(i).getName() + " - " + players.get(i).getCoins() + " - " + players.get(i).isPlaying());
    }

    public boolean bettingChoices(){
        System.out.println("Betting Choices");
        boolean betHasIncreased = false;
        int choice;
        if(players.get(currentPlayer).getCoins() > currentTopBet){
            Object[] choices = {"Igualar", "Subir", "Retirarse"};
            choice = JOptionPane.showOptionDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", elija una opción", "Texas Hold 'Em", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
        }
        else
            choice = 2;
        System.out.println(choice);
        switch (choice) {
            case 0:
                players.get(currentPlayer).takeCoins(currentTopBet-players.get(currentPlayer).getLastBet());
                players.get(currentPlayer).setLastBet(currentTopBet);
                break;
            case 1:
                int newCurrentTopBet;
                do {
                    newCurrentTopBet = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta. Fichas actuales: " + players.get(currentPlayer).getCoins()));
                } while (newCurrentTopBet > players.get(currentPlayer).getCoins() || newCurrentTopBet <= currentTopBet);
                players.get(currentPlayer).takeCoins(newCurrentTopBet-currentTopBet);
                players.get(currentPlayer).setLastBet(newCurrentTopBet);
                currentTopBet = newCurrentTopBet;
                betHasIncreased = true;
                break;
            case 2:
                players.get(currentPlayer).setPlaying(false);
                JOptionPane.showMessageDialog(null, "Jugador: " + players.get(currentPlayer).getName() + ", has sido retirado del juego", "Texas Hold Em", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
        showPlayersStatus();
        return betHasIncreased;
    }
    public void cycleBets(){
        System.out.println("Cycle Bets");
        System.out.println("Players in play: " + getPlayersInPlay());
        do{
            for(int i = 0; i < getPlayersInPlay(); i++){
                bettingChoices();
                cycleToNextPlayer();
            }
        }while(checkBets());
        showPlayersStatus();
    }
    public int getPlayersInPlay(){
        //int count = (int) players.stream().filter(Player::isPlaying()).count(); return count;
        int counter = 0;
        for(int i = 0; i < players.size(); i++)
            if(players.get(i).isPlaying())
                counter++;
        return counter;
    }

    public void declareWinner(){
        JOptionPane.showMessageDialog(null, "Ganador: Jugador " + players.get(winner).getName(), "Texas Hold Em", JOptionPane.INFORMATION_MESSAGE);
        players.get(winner).addCoins(currentTopBet);
    }
    public void showAllCards(){
        System.out.println("----------------------");
        System.out.println("Cards in board");
        for(Card c : boardCards)
            System.out.println(c.getSuit() + " | " + c.getValue());
        for(Player p : players) {
            System.out.println("Cards in player " + p.getName());
            p.printHand();
        }
        System.out.println("----------------------");
    }
    public boolean checkBets(){
        for(int i=0;i<players.size();i++){
            if(players.get(i).isPlaying())
                if(players.get(i).getLastBet()<currentTopBet)
                    return true;
        }
        return false;
    }
    public void showdown(){
        if(getPlayersInPlay()>1){
            currentPlayer = 0;
            for(int i=0;i<getPlayersInPlay();i++){
                cycleToNextPlayer();
                cardEvaluator = new HandEvaluator(players.get(currentPlayer).getHand());
                players.get(currentPlayer).setWinningHand(cardEvaluator.evaluateHand());
                switch (players.get(currentPlayer).getWinningHand()){
                    case 9: JOptionPane.showMessageDialog(null, "Escalera Real", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 8: JOptionPane.showMessageDialog(null, "Escalera de color", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 7: JOptionPane.showMessageDialog(null, "Poker", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 6: JOptionPane.showMessageDialog(null, "Full", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 5: JOptionPane.showMessageDialog(null, "Color", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 4: JOptionPane.showMessageDialog(null, "Escalera", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 3: JOptionPane.showMessageDialog(null, "Tercia", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 2: JOptionPane.showMessageDialog(null, "Doble Par", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 1: JOptionPane.showMessageDialog(null, "Un par", "-", JOptionPane.INFORMATION_MESSAGE); break;
                    case 0: JOptionPane.showMessageDialog(null, "Ninguna Jugada", "-", JOptionPane.INFORMATION_MESSAGE); break;
                }
            }
            cycleToNextPlayer();
            winner = currentPlayer;
            for(int i=0;i<getPlayersInPlay();i++){
                cycleToNextPlayer();
                if(players.get(currentPlayer).getWinningHand()>winner)
                    winner = currentPlayer;
            }
        }else {
            cycleToNextPlayer();
            winner = currentPlayer;
        }
    }
}
