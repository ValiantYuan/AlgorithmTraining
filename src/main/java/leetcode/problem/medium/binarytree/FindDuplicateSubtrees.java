package leetcode.problem.medium.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/1/27
 */
public class FindDuplicateSubtrees {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getTreeDesc(root);
        return list;
    }

    public String getTreeDesc(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = getTreeDesc(root.left);
        String right = getTreeDesc(root.right);
        String result = root.val + "," + left + "," + right;
        int count = map.getOrDefault(result, 0);
        if (count == 1) {
            list.add(root);
        }
        map.put(result, count + 1);
        return result;
    }
}
