import java.io.IOException;
import java.util.ArrayList;

import ec.util.MersenneTwisterFast;


public class GoFishMain {
	private static ArrayList deck = new ArrayList(52);
	private static ArrayList playerHand = new ArrayList(39);
	private static ArrayList cpuHand = new ArrayList(39);
	
	private static int playerScore = 0;
	private static int AIScore = 0;
	
	private static MersenneTwisterFast RNG = new MersenneTwisterFast();
	
	/**
	 * Creates an ArrayList of 52 different integers from 0-51
	 * @return the ArrayList containing the integers 0-51 in a random order
	 */
	public static ArrayList draw52Cards() {
		ArrayList deck = new ArrayList(52);
		
		while (deck.size() < 52) {
			int newNum = RNG.nextInt(52);
			while (!deck.contains(newNum)) {
				deck.add(newNum);
			}
		}
		
		//System.out.println(deck.toString());
		return deck;
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
	 * Returns the name of the card.
	 * @param card 0-51
	 * @return The name of the card.
	 */
	public static String getCardName(int card) {
		String name = "";
		switch (card) {
			case  0: name = "Ace of Clovers"; break;
			case  1: name = "Two of Clovers"; break;
			case  2: name = "Three of Clovers"; break;
			case  3: name = "Four of Clovers"; break;
			case  4: name = "Five of Clovers"; break;
			case  5: name = "Six of Clovers"; break;
			case  6: name = "Seven of Clovers"; break;
			case  7: name = "Eight of Clovers"; break;
			case  8: name = "Nine of Clovers"; break;
			case  9: name = "Ten of Clovers"; break;
			case 10: name = "Jack of Clovers"; break;
			case 11: name = "Queen of Clovers"; break;
			case 12: name = "King of Clovers"; break;
			case 13: name = "Ace of Spades"; break;
			case 14: name = "Two of Spades"; break;
			case 15: name = "Three of Spades"; break;
			case 16: name = "Four of Spades"; break;
			case 17: name = "Five of Spades"; break;
			case 18: name = "Six of Spades"; break;
			case 19: name = "Seven of Spades"; break;
			case 20: name = "Eight of Spades"; break;
			case 21: name = "Nine of Spades"; break;
			case 22: name = "Ten of Spades"; break;
			case 23: name = "Jack of Spades"; break;
			case 24: name = "Queen of Spades"; break;
			case 25: name = "King of Spades"; break;
			case 26: name = "Ace of Hearts"; break;
			case 27: name = "Two of Hearts"; break;
			case 28: name = "Three of Hearts"; break;
			case 29: name = "Four of Hearts"; break;
			case 30: name = "Five of Hearts"; break;
			case 31: name = "Six of Hearts"; break;
			case 32: name = "Seven of Hearts"; break;
			case 33: name = "Eight of Hearts"; break;
			case 34: name = "Nine of Hearts"; break;
			case 35: name = "Ten of Hearts"; break;
			case 36: name = "Jack of Hearts"; break;
			case 37: name = "Queen of Hearts"; break;
			case 38: name = "King of Hearts"; break;
			case 39: name = "Ace of Diamonds"; break;
			case 40: name = "Two of Diamonds"; break;
			case 41: name = "Three of Diamonds"; break;
			case 42: name = "Four of Diamonds"; break;
			case 43: name = "Five of Diamonds"; break;
			case 44: name = "Six of Diamonds"; break;
			case 45: name = "Seven of Diamonds"; break;
			case 46: name = "Eight of Diamonds"; break;
			case 47: name = "Nine of Diamonds"; break;
			case 48: name = "Ten of Diamonds"; break;
			case 49: name = "Jack of Diamonds"; break;
			case 50: name = "Queen of Diamonds"; break;
			case 51: name = "King of Diamonds"; break;
			default: name = "Card of Destiny"; break;
		}
		return name;
	}
	
	/**
	 * Distributes 7 cards for each player on the start of the game
	 * @param deck It is where the cards distributed to each players come from
	 * @param playerHand Receives 7 cards from the deck
	 * @param cpuHand Receives another 7 cards from the deck
	 */
	public static void dealCards(ArrayList deck, ArrayList playerHand, ArrayList cpuHand) {
		playerHand.clear();
		cpuHand.clear();
		// get 7 cards from deck
		// place each card in playerHand
		for (int i=0; i<7; i++) {
			playerHand.add(deck.remove(0));
		}
		// get 7 cards from deck
		// place each cacrd in cpuHand
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
		
		System.out.println("Player");
		System.out.print("Score: "); System.out.println(playerScore);
		System.out.print("# of cards: "); System.out.println(playerHand.size());
		System.out.println("Cards on hand:");
		for(int i = 0; i<playerHand.size(); i++) {
			System.out.println(getCardName((int)playerHand.get(i)));
		}
	}
}