import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final ArrayList <Card> cardDeck;
    public Deck() {
        cardDeck = new ArrayList<>();
        createDeck();
    }
    private void createDeck()
    {
        for(int i=1; i<=13; i++){
            Card SingleCard = new Card("♠", i);
            cardDeck.add(SingleCard);
        }
        for(int i=1; i<=13; i++){
            Card SingleCard = new Card("♡", i);
            cardDeck.add(SingleCard);
        }
        for(int i=1; i<=13; i++){
            Card SingleCard = new Card("♣", i);
            cardDeck.add(SingleCard);
        }
        for(int i=1; i<=13; i++){
            Card SingleCard = new Card("♢", i);
            cardDeck.add(SingleCard);
        }
    }

    public Card giveRandomCard(){
        Random rng = new Random();
        int rngCardIndex = rng.nextInt(cardDeck.size());
        Card card = cardDeck.get(rngCardIndex);
        cardDeck.remove(rngCardIndex);
        return card;
    }
}
