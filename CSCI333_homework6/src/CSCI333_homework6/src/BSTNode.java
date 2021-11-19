
public class BSTNode {
	private BSTNode p;
	private BSTNode left;
	private BSTNode right;
	private int key;
	
	/**
	 * Contractor used to create a new instance of BSTNode
	 * it sets the value of p, left, and right to null and the key value to key
	 * @param key
	 */
	public BSTNode(int key) {
		this.p = null;
		this .left = null;
		this.right = null;
		this.key = key;
	}
	
	/**
	 * Gets the value of p
	 * @return the value of p
	 */
	public BSTNode getP() {
		return p;
	}

	/**
	 * sets to value of p to a specific value
	 * @param p is the value this.p is being set to
	 */
	public void setP(BSTNode p) {
		this.p = p;
	}

	/**
	 * gets the value of left
	 * @return the value of left
	 */
	public BSTNode getLeft() {
		return left;
	}

	/**
	 * sets to value of left to a specific value
	 * @param left is the value this.left is being set to
	 */
	public void setLeft(BSTNode left) {
		this.left = left;
	}

	/**
	 * gets the value of right
	 * @return the value of right
	 */
	public BSTNode getRight() {
		return right;
	}
	
	/**
	 * sets to value of right to a specific value
	 * @param right is the value this.right is being set to
	 */
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	/**
	 * gets the value of key
	 * @return the value of key
	 */
	public int getKey() {
		return key;
	}
	

}
