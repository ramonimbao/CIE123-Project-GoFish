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
}