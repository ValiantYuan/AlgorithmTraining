package practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @NAME: BinaryTree
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION:
 **/
public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

    }
    ArrayList<Integer> values = new ArrayList<>();

    public static void main(String[] args) {
        new BinaryTree().test();
    }


    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        preOrderTraversal(node1);
        printValues(values);
        values.clear();
        inOrderTraversal(node1);
        printValues(values);
        values.clear();
        postOrderTraversal(node1);
        printValues(values);
        values.clear();
    }

    public void printValues(ArrayList<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            System.out.print( values.get(i) + " ");
        }
        System.out.println();
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        visit(root);
        stack.push(root);
        TreeNode top = null;
        TreeNode lastPop = root;
        while (!stack.isEmpty() ) {
            top = stack.peek();
            if (top.left != null && top.left != lastPop && top.right != lastPop) {
                visit(top.left);
                stack.push(top.left);
            } else if (top.right != null && top.right != lastPop) {
                visit(top.right);
                stack.push(top.right);
            } else {
                lastPop = stack.pop();
            }
        }
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode top = null;
        TreeNode lastPop = root;
        while (!stack.isEmpty() ) {
            top = stack.peek();
            if (top.left != null && top.left != lastPop && top.right != lastPop) {
                stack.push(top.left);
            } else if (top.right != null && top.right != lastPop) {
                visit(top);
                stack.push(top.right);
            } else {
                //走到这里有几种情况：
                //1.左节点为空，或者左子节点被访问过，或者右子节点被访问过
                //2.右子节点为空，或者右子节点被访问过
                //当处理完左分支时，1.执行else if逻辑，访问右节点并添加当前节点到结果集
                //2.右子节点为空，进入到else逻辑，此时由于节点top节点是在if分支中进栈的，所以需要记录并出栈，即下面的逻辑
                lastPop = stack.pop();
                if (top.right == null) visit(top);
            }
        }
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode top = null;
        TreeNode lastPop = root;
        while (!stack.isEmpty() ) {
            top = stack.peek();
            if (top.left != null && top.left != lastPop && top.right != lastPop) {
                stack.push(top.left);
            } else if (top.right != null && top.right != lastPop) {
                stack.push(top.right);
            } else {
                visit(top);
                lastPop = stack.pop();
            }
        }
    }

    /**
     * 访问节点时的操作
     * @param node
     */
    public void visit(TreeNode node) {
        values.add(node.val);
    }
}
