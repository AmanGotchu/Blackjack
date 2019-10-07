package com.blackjack.test.card;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blackjack.src.card.Card;
import com.blackjack.src.card.Deck;

class DeckTest {

	@Test
	void constructorTest() {
		Deck deck = new Deck(1);
		assertTrue(deck.numberDecks == 1);
		
		deck = new Deck(4);
		assertTrue(deck.numberDecks == 4);
	}
	
	@Test
	void getNewCardTest() {
		int numberDecks = 2;
		int totalCards = 52 * numberDecks;
		Deck deck = new Deck(numberDecks);
		
		boolean exceptionThrownCorrectly = false;
		for(int i = 0; i<totalCards+1; i++) {
			try {
				Card temp = deck.getNewCard();
			} catch (Exception e) {
				if(i != totalCards) {
					fail("Shouldn't throw before the entirety of the deck is used!");
				}else {
					exceptionThrownCorrectly = true;
				}
			}
		}
		
		assertTrue(exceptionThrownCorrectly);
	}
	
	@Test
	void testResetDeck() {
		Deck deck = new Deck(1);
		
		try {
			deck.getNewCard();
			deck.getNewCard();
		} catch (Exception e) {
			fail("Shouldn't fail with only two draws!");
		}
		
		assertTrue(deck.deckIndex == 2);
		deck.resetDeck();
		assertTrue(deck.deckIndex == 0);
	}
	
	// A more appropriate way of testing a shuffle algorithm is with a large sample set and lots of iterations of testing
	// This is a very crude and simple way of making sure that two decks won't be the same after a shuffle
	@Test
	void testShuffleDeck() throws Exception {
		int numberDecks = 1;
		
		Deck deckOne = new Deck(numberDecks);
		Deck deckTwo = new Deck(numberDecks);
		
		int notSameCounter = 0;
		
		for(int i = 0; i<52; i++) {
			Card oneCard = deckOne.getNewCard();
			Card twoCard = deckTwo.getNewCard();
			
			if(oneCard.getFace() != twoCard.getFace() || oneCard.getValue() != twoCard.getValue()) {
				notSameCounter++;
			}
		}
		
		assertTrue(notSameCounter >= 1);
	}
}
