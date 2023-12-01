import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		BNode<E> element = new BNode<E>(e);

		if (root == null) {
			root = element;
		}

		else {
			BNode<E> current = root;
			BNode<E> parent = null;
			root.add(parent, current, e);
		}

			
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		
		if (root == null) {
			return -1;
		}

		return root.depth(root, node);
		
	}

	// compute the height of BST
	public int height() {
		BNode<E> current = root;
		int result = 0;

		return root.subHeight(current, result);

	}

	

	// Compute total nodes in BST
	public int size() {
		if (root == null) {
			return -1;
		}
		BNode<E> current = root;
		int result = 0;
		return root.subSize(current, result);

	}

	
	

	// Check whether element e is in BST
	public boolean contains(E e) {

		if (root == null) {
			return false;
		}

		else {
			BNode<E> current = root;
			return root.contain(current,  e);
		}
		

	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		E result = current.getData();
		return root.FindMin(current, result);
	}

	

	// Find the minimum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		E result = current.getData();
		return root.FindMax(current, result);
	}

	

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		if (!contains(e)) {
			return false;
		}
		BNode<E> current = root;
		BNode<E> before = null;
		return	root.remove(before, current, e);

	}

	
	
	// get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null || contains(data)== false) {
			return null;
		}
		else {
			List<E> result =new  ArrayList<E>();
			return root.descendants(result,root ,data);
		}
		
	}
	
	
	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (root == null || contains(data)== false) {
			return null;
		}
		else {
			List<E> result =new  ArrayList<E>();
			BNode<E> current = root;
			return root.ancestors(result,current ,data);
		}
	}

	
	// display BST using inorder approach
	public void inorder() {
		if (root == null) {
			return;
		}
		root.inorder(root);
	}

	// display BST using preorder approach
	public void preorder() {
		if (root == null) {
			return;
		}
		root.preordoer(root);
		}
	
	
	// display BST using postorder approach
	public void postorder() {
		if (root == null) {
			return;
		}
		root.postordoer(root);
	}
	

	

	@Override
	public String toString() {
		return "BST root =" + root.toString();
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		List<Integer> list = new ArrayList<>(List.of(1, 21,19, 33, 11));
		bst.add(15);
		bst.add(5);
		bst.add(7);
		bst.add(list);

		System.out.println("Depth : " + bst.depth(7));
		System.out.println("Height : " + bst.height());
		System.out.println("Size : " + bst.size());
		System.out.println("Contain : " + bst.contains(12));
		System.out.println("Min : " + bst.findMin());
		System.out.println("Max : " + bst.findMax());
		System.out.println( bst.remove(7));
		System.out.println("Decentdant : "+ bst.descendants(33));
		System.out.println("Ancestors : "+ bst.ancestors(15));
		System.out.println("InOrder : ");
		bst.inorder();
		System.out.println("Preorder : ");
		bst.preorder();
		System.out.println("PostOrder : ");
		bst.postorder();
		
		System.out.println(bst.toString());
	}
}
