package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
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
	 * Return the lager argument, based on sort order, using
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 */
	public static <E extends Comparable<? super E>> E max (E ... args) {
		if (args == null) throw new IllegalArgumentException();
		E max = args[0];
		for(int i = 0 ; i < args.length; i++) {
			max = (args[i].compareTo(max)> 0) ? args[i] : max;
		}
				System.out.println();
		return max;	
	}
	
	/**
	 *Filter coin by use the specified currency of coin.
	 * @param coins  is value's list with the same currency
	 * @param currency is the currency that want to use 
	 * @return a Valuable's list with the same currency
	 */
	public static <E extends Valuable>List<E> filterByCurrency(List<E> value, String currency) {
		List<E> same = new ArrayList<>();
		for (E s : value) {
			if (s.getCurrency().equals(currency))
				same.add(s);
		}
		return same;
	}

	public static void main(String[]args) {
		List<Valuable> coins = new ArrayList<Valuable>();
		String max = MoneyUtil.max("dog","zebra","cat");
		System.out.println(max);
		 
		Money m1 = new Coin(20,"Baht");
		Money m2 = new Banknote(500,"Baht", 0001);
		Money m3 = new Banknote(100,"Baht",0002);
		Money max2 =  (Money) MoneyUtil.max(m1,m2,m3);
		System.out.println(max2);
		
		
		List<Banknote> list = new ArrayList<Banknote>();
		list.add(new Banknote(10.0,"USD",011));
		list.add(new Banknote(500.0,"Baht",012));
		MoneyUtil.sortMoneys(list);
		
		List<Coin>  coins1 = Arrays.asList(new Coin(5,"Baht"), new Coin(0.1,"Ringgit"), new Coin(5,"Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins1,"Baht");
//		coins.add(new Coin(0.5, "Baht"));
//		coins.add(new Coin(2.0, "Baht"));
//		coins.add(new Coin(1.0, "Baht"));
//		coins.add(new Coin(1.0, "Baht"));
//		coins.add(new Coin(100.0, "Yen"));
//		coins.add(new Coin(2.0, "Baht"));
//		coins.add(new Coin(2.0, "Yen"));
//		coins.add(new Coin(2.0, "USD"));
//		// unsorted a list of coins
//		System.out.println("Unsorted money");
//		print(coins);
//				
//		System.out.println("-----------");
//		// sorted
//		Collections.sort(coins, comp);
//		System.out.println("Sorted money");
//		print(coins);
//		
//		System.out.println("-----------");
//		// Test compareTo() method
//		System.out.printf("%.2f compare to %.2f\n", coins.get(0).getValue(), coins.get(2).getValue());
//		System.out.println("Result: " + coins.get(0).compareTo(coins.get(2)));
//		System.out.printf("%.2f compare to %.2f\n", coins.get(3).getValue(), coins.get(1).getValue());
//		System.out.println("Result: " + coins.get(3).compareTo(coins.get(1)));
//		System.out.printf("%.2f compare to %.2f\n", coins.get(4).getValue(), coins.get(4).getValue());
//		System.out.println("Result: " + coins.get(4).compareTo(coins.get(4)));
//		
//		System.out.println("-----------");
//		
//		// Filter only coin that has same currency
//		List<Valuable> money = new ArrayList<Valuable>();
//		money.addAll(coins);
//		sortMoneys(money);
//		List<Valuable> moneyf = filterByCurrency(money, "Baht");
//		System.out.println("Filter money");
//		print(moneyf);
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
	 * the method for sort any list  of stuff that implement Valuable and print.
	 * @param list is the list of stuff that implement Valuable that want to sort
	 */
	public static void sortMoneys(List<? extends Valuable> list) {
		java.util.Collections.sort(list,comp);
	}
}
