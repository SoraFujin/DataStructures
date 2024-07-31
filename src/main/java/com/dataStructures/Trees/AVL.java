package com.dataStructures.Trees;

public class AVL<T extends Comparable<T>> {
    private TNode<T> root;

    public TNode<T> rotateRight(TNode<T> node) {
        TNode<T> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }

    public TNode<T> rotateLeft(TNode<T> node) {
        TNode<T> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    public TNode<T> rotateRightToLeft(TNode<T> node) {
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }

    public TNode<T> rotateLeftToRight(TNode<T> node) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    private int calculateHeight(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight())) + 1;
    }

    private int getHeightDifference(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return calculateHeight(node.getLeft()) - calculateHeight(node.getRight());
    }

    private TNode<T> rebalance(TNode<T> node) {
        int balance = getHeightDifference(node);
        if (balance > 1) {
            if (getHeightDifference(node.getLeft()) >= 0) {
                return rotateRight(node);
            } else {
                return rotateLeftToRight(node);
            }
        } else if (balance < -1) {
            if (getHeightDifference(node.getRight()) <= 0) {
                return rotateLeft(node);
            } else {
                return rotateRightToLeft(node);
            }
        }
        return node;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private TNode<T> insert(T data, TNode<T> node) {
        if (node == null) {
            return new TNode<>(data);
        }

        int cmp = data.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (cmp > 0) {
            node.setRight(insert(data, node.getRight()));
        } else {
            return node;
        }

        node = rebalance(node);
        return node;
    }

    public TNode<T> search(T data) {
        return search(data, root);
    }

    private TNode<T> search(T data, TNode<T> node) {
        if (node == null || data.compareTo(node.getData()) == 0) {
            return node;
        }

        if (data.compareTo(node.getData()) < 0) {
            return search(data, node.getLeft());
        } else {
            return search(data, node.getRight());
        }
    }

    public void delete(T data) {
        root = delete(data, root);
    }

    private TNode<T> delete(T data, TNode<T> node) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (cmp > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            TNode<T> temp = getMinValueNode(node.getRight());
            node.setData(temp.getData());
            node.setRight(delete(temp.getData(), node.getRight()));
        }

        node = rebalance(node);
        return node;
    }

    private TNode<T> getMinValueNode(TNode<T> node) {
        TNode<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(TNode<T> node) {
        if (node != null) {
            traverse(node.getLeft());
            System.out.println(node.getData());
            traverse(node.getRight());
        }
    }
}
