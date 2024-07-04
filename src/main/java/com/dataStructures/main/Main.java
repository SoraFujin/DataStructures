package com.dataStructures.main;

import com.dataStructures.LinkedLists.SinglyLinkedList;

public class Main {
	public static void main(String[] args) {
		singlyLinkedList();
	}

	public static void singlyLinkedList() {
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<>();
		System.out.println("Sorted list");
		sl.addSorted(1);
		sl.addSorted(7);
		sl.addSorted(4);
		sl.addSorted(3);
		sl.addSorted(100);
		sl.addSorted(8);
		sl.traverse();
		System.out.println("--------------------");

		SinglyLinkedList<Integer> sl2 = new SinglyLinkedList<>();
		System.out.println("second list: ");
		sl2.add(10);
		sl2.add(120);
		sl2.add(1);
		sl2.add(7);
		sl2.add(77);
		sl2.add(9);
		sl2.traverse();

		// System.out.println();
		// SinglyLinkedList<String> sl2 = new SinglyLinkedList<>();
		// sl2.add("Hello");
		// sl2.add("World");
		// sl2.add("Niggers");
		// sl2.add("fuck");
		// sl2.traverse();
	}
}
