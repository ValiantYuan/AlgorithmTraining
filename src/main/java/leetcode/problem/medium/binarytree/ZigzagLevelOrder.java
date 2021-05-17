package leetcode.problem.medium.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2020/12/22
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        boolean isOrderLeft = true;
        while (!deque.isEmpty()) {
            Deque<Integer> curLevel = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if (isOrderLeft) {
                    curLevel.offerLast(treeNode.val);
                } else {
                    curLevel.offerFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
            }
            lists.add(new LinkedList<>(curLevel));
            isOrderLeft = !isOrderLeft;
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }
}
