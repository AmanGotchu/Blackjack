package com.blackjack.src.player;
import java.util.ArrayList;

import java.util.List;
import java.util.TreeSet;

import com.blackjack.src.card.Card;

/** Class that contains and maintains the hand of a current player 
 *  Could be used if a player were to ever play multiple games at once with 
 *  less refactoring.
 */
public class PlayerHand {
	private int handValue;
	public List<Card> playerCards;
	
	public PlayerHand() {
		this.playerCards = new ArrayList<>();
		this.handValue = 0;
	}
	
	/** Adds cards to hand and updates value accordingly */
	public void addCard(Card card) {
		this.playerCards.add(card);
		this.updateValues();
	}
	
	/** Calculates the maximum hand that's < 21 
	 *  In the event the hand is always > 21
	 *  that hand value will be used instead.
	 */
	private void updateValues() {
		int handValue = 0;
		int numberAces = 0;
		
		for(Card card : this.playerCards) {
			if(card.getFace() == Card.FACE.ACE) {
				numberAces++;
			}
			handValue += card.getValue();
		}
		
		while(handValue > 21 && numberAces > 0) {
			numberAces--;
			handValue -= 10;
		}
		
		this.handValue = handValue;
	}
	
	public int getHandValue() {
		return this.handValue;
	}
	
	/** Resets cards and resets hand */
	public void resetPlayer() {
		this.playerCards.clear();
		this.handValue = 0;
	}
	
	/** If smallest possible hand value is over 21 */
	public boolean isBust() {
		return this.handValue > 21;
	}
}
