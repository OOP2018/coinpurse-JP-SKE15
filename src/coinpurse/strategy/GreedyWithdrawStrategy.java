package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * The withdraw strategy that will advice the withdraw method in the purse class what
 * to with draw to the user but not change anything to the list .
 * @author Hayato Kawai
 *
 */
public class GreedyWithdrawStrategy implements WithdrawStrategy {
	private Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Find and return items form a collection whose total value equals
	 * the requested amount.
	 * @param amount is the amount of money to withdraw,with currency.
	 * @param money the contents that are available for possible withdraw.
	 * 		  Must not be null,but may be an empty list.
	 * 		  This list is not modified.
	 * @return if a solution is found, return a list containing references
	 * 		   from the money parameter (List) whose sum equals the amount.
	 * 		   If a solution is not found, return empty list
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> purse) {
		List<Valuable> valuez = new ArrayList<Valuable>();
		if( amount == null || amount.getValue() ==0) return null;
		double amountNeededToWithdraw = amount.getValue();
		Collections.sort(purse, comp);
		Collections.reverse(purse);
		for (Valuable value : purse) {
			double value2 = value.getValue();
			if (value.getCurrency().equalsIgnoreCase(amount.getCurrency())) {
				if (amountNeededToWithdraw >= value2) {
					amountNeededToWithdraw -= value2;
					valuez.add(value);
				}
			}
			if (amountNeededToWithdraw == 0 )
				break;
		}
		if (amountNeededToWithdraw != 0)
			return null;

		return valuez;
	}
}
