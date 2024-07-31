package com.dataStructures.List;

public interface ListInterface <T extends Comparable<T>> {

	void add(T data);

	int search(T data);

	void delete(T data);

	void traverse();

	void set(T data, int index);

	int size();
}
