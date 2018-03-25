package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.strategy.GreedyWithdrawStrategy;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * A coin purse contains valuables. You can insert valuable, withdraw money,
 * check the balance, and check if the purse is full.
 * 
 * @author Hayato Kawai
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<>();
	private Comparator<Valuable> comp = new ValueComparator();
	private WithdrawStrategy strategy= new RecursiveWithdraw();
	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuable you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of valuable in the purse. This is the number of
	 * valuable, not their value.
	 * 
	 * @return the number of valuavle in the purse
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
	 * Return the capacity of the purse.
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
	 * Insert a valuable into the purse. The valuable is only inserted if the purse
	 * has space for it and the valuable has positive value. No worthless valuables!
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
	 * Withdraw the requested amount of money that have currency is Baht. Return an
	 * array of Valuable withdrawn from purse, or return null if cannot withdraw the
	 * amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		return withdraw(new Money(amount, "Baht"));
	}

	/**
	 * Withdraw the requested amount of money that have the same currency as amount.
	 * Return an array of Valuable withdrawn from purse, or return null if cannot
	 * withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		if (amount.getValue() < 0 || money.size() == 0|| amount == null)
			return null;
		
		List<Valuable> list = new ArrayList<>();
		if(strategy.withdraw(amount, money) == null) return null;
		list.addAll(strategy.withdraw(amount, money));
		
		for(Valuable val : list) {
			money.remove(val);
		}
		Valuable[] value = new Valuable[list.size()];
		list.toArray(value);
		return value;
	}

	/**
	 * toString returns a string description of the purse contents.
	 * 
	 * @return value's description.
	 */
	public String toString() {
		return this.count() + " money with value " + this.getBalance();
	}
}
