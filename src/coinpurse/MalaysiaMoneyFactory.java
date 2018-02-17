package coinpurse;
/**
 * MoneyFactory class for Malaysia's Currency
 * @author Hayato Kawai
 * 
 */
public class MalaysiaMoneyFactory extends MoneyFactory {

	  private static long serialNumber = 9999;
	  /**
	   * create money with Malaysia's local currency
	   * @param value is value that want to create	   
	   * @return coin if value < 1
	   * 		 BankNote if value > 1
	   * 		null if Malaysia doesn't have that value coin or value banknote
	   */
		@Override
		public Valuable createMoney(double value) {
			if (value < 1) {
				if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5)
					return new Coin(value*100, "Sen");
				else {
					System.out.println("Malaysia doesn't have " + value + " coin");
				}
			} else {
				if (value == 1 || value == 2 || value == 5 ||value ==10|| value == 50 || value == 100) {
					serialNumber++; 
					return new BankNote(value, "Ringgit",serialNumber);}
				else {
					System.out.println("Malaysia doesn't have " + value + " note");
				}
			}
			return null;
		}
		

}
