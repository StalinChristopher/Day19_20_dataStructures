package com.yml.main;

import java.io.FileNotFoundException;

import com.yml.datastructures.OrderedList;
import com.yml.datastructures.UnOrderedList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to data structures program");
		// UnOrderedList o1 = new UnOrderedList();
		// o1.unorderedList();
		
		OrderedList o2 = new OrderedList<>();
		o2.run();

	}

}
