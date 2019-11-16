package Functional1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Account {

	static File file = new File("Users.txt");
	static Path path = Paths.get("Users.txt");

	static int pin;
	static Owner or;

	// we create a static map where where put the PIN as an integer and the Owner
	private static Map<Integer, Owner> bankAccount = new HashMap<>();

	public static void readingTheFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int i = 1;
			pin = Integer.parseInt(parts[i]);
			String firstName = parts[i + 2];
			String lastName = parts[i + 4];
			String accNo = parts[i + 6];
			int sold = Integer.parseInt(parts[i + 8]);
			or = new Owner(firstName, lastName, accNo, sold);

			bankAccount.put(pin, or);

		}
		reader.close();

	}

	// account number generator, we create the account number
	// AccountNumber_Generator acc1 = new AccountNumber_Generator();

	// we need to create a file where we put the account no and pins for each owner

	// this needs to be initialized once

	// final String accNo1 = acc1.generateAccount();

//	public void initiateAccounts() throws IOException {
//		// here we initiate the account after we open the ATM
//
//		bankAccount.put(0000, new Owner("NotSpecified", "NotSpecified", "7675756", 0));
//	}

	// to string for the map
	public static <K, V> String mapToString(Map<K, V> map) {
		return map.entrySet().stream().map(entry -> "PIN=" + " " + entry.getKey() + " " + entry.getValue())
				.collect(Collectors.joining("/n"));
	}

//getter for bank account
	public Map<Integer, Owner> getBankAccount() {
		return bankAccount;
	}

// setter for bank account 
	public void setBankAccount(Map<Integer, Owner> bankAccount) {
		Account.bankAccount = bankAccount;
	}

	// add deposit method
	public void addDeposit(Owner or, int amountDeposited) throws IOException {
		int initialAmount = or.getSoldAmount();
		// TODO Auto-generated method stub
		or.setSoldAmount(initialAmount + amountDeposited);
		System.out.println("Amount has been deposited");

		FileWriter fw = new FileWriter("C://Users//anatudor//Desktop//ana//ATM_Project//" + or.getFirstName() + ".txt");
		fw.write("Deposited amount : " + amountDeposited);
		fw.flush();
		fw.close();

	}

	void removeAmount(Owner or, int amountToBeWithdraw) throws IOException {
		int initialAmount = or.getSoldAmount();
		if (initialAmount > amountToBeWithdraw) {
			or.setSoldAmount(initialAmount - amountToBeWithdraw);
			System.out.println("Amount has been wihdraw");
			FileWriter fw = new FileWriter(
					"C://Users//anatudor//Desktop//ana//ATM_Project//" + or.getFirstName() + ".txt");
			fw.write("Amount withdrawed: " + amountToBeWithdraw);
			fw.flush();
			fw.close();

		} else {
			System.out.println("Insuficient funds ! ");
		}
	}

	public void changePIN(int newPIN) {

// if validator checks ok(true), we change the PIN 

		bankAccount.remove(pin);
		bankAccount.put(newPIN, or);

	}

	public void createNEWAccount() throws IOException {
		int pin = 1234;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your First Name");
		String fn = sc.next();
		System.out.println("Please enter your Last Name");
		String ln = sc.next();
		String accNo = new AccountNumber_Generator().generateAccount();

		bankAccount.put(pin, new Owner(fn, ln, accNo, 0));
		System.out.println("Account has been generate with : PIN = " + pin + " " + " First Name: " + fn + " "
				+ "Last Name: " + " " + "Account No " + accNo + " " + "Initial Sold amount of 0");

		System.out.println(bankAccount);

		File file = new File(fn + ".txt");
		file.createNewFile();

		sc.close();
		closingAndWriting();
	}

	public void displayHistory() throws IOException {
		System.out.println(or.getFirstName() + "    " + or.getAccNo());

		BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\anatudor\\Desktop\\ana\\ATM_Project\\" + or.getFirstName() + ".txt"));
		String currLine;

		while ((currLine = reader.readLine()) != null) {
			System.out.println(currLine);
		}
		reader.close();

	}

	// when closing the app, all modification will be written to the file
	void closingAndWriting() throws IOException {

		FileWriter filewriter = new FileWriter(file);
		filewriter.write(mapToString(bankAccount));
		filewriter.close();

	}

}
