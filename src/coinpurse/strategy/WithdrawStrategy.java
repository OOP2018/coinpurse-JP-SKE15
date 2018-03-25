package coinpurse.strategy;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * 
 * @author Hayato Kawai
 *
 */
public interface WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals the requested amount.
	 * @param money2 is the amount of money to withdraw, with currency
	 * @param money the contents that are available for possible withdraw.
	 * 		  Must not be null, but may be an empty list. This list is not modified.
	 * @return if a solution is found, return a List containing references frowm 
	 * 		   the money parameter (List) whose sum equals the amount.
	 * 		   if a solution is not found, may be return null. 
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> purse);
}
