package coinpurse;

import java.util.Scanner;

/**
 * Demo for MoneyFactory
 * 
 * @author Hayato Kawai
 *
 */
public class MoneyFactoryDemo {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("[t] = Thai ,[m] = Malay :");
		String country = sc.next();
		if (country.equalsIgnoreCase("t"))
			ThaiDemo();
		if (country.equalsIgnoreCase("m"))
			MalayDemo();
	}

	/**
	 * Demo for ThaiMoneyFactory
	 */
	public static void ThaiDemo() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();

		while (true) {
			System.out.print("Input money or [e] to exit : ");
			String testscommand = sc.next();
			if (testscommand.equalsIgnoreCase("e"))
				System.exit(0);
			Valuable value = factory.createMoney(testscommand);
			if (value != null)
				System.out.println(value);
			else
				System.out.println("Please try again");
		}
	}

	/**
	 * Demo for MalaysiaMoneyFactory
	 */
	public static void MalayDemo() {
		MoneyFactory.setFactory(new MalaysiaMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();

		while (true) {
			System.out.print("Input money or [e] to exit : ");
			String testscommand = sc.next();
			if (testscommand.equalsIgnoreCase("e"))
				System.exit(0);
			Valuable value = factory.createMoney(testscommand);
			if (value != null)
				System.out.println(value);
			else
				System.out.println("Please try again");
		}
	}
}
