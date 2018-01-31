package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class is a test class of Coin.
 * @author Hayato Kawai
 */
public class MoneyUtil {
	/**
	 *Filter coin by use the specified currency of coin.
	 * @param coins  is value's list with the same currency
	 * @param currency is the currency that want to use 
	 * @return a Valuable's list with the same currency
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> coins, String currency) {
		List<Valuable> same = new ArrayList<>();
		for (Valuable s : coins) {
			if (s.getCurrency().equals(currency))
				same.add(s);
		}
		return same;
	}

	public void main() {
		List<Valuable> coins = new ArrayList<Valuable>();
		coins.add(new Coin(10.0, "Bath"));
		coins.add(new Coin(0.5, "Bath"));
		coins.add(new Coin(2.0, "Bath"));
		coins.add(new Coin(1.0, "Bath"));
		coins.add(new Coin(1.0, "Bath"));
		coins.add(new Coin(100.0, "Yen"));
		coins.add(new Coin(2.0, "Bath"));
		coins.add(new Coin(2.0, "Yen"));
		coins.add(new Coin(2.0, "USD"));
		sortCoins(filterByCurrency(coins, "Bath"));
	}

	/**
	 * method for print Value's list
	 * @param list is the coin's list that want to print
	 */
	public static void printCoins(List<Valuable> list) {
		for (Valuable coin : list) {
			System.out.println(coin);
		}
	}

	/**
	 * the method for sort value of coin and print.
	 * @param list is the value's list that want to sort
	 */
	public static void sortCoins(List<Valuable> list) {
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(list,comp);
		printCoins(list);
	}
}
