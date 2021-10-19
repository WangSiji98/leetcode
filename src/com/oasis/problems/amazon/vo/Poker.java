package com.oasis.problems.amazon.vo;

/**
 * A standard 52-card deck comprises 13 ranks in each of the four French suits: clubs (♣), diamonds (♦), hearts (♥) and spades (♠)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * four French suits
 */
enum Suit {
    //♣
    CLUBS(0),
    //♦
    DIAMONDS(1),
    //♥
    HEARTS(2),
    //♠
    SPADES(3);

    private int type;
    private Suit(int _type) {
        type = _type;
    }
}


public class Poker {

    private static Suit[] suits = new Suit[]{Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
    private static String[] ranks = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    class Card {
        Suit suit;
        String rank;

        public Card(Suit _suit, String _rank) {
            suit = _suit;
            rank = _rank;
        }
    }
    
    private List<Card> cards;
    private Random random;
    private int curIdx;
    
    public Poker() {
        random = new Random();
        cards = new LinkedList<>();
        for (int k = 0; k < 4; ++k) {
            for (int i = 0; i < 13; ++i) {
                cards.add(new Card(suits[k], ranks[i]));
            }
        }
        curIdx = 0;
    }

    public void shuffle() {
        for (int i = curIdx; i < 52; ++i) {
            int j = random.nextInt(52);
            Collections.swap(cards, i, j);
        }
    }

    public Card getCard() {
        return cards.get(curIdx++);
    }

}
