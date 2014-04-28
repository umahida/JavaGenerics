
public class BST2<K extends Comparable<K>, V>{
    Node root;
    
    public BST2() {
		root = null;
	}
    
	private class Node {
		K key;
		V value;
		
		Node left;
		Node right;
		
		int size;
		
		public Node(K k, V v) {
			this.key = k;
			this.value = v;
			// TODO Auto-generated constructor stub
		}
	}
	
	public Node add(K iKey, V iVal){
		if(root == null){
			root = new Node(iKey, iVal);
		}
		else{
			root = insert(root, iKey, iVal);
		}
		return root;
	}
	
	public Node insert(Node n, K iKey, V iVal){
		if(n.key == iKey){
			return n;
		}
		if(n == null){
			n = i;
			return n;
		}
		else if (n.key.compareTo(i.key) > 0){
			n.left = insert(n.left, i);
		}
		else if ((n.key.compareTo(i.key) < 0)){
			n.right = insert(n.right, i);
		}
		return n;
	}
	public static void main(String[] args) {
		BST2<Integer, String> tree = new BST2<Integer, String>();
		tree.add()
	}

}
