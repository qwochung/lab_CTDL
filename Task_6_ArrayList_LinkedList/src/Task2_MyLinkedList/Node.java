package Task2_MyLinkedList;

public class Node <E> {
	E data;
	Node<E> next;
	
	
	public Node(E data) {
		this.data = data;
		}
	
	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
		}
	
}
