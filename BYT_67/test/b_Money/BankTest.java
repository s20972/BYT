package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("Nordea", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals("SEK", Nordea.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		assertTrue(Nordea.getAccounts().containsKey("Bob"));
		assertFalse(Nordea.getAccounts().containsKey("Ulrika"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		//Account doesnt exists
		DanskeBank.deposit("Gabriella", new Money(Integer.valueOf(550), DKK));

		assertEquals(Integer.valueOf(550),
				DanskeBank.getBalance("Gabriella"));

		assertFalse(DanskeBank.getAccounts().containsKey("Unknown"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {

		assertEquals(Integer.valueOf(0),
				SweBank.getBalance("Bob"));

		SweBank.deposit("Bob",new Money(10000,SEK));
		SweBank.withdraw("Bob",new Money(10000,SEK));

		assertEquals(Integer.valueOf(0),
				SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {

		assertEquals(Integer.valueOf(0) , SweBank.getBalance("Bob"));

		SweBank.deposit("Bob",new Money(1500,SEK));

		assertEquals(Integer.valueOf(1500), SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
}
