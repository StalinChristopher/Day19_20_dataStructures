package com.yml.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnOrderedList<T extends Comparable> {
    Node head;

    public void unorderedList() {
        readFile();
        display();
        getUserInput();
        display();
        writeFile();
    }

    /**
     * @param <T> Read words from words.txt file
     */
    public <T extends Comparable<T>> void readFile() {
        Scanner sc;
        try {
            sc = new Scanner(new File("/Users/stalincd/Documents/Assignments/Day19_20_dataStructures/data/words.txt"));

            String whole = "";
            while (sc.hasNext()) {
                whole = whole + sc.next() + " ";
            }
            T[] array = (T[]) whole.split(",");
            // add(array);
            for (T t : array) {
                add(t);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param <T>
     * @param data add element to the linkedList
     */
    public <T extends Comparable<T>> void add(T data) {

        Node newNode = new Node(data);

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
     * @param <T> Method to display elements of the linkedList
     */
    public <T> void display() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    /**
     * @param <T> Method to obtain user input
     */
    public <T extends Comparable<T>> void getUserInput() {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter word you wanna search");
        T input = (T) r.next();
        search(input);

    }

    /**
     * @param <T>
     * @param element Method to search a given element
     */
    private <T extends Comparable<T>> void search(T element) {
        Node temp;
        temp = head;
        while (temp != null) {
            if (temp.data.equals(element)) {
                remove(element);
                break;
            } else {
                temp = temp.next;
            }
        }
        if (temp == null) {
            add(element);
        }
    }

    /**
     * @param <T>
     * @param input Method to remove an element from the linkedList
     */
    private <T> void remove(T input) {
        if (input.equals(head.data)) { // Removing the first element
            head = head.next;
            return;
        }
        Node temp = head.next;
        Node q = head;
        while (temp != null) {
            if (temp.data.equals(input)) {
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
     * Write into output file
     */
    public void writeFile() {
        try {
            FileWriter writer = new FileWriter(
                    "/Users/stalincd/Documents/Assignments/Day19_20_dataStructures/data/unorderedlistOutput.txt");
            Node temp;
            temp = head;
            while (temp.next != null) {
                writer.write(temp.data + " ");
                temp = temp.next;
            }
            writer.write(temp.data + "");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
