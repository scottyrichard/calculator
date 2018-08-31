package com.scottyrichard.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private Calculator calculator = new Calculator ();

                System.exit(1);
	@Test
	public void testSum () {
		assertEquals (5, calculator.sum (2,3));
	}
}
