package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import Functional1.Account;
import Functional1.Owner;

public class test {
	private static Map<Integer, Owner> bankAccount = new HashMap<>();

	public static <K, V> String mapToString(Map<K, V> map) {
		return map.entrySet().stream().map(entry -> "PIN=" + " " + entry.getKey() + " " + entry.getValue())
				.collect(Collectors.joining("\n "));
	}

	public static void main(String[] args) throws IOException {

		readingTheFile();
	}

	public static void readingTheFile() throws IOException {

		Account acc = new Account();
		String path = "Users.txt";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			int i = 1;

			int pin = Integer.parseInt(parts[i]);
			String firstName = parts[i + 2];
			String lastName = parts[i + 4];
			String accNo = parts[i + 6];
			int sold = Integer.parseInt(parts[i + 8]);

			StringBuilder sb = new StringBuilder();
			sb.append(pin);
			sb.append(firstName);
			sb.append(lastName);
			sb.append(accNo);
			sb.append(sold);

			System.out.println(sb.toString());

			Owner or = new Owner(firstName, lastName, accNo, 0);

			bankAccount.put(0000, or);
			System.out.println(bankAccount);

		}
		reader.close();

	}
}
