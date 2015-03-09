
public class Card {
	public static String type;
	public static String suit;
	
	public static void createCard(int cardType, int cardSuit){
		switch(cardType) {
		case 0: type = "Ace"; break;
		case 1: type = "Two"; break;
		case 2: type = "Three"; break;
		case 3: type = "Four"; break;
		case 4: type = "Five"; break;
		case 5: type = "Six"; break;
		case 6: type = "Seven"; break;
		case 7: type = "Eight"; break;
		case 8: type = "Nine"; break;
		case 9: type = "Ten"; break;
		case 10: type = "Jack"; break;
		case 11: type = "Queen"; break;
		case 12: type = "King"; break;

		
		}
		
		switch(cardSuit) {
		case 0: suit = "Clovers"; break;
		case 1: suit = "Spades"; break;
		case 2: suit = "Hearts"; break;
		case 3: suit = "Diamonds"; break;
		}
	}
	
	public static String getCardName(){
		return type + " of " + suit;
	}

}
