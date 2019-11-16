package Functional1;

import Validators.*;
import java.util.Random;

public class AccountNumber_Generator {
	// this will be used for new customers.
	// and also to generate initial accounts
	private String accountNumber;

	public void setAccount(String account) {
		accountNumber = account;
	}

	public String getAccount() {
		return accountNumber;
	}

	public String generateAccount() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();

		sb.append("1");
		// first number in Account should be 1
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));
		sb.append(Integer.toString((rand.nextInt(9) + 1)));

		ValidatorAccount vA = new ValidatorAccount();
		boolean check = vA.checkAccountNumber(sb.toString());
		if (check == true) {
//if the account we created passes the check below, we set the Account
			setAccount(sb.toString());

		}
		return getAccount();
	}

}
