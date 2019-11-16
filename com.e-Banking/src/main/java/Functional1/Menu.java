package Functional1;

import java.io.FileWriter;
import java.io.IOException;
import Validators.*;
import java.util.Scanner;

public class Menu extends Console {

	static Account accounts = new Account();
// we open the scan here because we will use input from the keyboard multiple times

	Scanner sc = new Scanner(System.in);

	int pinFromKeyboard;

	public void start() throws IOException {
		Account.readingTheFile();

		System.out.println("Are you a new customer ? YES/NO");
		String answer = sc.next();

		switch (answer) {
		case "YES":

			accounts.createNEWAccount();

			break;
		case "NO":
			System.out.println("Please enter your PIN");
			checkPIN();

			break;
		default:
			System.out.println("Please try Again !");

		}

	}

	public void checkPIN() throws IOException {

		while (sc.hasNext()) {
			int i = sc.nextInt();
			if (accounts.getBankAccount().containsKey(i)) {
// here we assign the object bank account created earlier to the account to which the pin from the keyboard matches
				pinFromKeyboard = i;
				optionsSwitchStatement();

				System.out.println("Welcome ! ");

			}

			else {
				System.out.println("Your PIN is invalid. Please try again");
			}

		}

	}

	public void optionsSwitchStatement() throws IOException {
		System.out.println("Please select what would you like to do?");
		System.out.println("1. Verify current available amount ");
		System.out.println("2. Deposit amount");
		System.out.println("3. Withdraw");
		System.out.println("4. Change PIN");
		System.out.println("5. Transfer Money");
		System.out.println("6.View History");

		int optionFromKeyboard = sc.nextInt();
		Owner or = accounts.getBankAccount().get(pinFromKeyboard);

		switch (optionFromKeyboard) {

		case 1:
			System.out.println("The current amount is : " + (or.getSoldAmount()));

			break;
		case 2:
			System.out.println("Please enter amount to be deposited");
			validatorDeposit vd = new validatorDeposit();

			int amountDeposited = sc.nextInt();
			boolean check = vd.checkDeposit(amountDeposited);
			if (check == true) {
				accounts.addDeposit(or, amountDeposited);

			}
			break;

		case 3:
			System.out.println("Please enter the amount you wish to withdraw");
			validatorWithdraw vw = new validatorWithdraw();
			@SuppressWarnings("unused")
			int amountToBeWithdraw = sc.nextInt();
			boolean check2 = vw.checkWithdraw(amountToBeWithdraw);

			if (check2 == true) {

				accounts.removeAmount(or, amountToBeWithdraw);
			}

			break;
		case 4:
			System.out.println("Please enter the new PIN");
			validatorPIN validator = new validatorPIN();
			// we check the new PIN with out validator
			int pin = sc.nextInt();
			boolean check3 = validator.checkPIN(Integer.toString(pin));
			if (check3 == true) {
				accounts.changePIN(pin);
			}
			break;

		case 5:
			System.out.println("Please enter the account to which you would like to transfer");
			ValidatorAccount validator2 = new ValidatorAccount();
			String transferAccount = sc.next();
			boolean check4 = validator2.checkAccountNumber(transferAccount);
			if (check4 == true) {
				System.out.println("Please enter the amount you wish to transfer");
				int transferAmount = sc.nextInt();
				validatorWithdraw vw2 = new validatorWithdraw();
				boolean check5 = vw2.checkWithdraw(transferAmount);
				if (check5 == true) {
					System.out.println("Amount has been transfered to account : " + transferAccount);
					FileWriter fw = new FileWriter(or.getFirstName() + "history.txt");
					fw.write("Deposited amount : " + transferAmount + "to account : " + transferAccount);
					fw.flush();
					fw.close();
					accounts.removeAmount(or, transferAmount);
					
				}
			}
			break;
		case 6:
			System.out.println("History Display  -------------------- ");
			accounts.displayHistory();
			break;

		default:

			System.out.println("Option selected is not a valid option");
			break;
		}
		otherOptions();
	}

	public void otherOptions() throws IOException {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("If you wish to get back to the main menu, please press 1");
		System.out.println("If you wish to cancel please press 2 ");
		int optionFromKeyboard = sc1.nextInt();

		switch (optionFromKeyboard) {
		case 1:
			optionsSwitchStatement();
			break;

		case 2:
			stop();
			break;

		default:
			System.out.println("Option is invalid. Canceling this request");
			break;
		}
		sc1.close();
	}

	private void stop() throws IOException {
		// TODO Auto-generated method stub
		accounts.closingAndWriting();
		System.out.println("Thank you and Have a Great Day ! ");

	}

}
