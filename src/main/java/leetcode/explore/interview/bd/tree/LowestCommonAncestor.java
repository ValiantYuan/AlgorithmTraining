package leetcode.explore.interview.bd.tree;

import basestructure.TreeNode;

/**
 * @NAME: LowestCommonAncestor
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION:
 **/
public class LowestCommonAncestor {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    /**
     *
     * @param currentNode 当前访问的节点
     * @param p
     * @param q
     * @return 采用深度优先的方式遍历二叉树
     */
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        //如果当前已到达最底层，则返回false
        if (currentNode == null) {
            return false;
        }
        //左分支是否包含p或者q
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        //右分支是否包含p或者q
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        //当前值是否等于p或者q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        //只有在p和q到最低公共祖先上，才有可能p，q分别存在两个分支，或者一个是当前节点一个是子分支
        if (left + right + mid >= 2) {
            ans = currentNode;
        }
        //对于当前节点，返回是否包含p或者q即可
        return (left + right + mid) > 0;

    }
}
