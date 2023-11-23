package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E parameter = input.poll();
			input.offer(parameter);
			input.offer(parameter);
		}
	}

	
	
	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Queue<E> subQueue = new LinkedList<>();
		Stack<E> stack = new Stack<>();
		int size = input.size();
		while (!input.isEmpty()) {
			E element = input.poll()	;
			subQueue.offer(element);  // 1 2 3
			stack.push(element);	// 3 2 1
		}
		while (!subQueue.isEmpty()) {
			input.offer(subQueue.poll());
		}
		while (!stack.isEmpty()) {
			input.offer(stack.pop());
		}
		
			
	}
	
	
	
	public static void main(String[] args) {
		Queue<Integer> queue	= new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		stutter(queue);
		System.out.println(queue.toString());
		
		Queue<String> input	= new LinkedList<>();
		input.offer("a");
		input.offer("b");
		input.offer("c");
		mirror(input);
		System.out.println(input.toString());
		
	}

}
