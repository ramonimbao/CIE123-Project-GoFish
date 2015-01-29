import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Tester {

	@Test
	public void testDraw52Cards() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckDeckDuplicates() {
		//fail("Not yet implemented");
		ArrayList deck = new ArrayList(52); 
		for (int i=0; i<5; i++) {
			deck = GoFishMain.draw52Cards();
			assertEquals(false, GoFishMain.checkDeckDuplicates(deck));
		}
	}

	@Test
	public void testGetCardName() {
		assertEquals("Ace of Clovers", GoFishMain.getCardName(0));
		assertEquals("Ace of Spades", GoFishMain.getCardName(13));
		assertEquals("Ace of Hearts", GoFishMain.getCardName(26));
		assertEquals("Ace of Diamonds", GoFishMain.getCardName(39));
		assertEquals("Card of Destiny", GoFishMain.getCardName(52));
	}
}
