package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(Integer.valueOf(1000), EUR10.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
		assertEquals(SEK, SEK0.getCurrency());
		assertEquals(EUR, EUR0.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("(0) (SEK)",this.SEK0.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(0), SEK0.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK0.equals(EUR0));
	}

	@Test
	public void testAdd() {
		assertTrue(EUR10.equals(EUR10.add(EUR0)));
		assertFalse(EUR10.equals(EUR10.add(EUR10)));;
	}

	@Test
	public void testSub() {
		assertEquals(Integer.valueOf(2000), EUR20.sub(EUR0).getAmount());
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
	}

	@Test
	public void testNegate() {
		assertFalse(EUR10.equals(EUR10.negate()));
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, EUR10.compareTo(EUR10));
		assertEquals(1, EUR20.compareTo(SEK100));
		assertEquals(-1, SEK100.compareTo(EUR20));
	}
}
