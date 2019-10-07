package com.blackjack.src.engine;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blackjack.src.card.Deck;
import com.blackjack.src.player.Player;
import com.blackjack.src.prompt.Prompter;

/** Handles all game logic */
public class BlackjackEngine {
	List<Player> players;
	Player dealer;
	Deck gameDeck;
	
	enum ACTIONS {
		HIT,
		STAND
		// Add more ACTIONS here!
	}
	
    public static Map<String, ACTIONS> stringToAction = new HashMap<>() {{
    	put("hit", ACTIONS.HIT);
    	put("stand", ACTIONS.STAND);
    	// assign string to a new ACTION here!
    }};
	
    /** Initialize a new game deck, players, and a dealer! */
	public BlackjackEngine(int numDecks, int numPlayers) {
		this.gameDeck = new Deck(numDecks);
		this.players = new ArrayList<>();
		for(int i = 0; i<numPlayers; i++) {
			String name = Prompter.promptForName();
			this.players.add(new Player("(" + (i+1) + ")" + name, false));
		}
		this.dealer = new Player("DEALER", true);
	}
	
	/** Simulates individual rounds for every player in Blackjack */
	public void playRound() throws Exception {
		resetRound();
		
		// Give dealer two cards to start the round
		this.dealer.addNewCard(gameDeck.getNewCard());
		this.dealer.addNewCard(gameDeck.getNewCard());
		
		// Set true to hide one of the dealer's cards
		this.dealer.displayCards(true);
		
		// Deal cards to all players
		for(Player player : this.players) {
			player.addNewCard(gameDeck.getNewCard());
			player.addNewCard(gameDeck.getNewCard());
			player.displayCards(false);
		}
		
		// Play a round for each player
		for (Player player : this.players) {
			individualRound(player, gameDeck);
		}
		
		// Complete the last round (Dealer's round)
		dealerRound(dealer, gameDeck);
		
		// Output game results
		showFinalResults(this.players, dealer);
	}
	
	/** Simulates a single round for an individual player in Blackjack */
	private void individualRound(Player player, Deck gameDeck) throws Exception {
		player.displayCards(false);
		boolean keepPlaying = true;
		// Ask for a player's ACTION until they bust or decide to STAND
		while (keepPlaying && player.getHandValue() < 21) {
			System.out.println(player.getName()+"'s turn!");

			ACTIONS responseAction = stringToAction.get(Prompter.promptForAction());
			keepPlaying = handleAction(player, responseAction);
			
			player.displayCards(false);
		}
		
		showRoundResults(player);
	}
	
	/** Handles a user action for a specific player */
	private boolean handleAction(Player player, ACTIONS responseAction) throws Exception {
		boolean keepPlaying = true;
		
		// Logic for handling actions
		if(responseAction == ACTIONS.HIT) {
			System.out.println(player.getName() + " chooses to HIT!");
			player.addNewCard(gameDeck.getNewCard());
		} else if(responseAction == ACTIONS.STAND) {
			System.out.println(player.getName() + " chooses to STAND!");
			keepPlaying = false;
		} // Add more actions here!
		
		System.out.println();
		return keepPlaying;
	}
	
	/** Dealer's tend to have a specific algorithm when playing for the House!
	 * Generally they hit until they are >= 17 
	 */
	private void dealerRound(Player player, Deck gameDeck) throws Exception {
		// Show both cards
		player.displayCards(false);
		while(player.getHandValue() < 17) {
			System.out.println(player.getHandValue());
			player.addNewCard(gameDeck.getNewCard());
			player.displayCards(false);
		}
	} 
	
	/** Shows an individual rounds results */
	private void showRoundResults(Player player) {
		if(player.getHandValue() == 21) {
			System.out.println(player.getName() + " got 21!");
		} else if(player.getHandValue() > 21) {
			System.out.println(player.getName() + " busts!");
		} else {
			System.out.println(player.getName() + " finishes with: " + player.getHandValue());
		}
		System.out.println();
	}
	
	/** Compares all players with the dealer and outputs everyone's result */
	private void showFinalResults(List<Player> players, Player dealer) {
		System.out.println("RESULTS");
		System.out.println("========================");
		
		int dealerHandVal = dealer.getHandValue();
		for(Player player : players) {
			int playerHandVal = player.getHandValue();
			
			if(playerHandVal > 21) {
				System.out.println(player.getName() + " busts with " + playerHandVal);
			}else {
				if(dealerHandVal > 21) {
					System.out.println(player.getName() + " wins since the dealer BUSTS with " + dealerHandVal);
				}else if(playerHandVal == dealerHandVal) {
					System.out.println(player.getName() + " and dealer DRAW with " + playerHandVal);
				} else if(playerHandVal < dealerHandVal) {
					System.out.println(player.getName() + " loses against dealer with " + playerHandVal + " vs. " + dealerHandVal);
				} else if(playerHandVal > dealerHandVal) {
					System.out.println(player.getName() + " wins agains dealer with " + playerHandVal + " vs. " + dealerHandVal);
				}
			}
		} 
	}

	/** Resets all Players and Deck */
	private void resetRound() {
		this.gameDeck.resetDeck();
		this.dealer.resetHand();
		for(Player player : this.players) {
			player.resetHand();
		}
	}
}
