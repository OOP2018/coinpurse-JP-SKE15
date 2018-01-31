package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Hayato Kawai
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money  = new ArrayList<>();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double value = 0.0;
		for (int i = 0; i < money.size(); i++) {
			value = value + money.get(i).getValue();
		}
		return value;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() == capacity)
			return true;
		else
			return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param value
	 *            is a Value object to insert into purse
	 * @return true if value inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		boolean ok = false;
		if (!this.isFull() && value.getValue() != 0) {
			ok = money.add(value);
		}
		return ok;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		/*
		 * See lab sheet for outline of a solution, or devise your own solution. The
		 * idea is to be greedy. Try to withdraw the largest coins possible. Each time
		 * you choose a coin as a candidate for withdraw, add it to a temporary list and
		 * decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0 then you found a
		 * solution! Now, use the temporary list to remove coins from the money list,
		 * and return the temporary list (as an array).
		 */
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		// Your code might use some other variable for the remaining amount to withdraw.
		List<Valuable> purse = new ArrayList<>();
		Comparator<Valuable> comp = new ValueComparator() ;
		double amountNeededToWithdraw = amount;
		Collections.sort(money,comp);
		Collections.reverse(money);
		if (amountNeededToWithdraw < 0 || money.size() == 0 || this.getBalance() < amountNeededToWithdraw)return null;
		for (Valuable value : money) {
			if (amountNeededToWithdraw >= value.getValue()) {
				amountNeededToWithdraw -= value.getValue();
				purse.add(value);
			}
			if (amountNeededToWithdraw == 0)
				break;
		}
		if (amountNeededToWithdraw != 0)
			return null;
		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		for (Valuable re : purse) {
			money.remove(re);
		}
		Valuable[] moneys = new Valuable[purse.size()];
		purse.toArray(moneys);
		return moneys;
	}

	/**
	 * toString returns a string description of the purse contents. 
	 * @return value's description.
	 */
	public String toString() {
		return this.count() + " coins with value " + this.getBalance();
	}
}
