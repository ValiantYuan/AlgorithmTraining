package leetcode.marchonoffer;

import java.util.HashMap;
import java.util.Map;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2020/9/4
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();
    private int[] preorder;
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length != inorder.length){
            return null;
        }
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildChildTree(0, inorder.length - 1);
    }

    /**
     * 依赖前序遍历来构建树的节点，前序节点不停前进，则代表在以前序的方式递归构建二叉树，先左后右
     * @param start
     * @param end
     * @return
     */
    private TreeNode buildChildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);
        int inIndex = map.get(rootValue);
        preIndex++;
        root.left = buildChildTree(start, inIndex - 1);
        root.right = buildChildTree(inIndex + 1, end);
        return root;
    }

}
