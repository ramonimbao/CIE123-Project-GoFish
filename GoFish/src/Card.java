
public class Card {
	public static String type;
	public static String suit;
	
	public Card(int card){
		switch (card) {
		case 0: type = "Ace"; suit = "Clovers"; break;
		case 1: type = "Two"; suit = "Clovers"; break;
		case 2: type = "Three"; suit = "Clovers"; break;
		case 3: type = "Four"; suit = "Clovers"; break;
		case 4: type = "Five"; suit = "Clovers"; break;
		case 5: type = "Six"; suit = "Clovers"; break;
		case 6: type = "Seven"; suit = "Clovers"; break;
		case 7: type = "Eight"; suit = "Clovers"; break;
		case 8: type = "Nine"; suit = "Clovers"; break;
		case 9: type = "Ten"; suit = "Clovers"; break;
		case 10: type = "Jack"; suit = "Clovers"; break;
		case 11: type = "Queen"; suit = "Clovers"; break;
		case 12: type = "King"; suit = "Clovers"; break;
		case 13: type = "Ace"; suit = "Spades"; break;
		case 14: type = "Two"; suit = "Spades"; break;
		case 15: type = "Three"; suit = "Spades"; break;
		case 16: type = "Four"; suit = "Spades"; break;
		case 17: type = "Five"; suit = "Spades"; break;
		case 18: type = "Six"; suit = "Spades"; break;
		case 19: type = "Seven"; suit = "Spades"; break;
		case 20: type = "Eight"; suit = "Spades"; break;
		case 21: type = "Nine"; suit = "Spades"; break;
		case 22: type = "Ten"; suit = "Spades"; break;
		case 23: type = "Jack"; suit = "Spades"; break;
		case 24: type = "Queen"; suit = "Spades"; break;
		case 25: type = "King"; suit = "Spades"; break;
		case 26: type = "Ace"; suit = "Hearts"; break;
		case 27: type = "Two"; suit = "Hearts"; break;
		case 28: type = "Three"; suit = "Hearts"; break;
		case 29: type = "Four"; suit = "Hearts"; break;
		case 30: type = "Five"; suit = "Hearts"; break;
		case 31: type = "Six"; suit = "Hearts"; break;
		case 32: type = "Seven"; suit = "Hearts"; break;
		case 33: type = "Eight"; suit = "Hearts"; break;
		case 34: type = "Nine"; suit = "Hearts"; break;
		case 35: type = "Ten"; suit = "Hearts"; break;
		case 36: type = "Jack"; suit = "Hearts"; break;
		case 37: type = "Queen"; suit = "Hearts"; break;
		case 38: type = "King"; suit = "Hearts"; break;
		case 39: type = "Ace"; suit = "Diamonds"; break;
		case 40: type = "Two"; suit = "Diamonds"; break;
		case 41: type = "Three"; suit = "Diamonds"; break;
		case 42: type = "Four"; suit = "Diamonds"; break;
		case 43: type = "Five"; suit = "Diamonds"; break;
		case 44: type = "Six"; suit = "Diamonds"; break;
		case 45: type = "Seven"; suit = "Diamonds"; break;
		case 46: type = "Eight"; suit = "Diamonds"; break;
		case 47: type = "Nine"; suit = "Diamonds"; break;
		case 48: type = "Ten"; suit = "Diamonds"; break;
		case 49: type = "Jack"; suit = "Diamonds"; break;
		case 50: type = "Queen"; suit = "Diamonds"; break;
		case 51: type = "King"; suit = "Diamonds"; break;
	}
	}
	
	public static String getCardName(){
		return type + " of " + suit;
	}

}
