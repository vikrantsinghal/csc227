import static org.junit.Assert.*;

import org.junit.Test;


public class DiceTest {

	@Test
	public void ConstructorAndToStringTest() {
		char[] a = {'A', 'B', 'C', 'D', 'E', 'F'};
		Dice dice = new Dice(a);
		System.out.println(dice.toString());
		System.out.println(dice.get());
		assertFalse(dice.isSelected());
		dice.select(true);
		assertTrue(dice.isSelected());
	}

}
