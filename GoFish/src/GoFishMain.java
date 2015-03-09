import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import ec.util.MersenneTwisterFast;


public class GoFishMain {
	private static ArrayList<Card> deck = new ArrayList(52);
	private static ArrayList<Card> playerHand = new ArrayList(39);
	private static ArrayList<Card> cpuHand = new ArrayList(39);
	
	private static int playerScore = 0;
	private static int AIScore = 0;
	
	private static int playerTurn = 0;
	
	
	
	private static MersenneTwisterFast RNG = new MersenneTwisterFast();
	
	/**
	 * Creates an ArrayList of 52 different integers from 0-51
	 * @return the ArrayList containing the integers 0-51 in a random order
	 */
	public static ArrayList draw52Cards() {
		ArrayList deck = new ArrayList(52);
		ArrayList<Card> returnDeck = new ArrayList(52);
		
		Card newCard;
		
		while (deck.size() < 52) {
			int newNum = RNG.nextInt(52);
			while (!deck.contains(newNum)) {
				newCard = new Card(newNum);
				returnDeck.add(newCard);
				deck.add(newNum);
			}
		}
		
		return returnDeck;
	}
	/**
	 * Checks for duplicates inside a deck
	 * @param deck the ArrayList of the deck of cards
	 * @return true if there are duplicates, false when there are none
	 */
	public static boolean checkDeckDuplicates(ArrayList deck) {
		boolean hasDuplicates = false;
		for(int i=0; i<52; i++) {
			for (int j=0; j<52; j++) {
				if (deck.toArray()[i] == deck.toArray()[j] && i != j) {
					hasDuplicates = true;
				}
			}
		}
		
		return hasDuplicates;
	}
	
	public static void main(String[] args) {
		displayTitleScreen();
		startGame();
	}
	
	/**
	 * Distributes 7 cards for each player on the start of the game
	 * @param deck It is where the cards distributed to each players come from
	 * @param playerHand Receives 7 cards from the deck
	 * @param cpuHand Receives another 7 cards from the deck
	 */
	public static void dealCards(ArrayList<Card> deck, ArrayList<Card> playerHand, ArrayList<Card> cpuHand) {
		playerHand.clear();
		cpuHand.clear();
		// get 7 cards from deck
		// place each card in playerHand
		for (int i=0; i<7; i++) {
			playerHand.add(deck.remove(0));
		}
		// get 7 cards from deck
		// place each card in cpuHand
		for (int i=0; i<7; i++) {
			cpuHand.add(deck.remove(0));
		}
	}
	
	public static void displayTitleScreen() {
		System.out.println(
		  "╔═══════════════════════════════════╗\n"
		+ "║ ┌───────────────────────────────┐ ║\n"
		+ "║ │                               │ ║\n"
		+ "║ │                               │ ║\n"
		+ "║ │   ╓──╖╓──╖  ╓──╖─╥─╓──╖╥  ╥   │ ║\n"
		+ "║ │   ║  ╜║  ║  ║  ╜ ║ ║  ╜║  ║   │ ║\n"
		+ "║ │   ║╓─╖║  ║  ╟──  ║ ╙──╖╟──╢   │ ║\n"
		+ "║ │   ║╙ ║║  ║  ║    ║ ╓  ║║  ║   │ ║\n"
		+ "║ │   ╙──╜╙──╜  ╙   ─╨─╙──╜╨  ╨   │ ║\n"
		+ "║ │       ┌─┐┬┌─   ┐┌─┐┌─┐        │ ║\n"
		+ "║ │       │  │├─ ─ │┌─┘ ─┤        │ ║\n"
		+ "║ │       └─┘┴└─   ┴└─┘└─┘        │ ║\n"
		+ "║ │        →   PROJECT  ←         │ ║\n"
		+ "║ │                               │ ║\n"
		+ "║ │     Dawn Christine Corpuz     │ ║\n"
		+ "║ │      Ramon Miguel Imbao       │ ║\n"
		+ "║ │                               │ ║\n"
		+ "║ │    Press <ENTER> to start.    │ ║\n"
		+ "║ │                               │ ║\n"
		+ "║ └───────────────────────────────┘ ║\n"
		+ "╚═══════════════════════════════════╝\n"
				);
		
		try {
			if (System.in.read() != -1) {
				for(int i=0; i<100; i++) System.out.println();
				// call StartGame
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void startGame() {
		deck = draw52Cards();
		
		dealCards(deck, playerHand, cpuHand);
		
		System.out.println("[PLAYER]");
		System.out.print("Score: "); System.out.println(playerScore);
		System.out.print("# of cards: "); System.out.println(playerHand.size());
		System.out.println("Cards on hand:");
		for(int i = 0; i<playerHand.size(); i++) {
			System.out.println("   " + playerHand.get(i).getCardName());
		}
		
		System.out.println();
		System.out.println("[AI]");
		System.out.print("Score: "); System.out.println(AIScore);
		System.out.print("# of cards: "); System.out.println(cpuHand.size());
		
		
	}
}