import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BST<K extends Comparable<K>, V> {
	Node root;

	private class Node{
		K key;
		V value;
		int size;
		Node left, right;

		Node(K key, V value, int size){
			this.key = key;
			this.value = value;
			this.size = size;
		}
		public String toString() {
			String s = "Key " + key.toString() + " Value" + value.toString(); 
			return s;
		};
	}
	public Node insert(K iKey, V iValue){
		root = insert(root, iKey, iValue);
		return root;
	}
	public Node insert(Node n, K iKey, V iValue){
		if (n == null) 
			return new Node(iKey, iValue, 1);
		else if((n.key).compareTo(iKey) < 0 )
			n.right = insert(n.right,iKey, iValue);
		else if((n.key).compareTo(iKey) > 0 ){
			n.left = insert(n.left,iKey, iValue);
		}
		else if((n.key).compareTo(iKey) == 0)
			n.value = iValue;
		n.size = size(n.right) + size(n.left) + 1 ;
		return n;
	}

	public int size(Node n){
		if(n == null)
			return 0;
		else 
			return n.size;
		
	}
	
	public int size(){
		return size(root);
	}
	public void printInOrder(){
		if (root == null){
			System.out.println("Tree is empty");
			return;
		}
		else
			printInOrder(root);
	}

	public void printInOrder(Node n){
		if(n == null)
			return;
		printInOrder(n.left);
		System.out.println("Node key " + n.key 
				+ " value " + n.value);
		printInOrder(n.right);
	}
	
	public int height(){
		return height(root);
	}
	
	public int height(Node n){
		if(n == null) return -1;
		else{
			int subTreeHeight = 1 + Math.max(height(n.left), height(n.right));
			return subTreeHeight;
		}
	}
	
	public boolean isBST(){
		return isBST(root);
	}
	/*
	 * WRONG implementation !! 
	 * if 4 lies in left subtree ad right subtree strats with 3 -> true
	 */
	public boolean isBST(Node n){
		boolean isSubTreeBST = true;
		if(n == null)
			return isSubTreeBST;
		else {
			if(isBST(n.left) && isBST(n.right)){
				int cmpL , cmpR;
				if (n.left != null)
					cmpL = n.key.compareTo(n.left.key);
				else
					cmpL = 1;
				if (n.right != null)
					cmpR = n.key.compareTo(n.right.key);
				else
					cmpR = -1;
				if(!(cmpR <= cmpL))
					isSubTreeBST = false;
			}else
				isSubTreeBST = false;
			
		}
		return isSubTreeBST;
		
	}
	public boolean isBSTMM(){
		
		return false;
		
	}
	
	public void bfs(){
		Queue<BST.Node> q = new LinkedList<BST.Node>();
		if ( root == null)
			return;
		else{
			q.add(root);
			while(!q.isEmpty()){
				Node n = q.remove();
				if (n.right != null)
					q.add(n.right);
				if(n.left != null)
					q.add(n.left);
				System.out.println("Node : key " + n.key + 
						" value " + n.value);
			}
		}	
	}
	
	public void dfs(){
		Stack<BST.Node> s = new Stack<BST.Node>();
		if (root == null)
			return;
		else{
			s.push(root);
			while(!s.isEmpty()){
				Node n = s.pop();
				System.out.println("Node : key " + n.key + 
						" value " + n.value);
				if (n.left != null)
					s.push(n.left);
				if (n.right != null)
					s.push(n.right);
			}
		}
	}
	
	public void printLongestPaths(BST.Node n, BST.Node[] paths,int loc, int maxDepth){
		if(n == null){
			return ;
		}else{
				System.out.println("Added n " + n.toString()+ " at " + loc );
				paths[loc] = n;
				if((loc) ==  maxDepth){
					for(BST.Node i : paths){
						System.out.println("Node " + i.toString());
					}
				}
				loc++;
				printLongestPaths(n.right, paths, loc, maxDepth);
				printLongestPaths(n.left, paths, loc, maxDepth);
		}
	}
	
	
	public void pLP(){
		BST.Node[] paths = new BST.Node[height() + 1];
		printLongestPaths(root, paths, 0, height());
	}
	public static void main(String[] args) {
		BST<Integer, String> tree = new BST<Integer, String>();
		tree.printInOrder();
		tree.insert(new Integer(6), "Urvish");
		tree.insert(new Integer(7), "Mahida");
		tree.insert(new Integer(1), "Smit");
		tree.insert(new Integer(10), "Raabit");
		tree.insert(new Integer(0), "kruti");
		tree.insert(new Integer(-5), "Vineet");
		tree.insert(new Integer(-10), "Sodha");
		tree.insert(new Integer(8), "Rohan");
		tree.insert(new Integer(9), "Chaubal");
//		tree.printInOrder();
//		System.out.println("Size " + tree.size());
		System.out.println("Height " + tree.height());
//		System.out.println("isBast " + tree.isBST());
//		System.out.println(tree.isBSTMM());
//		tree.bfs();
//		tree.dfs();
		tree.pLP();
	}
}


