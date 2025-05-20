public class Card {
    private int value;
    private String suit;
    //private String rank;
    public Card(String suit, int value) {
        this.value = value;
        this.suit = suit;
    }
    public int getValue() {
        return value;
    }
    public String getSuit() {
        return suit;
    }
    public boolean equalsValue(Card card) {
        return this.value == card.value;
    }

    public boolean equalsSuit(Card card) {
        return this.suit.equals(card.suit);
    }
    public boolean equalsCard(Card card) {
        return equalsSuit(card) && equalsValue(card);
    }
}
