package u7pp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit tests for Card
 * You do not need to worry about these - they should be automatically passing
 */
public class CardTests
{
    private Card card, compareCardSuit, compareCardValue, compareCardEqual;

    @BeforeEach
    public void setup() {
        card = new Card(Card.VALUES[0], Card.SUITS[0]);
        compareCardEqual = new Card(Card.VALUES[0], Card.SUITS[0]);
        compareCardSuit = new Card(Card.VALUES[0], Card.SUITS[1]);
        compareCardValue = new Card(Card.VALUES[1], Card.SUITS[0]);
    }

    @Test
    public void Card_WhenGivenValidInput_ShouldCreateThatCard()
    {
        assertEquals(Card.VALUES[0], card.getValue());
        assertEquals(Card.SUITS[0], card.getSuit());

    }

    @Test
    public void Card_WhenGivenValidButStranglyFormatedInput_ShouldCreateThatCardWithProperFormat()
    {
        String weirdFormattedValue = weirdFormat(Card.VALUES[0]);
        String weirdFormattiedSuit = weirdFormat(Card.SUITS[0]);

        Card card = new Card(weirdFormattedValue, weirdFormattiedSuit);
        assertEquals(Card.VALUES[0], card.getValue());
        assertEquals(Card.SUITS[0], card.getSuit());
    }

    @Test
    public void Card_WhenGivenInvalidInput_ShouldCreateADefaultCard() 
    {
        Card card = new Card("Monkey", "Dunharrow");
        assertEquals(Card.VALUES[0], card.getValue());
        assertEquals(Card.SUITS[0], card.getSuit());
    }

    @Test
    public void equals_WhenGivenAMatchingCard_ShouldReturnTrue()
    {
        assertTrue(card.equals(compareCardEqual));
    }

    @Test
    public void equals_WhenGivenANotMatchingValue_ShouldReturnFalse()
    {
        assertFalse(card.equals(compareCardValue));
    }

    @Test
    public void equals_WhenGivenANotMatchingSuit_ShouldReturnFalse()
    {
        assertFalse(card.equals(compareCardSuit));
    }

    @Test
    public void toString_WhenGivenACard_ShouldReturnAStringFormattedValueOfSuit()
    {
        assertEquals(card.getValue() + " of " + card.getSuit(), card.toString());
    }

    @Test
    public void compareTo_WhenGivenASmallerCard_ShouldReturn1()
    {
        assertEquals(1, compareCardValue.compareTo(card));
    }

    @Test
    public void compareTo_WhenGivenALargerCard_ShouldReturnNegative1()
    {
        assertEquals(-1, card.compareTo(compareCardValue));
    }

    @Test
    public void compareTo_WhenGivenAnEqualCard_ShouldReturn0()
    {
        assertEquals(0, card.compareTo(compareCardEqual));
    }

    /**
     * Copies a String and gives it a random capitalization
     * @param str the string to be formatted
     * @return a new string with each letter in str having a 50% chance to be capitalized or not
     */
    private String weirdFormat(String str) {
        String formattedStr = "";

        for(int i = 0; i < str.length(); i++) {
            int randomNum = (int) (Math.random() * 2);
            String letter = str.substring(i, i+1);
            formattedStr += randomNum == 0 ? letter.toUpperCase() : letter;
        }

        return formattedStr;
    }

}
