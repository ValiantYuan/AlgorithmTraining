package leetcode.intermidiate.tree;

import basestructure.TreeNode;

import java.util.HashMap;

/**
 * @NAME: BuildTree
 * @USER: valiant
 * @DATE: 2019-09-24
 * @DESCRITION:
 **/
public class BuildTree {
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> idx_map = new HashMap<>();
    private int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        int index = 0;
        this.preorder = preorder;
        this.inorder = inorder;
        for (int val : inorder
             ) {
            idx_map.put(val, index++);
        }
        return  buildTree(0, length - 1);

    }


    /**
     *
     * @param start 起始位置
     * @param end   结束位置
     * @return start和end都是可以取值的位置，所有start可以等于end
     */
    public TreeNode buildTree(int start, int end) {
        //终止条件是当前值范围变为1
        if(start > end) {
            return null;
        }
        int rootVal = preorder[preindex];
        TreeNode root = new TreeNode(rootVal);
        int index = idx_map.get(rootVal);
        //重建二叉树时，按照前序一直往左树递归，递归完后再递归右树，所以preindex一直加
        preindex++;
        root.left = buildTree(start, index - 1);
        root.right = buildTree(index + 1, end);
        return root;

    }
}
