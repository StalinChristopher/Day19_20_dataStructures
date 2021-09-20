package com.yml.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderedList<T> {

	public void run() throws FileNotFoundException {
		Scanner r = new Scanner(System.in);
		File file = new File("/Users/stalincd/Documents/Assignments/Day19_20_dataStructures/data/orderedList.txt");
		Scanner sc = new Scanner(file);

		String str;
		String s = "";
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			s = s + str;
		}
		sc.close();
		String[] arr = s.split(",");// to split the string array
		Integer[] array = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(array.getClass());
		bubbleSort(array);

		System.out.println("Enter the element");
		Integer user = r.nextInt();
		boolean b = search(user);
		if (b) {
			add(user);
		}
		write();
		display();
	}

	Node head;
	static Scanner r = new Scanner(System.in);

	/**
	 * @param <T>
	 * @return Size of the linkedList
	 */
	public <T extends Comparable<T>> int getSize() {
		int count = 0;
		if (head == null) {
			return 0;
		} else {

			Node<T> temp = head;
			while (temp != null) {
				count++;
				temp = temp.next;

			}
		}
		return count;
	}

	/**
	 * @param <T>
	 * @param index
	 * @return returns the element for the given index of the linkedList
	 */
	public <T extends Comparable<T>> T get(int index) {
		Node<T> temp = head;
		Node<T> prev = null;

		for (int i = 0; i <= index; i++) {
			prev = temp;
			temp = temp.next;
		}
		return (T) prev.data;
	}

	/**
	 * To add normal
	 * 
	 * @param <T>
	 * @param input
	 */
	private <T extends Comparable<T>> void addNormal(T input) {
		Node newNode = new Node(input);

		if (head == null)
			head = newNode;
		else {
			Node temp;
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	/**
	 * Compare and add
	 * 
	 * @param <T>
	 * @param data
	 */
	public <T extends Comparable<T>> void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null || head.data.compareTo(data) > 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null && temp.next.data.compareTo(data) < 0) {
				temp = temp.next;

			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	/**
	 * Remove element
	 * 
	 * @param <T>
	 * @param input
	 */
	public <T extends Comparable<T>> void pop(T input) {

		if (input.equals(head.data)) { // Removing the first element
			head = head.next;
			return;
		}
		Node temp = head.next;
		Node q = head;
		while (temp != null) {

			if (temp.data.equals(input)) {
				// System.out.println(temp.data);
				if (temp.next == null) {
					temp = temp.next;
					q.next = null;
				} else {
					q.next = temp.next;

					temp = temp.next;
				}
			} else {
				q = temp;
				temp = temp.next;
			}
		}

	}

	/**
	 * Take user input
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T extends Comparable<T>> T userInput() {

		T key = (T) r.next();
		return key;
	}

	/**
	 * Search the data
	 * 
	 * @param <T>
	 * @param input
	 * @return
	 */
	public <T extends Comparable<T>> boolean search(T input) {
		boolean flag = true;
		Node temp;
		temp = head;
		while (temp != null) {
			if (temp.data.equals(input)) {

				flag = false;
				pop(input);

				break;
			} else {
				temp = temp.next;
			}
		}
		return flag;
	}

	/**
	 * Display function
	 * 
	 * @param <T>
	 */
	public <T extends Comparable<T>> void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**
	 * Sort the elements
	 * 
	 * @param <T>
	 * @param a
	 * @return
	 */
	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {

		int len = a.length;
		T temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (T t : a) {
			addNormal(t);
		}

		System.out.println("Sorted array");
		printArray(a);
		return a;
	}

	/**
	 * Print the array
	 * 
	 * @param <T>
	 * @param a
	 */
	public static <T extends Comparable<T>> void printArray(T[] a) {
		for (T t : a) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

	public void write() {
		try {

			FileWriter fWriter = new FileWriter(
					"/Users/stalincd/Documents/Assignments/Day19_20_dataStructures/data/orderListOutput.txt");

			String text = "";

			// fWriter.write(text);

			Node temp;
			temp = head;
			while (temp.next != null) {
				text = text + temp.data + "----->";
				temp = temp.next;
			}
			text = text + temp.data;
			fWriter.write(text);
			fWriter.close();

			System.out.println("File is created successfully with the content.");
		}

		// Catch block to handle if exception occurs
		catch (IOException e) {
			// Print the exception
			System.out.print(e.getMessage());
		}
	}

}
