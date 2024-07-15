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

	public SLNode<T> getMiddle(SLNode<T> head) {
		if (head == null) {
			return head;
		}

		SLNode<T> fast = head;
		SLNode<T> slow = head;

		while (fast.getNext() != head && fast.getNext().getNext() != head) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}

		return slow;
	}

	public SLNode<T> merge(SLNode<T> a, SLNode<T> b) {
		SLNode<T> newList = null;
		SLNode<T> tail = null;

		while (a != null && b != null) {
			SLNode<T> nextNode = null;

			if (a.getData().compareTo(b.getData()) < 0) {
				nextNode = a;
				a = a.getNext();
			} else {
				nextNode = b;
				b = b.getNext();
			}

			if (tail != null && tail != head) {
				tail.setNext(nextNode);
			} else {
				newList = nextNode;
				tail = nextNode;
			}

			if (a != null) {
				tail.setNext(a);
			} else {
				tail.setNext(b);
			}
		}

		return newList;
	}

	public SLNode<T> mergeSort(SLNode<T> head) {
		if (head == null || head.getNext() == head) {
			return head;
		}

		SLNode<T> middle = getMiddle(head);

		SLNode<T> leftList = head;
		SLNode<T> rightList = middle.getNext();

		middle.setNext(null);

		leftList = mergeSort(leftList);
		rightList = mergeSort(rightList);

		return merge(leftList, rightList);
	}

	public void sort() {
		if (head == null || head.getNext() == head) {
			return;
		}
		head = mergeSort(head);

		SLNode<T> current = head;
		while (current.getNext() != head) {
			current = current.getNext();
		}
		current.setNext(head);
	}


	public void reverse() {

		if (head == null) {
			System.out.println("List is empty");
		}
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

	public T delete(T data) {
		SLNode<T> current = head;
		SLNode<T> prev = null;

		if (head == null) {
			return null;
		}

		if (head.getData().equals(data) && head.getNext() == null)
			head = null;

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

