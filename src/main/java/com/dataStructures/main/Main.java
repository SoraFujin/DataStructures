package com.dataStructures.main;

import com.dataStructures.LinkedLists.SinglyLinkedList;

public class Main {
	public static void main(String[] args) {
		linkedLists();
	}

	public static void linkedLists() {
		SinglyLinkedList<Integer> sL = new SinglyLinkedList<>();
		sL.addAtHead(10);
		sL.addAtHead(7);
	}
}
