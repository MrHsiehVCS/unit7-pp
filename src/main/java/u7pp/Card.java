package u7pp;

/**
 * A class that represents a standard playing Card (values 2 - 10, Jack - Ace) (suits clubs, diamonds, hearts, spades)
 * @author David Hoffman
 */
public class Card implements Comparable<Card> {
	
    public static String[] SUITS = {"Clubs", "Hearts", "Diamonds", "Spades"};
    public static String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

	//Instance variables
	private String suit;
	private String value;
	
	/**
	 * Constructs a Card based on the parameters. Forces the capitalization to match Card.SUITS and Card.VALUES
	 * @suit: the suit for the card. Must be in Card.SUITS. If not, set to Card.SUITS[0]
	 * @value: the face value of the card. Must be in Card.VALUES. If not, set to Card.VALUES[0]
	 */
	public Card(String value, String suit) {
        int suitIndex = Card.suitIndex(suit);
        int valueIndex = Card.valueIndex(value); 
		this.suit = suitIndex != -1 ? Card.SUITS[suitIndex] : Card.SUITS[0];
		this.value = valueIndex != -1 ? Card.VALUES[valueIndex] : Card.VALUES[0];
	}
	
	/**
	 * Getter for the suit of the Card. 
	 * @return the suit of the Card
	 */
	public String getSuit() {
		return this.suit;
	}
	
	/**
	 * Getter for the face value of the Card.
	 * @return the face value of the Card
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Compares two cards and returns true if they share a suit and value
	 * @param c: the Card to compare this to.
	 * @return true if both the suit and value of this and c are the same
	 */
	public boolean equals(Card c) {
		return this.suit.equals(c.suit) && this.value.equals(c.value);
	}
	
	/**
	 * toString for the Card class
	 * @return "<this.value> of <this.suit>"
	 */
	 @Override
	public String toString() {
		return this.value + " of " + this.suit;
	}
	
	/**
	 * Implements the Comparable interface.
	 * @param c: a Card to compare with this
	 * @return 1 if the value of this is greater than c, 0 if they are equal and -1 if this is less than c
	 *	The ranking for values are given by the Card.VALUES array
	 */
	public int compareTo (Card c) {
		if(this.equals(c))
			return 0;

		return Card.getIndexOfStringInArray(this.getValue(), Card.VALUES) >
                Card.getIndexOfStringInArray(c.getValue(), Card.VALUES) ? 1 : -1;
	}

    private static int suitIndex(String suit) {
        return Card.getIndexOfStringInArray(suit.toLowerCase(), Card.SUITS);
    }

    private static int valueIndex(String value) {
        return getIndexOfStringInArray(value.toLowerCase(), Card.VALUES);
    }

    private static int getIndexOfStringInArray(String str, String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(str.equals(arr[i].toLowerCase()))
                return i;
        }
        return -1;
    }
}