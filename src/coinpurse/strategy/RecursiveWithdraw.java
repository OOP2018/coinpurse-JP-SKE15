package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * Class for use recursive withdraw
 * @author Hayato Kawai
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {
	private List<Valuable> list = new ArrayList<>();
	private Comparator<Valuable> comp = new ValueComparator();
	private boolean firstWithdraw = true;

	/**
	 * This method is a recursive withdraw.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {

		if (amount == null)
			return null;
		
		double amountVal = amount.getValue();
		
		if (firstWithdraw == true) {
			if (amountVal == 0)
				return null;
		}
		if (amountVal == 0)
			return new ArrayList<>();
		if (amountVal < 0 || money.size() == 0)
			return null;
		
		Valuable val = money.get(0);
		firstWithdraw = false;
		
		if (amount.getCurrency().equals(val.getCurrency())) {
			list = withdraw(new Money(amountVal - val.getValue(), amount.getCurrency()),
					money.subList(1, money.size()));
			if (list != null) {
				list.add(val);
				Collections.sort(list, comp);
				Collections.reverse(list);
				return list;
			}
		}
		
		return withdraw(amount, money.subList(1, money.size()));

	}

}