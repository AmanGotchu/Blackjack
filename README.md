# BlackJack

KPCB Fellowship Card Game Submission

## Getting Started

git clone https://github.com/AmanGotchu/Blackjack.git
cd Blackjack

### Game Rules
The code is designed and factored for ease of extendability for more actions and features!

This current game of Blackjack contains the basic following actions
- HIT: Adding another card to your hand
- STAND: Leaving your hand how it is

Small Sidenotes
- There can be up to 3 different decks and 7 different players in any game!
- Hand values are determined as the largest possible value that can be attained without busting. If there is no such value then the hand value will be calculated as if all Aces are 1's.
- Randomization of decks are completed using Fisher-Yates shuffling algorithm (mentioned below).
- All input is taken through standard in and all output is given through standard out.

### Prerequisites
Need an updated working version of Java: https://www.oracle.com/technetwork/java/javase/downloads/index.html

1. Java
2. JUnit 
3. Eclipse (Only for running test cases) TODO: Terminal based testing

### Installing and starting the terminal-based game
1. cd Blackjack
2. javac Start.java
3. java Start

## Running the tests
Import git project into Eclipse, and run the following tests
- CardTest.java
- DeckTest.java
- PlayerHandTest.java
- PlayerTest.java

If errors are present in Test files opt for Eclipse's suggested Fix to the overall project.
If still having trouble contact me!

- Email: aman.gottu@gmail.com
- Phone: 713-471-2306

## Classes

### Prompter
The prompter class is used whenever the game requires user input.
It handles validation of input as well as clear direction of what is required of the user!

It currently prompts for the following

1. Number of players
```
public static int promptForNumberPlayers()
```

2. Number of decks
```
public static int promptForNumberDecks()
```

3. User Name
```
public static String promptForName()
```

4. Action in Game
```
public static String promptForAction()
```

5. Does another Round want to be played
```
public static boolean promptForAnotherRound()
```

### Card
The card class is initialized with
1. Face ENUM
2. SUIT ENUM

#### Testing the Card class
Simply ensure that each card correctly initializes it's FACE and SUIT value as well as the appropriate numerical value that corresponds to each FACE.

### Deck
The Deck class is heavily dependent on the Card class!

The Deck class is initialized with
1. Number of decks being used in (int)

The Deck class supports 
1. Initialization of multiple decks
```
public Deck(int numberDecks) {
this.numberDecks = numberDecks;
initializeDeck(this.numberDecks);
resetDeck();
}
```

2. shuffling and randomization
Shuffling and randomization are done with the simple Fisher-Yates algorithm
Credits below
```
private void shuffle()
```

3. Drawing a card
```
public Card getNewCard()
```

4. Resetting a deck for future rounds.
```
public void resetDeck()
```

#### DeckTest: Testing the Deck class

Each of these functionalities are unit tested to ensure that shuffling is random enough, the appropriate cards are being initialized, drawing a card doesn't exceed the total limit of cards, and resetting resets the deck to a brand new state.

There is a CAVEAT when testing randomness which can more accurately be done with multiple iterations and analysis of the distribution of all samples taken. 

The current test does a simple check to make sure enough cards are different from the previous iteration. 
TODO: Enhance testing!

### PlayerHand

The PlayerHand class is initialized with nothing and immediately initializes an empty Arraylist and initial value of 0 for it's handValue.

The PlayerHand class supports

1. Adding cards to hand
```
public void addCard(Card card)
```
Adding cards to the hand automatically updates the value of the hand with a private method updateValues().
updateValues() contains the logic that allows the hand value to equal the largest valid hand <= 21 if possible.

2. Retrieving hand value
```
public int getHandValue()
```

3. Resetting hand
```
public void resetPlayer()
```

4. Determining if current hand is bust
```
public boolean isBust()
```

#### PlayerHandTest: Testing the PlayerHand class

PlayerHandTest tests 
1. Initialization of variables to empty list and 0 hand value.
2. Testing the bust method for values >, =, and < 21.
3. Testing the internal handValue logic when dealing with Aces.
4. Tested each individual card to ensure that handValue is accurate with each one.

### Player
The Player class is initialized with a name and a boolean value stating if the user is the dealer or not
The Player class is also heavily dependent on the PlayerHand class

It's used to interact within the Blackjack game and includes 
```
private PlayerHand hand;
private String name;
private boolean isDealer;
```
A player can 

1. Add a new card to their hand
```
public void addNewCard(Card newCard)
```
2. Get the largest valid value <= 21 in their hand. If smallest value is > 21 then that's what is used.
```
public int getHandValue()
```
3. Reset their hand
```
public void resetHand()
```
4. Display their cards
```
public void displayCards(boolean initialDealerDisplay);
```
InitialDealerDisplay is used when the dealer initially shows his cards. He only shows one while everyone else shows both, so that allows us to HIDE that card until his turn.

#### PlayerTest: Testing the Player class
PlayerTests included testing
1. name and dealer properties
2. Adding card to hand
3. Validating value of hand
4. Resetting the hand

### BlackjackEngine
BlackjackEngine facilitates the game with Players, Deck, and Prompter!
It contains the logic to complete a full round of Blackjack.

BlackjackEngine is initialized with the number of decks being used, and the number of people playing the game. Both having their own constraints.

BlackjackEngine can:

1. Initialize the Game deck, players, and dealer
```
public BlackjackEngine(int numDecks, int numPlayers)
}
```
2. Complete a full round of blackjack
```
public void playRound()
```
Playing a full round of blackjack entails:
- Giving all players and dealer cards while showing them face up (except for dealer initially)
- Iteratively going to each player, allowing them to perform specific actions specified in BlackjackEngine.
Currently supporting only HIT and STAND, but allows for easy addition due to the current factoring!
```
private void individualRound(Player player, Deck gameDeck){}

private boolean handleAction(Player player, ACTIONS responseAction)

private void showRoundResults(Player player)
```

- Finishing off the circle with the final dealer round which follows a strict algorithm (commonly used in real casinos)
```
private void dealerRound(Player player, Deck gameDeck)
```

- Then all players are compared against the dealer and the final result is displayed!
```
private void showFinalResults(List<Player> players, Player dealer)
```

- The user is then prompted if they want to play another game in which the Players and Decks are reset!
```
private void resetRound()
```

#### BlackjackEngine Tests

Unfortunately due to time constraint, testing the full game engine wasn't completed.
My test plan:
Simulate games that would cover edge cases in the previously mentioned methods to ensure majority code coverage.
TODO: Finish tests for BlackjackEngine

## Built With

* [Java](https://docs.oracle.com/en/java/javase/13/) - The language used
* [JUnit](https://junit.org/junit5/) - Testing tool used

## Authors

* **Aman Gottumukkala**

## Acknowledgments

* Fisher Yates algorithm - https://www.isa-afp.org/browser_info/current/AFP/Fisher_Yates/outline.pdf
* Basic Blackjack Rules - http://www.hitorstand.net/strategy.php
