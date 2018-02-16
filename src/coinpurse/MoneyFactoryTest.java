package coinpurse;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class for test the MoneyFactory with JUnit
 * 
 * @author Hayato Kawai
 *
 */
public class MoneyFactoryTest {

	@Test
	public void testSetGetInstance() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
		MoneyFactory.setFactory(new MalaysiaMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalaysiaMoneyFactory");
	}

	@Test
	public void testCurrency() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable value1 = factory.createMoney("1000.0");
		Valuable value2 = factory.createMoney(5);
		assertEquals(value1.getCurrency(), "Baht");
		assertEquals(value2.getCurrency(), "Baht");

		MoneyFactory.setFactory(new MalaysiaMoneyFactory());
		factory = MoneyFactory.getInstance();
		value1 = factory.createMoney("1000.0");
		value2 = factory.createMoney(5);
		Valuable value3 = factory.createMoney(0.05);
		assertEquals(value1, null);
		assertEquals(value2.getCurrency(), "Ringgit");
		assertEquals(value3.getCurrency(), "Sen");
	}
}
