package u7pp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import static org.mockito.Mockito.*;

/**
 * Unit tests for Deck
 * you do not need to worry about these - they should be automatically passing
 */
public class DeckTests {

    private Deck deck;
    private static final int DECK_SIZE = Card.SUITS.length * Card.VALUES.length;

    
    @BeforeEach
    public void setup()
    {
        deck = new Deck();
    }

    @Test
    public void Deck_WhenCalled_ShouldCreateAllPossibleCards()
    {
        ArrayList<Card> cards = createPossibleCards();
        ArrayList<Card> cardsInDeck = dealAllCards();

        //Workaround since contains and remove do not seem to work right
        //Fix at some point
        for(Card c : cardsInDeck) {
            for(int i = 0; i < cards.size(); i++) {
                if(c.equals(cards.get(i)))
                    cards.remove(i);
            }
        }

        assertTrue(cards.isEmpty());
    }

    @Test
    public void Deck_WhenCalled_ShouldRandomizeCards()
    {
        ArrayList<Card> cards = createPossibleCards();
        ArrayList<Card> cardsInDeck = dealAllCards();

        //Workaround since contains and remove do not seem to work right
        //Fix at some point
        boolean notSame = false;
        for(int i = 0; i < cards.size() && !notSame; i++) {
            if(!cards.get(i).equals(cardsInDeck.get(i)))
                notSame = true;
        }

        assertTrue(notSame && cards.size() == cardsInDeck.size());
    }

    @Test
    public void deal_WhenCalled_ShouldReturnACard()
    {
        assertTrue(deck.deal() instanceof Card);
    }

    @Test
    public void deal_WhenDeckIsEmpty_ShouldShuffleDeck()
    {
        Deck mockedDeck = spy(Deck.class);
        while(mockedDeck.numLeft() > 0)
            mockedDeck.deal();
        
        mockedDeck.deal();
        verify(mockedDeck, atLeastOnce()).shuffle();
    }

    @Test
    public void numLeft_WhenCalled_ShouldReturnTheNumberOfCardsStillInDeck()
    {
        int cardsToDeal = 20;
        for(int i = 0; i < cardsToDeal; i++) {
            deck.deal();
        }
        assertEquals(DECK_SIZE - cardsToDeal, deck.numLeft());
    }

    private static ArrayList<Card> createPossibleCards()
    {
        int suitLength = Card.SUITS.length, valueLength = Card.VALUES.length;
        ArrayList<Card> cards = new ArrayList<Card>();

        for(int i = 0; i < suitLength; i++)
            for(int j = 0; j < valueLength; j++)
                cards.add(new Card(Card.VALUES[j], Card.SUITS[i]));

        return cards;
    }

    private ArrayList<Card> dealAllCards()
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        
        for(int i = 0; i < DECK_SIZE; i++)
            cards.add(deck.deal());
        
        return cards;
    }    
}
