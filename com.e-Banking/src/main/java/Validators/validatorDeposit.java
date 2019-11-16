package Validators;

public class validatorDeposit {

	public boolean checkDeposit(int Deposit) {

		if (Deposit < 10) {
			System.out.println("Amount deposited should be at least 10 RON");
			return false;
		} else if (Deposit > 5000) {
			System.out.println("For amounts bigger than 5000, please address the request to our offices");
			return false;
		} else
			return true;
	}

}
