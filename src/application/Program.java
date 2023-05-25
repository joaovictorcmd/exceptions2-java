package application;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		NumberFormat nf = NumberFormat.getCurrencyInstance();

		try {
			System.out.println("ENTER ACCOUNT DATA");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			System.out.println();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);

			System.out.println("New balance: " + nf.format(account.getBalance()));
		} catch (BusinessException be) {
			System.err.println("Withdraw error: " + be.getMessage());
		} catch (InputMismatchException ime) {
			System.err.println("Unexpected error");
			main(args);
		}

		sc.close();
	}

}
