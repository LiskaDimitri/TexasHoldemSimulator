/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.Arrays;

/**
 *
 * @author etcharn1
 */
public class PokerHand implements Comparable<PokerHand> {

    public static final int STRAIGHT_FLUSH = 9;
    public static final int FOUR_OF_A_KIND = 8;
    public static final int FULL_HOUSE = 7;
    public static final int FLUSH = 6;
    public static final int STRAIGHT = 5;
    public static final int THREE_OF_A_KIND = 4;
    public static final int TWO_PAIRS = 3;
    public static final int ONE_PAIR = 2;
    public static final int HIGH_CARD = 1;

    private Card[] cards;
    public static int handRankMax;

    //TO WORK ON IMPLEMENTATION
    private int highCardCombo = 0;

    public PokerHand(Card[] cards) {
        this.cards = cards;
        Arrays.sort(this.cards);
    }

    @Override
    public int compareTo(PokerHand o) {
        if (getHandRank() == o.getHandRank()) {
            // tiebreak by implementing highcardcombo;
        }
        return getHandRank() - o.getHandRank();
    }

    public int getHandRank() {
        if (isStraightFlush()) {
            return PokerHand.STRAIGHT_FLUSH;
        } else if (isFourOfAKind()) {
            return PokerHand.FOUR_OF_A_KIND;
        } else if (isFullHouse()) {
            return PokerHand.FULL_HOUSE;
        } else if (isFlush()) {
            return PokerHand.FLUSH;
        } else if (isStraight()) {
            return PokerHand.STRAIGHT;
        } else if (isThreeOfaKind()) {
            return PokerHand.THREE_OF_A_KIND;
        } else if (isTwoPairs()) {
            return PokerHand.TWO_PAIRS;
        } else if (isOnePair()) {
            return PokerHand.ONE_PAIR;
        } else {
            return PokerHand.HIGH_CARD;
        }
    }

    // WORKS
    public boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    // WORKS
    public boolean isFourOfAKind() {
        for (int i = 0; i < cards.length - 3; i++) {
            if ((cards[i].face == cards[i + 1].face && cards[i].suit != (cards[i + 1].suit))
                    && (cards[i].face == cards[i + 2].face && cards[i].suit != (cards[i + 2].suit))
                    && (cards[i].face == cards[i + 3].face && cards[i].suit != (cards[i + 3].suit))) {
                return true;
            }
        }
        return false;
    }

    //WORKS
    public boolean isFullHouse() {
        int ThreeOfaKindPosition = 0;
        for (int i = 0; i < cards.length - 2; i++) {
            if ((cards[i].face == cards[i + 1].face && cards[i].suit != (cards[i + 1].suit))
                    && (cards[i].face == cards[i + 2].face && cards[i].suit != (cards[i + 2].suit))) {
                ThreeOfaKindPosition = i;
                if (ThreeOfaKindPosition == 0
                        && (cards[ThreeOfaKindPosition + 3].face == cards[ThreeOfaKindPosition + 4].face
                        && cards[ThreeOfaKindPosition + 3].suit != (cards[ThreeOfaKindPosition + 4].suit))) {
                    return true;
                }
                if (ThreeOfaKindPosition == 2
                        && (cards[ThreeOfaKindPosition - 2].face == cards[ThreeOfaKindPosition - 1].face
                        && cards[ThreeOfaKindPosition - 2].suit != (cards[ThreeOfaKindPosition - 1].suit))) {
                    return true;
                }
            }
        }
        return false;
    }

    // WORKS
    public boolean isFlush() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].suit != (cards[i + 1].suit)) {
                return false;
            }
        }
        return true;
    }

    // WORKS
    public boolean isStraight() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].face != (cards[i + 1].face - 1)) {
                return false;
            }
        }
        return true;
    }

    //WORKS
    public boolean isThreeOfaKind() {
        for (int i = 0; i < cards.length - 2; i++) {
            if ((cards[i].face == cards[i + 1].face && cards[i].suit != (cards[i + 1].suit))
                    && (cards[i].face == cards[i + 2].face && cards[i].suit != (cards[i + 2].suit))) {
                return true;
            }
        }
        return false;
    }

    //WORKS
    public boolean isTwoPairs() {
        int pairsCounter = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            if ((cards[i].face == (cards[i + 1].face)) && (cards[i].suit != (cards[i + 1].suit))) {
                pairsCounter++;
            }
        }
        if (pairsCounter >= 2) {
            return true;
        }
        return false;
    }

    //WORKS
    public boolean isOnePair() {
        for (int i = 0; i < cards.length - 1; i++) {
            if ((cards[i].face == (cards[i + 1].face)) && (cards[i].suit != (cards[i + 1].suit))) {
                return true;
            }
        }
        return false;
    }

    // WORKS
    public int highCard() {
        int myHighCard = cards[0].face;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].face > myHighCard) {
                myHighCard = cards[i].face;
            }
        }
        return myHighCard;
    }

    // UGLY CODE ------ TO FIX
    @Override
    public String toString() {
        String stringReturn = "";
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
        return "\n";
    }
}
