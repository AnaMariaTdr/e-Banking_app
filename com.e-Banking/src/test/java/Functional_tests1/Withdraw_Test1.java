package Functional_tests1;

import static org.junit.Assert.*;

import org.junit.Test;

import Validators.validatorWithdraw;

public class Withdraw_Test1 {

	@Test
	public void validUnder5000Withdraw() {
		validatorWithdraw validator = new validatorWithdraw();
		boolean result = validator.checkWithdraw(4000);
		assertTrue("first check", result);
		boolean result1 = validator.checkWithdraw(3000);
		assertTrue("second check", result1);
	}

	@Test
	public void invalidAbove5000Withdraw() {
		validatorWithdraw validator = new validatorWithdraw();
		boolean result = validator.checkWithdraw(5010);
		assertFalse(result);

	}

	@Test
	public void invalidNotMultipleOfTenWithdraw() {
		validatorWithdraw validator = new validatorWithdraw();
		boolean result = validator.checkWithdraw(4233);
		assertFalse(result);

	}

}

