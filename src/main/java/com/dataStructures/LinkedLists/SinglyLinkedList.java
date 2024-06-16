package com.dataStructers.LinkedLists;

public class SinglyLinkedList<T extends Comparable<T>> {
	private SLNode<T> head;

	public void add(T data) {
		SLNode<T> node = new SLNode<>(data);
		if (head == null) {
			head = node;
			node.getNext();
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
		SLNode<T> node = new SLNode<>(data);
		if (head == null) {
			head = node;
			head.setNext(head);
		}
		SLNode<T> current = head;
		while (current.getNext() != head) {
			if (current.getData().compareTo(data) > 0) {
				current.setNext(node);
			} else {
				node.setNext(current);
			}
		}
	}
	// traverse
	// reverse
	// search
	// delete
}
