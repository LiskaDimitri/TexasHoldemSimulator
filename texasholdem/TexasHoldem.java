/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.ArrayList;
import java.util.Random;
import stacks.LinkedStack;

/**
 *
 * @author Dim
 */
public class TexasHoldem {

    private static int win = 0;
    private static Object ArrayUtils;

    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<Card>();
        for (int face = 2; face <= Face.ACE; face++) {
            deck.add(new Card(Suit.SPADES, face));
        }
        for (int face = 2; face <= Face.ACE; face++) {
            deck.add(new Card(Suit.HEARTS, face));
        }
        for (int face = 2; face <= Face.ACE; face++) {
            deck.add(new Card(Suit.CLUBS, face));
        }
        for (int face = 2; face <= Face.ACE; face++) {
            deck.add(new Card(Suit.DIAMONDS, face));
        }

//        for (Card card : deck) {
//            System.out.println(card.face + card.suit);
//        }
        LinkedStack<Card> thisIsTheRealDeck = new LinkedStack<>();

        Random random = new Random();
        while (!deck.isEmpty()) {
            thisIsTheRealDeck.push(
                    deck.remove(random.nextInt(deck.size())));
        }

//        while ( !thisIsTheRealDeck.isEmpty() )
//        {
//            Card card = thisIsTheRealDeck.pop();
//            System.out.println(card.face + card.suit);
//        }
        Card[] tableCards = new Card[5];
        for (int cardNumber = 0; cardNumber < tableCards.length; cardNumber++) {
            tableCards[cardNumber] = thisIsTheRealDeck.pop();
        }
        PokerHand tableHand = new PokerHand(tableCards);
        System.out.println("Table Cards");
        System.out.print(tableHand);
        System.out.println("------");

        Card[] mycards = new Card[2];
        for (int cardNumber = 0; cardNumber < mycards.length; cardNumber++) {
            mycards[cardNumber] = thisIsTheRealDeck.pop();
        }
        Card[] myHoldemCards = new Card[7];
        for (int cardNumber = 0; cardNumber < myHoldemCards.length; cardNumber++) {
            if (cardNumber < tableCards.length) {
                myHoldemCards[cardNumber] = tableCards[cardNumber];
            } else {
                myHoldemCards[cardNumber] = mycards[cardNumber - 5];
            }

        }
        //    Card[] myHoldemCards = (Card[]).(tableCards, mycards);
//        Card[] myHoldemCards = (Card[])ArrayUtils.(tableCards, mycards);

//        for (int cardNumber = 0;cardNumber < tableCards.length; cardNumber++){
//        }
        PokerHand myHand = new PokerHand(mycards);
        System.out.println("My Hand");
        System.out.println(myHand);

        System.out.println("------");

        HoldemHand myHoldemHand = new HoldemHand(myHoldemCards);
        System.out.print(myHoldemHand);

        System.out.println("------");

        PokerHand mybestPossibleHand = myHoldemHand.getBestPossibleHand(myHoldemCards);

        System.out.println("------");

        Card[] otherCards = new Card[2];
        for (int cardNumber = 0; cardNumber < otherCards.length; cardNumber++) {
            otherCards[cardNumber] = thisIsTheRealDeck.pop();
        }
        PokerHand otherHand = new PokerHand(otherCards);
//        System.out.println("Opponents Hand");
//        System.out.print(otherHand);

        ArrayList<Card> deckTwo = new ArrayList<Card>();
        for (int face = 2; face <= Face.ACE; face++) {
            deckTwo.add(new Card(Suit.SPADES, face));
        }
        for (int face = 2; face <= Face.ACE; face++) {
            deckTwo.add(new Card(Suit.HEARTS, face));
        }
        for (int face = 2; face <= Face.ACE; face++) {
            deckTwo.add(new Card(Suit.CLUBS, face));
        }
        for (int face = 2; face <= Face.ACE; face++) {
            deckTwo.add(new Card(Suit.DIAMONDS, face));
        }
        int index = 0;
        while (index < deckTwo.size()) {
            for (int y = 0; y < myHoldemCards.length; y++) {
                if ((deckTwo.get(index).face == (myHoldemCards[y].face)) && (deckTwo.get(index).suit.equals(myHoldemCards[y].suit))) {
                    deckTwo.remove(index);
                    index--;
                    System.out.println("card removed");
                }
            }
            index++;
        }
        for (Card card : deckTwo) {
            System.out.println(card.face + card.suit);
        }
        for (Card card : myHoldemCards) {
            System.out.println(card.face + card.suit);
        }
        ArrayList<Card[]> opponens990combination = new ArrayList<Card[]>();
        int combinationCounter = 0;
        //while (combinationCounter < 990) {
            for (int i = 0; i < deckTwo.size(); i++) {
                for (int y = 0; y < deckTwo.size(); y++) {
                    if ((deckTwo.get(i).face == (deckTwo.get(y).face)) 
                            && (deckTwo.get(i).suit.equals(deckTwo.get(y).suit))) 
                    {
                       combinationCounter--;
                    }
                    else{
                       Card[] tempCards = {deckTwo.get(i),deckTwo.get(y)};
                       opponens990combination.add(tempCards);
                       System.out.println(combinationCounter);
                       combinationCounter++; 
                    }  
                }
            }
            
       // }

        ArrayList<Card[]> opponentsPossibleHands = new ArrayList<>();
        for (int i = 0; i < deckTwo.size(); i++) {
            for (int y = 0; y < deckTwo.size(); y++) {
    //            opponentsPossibleHands.add(tableCard + deckTwo.get(index));
            }
        }

//        Card[] testDeck = new Card[5];
//        testDeck[0] = (new Card(Suit.SPADES, 3));
//        testDeck[1] = (new Card(Suit.CLUBS, 3));
//        testDeck[2] = (new Card(Suit.DIAMONDS, 10));
//        testDeck[3] = (new Card(Suit.CLUBS, 9));
//        testDeck[4] = (new Card(Suit.HEARTS, 14));
//
//        PokerHand table = new PokerHand(testDeck);
//        System.out.println("Table cards are : "+ table.getHandRank());
//        System.out.println("------------------");
//        System.out.println("Is Straight Flush: " + table.isStraightFlush());
//        System.out.println("Is Four of a Kind: " + table.isFourOfAKind());
//        System.out.println("Is Full House: " +table.isFullHouse());
//        System.out.println("Is Flush: " + table.isFlush());
//        System.out.println("Is Straight: " + table.isStraight());
//        System.out.println("Is three of a kind: " + table.isThreeOfaKind());
//        System.out.println("Is two pairs: " + table.isTwoPairs());
//        System.out.println("One pair: " + table.isOnePair());
//        System.out.println("High Card:" + table.highCard());
//        Card[] hand = new Card[2];
//        for (int cardNumber = 0; cardNumber < hand.length; cardNumber++) {
//            hand[cardNumber] = thisIsTheRealDeck.pop();
//        }
//        PokerHand myHand = new PokerHand(hand);
//        System.out.println(myHand);
//        
//        Card[] hand2 = new Card[2];
//        for (int cardNumber = 0; cardNumber < hand2.length; cardNumber++) {
//            hand2[cardNumber] = thisIsTheRealDeck.pop();
//        }
//        PokerHand otherHand = new PokerHand(hand2);
//        System.out.println(otherHand);
    }
}
