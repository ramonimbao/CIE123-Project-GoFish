import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ec.util.MersenneTwisterFast;


public class GoFishMain {
	private static ArrayList<Card> deck = new ArrayList(52);
	private static ArrayList<Card> playerHand = new ArrayList(39);
	private static ArrayList<Card> cpuHand = new ArrayList(39);
	
	private static int playerScore = 0;
	private static int AIScore = 0;
	
	private static int playerTurn = 0;
	
	private static boolean gameOver = false;
		
	
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
		while(!gameOver) evalTurn();
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
				clearScreen();
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
	
	public static void evalTurn(){
		if(playerTurn == 0){
			// Draw a Card
			if(deck.size() > 0 && playerHand.size() > 0) {
				playerHand.add(deck.remove(0));
			}
			else if (deck.size() > 0 && playerHand.size() == 0) {
				for(int i = 0; i < 7; i++) {
					playerHand.add(deck.remove(0));
				}
			}
			
			// Display Options
			System.out.println();
			System.out.println("Pick a type:");
			ArrayList options = new ArrayList(13);
			
			for(int i=0; i<playerHand.size(); i++){
				String cardType = playerHand.get(i).type;
				if (!options.contains(cardType)) {
					options.add(cardType);
				}
			}
			
			char letter = 'a';
			
			for (int i=0; i < options.size(); i++) {
				System.out.println("(" + (char)(letter+i) + ") " + options.get(i));
			}
			
			// Accept User Input
			Scanner s = new Scanner(System.in);
			int choice = (int)(s.next().charAt(0) - 'a');
			
			// Ask Type
			System.out.print("YOU: Do you have any ");
			System.out.print(options.get(choice));
			System.out.println("s?");
			
			
			// Check choice
			ArrayList cpuPlayerHand = new ArrayList(13);
			
			for(int i=0; i<cpuHand.size(); i++){
				String cardType = cpuHand.get(i).type;
				if (!cpuPlayerHand.contains(cardType)) {
					cpuPlayerHand.add(cardType);
				}
			}
			
			if (cpuPlayerHand.contains(options.get(choice))) {
				System.out.println("CPU: Yes.");
				for(int i = 0; i<cpuHand.size(); i++) {
					if (cpuHand.get(i).type == options.get(choice)) {
						playerHand.add(cpuHand.remove(i));
						i--;
					}
				}
			}
			
			else {
				System.out.println("CPU: Go fish.");
				
				playerTurn = 1;
			}
			
			// Check if Player has 4 of a kind
			int[] cardCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < playerHand.size(); i++) {
				switch (playerHand.get(i).type) {
				case "Ace": cardCount[0]++; break;
				case "Two": cardCount[1]++; break;
				case "Three": cardCount[2]++; break;
				case "Four": cardCount[3]++; break;
				case "Five": cardCount[4]++; break;
				case "Six": cardCount[5]++; break;
				case "Seven": cardCount[6]++; break;
				case "Eight": cardCount[7]++; break;
				case "Nine": cardCount[8]++; break;
				case "Ten": cardCount[9]++; break;
				case "Jack": cardCount[10]++; break;
				case "Queen": cardCount[11]++; break;
				case "King": cardCount[12]++; break;
				}
			}
			
			String[] cardNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
			for (int i = 0; i < 13; i++) {
				if (cardCount[i] == 4) {
					for(int j = 0; j < playerHand.size(); j++) {
						if (playerHand.get(j).type == cardNames[i]) {
							playerHand.remove(j);
							j--;
						}
					}
					playerScore++;
				}
			}
		}
		
		else {
		
		}
	}
	
	private static void clearScreen(){
		for(int i=0; i<100; i++)
			System.out.println();
	}
}