package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO import List, ArrayList, and Collections
// You will use Collections.sort() to sort the coins

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Hayato Kawai
 */
public class Purse {
	/** Collection of objects in the purse. */
	// TODO declare a List of Coins named "money".

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;
	private List<Coin> money = new ArrayList<Coin>();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
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
	// TODO write accessor method for capacity. Use Java naming convention.
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
		// TODO complete this method. Avoid writing duplicate code (Don't Repeat
		// Yourself)
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		boolean ok = false;
		if (!this.isFull() && coin.getValue() != 0) {
			ok = money.add(coin);
		}
		return ok;
		// if (coin.getValue() <= 0)
		// return false;
		// if (!isFull()) {
		// money.add(coin);
		// return true;
		//
		// }
		// if (isFull())
		// return false;
		// // if the purse is already full then can't insert anything.
		// // TODO complete the insert method
		// return false;
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
	public Coin[] withdraw(double amount) {

		// TODO don't allow to withdraw amount < 0
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
		List<Coin> purse = new ArrayList<>();
		double amountNeededToWithdraw = amount;
		Collections.sort(money);
		Collections.reverse(money);
		if (amountNeededToWithdraw < 0 || money.size() == 0 || this.getBalance() < amountNeededToWithdraw)
			return null;
		for (Coin coin : money) {
			if (amountNeededToWithdraw >= coin.getValue()) {
				amountNeededToWithdraw -= coin.getValue();
				purse.add(coin);
			}
			if (amountNeededToWithdraw == 0)
				break;
		}
		for (Coin re : purse) {
			money.remove(re);
		}
		if (amountNeededToWithdraw != 0)
			return null;

		Coin[] moneys = new Coin[purse.size()];
		purse.toArray(moneys);
		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return moneys; // TODO replace this with real code
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	public String toString() {
		return this.count() + " coins with value " + this.getBalance();
	}

}
// TODO When you finish, there should not be any TODO comments, including this
// one!
