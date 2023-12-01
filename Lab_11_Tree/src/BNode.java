import java.util.List;

public class BNode<E  extends Comparable<E>> {
	private E data;
	private BNode<E> myLeft;
	private BNode<E> myRight;

	public BNode(E data) {
		this.data = data;
		this.myLeft = null;
		this.myRight = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.myLeft = left;
		this.myRight = right;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the myLeft
	 */
	public BNode<E> getMyLeft() {
		return myLeft;
	}

	/**
	 * @param myLeft the myLeft to set
	 */
	public void setMyLeft(BNode<E> myLeft) {
		this.myLeft = myLeft;
	}

	/**
	 * @return the myRight
	 */
	public BNode<E> getMyRight() {
		return myRight;
	}

	/**
	 * @param myRight the myRight to set
	 */
	public void setMyRight(BNode<E> myRight) {
		this.myRight = myRight;
	}

	@Override
	public String toString() {
		if (myLeft != null) {
			System.out.println(myLeft.toString());
		}
		if (myRight != null) {
			System.out.println(myRight.toString());
		}
		return " -BNode data=" + data ;
	}

	public void add(BNode<E> parent, BNode<E> current, E e) {
		BNode<E> element = new BNode<E>(e);

		while (current != null) {
			parent = current;
			int comparable = e.compareTo(current.getData());
			if (comparable < 0) {
				current = current.getMyLeft();
			}
			if (comparable > 0) {
				current = current.getMyRight();
			}
		}

		int comparable = e.compareTo(parent.getData());
		if (comparable < 0) {
			parent.setMyLeft(element);
		} else {
			parent.setMyRight(element);
		}

	}

	

	public int depth(BNode<E> root, E node) {
		int depth = 0;
		BNode<E> current = root;
		while (current != null) {
			int comparable = node.compareTo(current.getData());

			if (comparable < 0) {
				current = current.getMyLeft();
				depth++;
			}
			if (comparable > 0) {
				current = current.getMyRight();
				depth++;
			}
			if (comparable == 0) {

				return depth;
			}

		}

		return -1;
	}

	
	
	public int subHeight(BNode<E> current, int result) {
		if (current == null) {
			return result;
		} else {
			result++;
			int lenLeft = result;
			int lenRight = result;

			lenLeft = subHeight(current.getMyLeft(), result);

			lenRight = subHeight(current.getMyRight(), result);

			result = Math.max(lenLeft, lenRight);
		}
		return result;		
	}

	
	
	
	public int subSize(BNode<E> current, int result) {
		if (current == null) {
			return result;
		} else {
			result++;

			result = subSize(current.getMyLeft(), result);

			result = subSize(current.getMyRight(), result);

		}
		return result;		
	}

	

	
	public boolean contain(BNode<E> current, E e) {
		while (current != null) {
			int comparable = e.compareTo(current.getData());

			if (comparable < 0) {
				current = current.getMyLeft();
			}
			if (comparable > 0) {
				current = current.getMyRight();
			}
			if (comparable == 0) {

				return true;
			}

		}

		return false;
	}

	
	
	
	
	public E FindMin(BNode<E> current, E result) {

		if (current == null) {
			return result;
		} else {
			if (result.compareTo(current.getData()) > 0) {
				result = current.getData();
			}
			result = FindMin(current.getMyLeft(), result);

		}
		return result;
	}

	

	
	
	public E FindMax(BNode<E> current, E result) {
		if (current == null) {
			return result;
		} else {
			if (result.compareTo(current.getData()) < 0) {
				result = current.getData();
			}
			result = FindMax(current.getMyRight(), result);

		}
		return result;
	}

	
	
	
	public boolean remove(BNode<E> before, BNode<E> current, E e) {
int comparable = e.compareTo(current.getData());
		
		if (comparable < 0) {
			return remove(current, current.getMyLeft(), e);
		}
		if (comparable > 0) {
			return remove(current, current.getMyRight(), e);
			
		}
		else {
//				right and left is NULL
			if (current.getMyLeft() == null && current.getMyRight() == null) {
				updateNode(before, current, null);
			}

//			right and left not null
			if (current.getMyLeft() != null && current.getMyRight() != null) {
//				find min of right branch
				BNode<E> newNode = findMinNode (current.getMyRight());
				current.setData(newNode.getData());
				return remove(current, current.getMyRight(), newNode.getData());
			} 
			else {
				BNode<E> chid = (current.getMyRight()!=null) ? current.getMyRight() : current.getMyLeft();
				updateNode(	before, current, chid);
				
			}

		}

		return true;
	}
	

	
	private BNode<E> findMinNode(BNode<E> myRight) {
		while (myRight.getMyLeft()!= null) {
			myRight = myRight.getMyLeft();
		}
		return myRight;
	}
	
	
	private void updateNode(BNode<E> before, BNode<E> current, BNode<E> e) {
		if (before.getMyRight()== current) {
			before.setMyRight(e);
		}
		else {
			before.setMyLeft(e);
		}
	}

	
	
	

	
	public List<E> descendants( List<E> result, BNode<E> root, E data) {
		BNode<E> current = root;
		
		int comparable = data.compareTo(current.getData());
		if (comparable < 0) {
			result.add(current.getData());
			descendants(result, current.getMyLeft(), data);
		}
		if (comparable > 0) {
			result.add(current.getData());
			descendants(result, current.getMyRight(), data);
		}
		else {
			return result;
		}
		return result;
	}

	
	
	public List<E> ancestors(List<E> result, BNode<E> current, E data2) {
		
		
		int comparable = data2.compareTo(current.getData());
		if (comparable < 0) {
			ancestors(result, current.getMyLeft(), data2);
		}
		if (comparable > 0) {
			ancestors(result, current.getMyRight(), data2);
		}
		if (comparable == 0) {
			
			 subAncestors(result, current.getMyLeft());
			 subAncestors(result, current.getMyRight());
		
		}
		return result;
	}

	private  void subAncestors(List<E> result, BNode<E> current) {
		if (current == null) {
			return;
			
		}
		else {
			result.add(current.getData());
			subAncestors(result, current.getMyLeft());
			subAncestors(result, current.getMyRight());
			
			
		}
	}

	
	
	
	
	public void inorder(BNode<E> root) {
		if (root != null) {
			inorder(root.getMyLeft());
			System.out.println(root.getData());
			inorder(root.getMyRight());
		}
		
	}

	public void preordoer(BNode<E> root) {
		if (root != null) {
			System.out.println(root.getData());
			preordoer(root.getMyLeft());
			preordoer(root.getMyRight());
			
	}
	
	}

	public void postordoer(BNode<E> root) {
		if (root != null) {
			postordoer(root.getMyLeft());
			postordoer(root.getMyRight());
			System.out.println(root.getData());
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
