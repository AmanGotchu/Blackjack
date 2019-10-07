package com.blackjack.test.player;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blackjack.src.card.Card;
import com.blackjack.src.player.Player;

class PlayerTest {
	
	@Test
	void constructorTest() {
		Player player = new Player("Aman", false);
		assertFalse(player.isDealer());
		assertTrue(player.getName().equals("Aman"));
	}
	
	@Test
	void isDealerTest() {
		Player player = new Player("Aman", true);
		assertTrue(player.isDealer());
	}
	
	@Test
	void addCardTest() {
		Player player = new Player("Aman", false);
		player.addNewCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(player.getHandValue() == 11);
		
		player.addNewCard(new Card(Card.FACE.TWO, Card.SUIT.CLUB));
		assertTrue(player.getHandValue() == 13);
		
		player.addNewCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(player.getHandValue() == 14);
		
		player.addNewCard(new Card(Card.FACE.FIVE, Card.SUIT.CLUB));
		assertTrue(player.getHandValue() == 19);
	}
	
	@Test
	void resetTest() {
		Player player = new Player("Aman", false);
		player.addNewCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		player.addNewCard(new Card(Card.FACE.TWO, Card.SUIT.CLUB));
		
		player.resetHand();
		assertTrue(player.getHandValue() == 0);
	}
}
