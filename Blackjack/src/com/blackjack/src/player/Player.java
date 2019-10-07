package com.blackjack.src.player;
import java.util.List;


import com.blackjack.src.card.Card;

public class Player {
	private PlayerHand hand;
	private String name;
	private boolean isDealer;
	
	/** Initializes name and dealer boolean */
	public Player(String name, boolean isDealer) {
		this.hand = new PlayerHand();
		this.name = name;
		this.isDealer = isDealer;
	}
	
	/** Adds card to player hand */
	public void addNewCard(Card newCard) {
		this.hand.addCard(newCard);
	}
	
	/** Reinitializes the player hand */
	public void resetHand() {
		this.hand = new PlayerHand();
	}
	
	/** Retrieves the hand value from the player's PlayerHand object */
	public int getHandValue() {
		return this.hand.getHandValue();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isDealer() {
		return this.isDealer;
	}
	
	/** Displays all of a player's cards appropriately
	 *  Considers the fact if the dealer is showing his cards
	 *  for the first time in which he only shows one!
	 */
	public void displayCards(boolean initialDealerDisplay) {
		System.out.println(this.getName() + "'s Cards:");
		System.out.println("==========================");
		for(int i = 0; i<this.hand.playerCards.size(); i++) {
			Card c = this.hand.playerCards.get(i);
			
			// If it's the initial showing of the dealer's hand 
			// it hides all cards except for the first
			if(i > 0 && initialDealerDisplay && isDealer) {
				System.out.print("HIDDEN | ");
			}else {
				System.out.print(c.getFace() + " " + Card.suitToChar.get(c.getSuit()) + " | ");
			}
		}
		System.out.println();
		System.out.println();
	}
}
