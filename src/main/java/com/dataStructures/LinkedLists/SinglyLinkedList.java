 package com.dataStructures.LinkedLists;

public class SinglyLinkedList<T extends Comparable<T>> {
	private SLNode<T> head;

	public void add(T data) {
		SLNode<T> node = new SLNode<>(data);
		if (head == null) {
			head = node;
			node.setNext(head); 
		} else {
			SLNode<T> current = head;
			while (current.getNext() != head) {
				current = current.getNext();
			}
			node.setNext(head); 
			current.setNext(node); 
			head = node; 
		}
	}

	public void addSorted(T data) {
		SLNode<T> newNode = new SLNode<T>(data);
		if (head == null) {
			head = newNode;
			newNode.setNext(head);
		} else {
			SLNode<T> current = head;
			SLNode<T> prev = null;
			if (data.compareTo(head.getData()) < 0) {
				while (current.getNext() != head) {
					current = current.getNext();
				}
				newNode.setNext(head);
				head = newNode;
				current.setNext(head);
			} else {
				do {
					prev = current;
					current = current.getNext();
				} while (current != head && data.compareTo(current.getData()) > 0);

				newNode.setNext(current);
				prev.setNext(newNode);
			}
		}
	}

	public void reverse() {

		if (head == null) 
			System.out.println("List is empty");
		
		SLNode<T> last = head;
		SLNode<T> prev = head;
		SLNode<T> current = head.getNext();
		head = head.getNext();

		while (head != last) {
			head = head.getNext();
			current.setNext(prev);
			prev = current;
			current = head;
		}
		current.setNext(prev);
		head = prev;

	}
	public SLNode<T> delete(T data) {
		if (head == null) 
				return null;

		SLNode<T> current = head;
		SLNode<T> prev = null;

		while (!data.equals(current.getData())) {
			if (current.getNext() == head) {
				System.out.println("Data not in the list");
				break;
			}
			prev = current;
			current = current.getNext();
		}

		if (current == head && current.getNext() == head) {
			head = null;
			return head;
		}


		if (current == head) {
			prev = head;
			while (prev.getNext() != head)
				prev = prev.getNext();
			
			head = current.getNext();
			prev.setNext(head);
		}

			else if (current.getNext() == head) 
				prev.setNext(head);
			else 
				prev.setNext(current.getNext());
		
		return null;

	}
	public T search(T data) {
		if (head == null) {
			return null;
		}

		SLNode<T> current = head;

		do {
			if (current.getData().equals(data)) {
				return current.getData();
			}
			current = current.getNext();
		} while (current != head);
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

