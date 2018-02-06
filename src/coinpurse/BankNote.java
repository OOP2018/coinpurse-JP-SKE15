package coinpurse;

/**
 * BankNote represents banknote (money) with a fixed value and currency.
 * @author Hayato Kawai
 *
 */
public class BankNote implements Valuable{

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	/**
	 * Initialize new BankNote 
	 * @param value is banknote's value
	 * @param currency is banknote's currency
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		serialNumber = nextSerialNumber++;
	}
	
	/**
	 * get banknote's value
	 * @return banknote's value
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * get banknote's currency
	 * @return banknote's currency
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * get banknote's serial number
	 * @return banknote's serial number
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 *Compares this object to the specified object.
	 * @param obj is the object that use to compare with this object
	 * @return true if obj is  banknote and the value and the currency of the objects are the same
	 */
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		BankNote other = (BankNote) obj;
		if( obj instanceof BankNote)  {
			if( this.value == other.value && this.currency.equals(other.currency)) equal = true;
		}
		return equal;
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
