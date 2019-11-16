package Validators;

import Functional1.*;

public class ValidatorAccount extends Account {

	public boolean checkAccountNumber(String Account) {

		if (Account.length() < 8 || Account.length() > 8) {
			System.out.println("Account Number must be 8 digits long");
			return false;
		} else {

			return true;
		}

	}
}
