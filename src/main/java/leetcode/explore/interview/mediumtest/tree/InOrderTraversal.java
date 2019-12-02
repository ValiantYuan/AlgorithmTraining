package leetcode.explore.interview.mediumtest.tree;

import basestructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @NAME: InOrderTraversal
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION:
 **/
public class InOrderTraversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode lastPop = root;
        TreeNode top;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            top = stack.peek();
            if (top.left != null && top.left != lastPop && top.right != lastPop) {
                stack.push(top.left);
            } else if (top.right != null && top.right != lastPop) {
                list.add(top.val);
                stack.push(top.right);
            } else {
                //走到这里有几种情况：
                //1.左节点为空，或者左子节点被访问过，或者右子节点被访问过
                //2.右子节点为空，或者右子节点被访问过
                //当处理完左分支时，1.执行else if逻辑，访问右节点并添加当前节点到结果集
                //2.右子节点为空，进入到else逻辑，此时由于节点top节点是在if分支中进栈的，所以需要记录并出栈，即下面的逻辑
                if (top.right == null) {
                    list.add(top.val);
                }
                lastPop = stack.pop();
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur == null) {
            //遍历左子树到达当前子树的叶节点
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()) {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
