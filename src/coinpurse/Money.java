package coinpurse;

/**
 * Money is a Superclass of Coin and BankNote that have a same methods
 * @author Hayato Kawai
 *
 */
public class Money implements Valuable {

	protected double value;
	protected String currency;

	public Money(double value , String currency) {
		this.value = value;
		this.currency= currency;
	}

	/**
	 * Get  money's value
	 * @return money's value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Compares this object with the specified object for order.
	 * @param v is the object that want to compare the value with this value
	 */
	public int compareTo(Valuable v) {
		 if(this.currency.equals(v.getCurrency()))
			 return Double.compare(this.value, v.getValue());
		 else  return this.currency.compareTo(v.getCurrency());
	}
	
	 
	/**
	 * Get  money's currency
	 * @return money's currency
	 */
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
		Money other = (Money) arg;
		return this.value == other.value && this.currency.equals(other.currency);
	}

}