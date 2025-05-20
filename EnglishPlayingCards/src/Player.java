import java.util.ArrayList;

public class Player {
    private String name;
    private int coins;
    private ArrayList<Card> hand;
    private boolean playing;
    private int lastBet;
    public Player(String name, int coins) {
        this.name = name;
        this.coins = coins;
        this.playing = true;
        this.hand = new ArrayList<>();
        this.lastBet = 0;
    }
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    public Card takeCardFromHand(int i) {
        Card card = hand.get(i);
        hand.remove(i);
        return card;
    }
    public void clearHand(){hand.clear();}

    public String getName() {return name;}
    public int getCoins() {return coins;}
    public void takeCoins(int bet) {this.coins-=bet;}
    public boolean isPlaying() {return playing;}
    public void setPlaying(boolean playing) {this.playing = playing;}
    public int getLastBet() {return lastBet;}
    public void setLastBet(int lastBet) {this.lastBet = lastBet;}

    public void printHand() {
        for (Card card : hand) {
            System.out.println(card.getSuit() + " | " + card.getValue());
        }
    }
    public String getCardSuit(int i){
        return hand.get(i).getSuit();
    }
    public int getCardValue(int i){
        return hand.get(i).getValue();
    }
    public int getHandSize(){return hand.size();}
}
