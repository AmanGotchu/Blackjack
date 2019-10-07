package com.blackjack.src.card;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import com.blackjack.src.card.Card.FACE;
import com.blackjack.src.card.Card.SUIT;

public class Deck {
	private List<Card> deck;
	
	public int deckIndex;
	public int numberDecks;

	/** Blackjack can potentially be played with multiple decks */
	public Deck(int numberDecks) {
		this.numberDecks = numberDecks;
		initializeDeck(this.numberDecks);
		resetDeck();
	}
	
	/** Returns a new card from the deck. 
	 * Throws exception if deck is empty, which shouldn't happen in Blackjack..
	 */
	public Card getNewCard() throws Exception {
		if(isEmpty()) {
			throw new Exception("Deck is empty!");
		}
		return deck.get(deckIndex++);
	}
	
	/** Shuffles deck and resets index to 0 */
	public void resetDeck() {
		this.deckIndex = 0;
		shuffle();
	}
	
	/** Initialize deck with the four SUIT and 13 FACE value combinations */
	private void initializeDeck(int numberDecks) {
		this.deckIndex = 0;
		this.deck = new ArrayList<>();
		for(int i = 0; i<this.numberDecks; i++) {
			for(Card.SUIT suit : Card.SUIT.values()) {
				for(Card.FACE face : Card.FACE.values()) {
					this.deck.add(new Card(face, suit));
				}
			}
		}
	}
	
	/** Using Fisher Yates shuffle algorithm 
	 *  Read from https://www.isa-afp.org/browser_info/current/AFP/Fisher_Yates/outline.pdf
	 *  and simulated basic concept in this method
	 */
	private void shuffle() {
		Random rng = new Random();
		for(int i = 0; i<deck.size(); i++) {
			int randomIndex = i + rng.nextInt(deck.size()-i);
			Card randomCard = deck.get(randomIndex);
			Card currentCard = deck.get(i);
			
			deck.set(randomIndex, currentCard);
			deck.set(i, randomCard);
		}
	}
	
	private boolean isEmpty() {
		return deckIndex >= deck.size();
	}
}
