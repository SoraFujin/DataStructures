package com.dataStructures.LinkedLists;

public class DLNode<T extends Comparable<T>> {
	private T data;
	private DLNode<T> next, prev;

	public DLNode(T data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setNext(DLNode<T> next) {
		this.next = next;
	}

	public DLNode<T> getNext() {
		return next;
	}

	public void setPrev(DLNode<T> prev) {
		this.prev = prev;
	}

	public DLNode<T> getPrev() {
		return prev;
	}

	public String toString() {
		return "data: " + data;
	}

}


