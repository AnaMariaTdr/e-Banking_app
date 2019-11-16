package Validators;

public class validatorPIN {

	public boolean checkPIN(String PIN) {

		if (PIN.length() != 4)
			throw new NumberFormatException("PIN should be 4 digits long");
		for (int i = 0; i < PIN.length(); i++) {
			if (!Character.isDigit(PIN.charAt(i)))
				throw new NumberFormatException("PIN should contain only digits");
		}
		return true;
	}
}
