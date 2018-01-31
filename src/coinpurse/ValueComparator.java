package coinpurse;

import java.util.Comparator;

/**
 * A comparator of a Valuable class.
 * @author HAYATO
 *
 */
public class ValueComparator implements Comparator<Valuable> {

		 /**
	     * Compare two objects that implement Valuable.
	     * First compare them by currency, so that "Baht" < "Dollar".
	     * If both objects have the same currency, order them by value.
	     *
	     * @param a Valuable object to compare with b
	     * @param b valuable object
	     * @return 1 if have higher value and currency
	     *         0 if both are the same value and currency
	     *        -1 if have lower value and currency
	     */
	@Override
	    public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equals(b.getCurrency())) {
			if(a.getValue()> b.getValue()) return 1;
			else if (a.getValue()< b.getValue()) return -1;
			return 0;
		} else {
			if(a.getCurrency().charAt(0)>b.getCurrency().charAt(0)) return 1;
			else return-1;
		}
	}
}
