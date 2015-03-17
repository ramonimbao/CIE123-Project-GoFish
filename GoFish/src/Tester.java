import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Tester {
	@Test
	public void testCheckDeckDuplicates() {
		//fail("Not yet implemented");
		ArrayList deck = new ArrayList(52); 
		for (int i=0; i<10; i++) {
			deck = GoFishMain.draw52Cards();
			assertEquals(false, GoFishMain.checkDeckDuplicates(deck));
		}
	}
	
	@Test
	public void testDealCards() {
		ArrayList deck = new ArrayList(52);
		ArrayList playerHand = new ArrayList(39);
		ArrayList cpuHand = new ArrayList(39);
		
		for(int i=0; i<10; i++) {
			deck = GoFishMain.draw52Cards();
			GoFishMain.dealCards(deck, playerHand, cpuHand);
			assertEquals(7, playerHand.size());
			assertEquals(7, cpuHand.size());
			assertEquals(38, deck.size());
		}
	}
	
	@Test
	public void testGetPlayerChoice() {
		ArrayList options = new ArrayList(13);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Please enter a choice from a-m");
			char choice = GoFishMain.getPlayerChoice(options);
			int converted = (int)(choice - 'a');
			if (converted > options.size() - 1) converted = options.size() - 1;
			if (converted < 0) converted = 0;
			assertEquals(converted, GoFishMain.convertCharToIntWithLimits(choice, options));
		}
	}
}
