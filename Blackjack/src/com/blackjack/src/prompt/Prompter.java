package com.blackjack.src.prompt;
import java.io.IOException;

import java.util.Scanner;

import com.blackjack.src.engine.BlackjackEngine;

/** Handles all of the user input in the game! */
public class Prompter {
	static Scanner inputScanner = new Scanner(System.in);
	
	/** Prompts user for the number of players until a valid input is given */
	public static int promptForNumberPlayers() {
		int numPlayers = 0;
		while(numPlayers < 1 || numPlayers > 7) {
			System.out.println("Enter the number of players that will be playing!");
			System.out.println("Min: 1 & Max: 7");
			String input = inputScanner.nextLine();
			
			try {
				numPlayers = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Input is not a number!");
			}
		}
		System.out.println("Game will be played with " + numPlayers + " player(s)!");
		System.out.println();

		return numPlayers;
	}
	
	/** Prompts user for the number of decks until a valid input is given */
	public static int promptForNumberDecks() {
		int numDecks = 0;
		while(numDecks < 1 || numDecks > 3) {
			System.out.println("Enter the number of decks that you'd like to play with!");
			System.out.println("Min: 1 & Max: 3");
			String input = inputScanner.nextLine();
			
			try {
				numDecks = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Input is not a valid number!");
			}
		}
		System.out.println("Game will be played with " + numDecks + " deck(s)!");
		System.out.println();
		return numDecks;
	}
	
	/** Prompts user for a name */
	public static String promptForName() {
		System.out.println("Enter your player name!");
		String name = inputScanner.nextLine();
		System.out.println();
		return name;
	}
	
	/** Prompts user for a card action */
	public static String promptForAction() {
		String response = "";
		while(!BlackjackEngine.stringToAction.containsKey(response)) {
			System.out.println("Enter a valid action from the following list: ");
			for(String actionStr : BlackjackEngine.stringToAction.keySet()) {
				System.out.print(actionStr + " | ");
			}
			System.out.println();
			response = inputScanner.nextLine();
		}
		
		return response;
	}
	
	/** Prompts user if they want to play another round until a valid input is given */
	public static boolean promptForAnotherRound() {
		Boolean response = null;
		while(response == null) {
			System.out.println("Enter Y if you'd like to play another round!");
			System.out.println("Enter N if you'd like to quit the game!");
			String resStr = inputScanner.nextLine();
			if(resStr.toLowerCase().equals("y")) {
				response = true;
				break;
			}else if(resStr.toLowerCase().equals("n")) {
				response = false;
				break;
			}else {
				System.out.println("Enter a valid input!");
			}
		}
		
		return response.booleanValue();
	}
}
