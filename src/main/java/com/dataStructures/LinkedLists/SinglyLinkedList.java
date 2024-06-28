package com.dataStructures.LinkedLists;

public class SinglyLinkedList<T extends Comparable<T>> {
	private SLNode<T> head;

	public void add(T data) {
		SLNode<T> node = new SLNode<>(data);
		if (head == null) {
			head = node;
			node.setNext(head);
		} else {
			node.setNext(head);
			SLNode<T> current = head;
			while (current.getNext() != head) {
				current = current.getNext();
			}
			head = node;
			current.setNext(head);
		}
	}

	public void addSorted(T data) {
		SLNode<T> newNode = new SLNode<T>(data);
		SLNode<T> current = head;
	}

	public void reverse() {}

	public T delete(T data) {
		return null;
	}

	public T search(T data) {
		return null;
	}

	public void traverse() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		SLNode<T> current = head;
		do {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		} while (current != head);
		System.out.println();
	}
}

