package Task_2;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		
		
		this.items = items;
	}


	
	
	

//	 menthod cost
	
	public double cost() {
		double result = 0.0;
		for (OrderItem orderItem : items) {
			result += orderItem.getPrice();
		}
		return result;
		}
	
	
	
	
	
	// using binary search approach
	public boolean contains(Product p) {
		sortByID();
		System.out.println(Arrays.toString(items));

		return binarySearch(p, 0, items.length-1);
	}
	
	
	
	
	
	
	// get all products based on the given type using linear search
	public Product[] filter(String type) {
		sortByType();
		int len = 0;
		for (OrderItem orderItem : items) {
			if (orderItem.getP().getType().equals(type)) {
				len++;
			}
		}
		
		Product[] result = new Product[len];
		recursionType(type, 0, result, 0);
		
		return result;
	}
	
	
	
	
//	menthod binary search
	public boolean binarySearch(Product p, int start, int end) {
		int mid = start + (end - start) /2;
		
		if (end< start) {
			return false;
		}
		
		if (items[mid].compareTo(new OrderItem(p, 0)) == 0) {
			return true;
		}
		if (items[mid].compareTo(new OrderItem(p, 0)) >0 ) {
			return binarySearch(p, start, --mid);
		}
		else {
			return binarySearch(p, ++mid, end);
		}
		
		
	}
	
	
	
	
//	menthod filter type by recursion
		public void recursionType(String type, int index, Product[] result, int count) {
			
			if (index == items.length) {
				return ;
			}
			
			if (items[index].getP().getType().equals(type) ) {
				result[count++]= items[index].getP();
				recursionType(type, ++index, result, count);
			}
			
			else {
				
				 recursionType(type, ++index, result, count);
			}
			
			
			
			
		}
	
	
	
//	menthod sort by name 
	public void sortByName( ) {
		Arrays.sort(items, new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
	
	
//	menthod sort by id
	public  void sortByID() {
		Arrays.sort(items, new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
	}
	
	
//	menthod sort by Type
	
	public void sortByType() {
		Arrays.sort(items, new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.compareByType(o2);
			}
		});
	}
	
	
	
	
}
