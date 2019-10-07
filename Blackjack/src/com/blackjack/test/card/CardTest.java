package com.blackjack.test.card;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blackjack.src.card.Card;

class CardTest {
	/** Testing individual suits */
	void suitHeartTest() {
		Card heart = new Card(Card.FACE.ACE, Card.SUIT.HEART);
		assertTrue(heart.getSuit() == Card.SUIT.HEART);
	}
	
	void suitDiamondTest() {
		Card diamond = new Card(Card.FACE.ACE, Card.SUIT.DIAMOND);
		assertTrue(diamond.getSuit() == Card.SUIT.DIAMOND);
	}
	
	void suitClubTest() {
		Card club = new Card(Card.FACE.ACE, Card.SUIT.CLUB);
		assertTrue(club.getSuit() == Card.SUIT.CLUB);
	}
	
	void suitSpadeTest() {
		Card spade = new Card(Card.FACE.ACE, Card.SUIT.SPADE);
		assertTrue(spade.getSuit() == Card.SUIT.SPADE);
	}

	/** Testing individual faces */
	@Test
	void faceAceTest() {
		Card ace = new Card(Card.FACE.ACE, Card.SUIT.CLUB);
		assertTrue(ace.value == 11);
		assertTrue(ace.getFace() == Card.FACE.ACE);
	}
	
	@Test
	void faceTwoTest() {
		Card two = new Card(Card.FACE.TWO, Card.SUIT.CLUB);
		assertTrue(two.value == 2);
		assertTrue(two.getFace() == Card.FACE.TWO);
	}
	
	@Test
	void faceThreeTest() {
		Card three = new Card(Card.FACE.THREE, Card.SUIT.CLUB);
		assertTrue(three.value == 3);
		assertTrue(three.getFace() == Card.FACE.THREE);
	}
	
	@Test
	void faceFourTest() {
		Card four = new Card(Card.FACE.FOUR, Card.SUIT.CLUB);
		assertTrue(four.value == 4);
		assertTrue(four.getFace() == Card.FACE.FOUR);
	}
	
	@Test
	void faceFiveTest() {
		Card five = new Card(Card.FACE.FIVE, Card.SUIT.CLUB);
		assertTrue(five.value == 5);
		assertTrue(five.getFace() == Card.FACE.FIVE);
	}
	
	@Test
	void faceSixTest() {
		Card six = new Card(Card.FACE.SIX, Card.SUIT.CLUB);
		assertTrue(six.value == 6);
		assertTrue(six.getFace() == Card.FACE.SIX);
	}
	
	@Test
	void faceSevenTest() {
		Card seven = new Card(Card.FACE.SEVEN, Card.SUIT.CLUB);
		assertTrue(seven.value == 7);
		assertTrue(seven.getFace() == Card.FACE.SEVEN);
	}
	
	@Test
	void faceEightTest() {
		Card eight = new Card(Card.FACE.EIGHT, Card.SUIT.CLUB);
		assertTrue(eight.value == 8);
		assertTrue(eight.getFace() == Card.FACE.EIGHT);
	}
	
	@Test
	void faceNineTest() {
		Card nine = new Card(Card.FACE.NINE, Card.SUIT.CLUB);
		assertTrue(nine.value == 9);
		assertTrue(nine.getFace() == Card.FACE.NINE);
	}
	
	@Test
	void faceTenTest() {
		Card ten = new Card(Card.FACE.TEN, Card.SUIT.CLUB);
		assertTrue(ten.value == 10);
		assertTrue(ten.getFace() == Card.FACE.TEN);
	}
	
	@Test
	void faceJackTest() {
		Card jack = new Card(Card.FACE.JACK, Card.SUIT.CLUB);
		assertTrue(jack.value == 10);
		assertTrue(jack.getFace() == Card.FACE.JACK);
	}
	
	@Test
	void faceQueenTest() {
		Card queen = new Card(Card.FACE.QUEEN, Card.SUIT.CLUB);
		assertTrue(queen.value == 10);
		assertTrue(queen.getFace() == Card.FACE.QUEEN);
	}
	
	@Test
	void faceKingTest() {
		Card king = new Card(Card.FACE.KING, Card.SUIT.CLUB);
		assertTrue(king.value == 10);
		assertTrue(king.getFace() == Card.FACE.KING);
	}
}
