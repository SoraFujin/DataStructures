package com.dataStructures.LinkedLists;

public class DoublyLinkedList <T extends Comparable <T>>{
	DLNode<T> head;

	public void addAtHead(T data){
		DLNode<T> newNode = new DLNode<>(data);
		if (head.getNext() != null) {
			head.setNext(newNode);	
			newNode = head;
		}
	}	
}
