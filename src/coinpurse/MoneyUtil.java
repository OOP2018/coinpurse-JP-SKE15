package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	public static List<Coin> filterByCurrency(List<Coin> coins , String currency  ) {
  List<Coin> same = new ArrayList<>();
  for(Coin s : coins) {
	  if( s.getCurrency().equals(currency)) same.add(s);
  }
	return same;
	
	}

	public static  void printCoins(List<Coin> coins) {
		for(Coin coin: coins) {
			System.out.println(coin);
		}
	}
	
}
