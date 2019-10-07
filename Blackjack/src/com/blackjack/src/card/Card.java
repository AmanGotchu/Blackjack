package com.blackjack.src.card;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {
	public static enum FACE {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
	public static enum SUIT {
		HEART, DIAMOND, SPADE, CLUB
	}
	
    public static Map<FACE, Integer> faceToValue = new HashMap<>() {{
    	put(FACE.TWO, 2);
    	put(FACE.THREE, 3);
    	put(FACE.FOUR, 4);
    	put(FACE.FIVE, 5);
    	put(FACE.SIX, 6);
    	put(FACE.SEVEN, 7);
    	put(FACE.EIGHT, 8);
    	put(FACE.NINE, 9);
    	put(FACE.TEN, 10);
    	put(FACE.JACK, 10);
    	put(FACE.QUEEN, 10);
    	put(FACE.KING, 10);
    	put(FACE.ACE, 11);
    }};
    
    public static Map<SUIT, Character> suitToChar = new HashMap<>() {{
    	put(SUIT.CLUB, '\u2663');
    	put(SUIT.SPADE, '\u2660');
    	put(SUIT.HEART, '\u2665');
    	put(SUIT.DIAMOND, '\u2666');
    }};
	
	private FACE face;
	private SUIT suit;
	public int value;
	
	/** Initializes a card with a FACE, SUIT enum and the appropriate integer value */
	public Card(FACE face, SUIT suit) {
		this.face = face;
		this.suit = suit;
		this.value = faceToValue.get(this.face);
	}
	
	public SUIT getSuit() {
		return this.suit;
	}
	
	public FACE getFace() {
		return this.face;
	}
	
	public int getValue() {
		return this.value;
	}
}
