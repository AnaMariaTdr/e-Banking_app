package Validators;

public class validatorWithdraw {

	public boolean checkWithdraw(int Withdraw) {

		if (Withdraw > 5000) {
			System.out.println("Withdraw must be under 5000 RON");
			return false;
		} else if (Withdraw % 10 != 0) {
			System.out.println("Withdraw must be multiple of 10");
			return false;
		}
		return true;
	}

}
