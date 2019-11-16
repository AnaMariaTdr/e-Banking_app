package Functional_tests1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Validators.ValidatorAccount;

public class Account_Test {

	@Test
	public void validAccountNumber() {
		ValidatorAccount validator = new ValidatorAccount();
		boolean result = validator.checkAccountNumber("18277584");
		assertTrue(result);
	}

	@Test(expected = NumberFormatException.class)

	public void invalidTooShortAccountNumber() {
		ValidatorAccount validator = new ValidatorAccount();
		boolean result = validator.checkAccountNumber("1827758");
		assertFalse(result);

	}

	@Test(expected = NumberFormatException.class)

	public void invalidTooLongAccountNumber() {
		ValidatorAccount validator = new ValidatorAccount();
		boolean result = validator.checkAccountNumber("182775845");
		assertFalse(result);

	}

}
