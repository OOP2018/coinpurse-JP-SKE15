package coinpurse;

import java.util.ResourceBundle;
 /**
  * This class is class for read file
  * @author Hayato Kawai
  *
  */
public class ReadFile {

	/**
	 * read the file 
	 * @return factory
	 */
	public static MoneyFactory read() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factory + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		
		if (factory == null)
			System.exit(1);
		return factory;
	}
}
