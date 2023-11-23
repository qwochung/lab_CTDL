package Stack;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class MyLIFO_App {
	
	
	
//	 This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> temp = new Stack<>();
		for (E e : array) {
			temp.push(e);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = temp.pop();
			
		}
		
		}
	
	
	
	
	
		// This method checks the correctness of the given input
		// i.e. ()(())[]{(())} ==> true, ){[]}() ==>		false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		
		for (char character : input.toCharArray()) {
			if (character == '(' ||
					character == '{' ||
					character == '[' ) {
				stack.push(character);
				
			}
			if (character == ')' ||
					character == '}' ||
					character == ']' ) {
				
				if (stack.isEmpty()) {
					return false;
				}
				
				char open = stack.pop();
				if (!subIsCorrect(open, character)) {
					return false;
				} 
				
				
			}
		}
		
		return stack.isEmpty();
		}

	
	
	
	
	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static double evaluateExpression(String expression) {
		expression= insertSpace(expression);
		Stack<Double> operandStack = new Stack<>();
		Stack<String> operatorStack = new Stack<>();
		
		String [] arr = expression.split("\\s+");
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			
			switch (str) {
			case "+":
			case "-": {
				if (operatorStack.isEmpty() || operatorStack.contains("(")) {
					operatorStack.add(str);
					
					break;
				}
				else {
					Double temp = processed(operatorStack.pop(), operandStack.pop(), operandStack.pop() );
					operandStack.add(temp);
					operatorStack.add(str);
					break;
				}
				
			}
			
			case "*":
			case "/": {
				if (operatorStack.contains("*") ||operatorStack.contains("/")  ) {
				Double temp = processed(operatorStack.pop(), operandStack.pop(), operandStack.pop() );	
				operandStack.add(temp);
				operatorStack.add(str);
				break;
			}
			else {
				operatorStack.add(str);
				break;
			}
			}
			
			
			
			
			case "(": {
				operatorStack.add(str);
				break;
			}
			
			case ")" :{
				double temp = 0;
				while (operatorStack.contains("(") ) {
					if (operatorStack.peek().equals("(")) {
						operatorStack.pop();
						break;
					}
					temp= processed(operatorStack.pop(), operandStack.pop(), operandStack.pop() );
					operandStack.add(temp);
				}

				break;
			}
			
			default : {
				operandStack.add(Double.valueOf(str));
 			}
			
			}
			
		}
		while (!operatorStack.isEmpty()) {
			double temp= processed(operatorStack.pop(), operandStack.pop(), operandStack.pop() );
			operandStack.add(temp);
			
		}
		
		
		return operandStack.pop();
	}



	
	
	
	private static double processed(String key, Double second, Double first) {
		switch (key) {
		case "+": {
			return first + second;
			
		}
		case "-": {
			return first - second;
			
		}
		case "*": {
			return first * second;
			
		}
		case "/": {
			return first / second;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
		
	}





	private static String insertSpace(String expression) {
		String result = "";
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < expression.toCharArray().length ; i++) {
			Character ch = expression.charAt(i);
			if (ch == '+' ||
				ch == '-' ||
				ch== '*'  ||
				ch == '/' ||
				ch == '(' ||
				ch == ')'  ) {
				
				list.add(list.size(), ' ');
				list.add(ch);
				list.add(' ');
			}
			else {
				list.add(expression.charAt(i));
			}
			
		}
		for (Character character : list) {
			result+= character;
		}

		return result;
	}





	private static boolean subIsCorrect(char open, char close) {
			return 	(open == '(' && close == ')') ||
					(open == '{' && close == '}')||
					(open == '[' && close == ']');
		}

	


	public static void main(String[] args) {
		Integer arr [] = {2,3,4,56,1,3,35,7};
		reserve(arr);
//		System.out.println(Arrays.toString(arr));
		
//		System.out.println(isCorrect("()["));
		
//		System.out.println(insertSpace("54+12*(1-1)"));
		System.out.println(evaluateExpression("51+(54*(3+2))"));
		
		
	}
}
