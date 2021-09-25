package com.yml.datastructures;

import java.util.Scanner;

import com.yml.queue.Queue;

public class BankingCashCounter {
	public static long minBal = 500;
	public static Scanner scanner = new Scanner(System.in);
	public static Queue queue = new Queue();
	public static boolean flag;
	public static int n;

	public static void bankingCashCounter() {
		System.out.println("Enter the number of people");
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			queue.enqueue(i);
		}

		while (n != 0) {
			long cash = minBal;
			System.out.println("Balance :" + cash);

			while (true) {
				System.out.println("Enter your option\n1.Withdraw\n2.Deposit\nAny Other Option: Exit");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					withdraw(cash);
					break;

				case 2:
					deposit(cash);
					break;

				default:
					return;
				}
			}
		}

	}

	/**
	 * method to deposit the cash
	 * 
	 * @param cash
	 */
	private static void deposit(long cash) {
		System.out.println("Enter the required amount to be deposited");
		long amount1 = scanner.nextInt();
		System.out.println("Amount deposited successfully");
		queue.dequeue();
		cash = cash + amount1;
		flag = true;
		System.out.println("Balance : " + cash);
		n--;
	}

	/**
	 * method to withdraw the cash
	 * 
	 * @param cash
	 */
	private static void withdraw(long cash) {

		System.out.println("Enter the amount to withdraw:");
		long amount = scanner.nextInt();
		if (amount > cash) {
			System.out.println("Insufficient balance");
		} else
			cash = cash - amount;
		flag = true;
		queue.dequeue();
		n--;
		System.out.println("Balance :  " + cash);
	}
}
