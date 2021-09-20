package com.yml.datastructures;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    Node(T data2) {
        this.data = data2;
        next = null;
    }
}