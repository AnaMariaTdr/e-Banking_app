package Functional_tests1;

import static org.junit.Assert.*;

import org.junit.Test;

import Validators.validatorPIN;

public class PIN_Test1 {

	@Test
	public void validFourDigitsPIN() {
		validatorPIN validator = new validatorPIN();
		boolean result = validator.checkPIN("1234");
		assertTrue("first value", result);
		boolean result1 = validator.checkPIN("5678");
		assertTrue("second value", result1);
	}

	@Test(expected = NumberFormatException.class)

	public void invalidThreeDigitsPIN() {
		validatorPIN validator = new validatorPIN();
		validator.checkPIN("123");

	}

	@Test(expected = NumberFormatException.class)

	public void invalidFiveDigitsPIN() {
		validatorPIN validator = new validatorPIN();
		validator.checkPIN("12345");

	}

	@Test(expected = NumberFormatException.class)

	public void nonNumericPIN() {

		validatorPIN validator = new validatorPIN();
		validator.checkPIN("hello");

	}

}
