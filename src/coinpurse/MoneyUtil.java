package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a test class of Coin.
 * @author Hayato Kawai
 */
public class MoneyUtil {
	/**
	 *Filter coin by use the specified currency of coin.
	 * @param coins  is coin's list with the same currency
	 * @param currency is the currency that want to use 
	 * @return a Coin's list with the same currency
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> same = new ArrayList<>();
		for (Coin s : coins) {
			if (s.getCurrency().equals(currency))
				same.add(s);
		}
		return same;
	}

	/**
	 * testsortCoins is for check the compareTo method
	 */
	public void testsortCoin() {
		List<Coin> coins = new ArrayList<Coin>();
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
	 * method for print Coin's list
	 * @param coins is the coin's list that want to print
	 */
	public static void printCoins(List<Coin> coins) {
		for (Coin coin : coins) {
			System.out.println(coin);
		}
	}

	/**
	 * the method for sort value of coin and print.
	 * @param coins is the coin's list that want to sort
	 */
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
		printCoins(coins);
	}
}
