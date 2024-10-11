package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExeptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("enter account date");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdraw = sc.nextDouble();
			Account account = new Account(number, holder, balance, withdraw);
			sc.nextLine();

			System.out.print("deseja fazer um saque ou um deposito? ");
			String r = sc.next();
			if (r.equals("deposito")) {
				System.out.print("Enter amount for deposit:");
				Double amount = sc.nextDouble();
				account.deposit(amount);
			} else if (r.equals("saque")) {
				System.out.print("Enter amount for withdraw:");
				Double amount = sc.nextDouble();
				account.withdraw(amount);
			}
			System.out.println("New balance:" + account.getBalance());
		} catch (DomainExeptions e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro");
		}
		sc.close();

	}

}
