package hr.fer.oop.lab2.prob2;


/**
 * This class implements program for creating binary tree and 
 * working with it .
 * @author Jurij Kos
 *
 */
public class TreeProgram {
	/**
	 * Starting point of the program.
	 * 
	 */
	public static void main(String[] args) {
		TreeNode node=null;
		
		//inserting nodes in tree
		node=insert(node, "Jasna");
		node=insert(node, "Ana");
		node=insert(node, "Ivana");
		node=insert(node, "Anamarija");
		node=insert(node, "Vesna");
		node=insert(node, "Kristina");
		
		System.out.println("Writing tree inorder:");
		
		writeTree(node);
		
		node=reverseTreeOrder(node);
		
		System.out.println("Writing reversed tree inorder");
		writeTree(node);
		
		int size = sizeOfTree(node);
		System.out.println("Number of nodes in tree is "+size+".");
		
		boolean found = containsData(node,"Ivana");
		System.out.println("Searched element is found: "+ found);

		boolean found2 = containsData2(node,"Ivana");
		System.out.println("Searched element is found: "+ found2);
	}
	/**
	 *Search for String in sorted binary tree.
	 * @param treeRoot
	 * 				  Root node of the tree
	 * @param data
	 * 				String we are searching for
	 * @return True if string is found. False if string is not found
	 */
	private static boolean containsData(TreeNode treeRoot,String data){
		while(treeRoot!=null){
			if(treeRoot.data.equals(data))
				return true;
			else if(data.compareTo(treeRoot.data)<0)
				treeRoot=treeRoot.left;
			else
				treeRoot=treeRoot.right;
		}
		return false;
	}
	/**
	 * Finds number of nodes in the tree.
	 * @param treeRoot
	 * 				Reference to root node 
	 * @return Number of nodes.
	 */
	private static int sizeOfTree(TreeNode treeRoot){
		if(treeRoot==null)
			return 0;
		return sizeOfTree(treeRoot.left)+1+sizeOfTree(treeRoot.right);
	}
	/**
	 * Inserts new data to the tree. Tree is in-order(LDR) sorted
	 * @param treeRoot
	 * 				Reference to the root node
	 * @param data
	 * 				Insert to the tree
	 * @return Reference to the new root node.
	 */
	private static TreeNode insert(TreeNode treeRoot,String data){
		if(treeRoot==null){
			treeRoot=new TreeNode();
			treeRoot.data=data;
			return treeRoot;
		}
		else if(data.compareTo(treeRoot.data)<0){
			treeRoot.left=insert(treeRoot.left, data);
		}
		else {
			treeRoot.right=insert(treeRoot.right, data);
		}
		return treeRoot;

		
	}
	/**
	 * Prints out data from all nodes in the tree in in-order.
	 * @param treeRoot Root of the tree
	 */
	private static void writeTree(TreeNode treeRoot){
		if(treeRoot!=null){
			writeTree(treeRoot.left);
			System.out.println(treeRoot.data);
			writeTree(treeRoot.right);
		}
	}
	/**
	 * It reverse binary tree from LDR type to the RDL type. 
	 * @param treeRoot
	 * @return Reference to the root node of new tree
	 */
	private static TreeNode reverseTreeOrder(TreeNode treeRoot){
	//	TreeNode newTree=null;
		if(treeRoot==null)
			return null;
		TreeNode node=treeRoot.left;
		treeRoot.left=treeRoot.right;
		treeRoot.right=node;
		treeRoot.left=reverseTreeOrder(treeRoot.left);
		treeRoot.right=reverseTreeOrder(treeRoot.right);
		return treeRoot;
	}
	/**
	 *Search for String in any binary tree.
	 * @param treeRoot
	 * 				  Root node of the tree
	 * @param data
	 * 				String we are searching for
	 * @return True if string is found. False if string is not found
	 */
	private static boolean containsData2(TreeNode treeRoot,String data){
		if(treeRoot==null)
			return false;
		else if(treeRoot.data.equals(data))
			return true;
		else 
			return (containsData2(treeRoot.left, data)|| containsData2(treeRoot.right, data));
	}
	
}
