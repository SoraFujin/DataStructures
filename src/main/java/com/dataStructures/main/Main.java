package com.dataStructures.main;

import com.dataStructures.LinkedLists.SinglyLinkedList;

public class Main {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<>();
		sl.addSorted(1);
		sl.addSorted(7);
		sl.addSorted(4);
		sl.addSorted(3);
		sl.addSorted(100);
		sl.addSorted(8);
		sl.traverse();
	}
}
