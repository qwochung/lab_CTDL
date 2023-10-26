package Task2_MyLinkedList;

import Task_1.MyArrayList;

public class SinglyLinkedList <E>{
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;
	
	
	
	public SinglyLinkedList() {
	super();
	}
	
	
	
	
	
	
	// Returns the number of elements in the list.
	public int size() {
		return size;
	}
	
	
	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		if (size !=0) {
			return true;
		}
		return false;
	}
	
	// Returns (but does not remove) the first element in the list.
	public E first() {
		return head.data;
	}

	
	
	// Returns (but does not remove) the last element in 	the list.
	public E last() {
		return tail.data;
	}
	
	
	
	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> node = new Node<E>(e);
		if (head == null) {
			head = node;
			tail = node;
		}
		else {
			node.next = head;
			head = node;
		}
		
		size++;
	}
	
	
	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> node = new Node<E>(e);
		if (head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		
		size++;
	}

	
	
	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (head == null) {
			return null;
		}
		
		E data = head.data;
		head = head.next;
		size--;
		
		return data;
	}
	
	
	
	
	
	
	// Removes and returns the last element of the list.
	public E removeLast() {
		if (head == null) {
			return null;
		}
		
		if (head.equals(tail)) {
			E data = head.data;
			head = null;
			tail = null;
			return data;
		}
		else {
			
		
		Node<E> current = head;
		while (current.next != tail ) {
			current = current.next;
		}
		
		E data = current.next.data;
		current.next = null;
		tail = current;
		size--;
		return data;
	}
	
	}
	
	
	
	
	public void print() {
		Node<E> current = head	;
		if (head == null) {
			System.out.println("null");
		}
		
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList= new SinglyLinkedList<>();
		linkedList.addFirst(10);
		linkedList.addLast(20);
		linkedList.addLast(30);
		linkedList.removeFirst();
		linkedList.removeLast();
		
		
		linkedList.print();
	}
	
	
	
	
	

}
