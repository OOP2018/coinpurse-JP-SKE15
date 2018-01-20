package coinpurse;

/**
 * Coins represents coinage (money) with a fixed value and currency.
 * @author Hayato Kawai
 */
public class Coin implements Comparable<Coin> {

	private double value;
	private String currency;

	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.currency;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		return this.value == other.value && this.currency.equals(other.currency);
	}

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

	@Override
	public String toString() {
		return this.value+"-"+this.currency;
	}
}
