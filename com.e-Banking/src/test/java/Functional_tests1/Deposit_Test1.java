package Functional_tests1;

import static org.junit.Assert.*;

import org.junit.Test;

import Validators.validatorDeposit;

public class Deposit_Test1 {

	@Test
	public void validDepositAmount() {
		validatorDeposit validator = new validatorDeposit();
		boolean result = validator.checkDeposit(1231);
		assertTrue(result);
		boolean result1 = validator.checkDeposit(4543);
		assertTrue(result1);
	}

	@Test
	public void invalidDepositAmount() {
		validatorDeposit validator = new validatorDeposit();
		boolean result = validator.checkDeposit(5);
		assertFalse(result);

	}

	@Test
	public void invalidTooBigDepositAmount() {
		validatorDeposit validator = new validatorDeposit();
		boolean result = validator.checkDeposit(12345);
		assertFalse(result);

	}

}
