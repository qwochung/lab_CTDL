package Task_1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> implements Comparable<E> {
	static final int DEFAULT_CAPACITY = 10;
	E[] element;
	int size;
	
	
	
	public MyArrayList() {
		super();
		this.element = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity) {
		super();
		this.element = (E[]) new Object[capacity];
	}
	
	
	
	
	
	
	
	
	
	
	// creates an array of double-size if the array of 	elements is full
	public void growSize() {
		
		if (element.length == size) {
			E[] temp = element;
			element = (E[]) new Object[size*2];
			System.arraycopy(temp, 0, element, 0, size);
		}
	}
	
	
	
	
	// Returns whether the list is empty.
	public boolean isEmpty() {
		if (size ==0) {
			return true;
		}
		return false;
	}


	
	
	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		return element[i];
	
	};
	
	
	
	
	
	// Replaces the element at index i with e, and 	returns the replaced element. ∗/
	public E set(int i, E e) throws	IndexOutOfBoundsException {
		E result = element[i];
		element[i] = e;
		return result;
	}

	
	
	
	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		growSize();
		element[size++] = e;
		return true;
	}
	
	
	
	// Inserts element e to be at index i, shifting all  subsequent elements later.
	public void add(int i, E e) throws 	IndexOutOfBoundsException {
		growSize();
		for (int j = element.length-1; j > i; j--) {
			element[j] = element[j-1];
		}
		element[i] = e;
	}
	
	
	
	
	
	// Removes and returns the element at index i, 	shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		E result = element[i];
		for (int j = i; j < element.length-1; j++) {
			element[j] = element[j+1];
		}
		size--;
		return result;
	}
	
	
	
	
	
	// It is used to clear all elements in the list.
	public void clear() {
		element = (E[]) new  Object[DEFAULT_CAPACITY];
		size =0;
	}

	
	
	// It is used to return the index in this list of the last occurrence of the specified element, or -1 if the 
	//	list does not contain this element.
	public <T> int lastIndexOf(Object o) {
		
		for (int i = 0; i < element.length; i++) {
			if (element[i].equals(o)) {
				return i;
			}
		}
		
		return -1;
	}

	
	
	
	
	
	
	// It is used to return an array containing all of the 	elements in this list in the correct order.
	
	public E[] toArray() {
		E[] result  =(E[]) new Object[size];
		System.arraycopy(element, 0, result, 0, size);

		Arrays.sort(result);
		return result;
		}
	
	
	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E>	result = new MyArrayList<>(size);
		System.arraycopy(this.element, 0, result.element, 0, size);
		return result;
	}
	
	
	
	
	
	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (E e : element) {
			if (e == null) {
				break;
			}
			if (e.equals(o)) {
				return true;
			}
		}
		return false;
	}

	
	
	
	
	
	// It is used to return the index in this list of the first occurrence
//	of the specified element, or -1 if the 	List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < element.length; i++) {
			if (element[i] == null) {
				break;
			}
			
			if (element[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	
	
	
	
	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E	 e) {
		remove(indexOf(e));

		return true;
	}
	
	
	
	
	
	
	// It is used to sort the elements of the list on the 	basis of specified comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(element, 0, size, c);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public void print() {
//		Arrays.toString(element);
		for (E e : element) {
			System.out.println(e);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		MyArrayList<Integer > arrayList = new MyArrayList<>();
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(9);
		arrayList.add(10);
		arrayList.add(11);
		arrayList.add(1, 8);
		arrayList.remove(0);
//		arrayList.clear();
//		arrayList.toArray();
//		arrayList.clone().print();
//		System.out.println(Arrays.toString(arrayList.toArray()));
//		arrayList.print();
		
//		System.out.println(arrayList.isEmpty());
//		System.out.println(arrayList.get(2));
//		System.out.println(arrayList.set(2, 10));
//		System.out.println(arrayList.lastIndexOf(11));
//		System.out.println(arrayList.contains(10));
//		System.out.println(arrayList.indexOf(100));	
//		System.out.println(arrayList.remove((Integer)8));	
		arrayList.sort(Comparator.naturalOrder());
		arrayList.print();

		
		 
	}

	

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
