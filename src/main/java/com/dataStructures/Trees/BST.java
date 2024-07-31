package com.dataStructures.Trees;

public class BST <T extends Comparable<T>> {
	private TNode<T> root;

	public void insert(T data) {
		root = insert(root, data);
	}
	
		private TNode<T> insert(TNode<T> node, T data) {
			if (node == null) {
				return new TNode<>(data);
			}

			if (data.compareTo(node.getData()) < 0) {
				node.setLeft(insert(node.getLeft(), data));
			} else if (data.compareTo(node.getData()) > 0) {
				node.setRight(insert(node.getRight(), data));
			}

			return node;
		}

	public TNode<T> search(T data) {
		return search(data, root);
	}

	private TNode<T> search(T data, TNode<T> node) {
		if (node != null) {
		if(node.getData().compareTo(data) == 0) 
			return node;
		else if (node.getData().compareTo(data) > 0 && node.hasLeft())
			return search(data, node.getLeft());
		else if (node.getData().compareTo(data) < 0 && node.hasRight()); 
			return search(data, node.getRight());
		}

		return null;
	}

	public TNode<T> delete(T data) {
		TNode<T> current = root;
		TNode<T> parent = null;
		boolean isLeftChild = false;

		while (current != null && !current.getData().equals(data)) {
			parent = current;
			if (data.compareTo(current.getData()) < 0) {
				current = current.getLeft();
				isLeftChild = true;
			} else {
				current = current.getRight();
				isLeftChild = false;
			}
		}

		if (current == null) 
			return null;  

		if (!current.hasLeft() && !current.hasRight()) {
			if (current == root) {
				root = null;
			} else {
				if (isLeftChild) 
					parent.setLeft(null);
				else 
					parent.setRight(null);
			}
		}
		else if (current.hasLeft() && !current.hasRight()) {
			if (current == root) {
				root = current.getLeft();
			} else {
				if (isLeftChild) 
					parent.setLeft(current.getLeft());
				else 
					parent.setRight(current.getLeft());
			}
		}
		else if (!current.hasLeft() && current.hasRight()) {
			if (current == root) {
				root = current.getRight();
			} else {
				if (isLeftChild) 
					parent.setLeft(current.getRight());
				else 
					parent.setRight(current.getRight());
			}
		}
		else {
			TNode<T> successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else {
				if (isLeftChild) 
					parent.setLeft(successor);
				else 
					parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());  
		}
		return current;
	}

	private TNode<T> getSuccessor(TNode<T> node) {
		TNode<T> successor = node.getRight();
		TNode<T> successorParent = node;

		while (successor.getLeft() != null) {
			successorParent = successor;
			successor = successor.getLeft();
		}

		if (successor != node.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}

		return successor;
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(TNode<T> node) {
		if (node == null) {
			return 0;
		}
		if (node.isLeaf()) {
			return 1;
		} else if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		} else {
			return countLeaves(node.getLeft()) + countLeaves(node.getRight());
		}
	}


	public int height() {
		return height(root);
	}

	public int height(TNode<T> node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.getLeft());
		if (node.hasRight())
			right = height(node.getRight());
		return (left > right) ? (left + 1) : (right + 1);
	}

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TNode<T> node) {
		if (node == null)
			return true;
		if (node.hasLeft() && node.hasRight())
			return isFull(node.getLeft()) && isFull(node.getRight());
		return !node.hasLeft() && !node.hasRight();
	}


	public boolean isComplete() {
		int height = height();
		return isComplete(root, 0, height);
	}

	private boolean isComplete(TNode<T> node, int level, int height) {
		if (node == null)
			return true;
		if (level == height - 1)
			return node.hasLeft() && !node.hasRight();
		if (level < height - 1)
			return isComplete(node.getLeft(), level + 1, height) && isComplete(node.getRight(), level + 1, height);
		return false;
	}

	public void traverse() {
		inOrderTraverse(root);
		System.out.println();
	}

	public void inOrderTraverse(TNode<T> root) {
		if (root == null) {
			return;
		}
		inOrderTraverse(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrderTraverse(root.getRight());

	}

}
