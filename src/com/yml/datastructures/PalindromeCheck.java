package com.yml.datastructures;

import java.util.Scanner;

import com.yml.dequeue.Dequeue;

public class PalindromeCheck {
	public static void palindromeCheck() {
		Dequeue<Character> dequeue = new Dequeue<>(20);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String");
		String string = scanner.nextLine();
		String front = "";
		String rear = "";

		
		for (int i = 0; i < string.length(); i++) {
			dequeue.insertRear(string.charAt(i));
		}
		for (int i = 0; i < string.length(); i++) {
			rear += dequeue.getRear();
			dequeue.deleteRear();
		}
		for (int i = 0; i < string.length(); i++) {
			dequeue.insertRear(string.charAt(i));
		}
		for (int i = 0; i < string.length(); i++) {
			front += dequeue.getFront();
			dequeue.deleteFront();
		}
		
		if (rear.equals(front)) {
			System.out.println("String is palindrome");
		} else {
			System.out.println("String is not palindrome");
		}
		scanner.close();
	}
}
