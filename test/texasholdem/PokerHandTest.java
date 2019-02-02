/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dim
 */
public class PokerHandTest {

    public PokerHandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Card[] testDeck1 = new Card[5];
        testDeck1[0] = (new Card(Suit.CLUBS, 3));
        testDeck1[1] = (new Card(Suit.CLUBS, 5));
        testDeck1[2] = (new Card(Suit.CLUBS, 4));
        testDeck1[3] = (new Card(Suit.CLUBS, 7));
        testDeck1[4] = (new Card(Suit.CLUBS, 6));

        PokerHand instance = new PokerHand(testDeck1);

        Card[] testDeck2 = new Card[5];
        testDeck2[0] = (new Card(Suit.SPADES, 6));
        testDeck2[1] = (new Card(Suit.HEARTS, 14));
        testDeck2[2] = (new Card(Suit.CLUBS, 6));
        testDeck2[3] = (new Card(Suit.CLUBS, 14));
        testDeck2[4] = (new Card(Suit.DIAMONDS, 6));

        PokerHand o = new PokerHand(testDeck2);
        int expResult = 2;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
        @Test
    public void testCompareTo_TieBReak() {
        System.out.println("compareTo");
        Card[] testDeck1 = new Card[5];
        testDeck1[0] = (new Card(Suit.CLUBS, 3));
        testDeck1[1] = (new Card(Suit.CLUBS, 5));
        testDeck1[2] = (new Card(Suit.CLUBS, 4));
        testDeck1[3] = (new Card(Suit.CLUBS, 7));
        testDeck1[4] = (new Card(Suit.CLUBS, 6));

        PokerHand instance = new PokerHand(testDeck1);

        Card[] testDeck2 = new Card[5];
        testDeck2[0] = (new Card(Suit.CLUBS, 3));
        testDeck2[1] = (new Card(Suit.CLUBS, 5));
        testDeck2[2] = (new Card(Suit.CLUBS, 4));
        testDeck2[3] = (new Card(Suit.CLUBS, 7));
        testDeck2[4] = (new Card(Suit.CLUBS, 6));

        PokerHand o = new PokerHand(testDeck2);
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandRank_STRAIGHTFLUSH() {
        System.out.println("getHandRank");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 5));
        testDeck[2] = (new Card(Suit.CLUBS, 4));
        testDeck[3] = (new Card(Suit.CLUBS, 7));
        testDeck[4] = (new Card(Suit.CLUBS, 6));

