import java.util.ArrayList;

import ec.util.MersenneTwisterFast;


public class GoFishMain {
	/**
	 * 
	 */
	private static MersenneTwisterFast RNG = new MersenneTwisterFast();
	
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
		ArrayList deck = new ArrayList(52);
		deck = draw52Cards();
		System.out.println(checkDeckDuplicates(deck));
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
}