package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class is a test class of Coin.
 * @author Hayato Kawai
 */
public class MoneyUtil {
	
	private static Comparator<Valuable> comp = new ValueComparator();
	/**
	 *Filter coin by use the specified currency of coin.
	 * @param coins  is value's list with the same currency
	 * @param currency is the currency that want to use 
	 * @return a Valuable's list with the same currency
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> value, String currency) {
		List<Valuable> same = new ArrayList<>();
		for (Valuable s : value) {
			if (s.getCurrency().equals(currency))
				same.add(s);
		}
		return same;
	}

	public static void main(String[]args) {
		List<Valuable> coins = new ArrayList<Valuable>();
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(100.0, "Yen"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(2.0, "Yen"));
		coins.add(new Coin(2.0, "USD"));
		// unsorted a list of coins
		System.out.println("Unsorted money");
		print(coins);
				
		System.out.println("-----------");
		// sorted
		Collections.sort(coins, comp);
		System.out.println("Sorted money");
		print(coins);
		
		System.out.println("-----------");
		// Test compareTo() method
		System.out.printf("%.2f compare to %.2f\n", coins.get(0).getValue(), coins.get(2).getValue());
		System.out.println("Result: " + coins.get(0).compareTo(coins.get(2)));
		System.out.printf("%.2f compare to %.2f\n", coins.get(3).getValue(), coins.get(1).getValue());
		System.out.println("Result: " + coins.get(3).compareTo(coins.get(1)));
		System.out.printf("%.2f compare to %.2f\n", coins.get(4).getValue(), coins.get(4).getValue());
		System.out.println("Result: " + coins.get(4).compareTo(coins.get(4)));
		
		System.out.println("-----------");
		
		// Filter only coin that has same currency
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(coins);
		sortMoneys(money);
		List<Valuable> moneyf = filterByCurrency(money, "Baht");
		System.out.println("Filter money");
		print(moneyf);
	}

	/**
	 * method for print Value's list
	 * @param list is the coin's list that want to print
	 */
	public static void print(List<Valuable> list) {
		for (Valuable value : list) {
			if(value.getValue() == 0) System.out.print("");
			else System.out.print(value+" ");
		}
		System.out.println();
		}
	

	/**
	 * the method for sort value of coin and print.
	 * @param list is the value's list that want to sort
	 */
	public static void sortMoneys(List<Valuable> list) {
		java.util.Collections.sort(list,comp);
	}
}
