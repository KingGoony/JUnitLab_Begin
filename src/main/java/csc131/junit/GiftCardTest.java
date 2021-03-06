package csc131.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest 
{
	@Test
	public void getIssuingStore() 
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.0;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String expected;
		
		issuingStore = 1337;
		balance = 100.0;
		card = new GiftCard(issuingStore, balance);
		
		balance -= 100.0;
		expected = "Remaining Balance: " + String.format("%6.2f", Math.abs(balance));
		
		assertEquals("deduct_RemaingBalance()", expected, card.deduct(100.0));
	}
}
