package coinpurse;

/**
 * BankNote represents banknote (money) with a fixed value and currency.
 * @author Hayato Kawai
 *
 */
public class BankNote extends Money{

	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	
	/**
	 * Initialize new BankNote 
	 * @param value is banknote's value
	 * @param currency is banknote's currency
	 */
	public BankNote(double value, String currency) {
		super(value,currency);
		serialNumber = nextSerialNumber++;
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
		return String.format("%.2f-%s note [%d]",value,currency,serialNumber);
	}
}
