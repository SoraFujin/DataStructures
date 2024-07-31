package com.dataStructures.List;

public interface ListInterface <T extends Comparable<T>> {

	void add();

	T search();

	T delete();

	void traverse();
}
