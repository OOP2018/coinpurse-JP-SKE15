package coinpurse;
/**
 *  Factory class of making money for make separate Currency
 * @author Hayato Kawai
 *
 */
public abstract class MoneyFactory {
 
	private static MoneyFactory factory;
	abstract Valuable createMoney(double value);
	
	/**
	 * get an instance of MoneyFactory. 
	 * @return factory is  an object of a subclass 
	 */
		public static MoneyFactory getInstance() {
		if(factory == null) factory = new ThaiMoneyFactory();
		return factory;
	 }
	 
		/**
		 * create new money object in the local currency.
		 * If the value is not a valid currency amount, 
		 * then throw IllegalArgumentException. 
		 * @param factory is object of a subclass
		 */
	public static void setFactory(MoneyFactory f) {
		factory = f;
	}
	
	/**
	 * This method is for convenience of the U.I.
	 *  The default implementation of this method converts parameter to a double and calls createMoney(double),
	 *   but a subclass may override it to permit other parameter values.
	 *   Throws: IllegalArgumentException if value of string is not a number. 
	 * @param value of money that want to create
	 * @return money
	 */
	Valuable createMoney(String value) {
		 double money = 0;
		 try {
		  money = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println(value+ "is not a number");
		}
		return createMoney(money);	 
	 }
}