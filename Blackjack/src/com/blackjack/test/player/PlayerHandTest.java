package com.blackjack.test.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blackjack.src.card.Card;
import com.blackjack.src.player.PlayerHand;

class PlayerHandTest {
	PlayerHand hand;
	
	@BeforeEach
	void setUp() throws Exception {
		hand = new PlayerHand();
	}
	
	@Test
	void constructorTest() {
		assertTrue(hand.getHandValue() == 0);
		assertTrue(hand.playerCards.size() == 0);
	}
	
	@Test
	void notBustTest() {
		assertFalse(hand.isBust());
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		hand.addCard(new Card(Card.FACE.KING, Card.SUIT.CLUB));
		assertFalse(hand.isBust());
	}
	
	@Test
	void isBustTest() {
		for(int i = 0; i<3; i++) {
			hand.addCard(new Card(Card.FACE.KING, Card.SUIT.CLUB));
		}
		assertTrue(hand.isBust());
	}
	
	/** Testing hand value functionality with aces */
	@Test
	void addMultipleAcesTest() {
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 12);
		
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 14);
		
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 16);
		
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 18);
		
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 20);
		
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 21);
		
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 12);
	}
	
	/** Testing individual card values */
	@Test
	void addAceCardTest() {
		hand.addCard(new Card(Card.FACE.ACE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 11);
	}
	
	@Test
	void addTwoCardTest() {
		hand.addCard(new Card(Card.FACE.TWO, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 2);
	}
	
	@Test
	void addThreeCardTest() {
		hand.addCard(new Card(Card.FACE.THREE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 3);
	}
	
	@Test
	void addFourCardTest() {
		hand.addCard(new Card(Card.FACE.FOUR, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 4);
	}
	
	@Test
	void addFiveCardTest() {
		hand.addCard(new Card(Card.FACE.FIVE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 5);
	}
	
	@Test
	void addSixCardTest() {
		hand.addCard(new Card(Card.FACE.SIX, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 6);
	}
	
	@Test
	void addSevenCardTest() {
		hand.addCard(new Card(Card.FACE.SEVEN, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 7);
	}
	
	@Test
	void addEightCardTest() {
		hand.addCard(new Card(Card.FACE.EIGHT, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 8);
	}
	
	@Test
	void addNineCardTest() {
		hand.addCard(new Card(Card.FACE.NINE, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 9);
	}
	
	@Test
	void addTenCardTest() {
		hand.addCard(new Card(Card.FACE.TEN, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 10);
	}
	
	@Test
	void addJackCardTest() {
		hand.addCard(new Card(Card.FACE.JACK, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 10);
	}
	
	@Test
	void addQueenCardTest() {
		hand.addCard(new Card(Card.FACE.QUEEN, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 10);
	}
	
	@Test
	void addKingCardTest() {
		hand.addCard(new Card(Card.FACE.KING, Card.SUIT.CLUB));
		assertTrue(hand.getHandValue() == 10);
	}
}
