package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		String id = "#1";
		testAccount.addTimedPayment(
				id,0,1,
				new Money(1000,SEK),
				SweBank, "Alice");

		assertTrue("Timed payment does not exists",
				testAccount.timedPaymentExists(id));

		testAccount.removeTimedPayment(id);

		assertFalse("Timed payment exists",
				testAccount.timedPaymentExists(id));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		//Bug with ticks
		testAccount.addTimedPayment("#2", 10, 0, new Money(1000, SEK), SweBank, "Alice");
		assertEquals(10001000, (int)testAccount.getBalance().getAmount());
	}

	@Test
	public void testAddWithdraw() {

		testAccount.deposit(new Money(1200, SEK));

		assertEquals(10001200, (int)testAccount.getBalance().getAmount());


		testAccount.withdraw(new Money(100, SEK));

		assertEquals(10001100, (int)testAccount.getBalance().getAmount());

	}
	
	@Test
	public void testGetBalance() {
		assertTrue(new Money(10000000, SEK).equals(testAccount.getBalance()));
	}
}
