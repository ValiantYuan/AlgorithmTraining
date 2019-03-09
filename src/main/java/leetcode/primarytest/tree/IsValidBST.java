package leetcode.primarytest.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
    	if (root == null || (root.left == null && root.right == null)) return true;  
    	List<Integer> values = new ArrayList<>();
    	inOrderTraversal(root, values);
    	for (int i = 0; i < values.size() - 1; i++) {
			if (values.get(i) >= values.get(i + 1)) return false;
		}
    	return true;
    }
    public void inOrderTraversal(TreeNode root, List values) {
    	if (root != null) {
			inOrderTraversal(root.left, values);
			values.add(root.val);
			inOrderTraversal(root.right, values);
		}
    }
    
    public static void main(String[] args) {
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(20);
		boolean result = new IsValidBST().isValidBST(head);
		System.out.println(result);
    }
}
