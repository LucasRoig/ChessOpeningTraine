package modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuissanceTest {

	@Test
	public void testPuissance() {
		assertTrue("2^0", Puissance.puissance(0) == 1);
		assertTrue("2^10", Puissance.puissance(10) == Math.pow(2, 10));
		assertTrue("2^60", Puissance.puissance(60) == Math.pow(2, 60));
		
		assertTrue("2^63", Puissance.puissance(63) == Long.parseUnsignedLong("9223372036854775808"));
	}

}
