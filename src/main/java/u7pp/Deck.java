package u7pp;

/**
 * A class that represents a Deck of all possible Cards
 * @author David Hoffman
 */
 
public class Deck {
 	
    //Instance Variables
    private Card[] myCards; //Array of all possible Cards
    private int top; //Index to show where the "next" card to be dealt is
    
    /**
     * Creates a new, shuffled Deck
     */
    public Deck() {
        this.shuffle();
    }
    
    /**
     * Moves the index top to the next Card in the Deck and then returns the Card at index top-1
     * @return the "top" Card of the deck
     */
    public Card deal() {
        if(numLeft() <= 0)
            this.shuffle();
        top++;
        return myCards[top - 1];
    }
    
    /**
     * Getter to know how many "undealt" Cards are in the deck
     * @return the number of "undealt" cards
     */
    public int numLeft() {
        return myCards.length - top;
    }
    
    /**
     * Sets myCards to a randomized version of all possible Cards
     * Sets top to 0
     */
    public void shuffle() {
        this.top = 0;
        Card[] allCards = Deck.createPossibleCards();
        this.myCards = Deck.randomize(allCards);
    }
    
    /**
     * Helper method for shuffle(). Generates all possible Cards based on Card.SUITS and Card.VALUES
     * @return an array filled with all unique possible Cards
     */
    private static Card[] createPossibleCards()
    {
        int suitLength = Card.SUITS.length, valueLength = Card.VALUES.length;

        Card[] cards = new Card[suitLength * valueLength];
        for(int i = 0; i < suitLength; i++) {
            for(int j = 0; j < valueLength; j++) {
                cards[(i * valueLength) + j] = new Card(Card.VALUES[j], Card.SUITS[i]);
            }
        }

        return cards;
    }

    /**
     * Helper method for shuffle(). Takes an array of cards and returns it in a randomized order.
     * @param cards an array of Cards. Is not modified
     * @return an array of same size and contents as cards, just in a randomized order
     */
    private static Card[] randomize(Card[] cards) {
        Card[] randomized = new Card[cards.length];

        for(Card card : cards) {
            boolean placed = false;
            while(!placed) {
                int randomIndex = (int) (Math.random() * randomized.length);
                if(randomized[randomIndex] == null) {
                    randomized[randomIndex] = card;
                    placed = true;
                }
            }
        }

        return randomized;
    }
}
