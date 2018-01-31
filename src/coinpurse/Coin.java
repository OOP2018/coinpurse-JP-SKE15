package coinpurse;

/**
 * Coins represents coinage (money) with a fixed value and currency.
 * @author Hayato Kawai
 */
public class Coin implements Comparable<Coin>,Valuable {

	private double value;
	private String currency;

	/**
	 * Constructor for a coin with a value and currency  
	 * if the value is negative change that to 0
	 * @param value is coin's value
	 * @param currency is coin's currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get  coin's value
	 * @return coin's value
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get  coin's currency
	 * @return coin's currency
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compares this object to the specified object.
	 * @param arg is the object that use to compare with this object
	 * @return true if the value and the currency of the objects are the same
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		return this.value == other.value && this.currency.equals(other.currency);
	}

	/**
	 * Compares this object with the specified object for order.
	 * @param coin is the object that want to compare the value with this value
	 * @return a negative integer if value of this object is less than value of the specified object,
	 *			zero if value of this object equal to value of the specified object or
	 *			a positive integer if value of this object is greater than value of the specified object.
	 */
	@Override
	public int compareTo(Coin coin) {
		Coin other = (Coin) coin;
		if (this.value > other.value)
			return 1;
		else if (this.value < other.value)
			return -1;
		else
			return 0;
	}

	/**
	 * show the coin's value and coin's currency
	 * return coin's value with coin's currency
	 */
	@Override
	public String toString() {
		return this.value+"-"+this.currency;
	}
}
