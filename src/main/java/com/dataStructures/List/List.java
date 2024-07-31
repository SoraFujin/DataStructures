package com.dataStructures.List;

public class List<T extends Comparable<T>> implements ListInterface<T> {
    private T[] arr;
    private int count = 0;

    @SuppressWarnings("unchecked")
    public List(int size) {
        if (size > 0) {
            arr = (T[]) new Comparable[size];
        } else {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
    }

	@Override
    public void add(T data) {
        if (count < arr.length) {
            arr[count++] = data;
        } else {
            System.out.println("List is full");
        }
    }

    @Override
    public void set(T data, int index) {
        if (index >= 0 && index < count) {
            arr[index] = data;
        } else {
            System.out.println("Index out of bounds");
        }
    }

    @Override
    public int search(T data) {
        for (int i = 0; i < count; i++) { 
            if (data.compareTo(arr[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(T data) {
        int index = search(data);
        if (index == -1) {
            System.out.println("Element not found");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[count - 1] = null; 
        count--;
    }

    @Override
    public void traverse() {
        for (int i = 0; i < count; i++) { 
            System.out.println(arr[i].toString());
        }
    }

    @Override
    public int size() {
        return count;
    }
}
