import com.blackjack.src.engine.BlackjackEngine;
import com.blackjack.src.prompt.Prompter;

public class Start {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numDecks = Prompter.promptForNumberDecks();
		int numPlayers = Prompter.promptForNumberPlayers();
		
		BlackjackEngine engine = new BlackjackEngine(numDecks, numPlayers);
		boolean play = true;
		while(play) {
			try {
				engine.playRound();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			play = Prompter.promptForAnotherRound();
		}
		
		System.out.println("Thanks for playing Blackjack!");
	}
}
