package coinpurse;

/**
 * An interface for objects having a monetary value and currency. 
 * @author Hayato Kawai
 */
public interface Valuable {
	
	/**
	 * get object's value
	 * @return object's value
	 */
	public double getValue();
	
	/**
	 * get object's currency
	 * @return object's currency
	 */
	public String getCurrency();
}
