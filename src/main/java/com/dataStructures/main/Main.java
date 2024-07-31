package com.dataStructures.main;

import com.dataStructures.LinkedLists.DoublyLinkedList;
import com.dataStructures.LinkedLists.SinglyLinkedList;
import com.dataStructures.List.List;
import com.dataStructures.Trees.AVL;
import com.dataStructures.Trees.BST;

public class Main {
	public static void main(String[] args) {
		System.out.println("##################################");
		System.out.println("Circular singly linked list: ");
		singlyLinkedList();

		System.out.println("##################################");
		System.out.println("Doubly Linked list: ");
		DoublyLinkedList();

		System.out.println("##################################");
		System.out.println("BST: ");
		BST();

		System.out.println("##################################");
		System.out.println("AVL: ");
		AVL();

		System.out.println("##################################");
		System.out.println("List: ");
		List();


	}

	public static void singlyLinkedList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(10);
		list.add(5);
		list.add(15);
		list.add(20);
		list.add(3);
		list.add(7);
		list.add(3);

 		System.out.println("-----------------------");
		System.out.println("Original List: ");
		list.traverse();

		System.out.println("-----------------------");
		list.reverse();
		System.out.println("Reversed List");
		list.traverse();

		list.reverse();

		System.out.println("-----------------------");
		System.out.println("Adding sorted: ");
		list.addSorted(32);
		list.addSorted(2);
		list.addSorted(2);
		list.addSorted(4);
		list.addSorted(1);
		list.traverse();

		System.out.println("-----------------------");
		System.out.println("Search Method: ");

		System.out.println("Searching for 7: ");
		System.out.println(list.search(7));
		

		System.out.println("-----------------------");
		System.out.println("Deleting Method: ");
		list.delete(10);
		list.delete(15);
		list.delete(7);
		list.delete(3);
		System.out.println("List after deleting");
		list.traverse();
	}

	public static void DoublyLinkedList() { 
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addAtHead(10);
		list.addAtHead(40);
		list.addAtHead(20);
		list.addAtHead(30);
		list.addAtHead(80);
 		System.out.println("-----------------------");
		System.out.println("Original List: ");
		System.out.println("Adding at the head of the list: ");
		list.traverse();

 		System.out.println("-----------------------");
		System.out.println("Adding at the end of the list: ");
		list.addAtTail(50);
		list.addAtTail(70);
		list.addAtTail(7);
		list.addAtTail(20);
		list.traverse();

 		System.out.println("-----------------------");
		System.out.println("Adding sorted to the list");
		list.addSorted(8);
		list.addSorted(0);
		list.addSorted(1);
		list.addSorted(7);
		list.addSorted(3);
		list.traverse();

		System.out.println("-----------------------");
		System.out.println("Reversed List");
		list.reverse();
		list.traverse();

		list.reverse();

		System.out.println("-----------------------");
		System.out.println("Searching Method");
		System.out.println(list.search(1));
		System.out.println(list.search(1123));

		System.out.println("-----------------------");
		System.out.println("Deleting Method:");
		System.out.println(list.delete(8));
		System.out.println(list.delete(70));
		System.out.println(list.delete(0));
		System.out.println(list.delete(20));
		list.traverse();
	}

	public static void BST(){
		BST<Integer> bst = new BST<>();
		bst.insert(7);
		bst.insert(8);
		bst.insert(4);
		bst.insert(3);
		bst.insert(1);
		bst.insert(10);
		bst.traverse();

		System.out.println("Tree Height: " + bst.height());

		System.out.println("Tree Leaves: " + bst.countLeaves());

		System.out.println("Is the tree Full?: " + bst.isFull());

		System.out.println("Is the tree complete?: " + bst.isComplete());

		System.out.println("-----------------------");
		System.out.println("Search Method:");
		System.out.println(bst.search(7));
		System.out.println(bst.search(10));
		System.out.println(bst.search(123));

		System.out.println("-----------------------");
		System.out.println("Delete Method:");
		bst.delete(7);
		bst.delete(1);
		bst.delete(10);
		bst.traverse();

		bst.insert(7);
		bst.insert(1);
		bst.insert(10);
	}

	public static void AVL(){
  AVL<Integer> avl = new AVL<>();
    
    avl.insert(7);
    avl.insert(8);
    avl.insert(4);
    avl.insert(3);
    avl.insert(1);
    avl.insert(10);
    
    System.out.println("AVL Tree Traversal:");
    avl.traverse();
    
    System.out.println("-----------------------");
    
    System.out.println("Search Method:");
    System.out.println(avl.search(7)); 
    System.out.println(avl.search(10)); 
    System.out.println(avl.search(123)); 
    
    System.out.println("-----------------------");
    
    System.out.println("Delete Method:");
    avl.delete(7);
    avl.delete(1);
    avl.delete(10);
    
    avl.traverse();
    
    avl.insert(7);
    avl.insert(1);
    avl.insert(10);
    
    System.out.println("AVL Tree Traversal after reinsertion:");
    avl.traverse();
	}

	public static void List() {
		List<Integer> list = new List<>(10);
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(60);
		list.add(50);
		list.add(70);
		list.add(30);
		list.add(90);
		list.add(80);
		list.add(100);

		list.traverse();

		System.out.println("List size: " + list.size());
		
		System.out.println("-----------------------");
		System.out.println("Search Method:");
		System.out.println(list.search(90));

		System.out.println("-----------------------");
		System.out.println("Delete Method:");
		list.delete(10);
		list.traverse();	

	}
}
