/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etcharn1
 */
public class HoldemHand {

    private Card[] cards;
    private Card[] combinationCards = new Card[5];
    private ArrayList<Integer> combinationHandArray = new ArrayList<>();
 //   private int HandRankMax;
    private final int[][] COMBINATIONS = {
        {1, 2, 3, 4, 5}, {1, 2, 3, 4, 6}, {1, 2, 3, 4, 7}, {1, 2, 3, 5, 6}, {1, 2, 3, 5, 7},
        {1, 2, 3, 6, 7}, {1, 2, 4, 5, 6}, {1, 2, 4, 5, 7}, {1, 2, 4, 6, 7}, {1, 2, 5, 6, 7},
        {1, 3, 4, 5, 6}, {1, 3, 4, 5, 7}, {1, 3, 4, 6, 7}, {1, 3, 5, 6, 7}, {1, 4, 5, 6, 7},
        {2, 3, 4, 5, 6}, {2, 3, 4, 5, 7}, {2, 3, 4, 6, 7}, {2, 3, 5, 6, 7}, {2, 4, 5, 6, 7},
        {3, 4, 5, 6, 7}
    };

    public HoldemHand(Card[] cards) {
        this.cards = cards;
    }

    public PokerHand getBestPossibleHand(Card[] sharedCards) {
        for (int i = 0; i < COMBINATIONS.length; i++) {
            for (int y = 0; y < COMBINATIONS[y].length; y++) {
                if (COMBINATIONS[i][y] == 1) {
                    combinationCards[y] = sharedCards[0];
                } else if (COMBINATIONS[i][y] == 2) {
                    combinationCards[y] = sharedCards[1];
                } else if (COMBINATIONS[i][y] == 3) {
                    combinationCards[y] = sharedCards[2];
                } else if (COMBINATIONS[i][y] == 4) {
                    combinationCards[y] = sharedCards[3];
                } else if (COMBINATIONS[i][y] == 5) {
                    combinationCards[y] = sharedCards[4];
                } else if (COMBINATIONS[i][y] == 6) {
                    combinationCards[y] = sharedCards[5];
                } else if (COMBINATIONS[i][y] == 7) {
                    combinationCards[y] = sharedCards[6];
                }
            }
            PokerHand combinationHand = new PokerHand(combinationCards);
            combinationHandArray.add(combinationHand.getHandRank());  
            System.out.println(combinationHand);
            System.out.println(combinationHand.getHandRank());
        }
        
        for (int i = 0; i < combinationHandArray.size();i++){
            if (combinationHandArray.get(i) > PokerHand.handRankMax ){
                PokerHand.handRankMax = combinationHandArray.get(i);
            }
        }
        System.out.println(PokerHand.handRankMax);
        return null;
    }

    @Override
    public String toString() {
        String stringReturn = "";
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
        return " ";
    }
}
