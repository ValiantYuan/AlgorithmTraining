package leetcode.explore.interview.primarytest.tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
			return list;
		}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
        	int currentLevelCount = queue.size();
			LinkedList<Integer> values = new LinkedList<>();
        	while (currentLevelCount > 0) {
        		TreeNode node = queue.poll();
        		currentLevelCount--;
        		values.addLast(node.val);
        		if (node.left != null) queue.add(node.left);
        		if (node.right != null) queue.add(node.right);
			}
        	list.add(values);
		}
        return list;
    }
    
    

}
