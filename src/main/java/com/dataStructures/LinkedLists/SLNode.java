package com.dataStructures.LinkedLists;

public class SLNode<T extends Comparable<T>> {
	private SLNode<T> next;
	private T data;

	public SLNode(T data) {
		this.data = data;
	}

	public SLNode<T> getNext() {
		return next;
	}

	public void setNext(SLNode<T> next) {
		this.next = next;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public String toString() {
		return "Data: " + data;
	}
}
