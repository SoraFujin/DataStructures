package com.dataStructures.LinkedLists;

public class DoublyLinkedList <T extends Comparable <T>>{
    private DLNode<T> head;
    private DLNode<T> tail;

    public void addAtHead(T data) {
        DLNode<T> newNode = new DLNode<>(data);
        
        if (head == null) { 
            head = newNode;
			tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }
	public void addAtTail(T data) {
		DLNode<T> newNode = new DLNode<>(data);
		DLNode<T> current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		newNode.setPrev(current);
		current = newNode;
	}
	
	public void addSorted(T data) {
		DLNode<T> newNode = new DLNode<>(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else if (data.compareTo(head.getData()) <= 0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		} else {
			DLNode<T> current = head;
			while (current.getNext() != null && data.compareTo(current.getNext().getData()) > 0) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			if (current.getNext() != null) {
				current.getNext().setPrev(newNode);
			} else {
				tail = newNode;
			}
			current.setNext(newNode);
			newNode.setPrev(current);
		}
	}

	public void reverse() {
		DLNode<T> current = head;
		DLNode<T> temp = null;

		while (current != null) {
			temp = current.getPrev();
			current.setPrev(current.getNext());
			current.setNext(temp);
			current = current.getPrev();
		}

		if (temp != null) {
			head = temp.getPrev();
		}
	}

	public DLNode<T> search(T data) {
		DLNode<T> current = head;

		while (current.getNext() != null) {
			if (current.getData().equals(data)) {
				return current;
			}
			current = current.getNext();
		}
		System.out.println("Data is not in the list");
		return null;
	}

	public DLNode<T> delete(T data) {
		if (head == null) {
			return null;
		}

		DLNode<T> current = head;

		if (data.equals(current.getData())) {
			if (current.getNext() == null) { 
				head = null;
			} else {
				head = current.getNext();
				head.setPrev(null);
			}
			return current;
		}

		while (current != null) {
			if (data.equals(current.getData())) {
				break;
			}
			current = current.getNext();
		}

		if (current == null) {
			return null;
		}
		DLNode<T> prev = current.getPrev();
		DLNode<T> next = current.getNext();

		if (prev != null) {
			prev.setNext(next);
		}

		if (next != null) {
			next.setPrev(prev);
		}

		return current;
	}

	public void traverse() {
		DLNode<T> current = head;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println();
	}
}