        PokerHand instance = new PokerHand(testDeck);
        int expResult = 9;
        int result = instance.getHandRank();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandRank_FullHouse() {
        System.out.println("getHandRank");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 6));
        testDeck[1] = (new Card(Suit.HEARTS, 14));
        testDeck[2] = (new Card(Suit.CLUBS, 6));
        testDeck[3] = (new Card(Suit.CLUBS, 14));
        testDeck[4] = (new Card(Suit.DIAMONDS, 14));

        PokerHand instance = new PokerHand(testDeck);
        int expResult = 7;
        int result = instance.getHandRank();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsStraightFlush() {
        System.out.println("IsStraightFlush");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 5));
        testDeck[2] = (new Card(Suit.CLUBS, 4));
        testDeck[3] = (new Card(Suit.CLUBS, 7));
        testDeck[4] = (new Card(Suit.CLUBS, 6));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = true;
        boolean result = instance.isStraightFlush();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotStraightFlush() {
        System.out.println("IsNotStraightFlush");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 3));
        testDeck[1] = (new Card(Suit.SPADES, 9));
        testDeck[2] = (new Card(Suit.HEARTS, 4));
        testDeck[3] = (new Card(Suit.DIAMONDS, 6));
        testDeck[4] = (new Card(Suit.HEARTS, 9));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = false;
        boolean result = instance.isStraightFlush();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFourOfAKind() {
        System.out.println("isFourOfaKind");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.HEARTS, 9));
        testDeck[1] = (new Card(Suit.HEARTS, 4));
        testDeck[2] = (new Card(Suit.CLUBS, 4));
        testDeck[3] = (new Card(Suit.DIAMONDS, 4));
        testDeck[4] = (new Card(Suit.SPADES, 4));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = true;
        boolean result = instance.isFourOfAKind();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotFourOfAKind() {
        System.out.println("isNOTFourOfaKind");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 8));
        testDeck[1] = (new Card(Suit.CLUBS, 5));
        testDeck[2] = (new Card(Suit.DIAMONDS, 5));
        testDeck[3] = (new Card(Suit.HEARTS, 5));
        testDeck[4] = (new Card(Suit.SPADES, 8));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = false;
        boolean result = instance.isFourOfAKind();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFullHouse() {
        System.out.println("isFullHouse");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.DIAMONDS, 10));
        testDeck[3] = (new Card(Suit.CLUBS, 10));
        testDeck[4] = (new Card(Suit.HEARTS, 3));

        PokerHand instance = new PokerHand(testDeck);
        boolean expResult = true;
        boolean result = instance.isFullHouse();
        assertEquals(expResult, result);

    }

    @Test
    public void testIsNotFullHouse() {
        System.out.println("isNotFullHouse");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.DIAMONDS, 10));
        testDeck[3] = (new Card(Suit.CLUBS, 9));
        testDeck[4] = (new Card(Suit.HEARTS, 3));

        PokerHand instance = new PokerHand(testDeck);
        boolean expResult = false;
        boolean result = instance.isFullHouse();
        assertEquals(expResult, result);

    }

    @Test
    public void testIsFlush() {
        System.out.println("isFlush");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 2));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.CLUBS, 4));
        testDeck[3] = (new Card(Suit.CLUBS, 5));
        testDeck[4] = (new Card(Suit.CLUBS, 6));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = true;
        boolean result = instance.isFlush();
        assertEquals(expResult, result);

    }

    @Test
    public void testIsNotFlush() {
        System.out.println("isNotFlush");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.DIAMONDS, 4));
        testDeck[3] = (new Card(Suit.HEARTS, 12));
        testDeck[4] = (new Card(Suit.DIAMONDS, 6));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = false;
        boolean result = instance.isFlush();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsStraight() {
        System.out.println("isStraight");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 14));
        testDeck[1] = (new Card(Suit.DIAMONDS, 12));
        testDeck[2] = (new Card(Suit.HEARTS, 13));
        testDeck[3] = (new Card(Suit.DIAMONDS, 11));
        testDeck[4] = (new Card(Suit.SPADES, 10));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = true;
        boolean result = instance.isStraight();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsnotStraight() {
        System.out.println("isNotStraight");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 6));
        testDeck[1] = (new Card(Suit.CLUBS, 8));
        testDeck[2] = (new Card(Suit.DIAMONDS, 8));
        testDeck[3] = (new Card(Suit.HEARTS, 7));
        testDeck[4] = (new Card(Suit.DIAMONDS, 9));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = false;
        boolean result = instance.isStraight();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsThreeOfaKind() {
        System.out.println("isThreeOfaKind");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 9));
        testDeck[1] = (new Card(Suit.SPADES, 14));
        testDeck[2] = (new Card(Suit.SPADES, 9));
        testDeck[3] = (new Card(Suit.DIAMONDS, 3));
        testDeck[4] = (new Card(Suit.HEARTS, 9));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = true;
        boolean result = instance.isThreeOfaKind();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotThreeOfaKind() {
        System.out.println("isNotThreeOfaKind");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.CLUBS, 3));
        testDeck[1] = (new Card(Suit.SPADES, 9));
        testDeck[2] = (new Card(Suit.HEARTS, 4));
        testDeck[3] = (new Card(Suit.DIAMONDS, 6));
        testDeck[4] = (new Card(Suit.HEARTS, 9));

        PokerHand instance = new PokerHand(testDeck);

        boolean expResult = false;
        boolean result = instance.isThreeOfaKind();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsTwoPairs() {
        System.out.println("isTwoPairs");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.DIAMONDS, 13));
        testDeck[3] = (new Card(Suit.CLUBS, 5));
        testDeck[4] = (new Card(Suit.HEARTS, 13));

        PokerHand instance = new PokerHand(testDeck);
        boolean expResult = true;
        boolean result = instance.isTwoPairs();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotTwoPairs() {
        System.out.println("isNotTwoPairs");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 3));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.CLUBS, 4));
        testDeck[3] = (new Card(Suit.CLUBS, 5));
        testDeck[4] = (new Card(Suit.CLUBS, 6));

        PokerHand instance = new PokerHand(testDeck);
        boolean expResult = false;
        boolean result = instance.isTwoPairs();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsOnePair() {
        System.out.println("isOnePair");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 9));
        testDeck[1] = (new Card(Suit.CLUBS, 14));
        testDeck[2] = (new Card(Suit.DIAMONDS, 9));
        testDeck[3] = (new Card(Suit.CLUBS, 12));
        testDeck[4] = (new Card(Suit.HEARTS, 6));

        PokerHand instance = new PokerHand(testDeck);
        boolean expResult = true;
        boolean result = instance.isOnePair();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotOnePair() {
        System.out.println("isNotOnePair");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 13));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.CLUBS, 14));
        testDeck[3] = (new Card(Suit.DIAMONDS, 5));
        testDeck[4] = (new Card(Suit.HEARTS, 6));

        PokerHand instance = new PokerHand(testDeck);
        boolean expResult = false;
        boolean result = instance.isOnePair();
        assertEquals(expResult, result);
    }

    @Test
    public void testHighCard() {
        System.out.println("highCard");
        Card[] testDeck = new Card[5];
        testDeck[0] = (new Card(Suit.SPADES, 13));
        testDeck[1] = (new Card(Suit.CLUBS, 3));
        testDeck[2] = (new Card(Suit.CLUBS, 14));
        testDeck[3] = (new Card(Suit.DIAMONDS, 5));
        testDeck[4] = (new Card(Suit.HEARTS, 6));

        PokerHand instance = new PokerHand(testDeck);
        int expResult = 14;
        int result = instance.highCard();
        assertEquals(expResult, result);
    }

//    @Test
    public void testToString() {
        System.out.println("toString");
        PokerHand instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
