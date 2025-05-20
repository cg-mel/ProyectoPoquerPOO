import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class PokerBaseClass {
    protected Deck deck;
    protected ArrayList<Player> players;
    private int numberOfPlayers;
    protected int baseCoins = 50;
    protected int currentPlayer;
    protected int currentTopBet;
    protected ArrayList<Card> boardCards;

    public PokerBaseClass() {
        players = new ArrayList<>();
        //preguntar por los jugadores aqui
        do{
            numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
        }while (numberOfPlayers<2 || numberOfPlayers>10);
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(JOptionPane.showInputDialog("Ingrese el nombre del jugador: " + (i+1)), baseCoins));
        }
        gameCycle();
        //Preguntar si se quiere repetir el juego aqui
    }

    public void gameCycle(){
        deck = new Deck();
        boardCards = new ArrayList<>();
        System.out.println("Players in play: " + getPlayersInPlay());
        currentPlayer = 0;
        gameSteps();
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
                    newCurrentTopBet = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta."));
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
                cycleToNextPlayer();
                bettingChoices();
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
        JOptionPane.showMessageDialog(null, "Ganador: Jugador " + players.get(currentPlayer).getName(), "Texas Hold Em", JOptionPane.INFORMATION_MESSAGE);
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
}
