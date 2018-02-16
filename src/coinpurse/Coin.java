package coinpurse;

/**
 * Coins represents coinage (money) with a fixed value and currency.
 * @author Hayato Kawai
 */
public class Coin extends Money  {

	/**
	 * Constructor for a coin with a value and currency  
	 * if the value is negative change that to 0
	 * @param value is coin's value
	 * @param currency is coin's currency
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	/**
	 * show the coin's value and coin's currency
	 * return coin's value with coin's currency
	 */
	@Override
	public String toString() {
		return String.format("%.2f-%s",value,currency);
	}
}
