package u7pp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WarTests {

    @Test
    public void war_defaultConstructor_decksCorrect()
    {
        War war = new War();

        ArrayList<Card> playerDeck = war.getPlayerCards();
        ArrayList<Card> compDeck = war.getComputerCards();

        // decks should be correct size (26)
        assertEquals(playerDeck.size(), 26);
        assertEquals(compDeck.size(), 26);
        
        // decks should be random
        assertTrue(isDeckRandomEnough(playerDeck));
        assertTrue(isDeckRandomEnough(compDeck));

        // decks should not have repeats between them
        boolean wasDuplicateFound = false;
        for(int i = 0; i < 52; i++) {
            for(int j = i+1; j < 52; j++) {
                Card cardi = i >= 26 ? compDeck.get(i-26) : playerDeck.get(i);
                Card cardj = j >= 26 ? compDeck.get(j-26) : playerDeck.get(j);

                if(cardi.equals(cardj)) {
                    wasDuplicateFound = true;
                    break;
                }
            }
            if(wasDuplicateFound) {
                break;
            }
        }

        assertFalse(wasDuplicateFound);
    }


    @Test
    public void war_parameterizedConstructor_isCorrect()
    {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("2", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("4", "Hearts"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("5", "Spades"));
        deck2.add(new Card("6", "Spades"));
        deck2.add(new Card("7", "Spades"));
        War war = new War(deck1, deck2);

        ArrayList<Card> playerCards = war.getPlayerCards();
        ArrayList<Card> compCards = war.getComputerCards();

        assertEquals(deck1.size(), playerCards.size());
        assertEquals(deck2.size(), compCards.size());

        // make sure the cards are all the same, in the same order
        assertEquals(deck1, playerCards);
        assertEquals(deck2, compCards);
    }

    @Test
    public void war_playTurn_simpleComparison_updatesDecksCorrectly() {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("2", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("4", "Hearts"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("5", "Spades"));
        deck2.add(new Card("6", "Spades"));
        deck2.add(new Card("7", "Spades"));

        ArrayList<Card> deck1After = new ArrayList<Card>();
        deck1After.add(new Card("3", "Hearts"));
        deck1After.add(new Card("4", "Hearts"));

        ArrayList<Card> deck2AfterVersion1 = new ArrayList<Card>();
        deck2AfterVersion1.add(new Card("6", "Spades"));
        deck2AfterVersion1.add(new Card("7", "Spades"));
        deck2AfterVersion1.add(new Card("2", "Hearts"));
        deck2AfterVersion1.add(new Card("5", "Spades"));

        ArrayList<Card> deck2AfterVersion2 = new ArrayList<Card>();
        deck2AfterVersion2.add(new Card("6", "Spades"));
        deck2AfterVersion2.add(new Card("7", "Spades"));
        deck2AfterVersion2.add(new Card("5", "Spades"));
        deck2AfterVersion2.add(new Card("2", "Hearts"));

        War war = new War(deck1, deck2);
        war.playTurn();

        ArrayList<Card> playerCards = war.getPlayerCards();
        ArrayList<Card> compCards = war.getComputerCards();

        // must remove cards from player deck, because player lost
        assertEquals(playerCards, deck1After);

        // must remove cards from compcard, and put the two won cards at the end of the compCards arraylist
        // two versions, can be either version
        assertTrue(compCards.equals(deck2AfterVersion1) || compCards.equals(deck2AfterVersion2));
        
    }

    @Test
    public void war_playTurn_simpleComparison2_updatesDecksCorrectly() {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("9", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("4", "Hearts"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("5", "Spades"));
        deck2.add(new Card("6", "Spades"));
        deck2.add(new Card("7", "Spades"));

        ArrayList<Card> deck1AfterV1 = new ArrayList<Card>();
        deck1AfterV1.add(new Card("3", "Hearts"));
        deck1AfterV1.add(new Card("4", "Hearts"));
        deck1AfterV1.add(new Card("9", "Hearts"));
        deck1AfterV1.add(new Card("5", "Spades"));

        ArrayList<Card> deck1AfterV2 = new ArrayList<Card>();
        deck1AfterV2.add(new Card("3", "Hearts"));
        deck1AfterV2.add(new Card("4", "Hearts"));
        deck1AfterV2.add(new Card("5", "Spades"));
        deck1AfterV2.add(new Card("9", "Hearts"));

        ArrayList<Card> deck2After = new ArrayList<Card>();
        deck2After.add(new Card("6", "Spades"));
        deck2After.add(new Card("7", "Spades"));

        War war = new War(deck1, deck2);
        war.playTurn();

        ArrayList<Card> playerCards = war.getPlayerCards();
        ArrayList<Card> compCards = war.getComputerCards();

        assertEquals(compCards, deck2After);      
        assertTrue(playerCards.equals(deck1AfterV1) || playerCards.equals(deck1AfterV2));
    }

    @Test
    public void war_playTurn_WarOnce_updatesDecksCorrectly() {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("5", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("4", "Hearts"));
        deck1.add(new Card("6", "Hearts"));
        deck1.add(new Card("7", "Hearts"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("5", "Spades"));
        deck2.add(new Card("6", "Spades"));
        deck2.add(new Card("7", "Spades"));
        deck2.add(new Card("8", "Spades"));
        deck2.add(new Card("9", "Spades"));

        ArrayList<Card> deck1and2 = new ArrayList<Card>();
        deck1and2.addAll(deck1);
        deck1and2.addAll(deck2);

        War war = new War(deck1, deck2);
        war.playTurn();

        ArrayList<Card> playerCards = war.getPlayerCards();
        ArrayList<Card> compCards = war.getComputerCards();

        assertEquals(playerCards, new ArrayList<Card>());
        assertTrue(haveSameContents(compCards, deck1and2));
    }

    @Test
    public void war_playTurn_WarTwice_updatesDecksCorrectly() {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("5", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("4", "Hearts"));
        deck1.add(new Card("6", "Hearts"));
        deck1.add(new Card("7", "Hearts"));
        deck1.add(new Card("3", "Diamonds"));
        deck1.add(new Card("4", "Diamonds"));
        deck1.add(new Card("6", "Diamonds"));
        deck1.add(new Card("9", "Diamonds"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("5", "Spades"));
        deck2.add(new Card("6", "Spades"));
        deck2.add(new Card("9", "Spades"));
        deck2.add(new Card("8", "Spades"));
        deck2.add(new Card("7", "Spades"));
        deck2.add(new Card("6", "Clubs"));
        deck2.add(new Card("7", "Clubs"));
        deck2.add(new Card("8", "Clubs"));
        deck2.add(new Card("5", "Clubs"));

        ArrayList<Card> deck1and2 = new ArrayList<Card>();
        deck1and2.addAll(deck1);
        deck1and2.addAll(deck2);

        War war = new War(deck1, deck2);
        war.playTurn();

        ArrayList<Card> playerCards = war.getPlayerCards();
        ArrayList<Card> compCards = war.getComputerCards();

        assertEquals(compCards, new ArrayList<Card>());
        assertTrue(haveSameContents(playerCards, deck1and2));
    }

    @Test
    public void war_playManyTurns_updatesDecksCorrectly() {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("9", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("9", "Hearts"));
        deck1.add(new Card("9", "Hearts"));
        deck1.add(new Card("9", "Hearts"));
        deck1.add(new Card("9", "Diamonds"));
        deck1.add(new Card("9", "Diamonds"));
        deck1.add(new Card("9", "Diamonds"));
        deck1.add(new Card("9", "Diamonds"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("2", "Spades"));
        deck2.add(new Card("2", "Spades"));
        deck2.add(new Card("2", "Spades"));
        deck2.add(new Card("2", "Spades"));
        deck2.add(new Card("2", "Spades"));
        deck2.add(new Card("2", "Clubs"));
        deck2.add(new Card("2", "Clubs"));
        deck2.add(new Card("2", "Clubs"));
        deck2.add(new Card("2", "Clubs"));

        ArrayList<Card> deck1and2 = new ArrayList<Card>();
        deck1and2.addAll(deck1);
        deck1and2.addAll(deck2);

        War war = new War(deck1, deck2);
        
        for(int i = 0; i < 9; i++) {
            war.playTurn();
        }

        ArrayList<Card> playerCards = war.getPlayerCards();
        ArrayList<Card> compCards = war.getComputerCards();

        assertEquals(compCards, new ArrayList<Card>());
        assertTrue(haveSameContents(playerCards, deck1and2));
    }

    @Test
    public void war_nonemptyDecks_isGameOverCorrect() {
        ArrayList<Card> deck1 = new ArrayList<Card>();
        deck1.add(new Card("2", "Hearts"));
        deck1.add(new Card("3", "Hearts"));
        deck1.add(new Card("4", "Hearts"));

        ArrayList<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card("5", "Spades"));
        deck2.add(new Card("6", "Spades"));
        deck2.add(new Card("7", "Spades"));

        ArrayList<Card> deck3 = new ArrayList<Card>();

        War war = new War(deck1, deck2);
        War war2 = new War(deck1, deck3);
        War war3 = new War(deck3, deck2);
        War war4 = new War(deck3, deck3);

        assertFalse(war.isGameOver());
        assertTrue(war2.isGameOver());
        assertTrue(war3.isGameOver());
        assertTrue(war4.isGameOver());
    }

    /// -----------------------------------------------------------
    /// Helper Methods
    /// -----------------------------------------------------------

    private boolean isDeckRandomEnough(ArrayList<Card> deck) {
        // count neighbors that are sequential and same suit
        // should be far less than 13 for a 26 size deck

        int sequentialNeighborCount = 0;
        for(int i = 1; i < deck.size(); i++) {
            Card card1 = deck.get(i);
            Card card2 = deck.get(i-1);
            if(card1.getSuit().equals(card2.getSuit()) && card1.getValue().equals(card2.getValue())) {
                sequentialNeighborCount++;
            }
        }

        return sequentialNeighborCount < 13;
    }

    // for testing equality when order doesn't matter
    private <T> boolean haveSameContents(List<T> list1, List<T> list2) {
        return list1.size() == list2.size() && list1.containsAll(list2) && list2.containsAll(list1);
    }
    
}
