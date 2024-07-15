package com.dataStructures.main;

import com.dataStructures.LinkedLists.SinglyLinkedList;

public class Main {
	public static void main(String[] args) {
		singlyLinkedList();
	}

	public static void singlyLinkedList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(10);
		list.add(5);
		list.add(15);
		list.add(20);
		list.add(3);
		list.add(7);
		list.add(3);

		System.out.println("Before sorting:");
		list.traverse();

		list.reverse();
		System.out.println("-----------------------");
		System.out.println("Reversed List");
		list.traverse();

		System.out.println(list.search(7));

	}
}
