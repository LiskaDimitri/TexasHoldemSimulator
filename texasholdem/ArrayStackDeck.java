/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.Arrays;
import java.util.Collection;
import stacks.StackInterface;

/**
 *
 * @author Dim
 */
public class ArrayStackDeck<Card> implements StackInterface<Card> {

    private static int DEFAULT_NUMBER_OF_CARDS;
    private static int MAX_NUMBER_OF_CARDS;

    private Card[] deck;
    private int topIndex;
    private boolean initialized = false;

    public ArrayStackDeck() {
        this(DEFAULT_NUMBER_OF_CARDS);
    }

    public ArrayStackDeck(int initialCapacity) {
        //checkCapacity(initialCapacity);

        Card[] tempDeck = (Card[]) new Object[initialCapacity];
        deck = tempDeck;
        topIndex = -1;
        initialized = true;
    }

    @Override
    public Card pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Card peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(Card card) {
        checkInitialization();
        //ensureCapacity();
        deck[topIndex - 1] = card;
        topIndex++;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void shuffleDeck() {
//        Collection.shuffle(ArrayStack);
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("The deck was not initialized");
        }
    }

    private void fillTheDeckWithCards() {
//        for ( int face = 2; face <= Face.ACE; face++ )
//        {
//            deck
//            deck.add( new Card( Suit.SPADES, face ) );
//        }
//        for ( int face = 2; face <= Face.ACE; face++ )
//        {
//            deck.add( new Card( Suit.HEARTS, face ) );
//        }
//        for ( int face = 2; face <= Face.ACE; face++ )
//        {
//            deck.add( new Card( Suit.CLUBS, face ) );
//        }
//        for ( int face = 2; face <= Face.ACE; face++ )
//        {
//            deck.add( new Card( Suit.DIAMONDS, face ) );
//        }
    }
}
