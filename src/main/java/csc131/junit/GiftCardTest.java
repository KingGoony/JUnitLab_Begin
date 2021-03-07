package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
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
	
	@Test
	public void deduct_RemainingBalance2() 
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String expected;
		
		issuingStore = 1337;
		balance = 100.0;
		card = new GiftCard(issuingStore, balance);
		
		expected = "Invalid Transaction";
		
		assertEquals("deduct_RemaingBalance()", expected, card.deduct(-100.0));
	}
	
	@Test
	public void deduct_RemainingBlance3() 
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String expected;
		
		issuingStore = 1337;
		balance = 100.0;
		card = new GiftCard(issuingStore, balance);
		
		balance -= 105.0;
		expected = "Amount Due: " + String.format("%6.2f", Math.abs(balance));
		
		assertEquals("deduct_RemaingBalance()", expected, card.deduct(105.0));
	}
	
	@Test
	public void constructor_IncorrectBalance_Low() 
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1, 100.0);});
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000, 100.0);});
	}
}
