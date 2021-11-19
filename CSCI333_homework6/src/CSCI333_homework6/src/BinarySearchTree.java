
public class BinarySearchTree {
	public BSTNode root;
	private int size;
	
	/**
	 * Constructor that is called to create a new instance of binarySearchTree
	 * sets the root equal to null and size = 0
	 */
	public BinarySearchTree() {
		super();
		this.root = null;
		this.size = 0;
	}
	
	/**
	 * returns the size of the tree
	 * @return the size variable
	 */
	public int size() {
		return this.size;
	}
	
//=====================================================================================================================================\\	
	
	/**
	 * Replaces one node for another in the BST
	 * @param T is the tree variable
	 * @param u is the node being replaces
	 * @param v is the node that will replace u
	 */
	private void TRANSPLANT(BinarySearchTree T, BSTNode u, BSTNode v) {
		if(u.getP() == null) {
			T.root = v;
		}else if(u == u.getP().getLeft()) {
			u.getP().setLeft(v);
		}else {
			u.getP().setRight(v);
		}
		if(v != null) {
			v.setP(u.getP());
		}
	}
	//public wrapper method for TRANSPLANT
	public void transplant(BinarySearchTree T, BSTNode u, BSTNode v) {
		TRANSPLANT(T, u, v);
	}
	
//=====================================================================================================================================\\
	
	/**
	 * searched for the node containing a specific key in the tree
	 * @param x is root node
	 * @param k is the key it is searching for
	 * @return the node containing the key
	 */
	private BSTNode SEARCH(BSTNode x, int k) {
		if(x == null) {
			return null;
		}
		if(k == x.getKey()) {
			return x;
		}
		if(k<x.getKey()) {
			return SEARCH(x.getLeft(), k);
		}else {
			return SEARCH(x.getRight(), k);
		}
	}
	//public wrapper method for SEARCH
	public BSTNode search(BSTNode x, int k) {
		return SEARCH(x, k);
	}
	
//=====================================================================================================================================\\	
	
	/**
	 * traverses all the way to the left to return the smallest node in the tree
	 * @param x is the root of the tree
	 * @return the smallest node
	 */
	private BSTNode MINIMUM(BSTNode x) {
		while(x.getLeft() != null) {
			x = x.getLeft();
		}
		return x;
	}
	//public wrapper method for MINIMUM
	public BSTNode minimum(BSTNode x) {
		return MINIMUM(x);
	}
	
//=====================================================================================================================================\\	
	
	/**
	 * traverses all the way to the right to return the biggest node in the tree
	 * @param x is the root of the tree
	 * @return the biggest node
	 */
	private BSTNode MAXIMUM(BSTNode x) {
		while(x.getRight() != null) {
			x = x.getRight();
		}
		return x;
	}
//	public wrapper method for MAXIMUM
	public BSTNode maximum(BSTNode x) {
		return MAXIMUM(x);
	}
	
//=====================================================================================================================================\\		
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private BSTNode SUCCESSOR(BSTNode x) {
		if(x.getRight() != null) { // case 1: minimum of right subtree
			return minimum(x);
		}
		while(x.getP() != null && x == x.getP().getRight()) {// case 2: find left parent
			x = x.getP();
		}
		return x.getP();
	}
//	public wrapper method for SUCCESSOR
	public BSTNode successor(BSTNode x) {
		return SUCCESSOR(x);
	}
	
//=====================================================================================================================================\\		
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private BSTNode PREDECESSOR(BSTNode x) {
		if(x.getLeft() != null) {
			return maximum(x.getLeft());
		}
		while(x.getP() != null && x == x.getP().getLeft()) {
			x = x.getP();
		}
		return x.getP();
	}
	public BSTNode predecessor(BSTNode x) {
		return PREDECESSOR(x);
	}
	
//=====================================================================================================================================\\		
	
	/**
	 * Finds the place in the tree to add a new item
	 * @param T is the tree
	 * @param z the new node being added
	 */
	private void INSERT(BinarySearchTree T, BSTNode z) {
		BSTNode y = null;
		BSTNode x = T.root;
		while(x != null) {
			y = x;
			if(z.getKey() < x.getKey()) {
				x = x.getLeft();
			}else {
				x = x.getRight();
			}
		}
		z.setP(y);
		if(y == null) {
			T.root = z;
		}else if(z.getKey() < y.getKey()) {
			y.setLeft(z);
		}else {
			y.setRight(z);
		}
		this.size++;
		
	}
	//
	public void insert(BinarySearchTree T, BSTNode z) {
		INSERT(T, z);
	}
	
//=====================================================================================================================================\\		
	
	/**
	 * Finds the item in the tree to delete then calls transplant to swap its successor into is empty place
	 * @param T is the BST tree
	 * @param z is the node being removed
	 */
	private void DELETE(BinarySearchTree T, BSTNode z) {
		if(z.getLeft() == null) {
			TRANSPLANT(T, z, z.getRight());
		}else if(z.getRight() == null) {
			TRANSPLANT(T,z, z.getLeft());
		}else {
			BSTNode y = minimum(z.getRight());
			if(y.getP() != z) {
				TRANSPLANT(T, y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setP(y);
			}
			TRANSPLANT(T, z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setP(y);
		}
		this.size--;
	}
	//
	public void delete(BinarySearchTree T, BSTNode z) {
		DELETE(T, z);
	}
	
//=====================================================================================================================================\\		
	
	/**
	 * pre-order traversal
	 * prints the tree in the order of the rows
	 */
	private void PREORDER(BSTNode x) {
		if(x != null) {
			System.out.println(x.getKey());
			PREORDER(x.getLeft());
			PREORDER(x.getRight());
		}
	}
	//
	public void preOrder(BSTNode x) {
		PREORDER(x);
	}
	
//=====================================================================================================================================\\	
	
	/**
	 * in-Order traversal
	 * prints off the tree in order from smallest to biggest
	 */
	private void INORDER(BSTNode x) {
		if(x != null) {
			INORDER(x.getLeft());
			System.out.println(x.getKey());
			INORDER(x.getRight());
		}
	}
	//
	public void inOrder(BSTNode x) {
		INORDER(x);
	}
	
//=====================================================================================================================================\\	
	
	/**
	 * 
	 */
	private void POSTORDER(BSTNode x) {
		if(x != null) {
			POSTORDER(x.getLeft());
			POSTORDER(x.getRight());
			System.out.println(x.getKey());
		}
	}
	//
	public void postOrder(BSTNode x) {
		POSTORDER(x);
	}
	
	
}
































