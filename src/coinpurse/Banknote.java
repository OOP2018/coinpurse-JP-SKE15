package coinpurse;

/**
 * BankNote represents banknote (money) with a fixed value and currency.
 * @author Hayato Kawai
 *
 */
public class Banknote extends Money{

	private long serialNumber;
	
	/**
	 * Initialize new BankNote 
	 * @param value is banknote's value
	 * @param currency is banknote's currency
	 */
	public Banknote(double value, String currency,long serial) {
		super(value,currency);
		serialNumber = serial;
	}
	
	/**
	 * get banknote's serial number
	 * @return banknote's serial number
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * show the banknote's value and banknote's currency
	 * @return banknote's value with banknote's currency
	 */
	@Override
	public String toString() {
		
		return String.format("%.2f %s [%d]",value,currency,serialNumber);
	}
}
