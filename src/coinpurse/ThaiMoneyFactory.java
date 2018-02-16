package coinpurse;
/**
 * MoneyFactory class for Thai Currency
 * @author Hayato Kawai
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
     
	  private static long serialNumber = 9999;
	  /**
	   * create money with Thai's local currency
	   * @param value is value that want to create	   
	   * @return coin if value < 20
	   * 		 BankNote if value > 20
	   * 		null if Thailand doesn't have that value coin or value banknote
	   */
	@Override
	public Valuable createMoney(double value) {
		if (value < 20) {
			if (value == 1 || value == 2 || value == 5 || value == 10)
				return new Coin(value, "Baht");
			else {
				System.out.println("Thailand doesn't have " + value + " coin");
			}
		} else {
			if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
				serialNumber++; 
				return new BankNote(value, "Baht",serialNumber);}
			else {
				System.out.println("Thailand doesn't have " + value + " note");
			}
		}
		return null;
	}
	

}
