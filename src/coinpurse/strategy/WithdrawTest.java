package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Money;
import coinpurse.Valuable;
/**
 * test class for withdraw
 * @author HAYATO
 *
 */
public class WithdrawTest {
	private static final double TOL = 1.0E-6;
	private WithdrawStrategy strategy;
	private List<Valuable> money  ;
	private List<Valuable> removelist  ;
	private List<Valuable> removelist2  ;
	private List<Valuable> money2  ;
	
	
	/**
	 * Code to run before each test. Setup the "test fixture"
	 */
	@Before
	public void setUp() {
		strategy = new RecursiveWithdraw();
		money = new ArrayList<>();
		money2 = new ArrayList<>();
		removelist = new ArrayList<>();
		removelist2 = new ArrayList<>();
	}
	
	@Test 
	public void WithdrawOnething () {
		money.add(new Money(1.0, "Baht"));
		removelist = strategy.withdraw(new Money(1.0, "Baht"),money);
		assertEquals(1, removelist.size(),TOL);
		money.add(new Money(2.0, "Baht"));
		money.add(new Money(5.0, "Baht"));
		money2.add(new Money(7.0, "Baht"));
		money2.add(new Money(5.0, "Baht"));
		removelist =strategy.withdraw(new Money(2.0, "Baht"),money);
		assertEquals(1, removelist.size(),TOL);
		removelist2 = strategy.withdraw(new Money(7.0, "Baht"),money2);
		assertTrue(removelist.size()==removelist2.size());
	}
	
	@Test 
	public void WithdrawEverything () {
		money.add(new Money(2.0, "Baht"));
		money.add(new Money(5.0, "Baht"));
		removelist = strategy.withdraw(new Money(7.0, "Baht"),money);
		assertEquals(2, removelist.size(),TOL);
		money.add(new Money(2.0, "Baht"));
		money.add(new Money(5.0, "Baht"));
		money.add(new Money(2.0, "Baht"));
		money.add(new Money(10.0, "Baht"));
		money2.add(new Money(1.0, "Baht"));
		money2.add(new Money(10.0, "Baht"));
		money2.add(new Money(2.0, "Baht"));
		money2.add(new Money(3.0, "Baht"));
		removelist =strategy.withdraw(new Money(9.0, "Baht"),money);
		removelist2 =strategy.withdraw(new Money(6.0, "Baht"),money2);
		assertTrue(removelist.size()==removelist2.size());
	}
	
	@Test
	public void WithdrawDifferenceCurrency () {
		money.add(new Money(2.0, "Baht"));
		money.add(new Money(5.0, "Bath"));
		money2.add(new Money(5.0, "Yen"));
		money2.add(new Money(2.0, "Yen"));
		removelist =strategy.withdraw(new Money(2.0, "Yen"),money);
		removelist2 = strategy.withdraw(new Money(5.0, "Bath"),money);
		assertNull(removelist);
		assertEquals(1, removelist2.size(),TOL);
		
	}
	
	@Test
	public void WithdrawZero() {
		money.add(new Money(2.0, "Baht"));
		 removelist =strategy.withdraw(new Money(0.0, "Baht"),money);
		assertNull(removelist);
	}	

	
	@Test
	public void ImpossibleWithdraw() {
		money.add(new Money(2.0, "Baht"));
		money.add(new Money(5.0, "Baht"));
		strategy.withdraw(new Money(6.0, "Baht"),money);
		assertEquals(2, money.size(),TOL);
	}
	
	@Test
	public void WithdrawNull() {
		money2.add(new Money(2.0, "Baht"));
		 removelist2 =strategy.withdraw(null,money2);
		assertNull(removelist2);
	}
}
