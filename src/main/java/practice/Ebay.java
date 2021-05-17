package practice;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/4/21
 * 给两个二叉树的根结点，判断第一个二叉树是不是第二个二叉树的子树
 */
public class Ebay {

    public boolean isChild(TreeNode source, TreeNode target) {

        return same(source, target)
            || isChild(source.left, target)
            || isChild(source.right, target);
    }

    public boolean same(TreeNode source, TreeNode target) {
        if (source == null && target == null) {
            return true;
        }
        if (source.val == target.val) {
            if (target.left == null && target.right == null) {
                return true;
            }
            return same(source.left, target.left) && same(source.right, target.right);
        }
        return false;
    }


}
